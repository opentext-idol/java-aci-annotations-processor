/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class StringToDoubleConverter implements Converter<String, Double> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringToDoubleConverter.class);

    @Override
    public Double convert(final String in) {
        try {
            return Double.valueOf(in);
        } catch (final NumberFormatException e) {
            LOGGER.warn("Cannot convert \"{}\", returning 0", in);
            return 0d;
        }
    }

}
