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
 * Designates the target method as the build method for a given {@link com.autonomy.aci.client.annotations.IdolBuilder IdolBuilder}.
 * <p/>
 * This annotation has no effect if its parent class is not annotated with {@code IdolBuilder}.
 * <p/>
 * The target method must take no arguments and return an object whose type is the same as the enclosing class.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface IdolBuilderBuild {
}
