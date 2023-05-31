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
