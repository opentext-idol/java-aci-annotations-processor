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
