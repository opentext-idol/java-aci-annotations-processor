/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations;

/**
 * Enum representing possible types for the values of the annotations.
 */
public enum FieldType {

    /**
     * Indicates that the value resolves to a field name
     */
    FIELD,

    /**
     * <p>
     * Indicates that the value resolves to a path in an IDOL document. Intended to be used when XML has been indexed
     * into IDOL.
     * <p>
     * Where a path is relative to is annotation dependent.
     * <p>
     * If a path begins with {@literal //} then it is treated as a wildcard and any combination path ending with the
     * remainder of the given value will match
     */
    PATH

}
