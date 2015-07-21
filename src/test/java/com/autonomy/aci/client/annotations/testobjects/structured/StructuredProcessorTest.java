/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.structured;

import com.autonomy.aci.client.annotations.IdolAnnotationsProcessorFactory;
import com.autonomy.aci.client.annotations.IdolAnnotationsProcessorFactoryImpl;
import com.autonomy.aci.client.services.StAXProcessor;
import com.hp.autonomy.test.xml.XmlTestUtils;
import org.junit.Before;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StructuredProcessorTest {
    private IdolAnnotationsProcessorFactory idolAnnotationsProcessorFactory;
    private XMLStreamReader xmlStreamReader;

    @Before
    public void setUp() throws XMLStreamException, IOException {
        idolAnnotationsProcessorFactory = new IdolAnnotationsProcessorFactoryImpl();

        final Properties properties = new Properties();
        properties.load(StructuredProcessorTest.class.getResourceAsStream("/com/autonomy/aci/client/annotations/fields.properties"));
        idolAnnotationsProcessorFactory.setProperties(properties);

        xmlStreamReader = XmlTestUtils.getResourceAsXMLStreamReader("/com/autonomy/aci/client/annotations/structured.xml");
    }

    @Test
    public void testStructured() {
        final StAXProcessor<List<Structure>> processor = idolAnnotationsProcessorFactory.listProcessorForClass(Structure.class);

        final List<Structure> list = processor.process(xmlStreamReader);

        assertThat(list.size(), is(1));

        final Structure structure0 = list.get(0);

        assertThat(structure0.getAuthor(), is("alex.scown"));
        assertThat(structure0.getScalar(), is("42"));
        assertThat(structure0.getPackageName(), is("com.autonomy"));
    }

    @Test
    public void testConfiguredStructured() {
        final StAXProcessor<List<ConfiguredStructure>> processor = idolAnnotationsProcessorFactory.listProcessorForClass(ConfiguredStructure.class);

        final List<ConfiguredStructure> list = processor.process(xmlStreamReader);

        assertThat(list.size(), is(1));

        final ConfiguredStructure structure0 = list.get(0);

        assertThat(structure0.getAuthor(), is("alex.scown"));
        assertThat(structure0.getScalar(), is("42"));
        assertThat(structure0.getPackageName(), is("com.autonomy"));
    }
}
