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
