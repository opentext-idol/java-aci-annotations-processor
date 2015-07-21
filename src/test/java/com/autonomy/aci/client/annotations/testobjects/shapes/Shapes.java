/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.shapes;

import com.autonomy.aci.client.annotations.IdolField;
import com.autonomy.aci.client.annotations.IdolProcessorField;

public class Shapes {

    private String scalar;
    private Rectangle rectangle;
    private Circle circle;

    public Circle getCircle() {
        return circle;
    }

    @IdolProcessorField(value = "CIRCLE", processor = CircleProcessor.class)
    public void setCircle(final Circle circle) {
        this.circle = circle;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    @IdolProcessorField("RECTANGLE")
    public void setRectangle(final Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public String getScalar() {
        return scalar;
    }

    @IdolField("SCALAR_FIELD")
    public void setScalar(final String scalar) {
        this.scalar = scalar;
    }

}
