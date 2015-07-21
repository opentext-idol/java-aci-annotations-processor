/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.bugs.visibility;

import com.autonomy.aci.client.annotations.IdolAnnotationsProcessorFactory;
import com.autonomy.aci.client.annotations.IdolAnnotationsProcessorFactoryImpl;
import com.autonomy.aci.client.services.StAXProcessor;
import com.hp.autonomy.test.xml.XmlTestUtils;
import org.junit.Before;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class InvisibleManTest {

    private IdolAnnotationsProcessorFactory factory;
    private XMLStreamReader xmlStreamReader;

    @Before
    public void setUp() throws XMLStreamException {
        factory = new IdolAnnotationsProcessorFactoryImpl();
        xmlStreamReader = XmlTestUtils.getResourceAsXMLStreamReader("/com/autonomy/aci/client/annotations/invisible-men.xml");
    }

    @Test
    public void testPackageVisibleClass() {
        final StAXProcessor<List<InvisibleMan>> processor = factory.listProcessorForClass(InvisibleMan.class);

        final List<InvisibleMan> results = processor.process(xmlStreamReader);

        assertThat(results, hasSize(2));

        final InvisibleMan man = results.get(0);

        assertThat(man.getName(), is("smith"));
    }

}
