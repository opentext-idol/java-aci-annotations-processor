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

package com.autonomy.aci.client.annotations.testobjects.enums;

import com.autonomy.aci.client.annotations.IdolField;

public class Parliament {

    private Leader tory;
    private Leader libDem;
    private Leader labour;

    public Leader getLabour() {
        return labour;
    }

    @IdolField("LABOUR")
    public void setLabour(final Leader labour) {
        this.labour = labour;
    }

    public Leader getLibDem() {
        return libDem;
    }

    @IdolField("LIB_DEM")
    public void setLibDem(final Leader libDem) {
        this.libDem = libDem;
    }

    public Leader getTory() {
        return tory;
    }

    @IdolField("TORY")
    public void setTory(final Leader tory) {
        this.tory = tory;
    }

}
