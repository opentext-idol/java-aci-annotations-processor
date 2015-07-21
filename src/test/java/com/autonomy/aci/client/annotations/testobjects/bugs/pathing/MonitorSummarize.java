/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.bugs.pathing;

import com.autonomy.aci.client.annotations.FieldType;
import com.autonomy.aci.client.annotations.IdolDocument;
import com.autonomy.aci.client.annotations.IdolField;
import com.autonomy.aci.client.annotations.IdolProcessorField;

import java.util.ArrayList;
import java.util.List;

@IdolDocument("monitor")
public class MonitorSummarize {

    private String name;
    private String scriptName;
    private final List<MonitorStatus> currentStatus = new ArrayList<>();
    private int errors;
    private int warnings;
    private String otherReports;

    @IdolField(value = "name")
    public void setName(final String name) {
        this.name = name;
    }

    @IdolField("scriptName")
    public void setScriptName(final String scriptName) {
        this.scriptName = scriptName;
    }

    @IdolProcessorField(value = "currentStatus/status", fieldType = FieldType.PATH)
    public void addLastStatus(final MonitorStatus currentStatus) {
        this.currentStatus.add(currentStatus);
    }

    @IdolField(value = "errors")
    public void setErrors(final int errors) {
        this.errors = errors;
    }

    @IdolField(value = "warnings")
    public void setWarnings(final int warnings) {
        this.warnings = warnings;
    }

    @IdolField(value = "otherReports")
    public void setOtherReports(final String otherReports) {
        this.otherReports = otherReports;
    }

    public List<MonitorStatus> getCurrentStatus() {
        return currentStatus;
    }

    public int getErrors() {
        return errors;
    }

    public String getName() {
        return name;
    }

    public String getOtherReports() {
        return otherReports;
    }

    public String getScriptName() {
        return scriptName;
    }

    public int getWarnings() {
        return warnings;
    }
}
