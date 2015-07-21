/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.bugs.pathing;

import com.autonomy.aci.client.annotations.IdolAnnotationsProcessorFactory;
import com.autonomy.aci.client.annotations.IdolAnnotationsProcessorFactoryImpl;
import com.autonomy.aci.client.services.StAXProcessor;
import com.hp.autonomy.test.xml.XmlTestUtils;
import org.junit.Before;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MonitorSummarizeTest {

    private IdolAnnotationsProcessorFactory factory;

    @Before
    public void setUp() {
        factory = new IdolAnnotationsProcessorFactoryImpl();
    }

    @Test
    public void testMonitorSummarize() throws XMLStreamException {
        final StAXProcessor<List<MonitorSummarize>> processor = factory.listProcessorForClass(MonitorSummarize.class);

        final XMLStreamReader xmlStreamReader = XmlTestUtils.getResourceAsXMLStreamReader("/com/autonomy/aci/client/annotations/monitor-status.xml");

        final List<MonitorSummarize> list = processor.process(xmlStreamReader);

        assertThat(list.size(), is(6));

        final MonitorSummarize summarize0 = list.get(0);

        assertThat(summarize0.getCurrentStatus().size(), is(2));
    }

}
