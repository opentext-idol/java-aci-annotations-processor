/*
 * (c) Copyright 2015 Micro Focus or one of its affiliates.
 *
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License.
 *
 * The only warranties for products and services of Micro Focus and its affiliates
 * and licensors ("Micro Focus") are as may be set forth in the express warranty
 * statements accompanying such products and services. Nothing herein should be
 * construed as constituting an additional warranty. Micro Focus shall not be
 * liable for technical or editorial errors or omissions contained herein. The
 * information contained herein is subject to change without notice.
 */

package com.autonomy.aci.client.annotations.testobjects.bugs;

import com.autonomy.aci.client.annotations.IdolAnnotationsProcessorFactory;
import com.autonomy.aci.client.annotations.IdolAnnotationsProcessorFactoryImpl;
import com.autonomy.aci.client.annotations.testobjects.primitive.PrimitiveHolder;
import com.autonomy.aci.client.services.StAXProcessor;
import com.hp.autonomy.test.xml.XmlTestUtils;
import org.junit.Before;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConvertEmptyStringTest {

    private IdolAnnotationsProcessorFactory reflectionProcessorFactory;

    @Before
    public void setUp() {
        reflectionProcessorFactory = new IdolAnnotationsProcessorFactoryImpl();
    }

    @Test
    public void testEmptyFieldValuesDontDie() throws XMLStreamException {
        final XMLStreamReader xmlStreamReader = XmlTestUtils.getResourceAsXMLStreamReader("/com/autonomy/aci/client/annotations/primitives-empty.xml");

        final StAXProcessor<List<PrimitiveHolder>> processor = reflectionProcessorFactory.listProcessorForClass(PrimitiveHolder.class);

        final List<PrimitiveHolder> list = processor.process(xmlStreamReader);

        assertThat(list.size(), is(1));

        final PrimitiveHolder primitiveHolder = list.get(0);

        assertThat(primitiveHolder.isMyBoolean(), is(false));
        assertThat(primitiveHolder.getMyBooleanObj(), is(false));

        assertThat(primitiveHolder.getMyByte(), is((byte) 0));
        assertThat(primitiveHolder.getMyByteObj(), is((byte) 0));

        assertThat(primitiveHolder.getMyShort(), is((short) 0));
        assertThat(primitiveHolder.getMyShortObj(), is((short) 0));

        assertThat(primitiveHolder.getMyInt(), is(0));
        assertThat(primitiveHolder.getMyIntObj(), is(0));

        assertThat(primitiveHolder.getMyFloat(), is(0f));
        assertThat(primitiveHolder.getMyFloatObj(), is(0f));

        assertThat(primitiveHolder.getMyLong(), is(0L));
        assertThat(primitiveHolder.getMyLongObj(), is(0L));

        assertThat(primitiveHolder.getMyDouble(), is(0d));
        assertThat(primitiveHolder.getMyDoubleObj(), is(0d));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyCharThrowsIllegalArgumentException() throws XMLStreamException {
        final XMLStreamReader xmlStreamReader = XmlTestUtils.getResourceAsXMLStreamReader("/com/autonomy/aci/client/annotations/primitives-empty-char.xml");

        final StAXProcessor<List<PrimitiveHolder>> processor = reflectionProcessorFactory.listProcessorForClass(PrimitiveHolder.class);

        processor.process(xmlStreamReader);
    }

}
