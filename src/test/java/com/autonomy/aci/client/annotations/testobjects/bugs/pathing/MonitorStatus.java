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

package com.autonomy.aci.client.annotations.testobjects.bugs.pathing;

import com.autonomy.aci.client.annotations.IdolDocument;
import com.autonomy.aci.client.annotations.IdolField;

import java.util.Date;

@IdolDocument("status")
public class MonitorStatus {

    private String id;
    private String type;
    private Date startTime;
    private Date endTime;
    private String message;

    @IdolField(value = "status", attributeName = "id")
    public void setId(final String id) {
        this.id = id;
    }

    @IdolField(value = "status", attributeName = "type")
    public void setType(final String type) {
        this.type = type;
    }

    @IdolField(value = "status", attributeName = "startTime")
    public void setStartTime(final String startTime) {
        this.startTime = new Date(Long.parseLong(startTime) * 1000);
    }

    @IdolField(value = "status", attributeName = "endTime")
    public void setEndTime(final String endTime) {
        this.endTime = new Date(Long.parseLong(endTime) * 1000);
    }

    @IdolField(value = "status", attributeName = "message")
    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     * Clone getters added to avoid Findbugs exposure of Timestamp class.
     */
    public Date getStartTime() {
        return (Date) this.startTime.clone();
    }

    public Date getEndTime() {
        return (Date) this.endTime.clone();
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }
}
