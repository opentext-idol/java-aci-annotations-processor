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

package com.autonomy.aci.client.annotations;

import com.autonomy.aci.client.services.StAXProcessor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that when the given IDOL field is reached a {@code StAXProcessor} with the given class should be called.
 * <p>
 * The method should take a single argument.
 * <p>
 * If no class is specified then the processor that is used will be generated via
 * {@link com.autonomy.aci.client.annotations.IdolAnnotationsProcessorFactory#forClass}
 * for the type of the first argument of the method. In this case the type of the first argument of the method should be
 * annotated with IDOL processor annotations.
 * <p>
 * Note: if your class depends upon annotated methods in a non-public superclass, the annotations will not be found. This
 * is a limitation of the Java Reflection libraries.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface IdolProcessorField {

    /**
     * @return The root field of the annotated class. If {@link com.autonomy.aci.client.annotations.IdolProcessorField#fieldType fieldType}
     * is {@link com.autonomy.aci.client.annotations.FieldType#PATH PATH} then
     * the path is relative to the root IDOL field for the class.
     */
    String value();

    /**
     * @return The class of the {@code StAXProcessor} to be used. If no value is given then a processor will be generated
     * using {@link com.autonomy.aci.client.annotations.IdolAnnotationsProcessorFactory#forClass}
     */
    Class<? extends StAXProcessor<?>> processor() default ProcessorFieldDefaultProcessor.class;

    /**
     * @return The {@link com.autonomy.aci.client.annotations.ValueType} of the
     * {@link com.autonomy.aci.client.annotations.IdolProcessorField#value value}
     */
    ValueType valueType() default ValueType.LITERAL;

    /**
     * @return The {@link com.autonomy.aci.client.annotations.FieldType} of the
     * {@link com.autonomy.aci.client.annotations.IdolProcessorField#value value}
     */
    FieldType fieldType() default FieldType.FIELD;

    /**
     * @return The defaultValue of the value if {@link com.autonomy.aci.client.annotations.IdolProcessorField#valueType valueType} is
     * {@link com.autonomy.aci.client.annotations.ValueType#CONFIGURED CONFIGURED} and no
     * entry for the key given in value is found
     */
    String defaultValue() default "";

}
