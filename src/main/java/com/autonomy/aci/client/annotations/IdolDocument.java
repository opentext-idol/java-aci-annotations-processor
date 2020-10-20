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

package com.autonomy.aci.client.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Optional annotation used to designate a class as having IDOL annotations.
 * <p>
 * Designates an IDOL field as the root field of the annotated class.
 * <p>
 * Note: if your class depends upon annotated methods in a non-public superclass, the annotations will not be found. This
 * is a limitation of the Java Reflection libraries.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface IdolDocument {

    /**
     * @return The root field of the annotated class. If {@link com.autonomy.aci.client.annotations.IdolDocument#fieldType fieldType}
     * is {@link com.autonomy.aci.client.annotations.FieldType#PATH PATH} then the path is relative to the root of the
     * IDOL response.
     */
    String value() default AnnotationHelper.ROOT_FIELD_DEFAULT;

    /**
     * @return The {@link com.autonomy.aci.client.annotations.ValueType} of the
     * {@link com.autonomy.aci.client.annotations.IdolDocument#value value}.
     */
    ValueType valueType() default ValueType.LITERAL;

    /**
     * @return The {@link com.autonomy.aci.client.annotations.FieldType} of the
     * {@link com.autonomy.aci.client.annotations.IdolDocument#value value}.
     */
    FieldType fieldType() default FieldType.FIELD;

    /**
     * @return The defaultValue of the value if {@link com.autonomy.aci.client.annotations.IdolDocument#valueType valueType}
     * is {@link com.autonomy.aci.client.annotations.ValueType#CONFIGURED CONFIGURED} and no entry for the key given in
     * value is found.
     */
    String defaultValue() default "";

}
