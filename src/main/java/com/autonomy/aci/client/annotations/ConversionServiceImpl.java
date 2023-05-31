/*
 * Copyright 2015 Open Text.
 *
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License.
 *
 * The only warranties for products and services of Open Text and its affiliates
 * and licensors ("Open Text") are as may be set forth in the express warranty
 * statements accompanying such products and services. Nothing herein should be
 * construed as constituting an additional warranty. Open Text shall not be
 * liable for technical or editorial errors or omissions contained herein. The
 * information contained herein is subject to change without notice.
 */

package com.autonomy.aci.client.annotations;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Default implementation of ConversionService.
 */
class ConversionServiceImpl implements ConversionService {

    private final ConcurrentMap<ClassPair, Converter<?, ?>> converters = new ConcurrentHashMap<>();

    public ConversionServiceImpl() {
        registerConverter(new StringToDoubleConverter(), String.class, Double.class);
        registerConverter(new StringToDoubleConverter(), String.class, Double.TYPE);

        registerConverter(new StringToByteConverter(), String.class, Byte.class);
        registerConverter(new StringToByteConverter(), String.class, Byte.TYPE);

        registerConverter(new StringToIntegerConverter(), String.class, Integer.class);
        registerConverter(new StringToIntegerConverter(), String.class, Integer.TYPE);

        registerConverter(new StringToFloatConverter(), String.class, Float.class);
        registerConverter(new StringToFloatConverter(), String.class, Float.TYPE);

        registerConverter(new StringToShortConverter(), String.class, Short.class);
        registerConverter(new StringToShortConverter(), String.class, Short.TYPE);

        registerConverter(new StringToCharacterConverter(), String.class, Character.class);
        registerConverter(new StringToCharacterConverter(), String.class, Character.TYPE);

        registerConverter(new StringToBooleanConverter(), String.class, Boolean.class);
        registerConverter(new StringToBooleanConverter(), String.class, Boolean.TYPE);

        registerConverter(new StringToLongConverter(), String.class, Long.class);
        registerConverter(new StringToLongConverter(), String.class, Long.TYPE);
    }

    @Override
    public <S, T> boolean canConvert(final Class<S> inClass, final Class<T> outClass) {
        final ClassPair classPair = new ClassPair(inClass, outClass);

        return converters.containsKey(classPair);
    }

    @Override
    public <S, T> T convert(final S in, final Class<S> inClass, final Class<T> outClass) {
        final ClassPair classPair = new ClassPair(inClass, outClass);

        @SuppressWarnings("unchecked")
        // converters are only registered in the constructor where they are correctly registered
        final Converter<S, T> converter = (Converter<S, T>) converters.get(classPair);
        return converter.convert(in);
    }

    @Override
    public <S, T> void registerConverter(final Converter<S, T> converter, final Class<S> inClass, final Class<T> outClass) {
        final ClassPair classPair = new ClassPair(inClass, outClass);
        converters.put(classPair, converter);
    }

    private static class ClassPair {
        @SuppressWarnings("unused") // Used by reflectionEquals and reflectionHashCode
        private final Class<?> in;

        @SuppressWarnings("unused") // Used by reflectionEquals and reflectionHashCode
        private final Class<?> out;

        private ClassPair(final Class<?> in, final Class<?> out) {
            this.in = in;
            this.out = out;
        }

        @Override
        public boolean equals(final Object o) {
            return EqualsBuilder.reflectionEquals(this, o);
        }

        @Override
        public int hashCode() {
            return HashCodeBuilder.reflectionHashCode(this);
        }
    }

}
