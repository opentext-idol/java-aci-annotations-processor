/*
 * (c) Copyright 2015 Micro Focus or one of its affiliates.
 *
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License.
 *
 * The only warranties for products and services of Micro Focus and its affiliates
 * and licensors ("Micro Focus") are as may be set forth in the express warranty
 * statements accompanying such products and services. Nothing herein should be
 * construed as constituting an additional warranty. Micro Focus shall not be
 * liable for technical or editorial errors or omissions contained herein. The
 * information contained herein is subject to change without notice.
 */

package com.autonomy.aci.client.annotations;

import com.autonomy.aci.client.services.StAXProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Default implementation of {@link IdolAnnotationsProcessorFactory}.
 */
public class IdolAnnotationsProcessorFactoryImpl implements IdolAnnotationsProcessorFactory {

    private final ConversionService conversionService;

    private final ConcurrentMap<Class<?>, IdolAnnotationsListProcessor<?>> listProcessors = new ConcurrentHashMap<>();
    private final ConcurrentMap<Class<?>, StAXProcessor<?>> processors = new ConcurrentHashMap<>();
    private final AtomicReference<Properties> properties = new AtomicReference<>(new Properties());

    private static final Logger LOGGER = LoggerFactory.getLogger(IdolAnnotationsProcessorFactoryImpl.class);

    public IdolAnnotationsProcessorFactoryImpl() {
        this.conversionService = new ConversionServiceImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> StAXProcessor<T> forClass(final Class<T> clazz) {
        final StAXProcessor<T> processor = (StAXProcessor<T>) processors.get(clazz);

        if (processor != null) {
            return processor;
        } else {
            final Class<?>[] classes = clazz.getClasses();

            StAXProcessor<T> newProcessor = null;

            for (final Class<?> innerClass : classes) {
                if (innerClass.getAnnotation(IdolBuilder.class) != null) {
                    if (Modifier.isStatic(innerClass.getModifiers())) {
                        newProcessor = new IdolAnnotationsBuilderProcessor<>(clazz, innerClass, this);
                    } else {
                        LOGGER.warn("{} designated as IdolBuilder but is not static so the annotation has no effect.", innerClass.getCanonicalName());
                    }
                }
            }

            if (newProcessor == null) {
                newProcessor = new IdolAnnotationsProcessor<>(clazz, conversionService, properties.get(), this);
            }

            processors.putIfAbsent(clazz, newProcessor);
            return newProcessor;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> StAXProcessor<List<T>> listProcessorForClass(final Class<T> clazz) {
        @SuppressWarnings("unchecked")
        // listProcessors is private and only contains IdolAnnotationsListProcessor
        final IdolAnnotationsListProcessor<T> processor = (IdolAnnotationsListProcessor<T>) listProcessors.get(clazz);

        if (processor != null) {
            return processor;
        } else {
            final IdolAnnotationsListProcessor<T> newProcessor = new IdolAnnotationsListProcessor<>(clazz, this, properties.get());
            listProcessors.putIfAbsent(clazz, newProcessor);
            return newProcessor;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setProperties(final Properties properties) {
        this.properties.set(properties);

        //clear the maps as the processors contained within may now be incorrect 
        listProcessors.clear();
        processors.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setResourceBundle(final ResourceBundle resourceBundle) {
        final Properties properties = new Properties();

        for (final String key : resourceBundle.keySet()) {
            properties.setProperty(key, resourceBundle.getString(key));
        }

        setProperties(properties);
    }
}
