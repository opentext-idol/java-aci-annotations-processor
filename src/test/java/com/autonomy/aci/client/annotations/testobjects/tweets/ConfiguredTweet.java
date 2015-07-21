/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.tweets;

import com.autonomy.aci.client.annotations.IdolField;
import com.autonomy.aci.client.annotations.ValueType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ConfiguredTweet {

    private String reference;
    private String cleanTweet;
    private double positivity;

    public String getReference() {
        return reference;
    }

    @IdolField(value = "field.reference", valueType = ValueType.CONFIGURED, defaultValue = "autn:reference")
    public void setReference(final String reference) {
        this.reference = reference;
    }

    public String getCleanTweet() {
        return cleanTweet;
    }

    @IdolField(value = "field.cleanTweet", valueType = ValueType.CONFIGURED)
    public void setCleanTweet(final String cleanTweet) {
        this.cleanTweet = cleanTweet;
    }

    public double getPositivity() {
        return positivity;
    }

    @IdolField(value = "field.positivity", valueType = ValueType.CONFIGURED)
    public void setPositivity(final double positivity) {
        this.positivity = positivity;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
