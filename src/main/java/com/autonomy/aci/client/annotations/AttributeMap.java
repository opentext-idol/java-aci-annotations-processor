/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class AttributeMap<T> {

    private final Map<T, Map<String, Method>> map = new HashMap<>();

    void put(final T key, final String attributeName, final Method method) {
        Map<String, Method> methodMap = map.get(key);

        if (methodMap == null) {
            methodMap = new HashMap<>();
            map.put(key, methodMap);
        }

        methodMap.put(attributeName, method);
    }

    Map<String, Method> get(final T key) {
        final Map<String, Method> methodMap = map.get(key);
        return methodMap != null ? methodMap : new HashMap<String, Method>();
    }

}
