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

package com.autonomy.aci.client.annotations.testobjects.bugs.recursion;

import com.autonomy.aci.client.annotations.IdolDocument;
import com.autonomy.aci.client.annotations.IdolField;
import com.autonomy.aci.client.annotations.IdolProcessorField;

@IdolDocument("autn:node")
public class CategoryName {
    private String id = null;
    private String name = null;
    private CategoryName child;

    public CategoryName() {
    }

    public CategoryName(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    @IdolField("autn:id")
    public void setId(final String value) {
        if (this.id == null) {
            this.id = value;
        }
    }

    @IdolField("autn:name")
    public void setName(final String value) {
        if (this.name == null) {
            this.name = value;
        }
    }

    @IdolProcessorField("autn:node")
    public void addParent(final CategoryName category) {
        child = category;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public CategoryName getChild() {
        return child;
    }
}
