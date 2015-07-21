/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations;

import com.autonomy.aci.client.services.AciServiceException;
import com.autonomy.aci.client.services.StAXProcessor;
import com.autonomy.aci.client.services.impl.AbstractStAXProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Processor that returns an object of type {@code <T>}. Intended for creation via static factory.
 * @param <T> The type of the items in the list
 */
class IdolAnnotationsProcessor<T> extends AbstractStAXProcessor<T> {
    private static final long serialVersionUID = 8773112439724949069L;

    private final Map<String, Method> methodMap;
    private final ImmutableAttributeMap<String> attributeMap;
    private final Map<String, StAXProcessor<?>> processorMap;
    private final Map<Path, Method> pathMap;
    private final ImmutableAttributeMap<Path> pathAttributeMap;
    private final Map<Path, StAXProcessor<?>> pathProcessorMap;
    private final Class<T> clazz;
    private final ConversionService conversionService;

    private String rootField = AnnotationHelper.ROOT_FIELD_DEFAULT;

    @SuppressWarnings("unused")
    private static final Logger LOGGER = LoggerFactory.getLogger(IdolAnnotationsProcessor.class);

    IdolAnnotationsProcessor(final Class<T> clazz, final ConversionService conversionService, final Properties properties, final IdolAnnotationsProcessorFactory idolAnnotationsProcessorFactory) {
        this.clazz = clazz;
        this.conversionService = conversionService;

        final IdolDocument documentAnnotation = clazz.getAnnotation(IdolDocument.class);

        if (documentAnnotation != null) {
            final AnnotationHelper annotationHelper = new AnnotationHelper(documentAnnotation);

            switch (documentAnnotation.fieldType()) {
                case PATH:
                    final Path rootPath = annotationHelper.getPath(properties);

                    rootField = rootPath.getFinalFieldName();
                    break;
                case FIELD:
                default:
                    rootField = annotationHelper.getFieldName(properties);
            }
        }

        final Map<String, Method> methodMap = new HashMap<>();
        final Map<String, StAXProcessor<?>> processorMap = new HashMap<>();
        final Map<Path, Method> pathMap = new HashMap<>();
        final Map<Path, StAXProcessor<?>> pathProcessorMap = new HashMap<>();

        final AttributeMap<String> attributeMap = new AttributeMap<>();
        final AttributeMap<Path> pathAttributeMap = new AttributeMap<>();

        final Method[] publicMethods = clazz.getMethods();
        final Method[] allMethods = clazz.getDeclaredMethods();

        final Set<Method> methods = new HashSet<>();
        methods.addAll(Arrays.asList(publicMethods));
        methods.addAll(Arrays.asList(allMethods));

        for (final Method method : methods) {
            final Class<?>[] parameterTypes = method.getParameterTypes();

            if (parameterTypes.length == 1) {
                final IdolField fieldAnnotation = method.getAnnotation(IdolField.class);

                if (fieldAnnotation != null) {
                    method.setAccessible(true);

                    final AnnotationHelper annotationHelper = new AnnotationHelper(fieldAnnotation);
                    final String attributeName = fieldAnnotation.attributeName();

                    switch (fieldAnnotation.fieldType()) {
                        case PATH:
                            final Path path = annotationHelper.getPath(properties);

                            if (!attributeName.isEmpty()) {
                                pathAttributeMap.put(path, attributeName, method);
                            } else {
                                pathMap.put(path, method);
                            }
                            break;
                        case FIELD:
                        default:
                            final String fieldName = annotationHelper.getFieldName(properties);

                            if (!attributeName.isEmpty()) {
                                attributeMap.put(fieldName, attributeName, method);
                            } else {
                                methodMap.put(fieldName, method);
                            }
                    }
                }

                final IdolProcessorField processorAnnotation = method.getAnnotation(IdolProcessorField.class);

                if (processorAnnotation != null) {
                    method.setAccessible(true);

                    if (fieldAnnotation != null) {
                        throw new IllegalStateException("Method " + method.getName() + " for class " + clazz.getCanonicalName() + " is annotated with both IdolField and IdolProcessorField");
                    }

                    final AnnotationHelper annotationHelper = new AnnotationHelper(processorAnnotation);

                    final Class<? extends StAXProcessor<?>> processorClass = processorAnnotation.processor();

                    final StAXProcessor<?> processor;

                    if (processorClass == ProcessorFieldDefaultProcessor.class) {
                        final Class<?> innerProcessorClass = method.getParameterTypes()[0];

                        if (innerProcessorClass.equals(clazz)) {
                            processor = this;
                        } else {
                            processor = idolAnnotationsProcessorFactory.forClass(innerProcessorClass);
                        }
                    } else {
                        try {
                            processor = processorClass.newInstance();
                        } catch (final InstantiationException | IllegalAccessException e) {
                            throw new AciServiceException(e);
                        }
                    }

                    switch (processorAnnotation.fieldType()) {
                        case PATH:
                            final Path path = annotationHelper.getPath(properties);

                            pathMap.put(path, method);
                            pathProcessorMap.put(path, processor);
                            break;
                        case FIELD:
                        default:
                            final String fieldName = annotationHelper.getFieldName(properties);

                            methodMap.put(fieldName, method);
                            processorMap.put(fieldName, processor);
                    }
                }
            }
        }

        this.methodMap = Collections.unmodifiableMap(methodMap);
        this.processorMap = Collections.unmodifiableMap(processorMap);
        this.pathMap = Collections.unmodifiableMap(pathMap);
        this.pathProcessorMap = Collections.unmodifiableMap(pathProcessorMap);

        this.attributeMap = new ImmutableAttributeMap<>(attributeMap);
        this.pathAttributeMap = new ImmutableAttributeMap<>(pathAttributeMap);
    }

    @Override
    public T process(final XMLStreamReader xmlStreamReader) {
        if (!xmlStreamReader.getLocalName().equals(rootField)) {
            throw new IllegalStateException("ReflectionProcessor must start on " + rootField);
        }

        Path path = new Path("");

        try {
            final Constructor<T> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);

            final T item = constructor.newInstance();

            boolean firstRun = true;

            while (firstRun || xmlStreamReader.hasNext()) {
                final int event;

                if (firstRun) {
                    event = xmlStreamReader.getEventType();
                } else {
                    event = xmlStreamReader.next();
                }

                if (event == XMLEvent.START_ELEMENT) {
                    final String localName = xmlStreamReader.getLocalName();

                    final Map<String, Method> attributeMethods = attributeMap.get(localName);
                    final Map<String, Method> pathAttributeMethods = pathAttributeMap.get(path);

                    for (final Map.Entry<String, Method> entry : attributeMethods.entrySet()) {
                        final Method setter = entry.getValue();
                        final String attributeValue = xmlStreamReader.getAttributeValue(null, entry.getKey());

                        // if it's null then the attribute isn't present, so don't call the method
                        if (attributeValue != null) {
                            callSetter(item, setter, attributeValue);
                        }
                    }

                    for (final Map.Entry<String, Method> entry : pathAttributeMethods.entrySet()) {
                        final Method setter = entry.getValue();
                        final String attributeValue = xmlStreamReader.getAttributeValue(null, entry.getKey());

                        if (attributeValue != null) {
                            callSetter(item, setter, attributeValue);
                        }
                    }

                    if (!firstRun) {
                        path = path.append(localName);
                    }

                    Method setter = methodMap.get(localName);
                    StAXProcessor<?> processor = processorMap.get(localName);

                    if (setter == null) {
                        for (final Path testPath : pathMap.keySet()) {
                            if (testPath.isEquivalent(path)) {
                                setter = pathMap.get(testPath);
                                processor = pathProcessorMap.get(testPath);
                            }
                        }
                    }

                    if (setter != null && processor != null) {
                        final Class<?> parameterType = setter.getParameterTypes()[0];

                        try {
                            if ((clazz.equals(parameterType) && !firstRun) || !clazz.equals(parameterType)) {
                                setter.invoke(item, processor.process(xmlStreamReader));

                                // processor consumes the end element event
                                path = path.removeLastComponent();
                            }
                        } catch (final IllegalArgumentException e) {
                            throw new AciServiceException("Processor return type is illegal argument for setter: ", e);
                        }
                    } else if (setter != null) {
                        final String elementText = xmlStreamReader.getElementText();

                        final boolean setField = callSetter(item, setter, elementText);

                        if (setField) {
                            path = path.removeLastComponent();
                        }

                        if (xmlStreamReader.getEventType() == XMLEvent.END_ELEMENT && rootField.equals(xmlStreamReader.getLocalName())) {
                            break;
                        }
                    }
                } else if (event == XMLEvent.END_ELEMENT) {
                    if (rootField.equals(xmlStreamReader.getLocalName())) {
                        break;
                    }

                    path = path.removeLastComponent();
                }

                firstRun = false;
            }

            return item;
        } catch (final InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | XMLStreamException e) {
            throw new AciServiceException(e);
        }
    }

    private boolean callSetter(final T item, final Method setter, final String value) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        final Class<?>[] parameters = setter.getParameterTypes();

        // should always exist as otherwise the method won't be in the map
        final Class<?> parameterType = parameters[0];

        boolean setField = false;

        if (parameterType.equals(String.class)) {
            setter.invoke(item, value);
            setField = true;
        } else if (conversionService.canConvert(String.class, parameterType)) {
            setter.invoke(item, conversionService.convert(value, String.class, parameterType));
            setField = true;
        } else if (parameterType.isEnum()) {
            // we can suppress unchecked because we know that parameterType is an enum type
            // we use raw types because the code fails at runtime if we use wildcards
            @SuppressWarnings({"unchecked", "rawtypes"})
            final Class<? extends Enum> enumType = (Class<? extends Enum>) parameterType;

            setter.invoke(item, Enum.valueOf(enumType, value));
            setField = true;
        } else {
            final Constructor<?>[] constructors = parameterType.getConstructors();

            for (final Constructor<?> constructor : constructors) {
                final Class<?>[] constructorParameters = constructor.getParameterTypes();

                if (constructorParameters.length == 1 && constructorParameters[0].equals(String.class)) {
                    setter.invoke(item, constructor.newInstance(value));
                    setField = true;
                    break;
                }
            }
        }
        return setField;
    }
}
