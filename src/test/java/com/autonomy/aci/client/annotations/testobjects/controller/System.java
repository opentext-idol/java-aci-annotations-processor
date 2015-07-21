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

@IdolDocument("system")
public class System {

    private String hostName;
    private String ipAddress;
    private String os;

    private final List<Monitor> monitors = new LinkedList<>();

    public List<Monitor> getMonitors() {
        return monitors;
    }

    @IdolProcessorField("monitor")
    public void addMonitor(final Monitor monitor) {
        monitors.add(monitor);
    }

    public String getHostName() {
        return hostName;
    }

    @IdolField(value = "system", attributeName = "hostname")
    public void setHostName(final String hostName) {
        this.hostName = hostName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    @IdolField(value = "system", attributeName = "ip")
    public void setIpAddress(final String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getOs() {
        return os;
    }

    @IdolField(value = "system", attributeName = "os")
    public void setOs(final String os) {
        this.os = os;
    }
}
