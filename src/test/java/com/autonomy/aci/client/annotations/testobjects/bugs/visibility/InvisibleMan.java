/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.bugs.visibility;

import com.autonomy.aci.client.annotations.IdolDocument;
import com.autonomy.aci.client.annotations.IdolField;

// note package visibility
@IdolDocument("man")
class InvisibleMan {

    private String name;
    private boolean isVisible;

    boolean isVisible() {
        return isVisible;
    }

    @IdolField("visible")
    void setVisible(final boolean visible) {
        isVisible = visible;
    }

    String getName() {
        return name;
    }

    @IdolField("name")
    void setName(final String name) {
        this.name = name;
    }
}
