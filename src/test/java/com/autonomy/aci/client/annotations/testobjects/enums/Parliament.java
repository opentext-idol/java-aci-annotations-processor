/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
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
