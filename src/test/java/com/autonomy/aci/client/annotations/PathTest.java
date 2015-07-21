/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PathTest {
    private Path path1;
    private Path path2;
    private Path path3;
    private Path path4;
    private Path path5;

    @Before
    public void setUp() {
        path1 = new Path("a/b/c/d");
        path2 = new Path("//c/d");
        path3 = new Path("f/g/c/d");
        path4 = new Path("//h/i");
        path5 = new Path("");
    }

    @Test
    public void testReflexive() {
        assertThat(path1.isEquivalent(path1), is(true));
        assertThat(path2.isEquivalent(path2), is(true));
        assertThat(path3.isEquivalent(path3), is(true));
        assertThat(path4.isEquivalent(path4), is(true));
        assertThat(path5.isEquivalent(path5), is(true));
    }

    @Test
    public void testStartToken() {
        assertThat(path1.isEquivalent(path2), is(true));
        assertThat(path2.isEquivalent(path1), is(true));

        assertThat(path3.isEquivalent(path2), is(true));
        assertThat(path2.isEquivalent(path3), is(true));
    }

    @Test
    public void testNonEquivalence() {
        assertThat(path1.isEquivalent(path3), is(false));
        assertThat(path3.isEquivalent(path1), is(false));

        assertThat(path4.isEquivalent(path1), is(false));
        assertThat(path4.isEquivalent(path2), is(false));
        assertThat(path4.isEquivalent(path3), is(false));

        assertThat(path5.isEquivalent(path1), is(false));
        assertThat(path5.isEquivalent(path2), is(false));
        assertThat(path5.isEquivalent(path3), is(false));
        assertThat(path5.isEquivalent(path4), is(false));
    }
}
