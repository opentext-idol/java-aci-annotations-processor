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

public abstract class MonitorItem {

    protected String id;
    protected int count;
    protected long start;
    protected String end = "";
    protected String value;

    public int getCount() {
        return count;
    }

    public abstract void setCount(final int count);

    public String getEnd() {
        return end;
    }

    public abstract void setEnd(final String end);

    public String getId() {
        return id;
    }

    public abstract void setId(final String id);

    public long getStart() {
        return start;
    }

    public abstract void setStart(final long start);

    public String getValue() {
        return value;
    }

    public abstract void setValue(final String value);

}
