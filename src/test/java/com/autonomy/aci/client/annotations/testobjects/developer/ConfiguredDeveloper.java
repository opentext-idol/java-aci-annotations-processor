/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.developer;

import com.autonomy.aci.client.annotations.IdolDocument;
import com.autonomy.aci.client.annotations.IdolField;
import com.autonomy.aci.client.annotations.ValueType;

@IdolDocument(value = "document.developer", valueType = ValueType.CONFIGURED)
public class ConfiguredDeveloper {

    private String name;

    public String getName() {
        return name;
    }

    @IdolField("NAME")
    public void setName(final String name) {
        this.name = name;
    }

}
