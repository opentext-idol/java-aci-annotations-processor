/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.controller;

import com.autonomy.aci.client.annotations.IdolDocument;
import com.autonomy.aci.client.annotations.IdolField;

@IdolDocument("error")
public class Error extends MonitorItem {
    @Override
    @IdolField(value = "error", attributeName = "count")
    public void setCount(final int count) {
        this.count = count;
    }

    @Override
    @IdolField(value = "error", attributeName = "end")
    public void setEnd(final String end) {
        this.end = end;
    }

    @Override
    @IdolField(value = "error", attributeName = "id")
    public void setId(final String id) {
        this.id = id;
    }

    @Override
    @IdolField(value = "error", attributeName = "start")
    public void setStart(final long start) {
        this.start = start;
    }

    @Override
    @IdolField("error")
    public void setValue(final String value) {
        this.value = value;
    }
}
