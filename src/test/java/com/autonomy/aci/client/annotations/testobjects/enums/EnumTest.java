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

package com.autonomy.aci.client.annotations.testobjects.enums;

import com.autonomy.aci.client.annotations.IdolAnnotationsProcessorFactory;
import com.autonomy.aci.client.annotations.IdolAnnotationsProcessorFactoryImpl;
import com.autonomy.aci.client.services.StAXProcessor;
import com.hp.autonomy.test.xml.XmlTestUtils;
import org.junit.Before;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class EnumTest {

    private StAXProcessor<List<Parliament>> processor;

    @Before
    public void setUp() {
        final IdolAnnotationsProcessorFactory factory = new IdolAnnotationsProcessorFactoryImpl();

        processor = factory.listProcessorForClass(Parliament.class);
    }

    @Test
    public void testEnums() throws XMLStreamException {
        final XMLStreamReader xmlStreamReader = XmlTestUtils.getResourceAsXMLStreamReader("/com/autonomy/aci/client/annotations/enum.xml");

        final List<Parliament> parliaments = processor.process(xmlStreamReader);

        assertThat(parliaments.size(), is(1));

        final Parliament parliament = parliaments.get(0);

        assertThat(parliament.getTory(), is(Leader.CAMERON));
        assertThat(parliament.getLibDem(), is(Leader.CLEGG));
        assertThat(parliament.getLabour(), is(Leader.MILLIBAND));
    }

}
