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

package com.autonomy.aci.client.annotations.testobjects.primitive;

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

public class StringWrapperTest {

    private List<StringWrapper> list;

    @Before
    public void setUp() throws XMLStreamException {
        final IdolAnnotationsProcessorFactoryImpl reflectionProcessorFactory = new IdolAnnotationsProcessorFactoryImpl();

        final XMLStreamReader xmlStreamReader = XmlTestUtils.getResourceAsXMLStreamReader("/com/autonomy/aci/client/annotations/tweets.xml");

        final StAXProcessor<List<StringWrapper>> processor = reflectionProcessorFactory.listProcessorForClass(StringWrapper.class);

        list = processor.process(xmlStreamReader);
    }


    @Test
    public void testStringConstructor() {
        final StringWrapper wrappedString = new StringWrapper();
        wrappedString.setWrappedString("http://a0.twimg.com/profile_images/2282204650/image_normal.jpg");

        assertThat(list.get(0), is(wrappedString));
    }

}
