/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.pathological;

import com.autonomy.aci.client.annotations.IdolAnnotationsProcessorFactory;
import com.autonomy.aci.client.annotations.IdolAnnotationsProcessorFactoryImpl;
import org.junit.Test;

public class PathologicalTest {

    @Test(expected = IllegalStateException.class)
    public void testDoubleAnnotationThrowsIllegalStateException() {
        final IdolAnnotationsProcessorFactory idolAnnotationsProcessorFactory = new IdolAnnotationsProcessorFactoryImpl();

        idolAnnotationsProcessorFactory.forClass(Pathological.class);
    }

}
