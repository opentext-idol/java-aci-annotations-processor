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
