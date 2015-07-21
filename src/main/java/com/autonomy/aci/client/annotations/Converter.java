/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations;

/**
 * Defines a interface for converting a value from one type to another.
 * @param <S> The type of the input argument
 * @param <T> The return type of the converter
 */
interface Converter<S,T> {

    /**
     * Convert the input to an instance of the output type.
     * @param in The input object
     * @return The input object converted to an instance of the output type
     */
    T convert(S in);

}
