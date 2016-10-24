/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * Designates a static inner class as a builder for its outer class.  Using this annotation on a non static class has no effect.
 * <p>
 * A method inside the class should be annotated with {@link com.autonomy.aci.client.annotations.IdolBuilderBuild IdolBuilderBuild}.
 * <p>
 * Failure to do this will result in an {@code IllegalStateException} at runtime.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface IdolBuilder {
}
