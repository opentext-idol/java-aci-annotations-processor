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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that a method should be called with the result of an IDOL field. The method should take a single argument.
 * <p>
 * If the first argument has type {@code String} the method will be called with the value of the IDOL field.
 * <p>
 * If the first argument is a primitive type or boxed wrapper class the value of the IDOL field will be converted to
 * the correct type.
 * <ul>
 * <li> For {@code char}/{@code Character}, an {@code IllegalArgumentException} will be thrown if the field value
 * does not have length 1.
 * <li> For numeric types, if the field value cannot be converted then 0 will be returned.  This includes overflow cases.
 * It is the client's responsibility to ensure the chosen numeric type is large enough to handle all possible values.
 * </ul>
 * <p>
 * If the first argument as a constructor that takes a single string then that constructor will be called with the value
 * of the IDOL field.
 * <p>
 * Note: if your class depends upon annotated methods in a non-public superclass, the annotations will not be found.  This
 * is a limitation of the Java Reflection libraries
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface IdolField {

    /**
     * @return The root field of the annotated class. If {@link com.autonomy.aci.client.annotations.IdolField#fieldType fieldType}
     * is {@link com.autonomy.aci.client.annotations.FieldType#PATH PATH} then the path is relative to the root IDOL
     * field for the class.
     */
    String value();

    /**
     * If present, the value will be read from the attribute of the IDOL field with the given name, instead of the IDOL
     * field value.
     * @return The attribute name to read the value from
     */
    String attributeName() default "";

    /**
     * @return The {@link com.autonomy.aci.client.annotations.ValueType} of the
     * {@link com.autonomy.aci.client.annotations.IdolField#value value}
     */
    ValueType valueType() default ValueType.LITERAL;

    /**
     * @return The {@link com.autonomy.aci.client.annotations.FieldType} of the
     * {@link com.autonomy.aci.client.annotations.IdolField#value value}
     */
    FieldType fieldType() default FieldType.FIELD;

    /**
     * @return The defaultValue of the value if {@link com.autonomy.aci.client.annotations.IdolField#valueType valueType}
     * is {@link com.autonomy.aci.client.annotations.ValueType#CONFIGURED CONFIGURED} and no entry for the key given in
     * value is found
     */
    String defaultValue() default "";

}
