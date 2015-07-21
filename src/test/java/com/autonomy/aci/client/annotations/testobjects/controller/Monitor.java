/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.controller;

import com.autonomy.aci.client.annotations.IdolDocument;
import com.autonomy.aci.client.annotations.IdolField;
import com.autonomy.aci.client.annotations.IdolProcessorField;

import java.util.LinkedList;
import java.util.List;

@IdolDocument("monitor")
public class Monitor {

    private String name;
    private Status lastStatus;
    private long lastResultTime;
    private long interval;

    private final List<Error> errors = new LinkedList<>();
    private final List<Warning> warnings = new LinkedList<>();

    public List<Error> getErrors() {
        return errors;
    }

    @IdolProcessorField("error")
    public void addError(final Error monitorItem) {
        errors.add(monitorItem);
    }

    public List<Warning> getWarnings() {
        return warnings;
    }

    @IdolProcessorField("warning")
    public void addWarning(final Warning monitorItem) {
        warnings.add(monitorItem);
    }

    public long getInterval() {
        return interval;
    }

    @IdolField(value = "monitor", attributeName = "interval")
    public void setInterval(final long interval) {
        this.interval = interval;
    }

    public long getLastResultTime() {
        return lastResultTime;
    }

    @IdolField(value = "monitor", attributeName = "lastresulttime")
    public void setLastResultTime(final long lastResultTime) {
        this.lastResultTime = lastResultTime;
    }

    public Status getLastStatus() {
        return lastStatus;
    }

    @IdolField(value = "monitor", attributeName = "laststatus")
    public void setLastStatus(final Status lastStatus) {
        this.lastStatus = lastStatus;
    }

    public String getName() {
        return name;
    }

    @IdolField(value = "monitor", attributeName = "name")
    public void setName(final String name) {
        this.name = name;
    }
}
