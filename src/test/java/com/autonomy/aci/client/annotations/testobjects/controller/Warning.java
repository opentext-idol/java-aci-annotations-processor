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
