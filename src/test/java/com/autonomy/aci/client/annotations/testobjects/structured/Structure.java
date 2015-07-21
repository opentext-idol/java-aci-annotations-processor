/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.structured;

import com.autonomy.aci.client.annotations.FieldType;
import com.autonomy.aci.client.annotations.IdolField;

public class Structure {
    private String scalar;
    private String author;
    private String packageName;

    public String getAuthor() {
        return author;
    }

    @IdolField(value = "autn:content/DOCUMENT/DATA/AUTHOR", fieldType = FieldType.PATH)
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

    @IdolField(value = "//SOURCE/MAIN/PACKAGE", fieldType = FieldType.PATH)
    public void setPackageName(final String packageName) {
        this.packageName = packageName;
    }
}
