/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.shapes;

import com.autonomy.aci.client.annotations.IdolDocument;
import com.autonomy.aci.client.annotations.IdolField;

@IdolDocument("RECTANGLE")
public class Rectangle {

    private int x0;
    private int x1;
    private int y0;
    private int y1;

    public int getX0() {
        return x0;
    }

    @IdolField("X0")
    public void setX0(final int x0) {
        this.x0 = x0;
    }

    public int getX1() {
        return x1;
    }

    @IdolField("X1")
    public void setX1(final int x1) {
        this.x1 = x1;
    }

    public int getY0() {
        return y0;
    }

    @IdolField("Y0")
    public void setY0(final int y0) {
        this.y0 = y0;
    }

    public int getY1() {
        return y1;
    }

    @IdolField("Y1")
    public void setY1(final int y1) {
        this.y1 = y1;
    }

}
