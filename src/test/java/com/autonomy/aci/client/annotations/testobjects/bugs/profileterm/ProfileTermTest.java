/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.bugs.profileterm;

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

public class ProfileTermTest {

    private IdolAnnotationsProcessorFactory factory;

    @Before
    public void setUp() {
        factory = new IdolAnnotationsProcessorFactoryImpl();
    }

    @Test
    public void testProfileTermProcessor() throws XMLStreamException {
        final XMLStreamReader xmlStreamReader = XmlTestUtils.getResourceAsXMLStreamReader("/com/autonomy/aci/client/annotations/terms.xml");

        final StAXProcessor<List<ProfileTerm>> processor = factory.listProcessorForClass(ProfileTerm.class);

        final List<ProfileTerm> terms = processor.process(xmlStreamReader);

        assertThat(terms.size(), is(104));

        final ProfileTerm term = terms.get(0);

        assertThat(term.getName(), is("20"));
        assertThat(term.getWeight(), is(33L));

        final ProfileTerm last = terms.get(terms.size() - 1);

        assertThat(last.getName(), is("TROOP"));
        assertThat(last.getWeight(), is(109L));
    }

}
