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