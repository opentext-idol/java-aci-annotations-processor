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

package com.autonomy.aci.client.annotations.testobjects.tweets;

import com.autonomy.aci.client.annotations.IdolField;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Tweet {
    private String reference;
    private String cleanTweet;
    private double positivity;

    public String getReference() {
        return reference;
    }

    @IdolField("autn:reference")
    public void setReference(final String reference) {
        this.reference = reference;
    }

    public String getCleanTweet() {
        return cleanTweet;
    }

    @IdolField("CLEAN_TWEET")
    public void setCleanTweet(final String cleanTweet) {
        this.cleanTweet = cleanTweet;
    }

    public double getPositivity() {
        return positivity;
    }

    @IdolField("POSITIVITY")
    public void setPositivity(final double positivity) {
        this.positivity = positivity;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
