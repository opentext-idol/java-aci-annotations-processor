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

@IdolDocument("controller")
public class Controller {

    private String UUID;
    private int port;
    private System system;

    private final List<Service> services = new LinkedList<>();

    public int getPort() {
        return port;
    }

    @IdolField(value = "controller", attributeName = "port")
    public void setPort(final int port) {
        this.port = port;
    }

    public List<Service> getServices() {
        return services;
    }

    @IdolProcessorField("service")
    public void addService(final Service service) {
        services.add(service);
    }

    public System getSystem() {
        return system;
    }

    @IdolProcessorField("system")
    public void setSystem(final System system) {
        this.system = system;
    }

    public String getUUID() {
        return UUID;
    }

    @IdolField(value = "controller", attributeName = "UUID")
    public void setUUID(final String UUID) {
        this.UUID = UUID;
    }

}
