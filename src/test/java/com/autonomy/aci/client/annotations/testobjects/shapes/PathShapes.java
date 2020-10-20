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

package com.autonomy.aci.client.annotations.testobjects.shapes;

import com.autonomy.aci.client.annotations.FieldType;
import com.autonomy.aci.client.annotations.IdolField;
import com.autonomy.aci.client.annotations.IdolProcessorField;

public class PathShapes {

    private String scalar;
    private Rectangle rectangle;
    private Circle circle;

    public Circle getCircle() {
        return circle;
    }

    @IdolProcessorField(value = "//CIRCLE", processor = CircleProcessor.class, fieldType = FieldType.PATH)
    public void setCircle(final Circle circle) {
        this.circle = circle;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    @IdolProcessorField(value = "autn:content/DOCUMENT/RECTANGLE", fieldType = FieldType.PATH)
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
