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

package com.autonomy.aci.client.annotations.testobjects.bugs.recursion;

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

public class CategoryPathTest {

    private IdolAnnotationsProcessorFactory factory;

    @Before
    public void setUp() {
        factory = new IdolAnnotationsProcessorFactoryImpl();
    }

    @Test
    public void testGetActualPath() throws XMLStreamException {
        final XMLStreamReader xmlStreamReader = XmlTestUtils.getResourceAsXMLStreamReader("/com/autonomy/aci/client/annotations/categories.xml");

        final StAXProcessor<List<CategoryPath>> processor = factory.listProcessorForClass(CategoryPath.class);

        final CategoryPath path = processor.process(xmlStreamReader).get(0);

        assertThat(path.getId(), is("D013317_2"));
        assertThat(path.getName(), is("Strikes, Employee"));

        final List<CategoryName> actualPath = path.getActualPath();

        assertThat(actualPath.size(), is(6));
    }

}
