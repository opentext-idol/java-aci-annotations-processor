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

package com.autonomy.aci.client.annotations.testobjects.developer;

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
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class IdolDocumentTest {

    private IdolAnnotationsProcessorFactoryImpl reflectionProcessorFactory;

    private XMLStreamReader xmlStreamReader;

    @Before
    public void setUp() throws XMLStreamException, IOException {
        reflectionProcessorFactory = new IdolAnnotationsProcessorFactoryImpl();

        final Properties properties = new Properties();

        properties.load(IdolDocumentTest.class.getResourceAsStream("/com/autonomy/aci/client/annotations/fields.properties"));

        reflectionProcessorFactory.setProperties(properties);

        xmlStreamReader = XmlTestUtils.getResourceAsXMLStreamReader("/com/autonomy/aci/client/annotations/customTag.xml");
    }

    @Test
    public void testIdolDocument() {
        final StAXProcessor<List<DeveloperImpl>> processor = reflectionProcessorFactory.listProcessorForClass(DeveloperImpl.class);

        final List<DeveloperImpl> developers = processor.process(xmlStreamReader);

        assertThat(developers.size(), is(3));

        assertThat(developers.get(0).getName(), is("Alex"));
        assertThat(developers.get(1).getName(), is("Jin"));
        assertThat(developers.get(2).getName(), is("Brian"));
    }

    @Test
    public void testConfiguredIdolDocument() {
        final StAXProcessor<List<ConfiguredDeveloper>> processor = reflectionProcessorFactory.listProcessorForClass(ConfiguredDeveloper.class);

        final List<ConfiguredDeveloper> developers = processor.process(xmlStreamReader);

        assertThat(developers.size(), is(3));

        assertThat(developers.get(0).getName(), is("Alex"));
        assertThat(developers.get(1).getName(), is("Jin"));
        assertThat(developers.get(2).getName(), is("Brian"));
    }

    @Test
    public void testResourceBundleConfiguredIdolDocument() throws IOException {
        final ResourceBundle resourceBundle = new PropertyResourceBundle(IdolDocumentTest.class.getResourceAsStream("/com/autonomy/aci/client/annotations/fields.properties"));

        reflectionProcessorFactory.setResourceBundle(resourceBundle);

        final StAXProcessor<List<ConfiguredDeveloper>> processor = reflectionProcessorFactory.listProcessorForClass(ConfiguredDeveloper.class);

        final List<ConfiguredDeveloper> developers = processor.process(xmlStreamReader);

        assertThat(developers.size(), is(3));

        assertThat(developers.get(0).getName(), is("Alex"));
        assertThat(developers.get(1).getName(), is("Jin"));
        assertThat(developers.get(2).getName(), is("Brian"));
    }

    @Test
    public void testPathIdolDocument() {
        final StAXProcessor<List<PathDeveloper>> processor = reflectionProcessorFactory.listProcessorForClass(PathDeveloper.class);

        final List<PathDeveloper> developers = processor.process(xmlStreamReader);

        assertThat(developers.size(), is(3));

        assertThat(developers.get(0).getName(), is("Alex"));
        assertThat(developers.get(1).getName(), is("Jin"));
        assertThat(developers.get(2).getName(), is("Brian"));
    }

    @Test
    public void testConfiguredPathIdolDocument() {
        final StAXProcessor<List<ConfiguredPathDeveloper>> processor = reflectionProcessorFactory.listProcessorForClass(ConfiguredPathDeveloper.class);

        final List<ConfiguredPathDeveloper> developers = processor.process(xmlStreamReader);

        assertThat(developers.size(), is(3));

        assertThat(developers.get(0).getName(), is("Alex"));
        assertThat(developers.get(1).getName(), is("Jin"));
        assertThat(developers.get(2).getName(), is("Brian"));
    }

}
