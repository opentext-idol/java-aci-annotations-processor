/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.tweets;

import com.autonomy.aci.client.annotations.IdolBuilder;
import com.autonomy.aci.client.annotations.IdolBuilderBuild;
import com.autonomy.aci.client.annotations.IdolField;

public class TweetWithBuilder {
    private final String reference;
    private final String cleanTweet;
    private final double positivity;

    private TweetWithBuilder(final String cleanTweet, final double positivity, final String reference) {
        this.cleanTweet = cleanTweet;
        this.positivity = positivity;
        this.reference = reference;
    }

    public String getCleanTweet() {
        return cleanTweet;
    }

    public double getPositivity() {
        return positivity;
    }

    public String getReference() {
        return reference;
    }

    @IdolBuilder
    public static class Builder {
        private String reference;
        private String cleanTweet;
        private double positivity;

        @IdolField("CLEAN_TWEET")
        public void setCleanTweet(final String cleanTweet) {
            this.cleanTweet = cleanTweet;
        }

        @IdolField("POSITIVITY")
        public void setPositivity(final double positivity) {
            this.positivity = positivity;
        }

        @IdolField("autn:reference")
        public void setReference(final String reference) {
            this.reference = reference;
        }

        @IdolBuilderBuild
        public TweetWithBuilder build() {
            return new TweetWithBuilder(cleanTweet, positivity, reference);
        }
    }
}
