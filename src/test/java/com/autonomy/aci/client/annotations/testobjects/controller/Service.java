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

@IdolDocument("service")
public class Service {

    private int port;
    private String name;
    private String labels;
    private RunState runState;

    private final List<Monitor> monitors = new LinkedList<>();

    public List<Monitor> getMonitors() {
        return monitors;
    }

    @IdolProcessorField("monitor")
    public void addMonitor(final Monitor monitor) {
        monitors.add(monitor);
    }

    public String getLabels() {
        return labels;
    }

    @IdolField(value = "service", attributeName = "labels")
    public void setLabels(final String labels) {
        this.labels = labels;
    }

    public String getName() {
        return name;
    }

    @IdolField(value = "service", attributeName = "name")
    public void setName(final String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    @IdolField(value = "service", attributeName = "port")
    public void setPort(final int port) {
        this.port = port;
    }

    public RunState getRunState() {
        return runState;
    }

    @IdolField(value = "service", attributeName = "runstate")
    public void setRunState(final RunState runState) {
        this.runState = runState;
    }
}
