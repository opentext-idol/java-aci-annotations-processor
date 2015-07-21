/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
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

public class PrimitiveTest {

    private List<PrimitiveHolder> list;

    @Before
    public void setUp() throws XMLStreamException {
        final IdolAnnotationsProcessorFactoryImpl reflectionProcessorFactory = new IdolAnnotationsProcessorFactoryImpl();

        final XMLStreamReader xmlStreamReader = XmlTestUtils.getResourceAsXMLStreamReader("/com/autonomy/aci/client/annotations/primitives.xml");

        final StAXProcessor<List<PrimitiveHolder>> processor = reflectionProcessorFactory.listProcessorForClass(PrimitiveHolder.class);

        list = processor.process(xmlStreamReader);
    }

    @Test
    public void testListSize() {
        assertThat(list.size(), is(1));
    }

    @Test
    public void testChar() {
        final PrimitiveHolder primitiveHolder = list.get(0);

        assertThat(primitiveHolder.getMyChar(), is('a'));
    }

    @Test
    public void testCharacter() {
        final PrimitiveHolder primitiveHolder = list.get(0);

        assertThat(primitiveHolder.getMyCharObj(), is('b'));
    }

    @Test
    public void testBoolean() {
        final PrimitiveHolder primitiveHolder = list.get(0);

        assertThat(primitiveHolder.isMyBoolean(), is(true));
    }

    @Test
    public void testBooleanObj() {
        final PrimitiveHolder primitiveHolder = list.get(0);

        assertThat(primitiveHolder.getMyBooleanObj(), is(false));
    }

    @Test
    public void testByte() {
        final PrimitiveHolder primitiveHolder = list.get(0);

        assertThat(primitiveHolder.getMyByte(), is((byte) 42));
    }

    @Test
    public void testByteObj() {
        final PrimitiveHolder primitiveHolder = list.get(0);

        assertThat(primitiveHolder.getMyByteObj(), is((byte) 56));
    }

    @Test
    public void testShort() {
        final PrimitiveHolder primitiveHolder = list.get(0);

        assertThat(primitiveHolder.getMyShort(), is((short) 10000));
    }

    @Test
    public void testShortObj() {
        final PrimitiveHolder primitiveHolder = list.get(0);

        assertThat(primitiveHolder.getMyShortObj(), is((short) 5000));
    }

    @Test
    public void testInt() {
        final PrimitiveHolder primitiveHolder = list.get(0);

        assertThat(primitiveHolder.getMyInt(), is(777));
    }

    @Test
    public void testInteger() {
        final PrimitiveHolder primitiveHolder = list.get(0);

        assertThat(primitiveHolder.getMyIntObj(), is(666666));
    }

    @Test
    public void testLong() {
        final PrimitiveHolder primitiveHolder = list.get(0);

        assertThat(primitiveHolder.getMyLong(), is(1234567890L));
    }

    @Test
    public void testLongObj() {
        final PrimitiveHolder primitiveHolder = list.get(0);

        assertThat(primitiveHolder.getMyLongObj(), is(987654321L));
    }

    @Test
    public void testFloat() {
        final PrimitiveHolder primitiveHolder = list.get(0);

        assertThat(primitiveHolder.getMyFloat(), is(255.55f));
    }

    @Test
    public void testFloatObj() {
        final PrimitiveHolder primitiveHolder = list.get(0);

        assertThat(primitiveHolder.getMyFloatObj(), is(512.468f));
    }

    @Test
    public void testDouble() {
        final PrimitiveHolder primitiveHolder = list.get(0);

        assertThat(primitiveHolder.getMyDouble(), is(76452.21212));
    }

    @Test
    public void testDoubleObj() {
        final PrimitiveHolder primitiveHolder = list.get(0);

        assertThat(primitiveHolder.getMyDoubleObj(), is(127368.1231231));
    }

}
