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

package com.autonomy.aci.client.annotations.testobjects.bugs.buildertest;

import com.autonomy.aci.client.annotations.IdolAnnotationsProcessorFactory;
import com.autonomy.aci.client.annotations.IdolAnnotationsProcessorFactoryImpl;
import com.hp.autonomy.test.xml.XmlTestUtils;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class ScheduleListProcessorTest {

    @Test
    public void testScheduleListProcessor() throws XMLStreamException {
        final IdolAnnotationsProcessorFactory factory = new IdolAnnotationsProcessorFactoryImpl();
        final ScheduleListProcessor processor = new ScheduleListProcessor(factory);
        final XMLStreamReader xmlStreamReader = XmlTestUtils.getResourceAsXMLStreamReader("/com/autonomy/aci/client/annotations/builder-test.xml");

        final List<Schedule> schedules = processor.process(xmlStreamReader);

        assertThat(schedules, hasSize(3));

        final Schedule schedule0 = schedules.get(0);
        assertThat(schedule0.getName(), is("backup"));
        assertThat(schedule0.getInterval(), is("1 day"));
        assertThat(schedule0.getControllerName(), is("windows"));

        final Schedule schedule2 = schedules.get(2);
        assertThat(schedule2.getName(), is("try to take over the world"));
        assertThat(schedule2.getInterval(), is("1 day"));
        assertThat(schedule2.getControllerName(), is("brain"));
    }

}
