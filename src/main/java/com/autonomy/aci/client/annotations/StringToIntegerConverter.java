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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class StringToIntegerConverter implements Converter<String, Integer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringToIntegerConverter.class);

    @Override
    public Integer convert(final String in) {
        try {
            return Integer.valueOf(in);
        } catch (final NumberFormatException e) {
            LOGGER.warn("Cannot convert \"{}\", returning 0", in);
            return 0;
        }
    }

}
