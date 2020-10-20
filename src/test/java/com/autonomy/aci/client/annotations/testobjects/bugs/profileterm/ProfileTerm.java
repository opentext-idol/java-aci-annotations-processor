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

package com.autonomy.aci.client.annotations.testobjects.bugs.profileterm;

import com.autonomy.aci.client.annotations.IdolDocument;
import com.autonomy.aci.client.annotations.IdolField;

@IdolDocument("autn:term")
public class ProfileTerm {

    private String name;
    private long weight;

    public String getName() {
        return name;
    }

    @IdolField("autn:term")
    public void setName(final String name) {
        this.name = name;
    }

    public long getWeight() {
        return weight;
    }

    @IdolField(value = "autn:term", attributeName = "weight")
    public void setWeight(final long weight) {
        this.weight = weight;
    }

}
