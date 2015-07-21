/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations;

/**
 * Interface that defines a service for converting objects to different types.
 */
interface ConversionService {

    /**
     * Register a Converter with this ConversionService.
     * @param converter The converter
     * @param inClass The class of the converter's input type
     * @param outClass The class of the converter's output type
     * @param <S> The input type of the converter
     * @param <T> The output type of the converter
     */
    <S, T> void registerConverter(Converter<S, T> converter, Class<S> inClass, Class<T> outClass);

    /**
     * Convert the "in" object to the type S, using one of the registered Converters.
     * @param in The input object
     * @param inClass The class to use for the input object
     * @param outClass The class to output
     * @param <S> The type to use for the input object
     * @param <T> The type to output
     * @return The result of converting the input
     */
    <S, T> T convert(S in, Class<S> inClass, Class<T> outClass);

    /**
     * Check that this ConversionService can convert from the "in" class to the "out" class.
     * @param in The input class
     * @param out The output class
     * @param <S> The type represented by the input class
     * @param <T> The type represented by the output class
     * @return True if this ConversionService can convert from the given input class to the given output class
     */
    <S, T> boolean canConvert(Class<S> in, Class<T> out);

}
