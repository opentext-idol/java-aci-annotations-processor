/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations;

class StringToCharacterConverter implements Converter<String, Character> {
    @Override
    public Character convert(final String in) {
        if (in.length() != 1) {
            throw new IllegalArgumentException(in + " is not a character literal. Consider using java.lang.String instead.");
        }

        try {
            return in.charAt(0);
        } catch (final IndexOutOfBoundsException e) {
            return '\u0000';
        }
    }
}
