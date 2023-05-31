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

package com.autonomy.aci.client.annotations.testobjects.developer;

import com.autonomy.aci.client.annotations.FieldType;
import com.autonomy.aci.client.annotations.IdolDocument;
import com.autonomy.aci.client.annotations.IdolField;
import com.autonomy.aci.client.annotations.ValueType;

@IdolDocument(value = "document.developer.path", fieldType = FieldType.PATH, valueType = ValueType.CONFIGURED)
public class ConfiguredPathDeveloper {

    private String name;

    public String getName() {
        return name;
    }

    @IdolField("NAME")
    public void setName(final String name) {
        this.name = name;
    }

}
