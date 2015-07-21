/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
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
