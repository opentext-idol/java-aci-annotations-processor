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

package com.autonomy.aci.client.annotations.testobjects.bugs.buildertest;

import com.autonomy.aci.client.annotations.IdolBuilder;
import com.autonomy.aci.client.annotations.IdolBuilderBuild;
import com.autonomy.aci.client.annotations.IdolDocument;
import com.autonomy.aci.client.annotations.IdolField;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@IdolDocument("schedule")
public class Schedule {

    private final String name;
    private final String interval;
    private String controllerName;

    private Schedule(final String name, final String interval) {
        this.interval = interval;
        this.name = name;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(final String controllerName) {
        this.controllerName = controllerName;
    }

    public String getInterval() {
        return interval;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @IdolBuilder
    @IdolDocument("schedule")
    public static class Builder {
        private String name;
        private String interval;
        private String controllerName;

        @IdolField("interval")
        public void setInterval(final String interval) {
            this.interval = interval;
        }

        @IdolField("name")
        public void setName(final String name) {
            this.name = name;
        }

        @IdolBuilderBuild
        public Schedule build() {
            return new Schedule(name, interval);
        }
    }
}
