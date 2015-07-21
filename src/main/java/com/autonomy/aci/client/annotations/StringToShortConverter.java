/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations;

class StringToShortConverter implements Converter<String, Short> {
    @Override
    public Short convert(final String in) {
        try {
            return Short.valueOf(in);
        } catch (final NumberFormatException e) {
            return 0;
        }
    }
}
