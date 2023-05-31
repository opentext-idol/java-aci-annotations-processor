/*
 * Copyright 2015 Open Text.
 *
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License.
 *
 * The only warranties for products and services of Open Text and its affiliates
 * and licensors ("Open Text") are as may be set forth in the express warranty
 * statements accompanying such products and services. Nothing herein should be
 * construed as constituting an additional warranty. Open Text shall not be
 * liable for technical or editorial errors or omissions contained herein. The
 * information contained herein is subject to change without notice.
 */

package com.autonomy.aci.client.annotations.testobjects.shapes;

import com.autonomy.aci.client.annotations.IdolField;
import com.autonomy.aci.client.annotations.IdolProcessorField;
import com.autonomy.aci.client.annotations.ValueType;

public class ConfiguredShapes {

    private String scalar;
    private Rectangle rectangle;
    private Circle circle;

    public Circle getCircle() {
        return circle;
    }

    @IdolProcessorField(value = "field.circle", valueType = ValueType.CONFIGURED, processor = CircleProcessor.class)
    public void setCircle(final Circle circle) {
        this.circle = circle;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    @IdolProcessorField(value = "field.rectangle", valueType = ValueType.CONFIGURED)
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
