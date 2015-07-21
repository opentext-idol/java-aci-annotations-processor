/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations;

import java.util.Properties;

/**
 * Utility class that reduces duplication when parsing field values.
 */
class AnnotationHelper {

    private final String value;
    private final String defaultValue;
    private final ValueType valueType;
    static final String ROOT_FIELD_DEFAULT = "autn:hit";

    AnnotationHelper(final IdolDocument annotation) {
        this.value = annotation.value();
        this.defaultValue = annotation.defaultValue();
        this.valueType = annotation.valueType();
    }

    AnnotationHelper(final IdolField annotation) {
        this.value = annotation.value();
        this.defaultValue = annotation.defaultValue();
        this.valueType = annotation.valueType();
    }

    AnnotationHelper(final IdolProcessorField annotation) {
        this.value = annotation.value();
        this.defaultValue = annotation.defaultValue();
        this.valueType = annotation.valueType();
    }

    String getFieldName(final Properties properties) {
        final String fieldName;

        switch (valueType) {
            case CONFIGURED:
                final String annotationFieldName = properties.getProperty(value);

                if (annotationFieldName == null && !defaultValue.isEmpty()) {
                    fieldName = defaultValue;
                } else {
                    fieldName = annotationFieldName;
                }
                break;
            case LITERAL:
            default:
                fieldName = value;
        }

        return fieldName;
    }

    Path getPath(final Properties properties) {
        final String pathString = getFieldName(properties);
        return new Path(pathString);
    }
}
