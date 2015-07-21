/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.primitive;

import com.autonomy.aci.client.annotations.IdolField;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class StringWrapper {

    private String wrappedString;

    public String getWrappedString() {
        return wrappedString;
    }

    @IdolField("PROFILE_IMAGE_URL")
    public void setWrappedString(final String wrappedString) {
        this.wrappedString = wrappedString;
    }

    @Override
    public boolean equals(final Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

}
