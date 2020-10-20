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

package com.autonomy.aci.client.annotations.testobjects.bugs.buildertest;

import com.autonomy.aci.client.annotations.IdolAnnotationsProcessorFactory;
import com.autonomy.aci.client.services.impl.AbstractStAXProcessor;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.util.ArrayList;
import java.util.List;

public class ScheduleListProcessor extends AbstractStAXProcessor<List<Schedule>> {

    private static final long serialVersionUID = -6397089790312332627L;
    private final IdolAnnotationsProcessorFactory processorFactory;

    public ScheduleListProcessor(final IdolAnnotationsProcessorFactory processorFactory) {
        this.processorFactory = processorFactory;
    }

    @Override
    public List<Schedule> process(final XMLStreamReader xmlStreamReader) {
        final List<Schedule> schedules = new ArrayList<>();

        try {
            while (xmlStreamReader.hasNext()) {
                final int event = xmlStreamReader.next();

                if (event == XMLEvent.START_ELEMENT) {
                    final String localName = xmlStreamReader.getLocalName();

                    if ("controller".equals(localName)) {
                        schedules.addAll(processController(xmlStreamReader));
                    }
                }
            }
        } catch (final XMLStreamException e) {
            throw new AssertionError(e);
        }

        return schedules;
    }

    private List<Schedule> processController(final XMLStreamReader xmlStreamReader) throws XMLStreamException {
        final List<Schedule> schedules = new ArrayList<>();
        String name = null;

        while (xmlStreamReader.hasNext()) {
            final int event = xmlStreamReader.next();

            if (event == XMLEvent.START_ELEMENT) {
                final String localName = xmlStreamReader.getLocalName();

                if ("name".equals(localName)) {
                    name = xmlStreamReader.getElementText();
                } else if ("schedule".equals(localName)) {
                    final Schedule schedule = processorFactory.forClass(Schedule.class).process(xmlStreamReader);
                    schedule.setControllerName(name);
                    schedules.add(schedule);
                }
            } else if (event == XMLEvent.END_ELEMENT) {
                if ("controller".equals(xmlStreamReader.getLocalName())) {
                    break;
                }
            }
        }

        return schedules;
    }

}
