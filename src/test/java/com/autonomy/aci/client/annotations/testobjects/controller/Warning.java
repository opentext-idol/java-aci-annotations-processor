/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.controller;

import com.autonomy.aci.client.annotations.IdolDocument;
import com.autonomy.aci.client.annotations.IdolField;

@IdolDocument("warning")
public class Warning extends MonitorItem {
    @Override
    @IdolField(value = "warning", attributeName = "count")
    public void setCount(final int count) {
        this.count = count;
    }

    @Override
    @IdolField(value = "warning", attributeName = "end")
    public void setEnd(final String end) {
        this.end = end;
    }

    @Override
    @IdolField(value = "warning", attributeName = "id")
    public void setId(final String id) {
        this.id = id;
    }

    @Override
    @IdolField(value = "warning", attributeName = "start")
    public void setStart(final long start) {
        this.start = start;
    }

    @Override
    @IdolField("warning")
    public void setValue(final String value) {
        this.value = value;
    }
}
