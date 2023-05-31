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

import java.lang.reflect.Method;
import java.util.Map;

class ImmutableAttributeMap<T> {

    private final AttributeMap<T> attributeMap;

    ImmutableAttributeMap(final AttributeMap<T> attributeMap) {
        this.attributeMap = attributeMap;
    }

    Map<String, Method> get(final T key) {
        return attributeMap.get(key);
    }

}
