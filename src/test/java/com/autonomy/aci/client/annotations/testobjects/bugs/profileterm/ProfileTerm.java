/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
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
