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

package com.autonomy.aci.client.annotations.testobjects.structured;

import com.autonomy.aci.client.annotations.FieldType;
import com.autonomy.aci.client.annotations.IdolField;
import com.autonomy.aci.client.annotations.ValueType;

public class ConfiguredStructure {
    private String scalar;
    private String author;
    private String packageName;

    public String getAuthor() {
        return author;
    }

    @IdolField(value = "structure.author", fieldType = FieldType.PATH, valueType = ValueType.CONFIGURED)
    public void setAuthor(final String author) {
        this.author = author;
    }

    public String getScalar() {
        return scalar;
    }

    @IdolField("SCALAR")
    public void setScalar(final String scalar) {
        this.scalar = scalar;
    }

    public String getPackageName() {
        return packageName;
    }

    @IdolField(value = "structure.package", fieldType = FieldType.PATH, valueType = ValueType.CONFIGURED)
    public void setPackageName(final String packageName) {
        this.packageName = packageName;
    }
}
