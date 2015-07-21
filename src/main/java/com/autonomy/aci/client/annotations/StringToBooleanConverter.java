/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations;

class StringToBooleanConverter implements Converter<String, Boolean> {
    @Override
    public Boolean convert(final String in) {
        return Boolean.valueOf(in);
    }
}
