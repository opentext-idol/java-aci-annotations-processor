/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.pathological;

import com.autonomy.aci.client.annotations.IdolField;
import com.autonomy.aci.client.annotations.IdolProcessorField;

public class Pathological {

    private String foo;

    @IdolField("CLEAN_TWEET")
    @IdolProcessorField("CLEAN_TWEET")
    public void setFoo(final String foo) {
        this.foo = foo;
    }
}
