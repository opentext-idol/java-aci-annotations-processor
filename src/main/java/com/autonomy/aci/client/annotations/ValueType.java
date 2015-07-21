/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations;

/**
 * Enum that determines how an annotation value will be resolved.
 */
public enum ValueType {

    /**
     * Denotes that the annotation value is a field or path literal.
     */
    LITERAL,

    /**
     * Denotes that the annotation value is a properties file key.
     */
    CONFIGURED

}
