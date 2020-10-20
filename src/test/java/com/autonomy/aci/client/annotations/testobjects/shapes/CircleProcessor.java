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

package com.autonomy.aci.client.annotations.testobjects.shapes;

import com.autonomy.aci.client.services.AciServiceException;
import com.autonomy.aci.client.services.impl.AbstractStAXProcessor;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public class CircleProcessor extends AbstractStAXProcessor<Circle> {
    private static final long serialVersionUID = -6361927625060373841L;

    @Override
    public Circle process(final XMLStreamReader xmlStreamReader) {
        if (!"CIRCLE".equals(xmlStreamReader.getLocalName())) {
            throw new AciServiceException("Processor should be on a CIRCLE tag");
        }

        final Circle circle = new Circle();

        try {
            while (xmlStreamReader.hasNext()) {
                final int event = xmlStreamReader.next();

                if (event == XMLEvent.START_ELEMENT) {
                    if ("X".equals(xmlStreamReader.getLocalName())) {
                        circle.setX(Integer.parseInt(xmlStreamReader.getElementText()));
                    } else if ("Y".equals(xmlStreamReader.getLocalName())) {
                        circle.setY(Integer.parseInt(xmlStreamReader.getElementText()));
                    } else if ("RADIUS".equals(xmlStreamReader.getLocalName())) {
                        circle.setRadius(Integer.parseInt(xmlStreamReader.getElementText()));
                    }
                } else if (event == XMLEvent.END_ELEMENT) {
                    if ("CIRCLE".equals(xmlStreamReader.getLocalName())) {
                        break;
                    }
                }
            }

            return circle;
        } catch (final XMLStreamException e) {
            throw new AciServiceException(e);
        }
    }
}
