/*
 * (c) Copyright 2015 Micro Focus or one of its affiliates.
 *
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License.
 *
 * The only warranties for products and services of Micro Focus and its affiliates
 * and licensors ("Micro Focus") are as may be set forth in the express warranty
 * statements accompanying such products and services. Nothing herein should be
 * construed as constituting an additional warranty. Micro Focus shall not be
 * liable for technical or editorial errors or omissions contained herein. The
 * information contained herein is subject to change without notice.
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
