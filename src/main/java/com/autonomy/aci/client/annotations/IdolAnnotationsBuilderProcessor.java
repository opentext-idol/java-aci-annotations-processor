/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations;

import com.autonomy.aci.client.services.AciServiceException;
import com.autonomy.aci.client.services.StAXProcessor;
import com.autonomy.aci.client.services.impl.AbstractStAXProcessor;

import javax.xml.stream.XMLStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Processor that uses the builder pattern.
 * @param <T> The type that the builder returns
 */
class IdolAnnotationsBuilderProcessor<T> extends AbstractStAXProcessor<T> {
    private static final long serialVersionUID = -7335827681067090053L;

    private StAXProcessor<?> builderProcessor;
    private Method buildMethod;

    IdolAnnotationsBuilderProcessor(final Class<T> clazz, final Class<?> builderClass, final IdolAnnotationsProcessorFactory idolAnnotationsProcessorFactory) {
        final Method[] methods = builderClass.getDeclaredMethods();

        for (final Method method : methods) {
            if (method.getAnnotation(IdolBuilderBuild.class) != null && method.getParameterTypes().length == 0 && method.getReturnType() == clazz) {
                buildMethod = method;
            }
        }

        if (buildMethod == null) {
            throw new IllegalStateException(builderClass.getCanonicalName() + " does not have a zero parameter method annotated with " + IdolBuilderBuild.class.getCanonicalName() + " with return type " + clazz.getCanonicalName());
        }

        setBuilderProcessor(idolAnnotationsProcessorFactory.forClass(builderClass));
    }

    @Override
    public T process(final XMLStreamReader xmlStreamReader) {
        final Object builder = builderProcessor.process(xmlStreamReader);

        try {
            // we have verified that buildMethod returns an object of type T at construction time
            // need the local variable to suppress warnings
            @SuppressWarnings({"unchecked", "UnnecessaryLocalVariable"})
            final T object = (T) buildMethod.invoke(builder);
            return object;
        } catch (final IllegalAccessException | InvocationTargetException e) {
            throw new AciServiceException(e);
        }
    }

    private void setBuilderProcessor(final Object object) {
        this.builderProcessor = (StAXProcessor<?>) object;
    }
}
