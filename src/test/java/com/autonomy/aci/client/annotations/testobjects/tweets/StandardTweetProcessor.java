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

package com.autonomy.aci.client.annotations.testobjects.tweets;

import com.autonomy.aci.client.services.AciServiceException;
import com.autonomy.aci.client.services.impl.AbstractStAXProcessor;
import com.autonomy.aci.client.services.impl.ErrorProcessor;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.util.ArrayList;
import java.util.List;

public class StandardTweetProcessor extends AbstractStAXProcessor<List<Tweet>> {
    private static final long serialVersionUID = 4973237884336529244L;

    @Override
    public List<Tweet> process(final XMLStreamReader xmlStreamReader) {
        try {
            if (isErrorResponse(xmlStreamReader)) {
                this.setErrorProcessor(new ErrorProcessor());
                processErrorResponse(xmlStreamReader);
            }

            final List<Tweet> tweets = new ArrayList<>();

            while (xmlStreamReader.hasNext()) {
                final int event = xmlStreamReader.next();

                if (event == XMLEvent.START_ELEMENT) {
                    if ("autn:hit".equals(xmlStreamReader.getLocalName())) {
                        tweets.add(processTweet(xmlStreamReader));
                    }
                }
            }

            return tweets;
        } catch (final XMLStreamException e) {
            throw new AciServiceException(e);
        }
    }

    private Tweet processTweet(final XMLStreamReader xmlStreamReader) throws XMLStreamException {
        final Tweet tweet = new Tweet();

        while (xmlStreamReader.hasNext()) {
            final int event = xmlStreamReader.next();

            if (event == XMLEvent.START_ELEMENT) {
                if ("autn:reference".equals(xmlStreamReader.getLocalName())) {
                    tweet.setReference(xmlStreamReader.getElementText());
                } else if ("CLEAN_TWEET".equals(xmlStreamReader.getLocalName())) {
                    tweet.setCleanTweet(xmlStreamReader.getElementText());
                } else if ("POSITIVITY".equals(xmlStreamReader.getLocalName())) {
                    tweet.setPositivity(Double.parseDouble(xmlStreamReader.getElementText()));
                }
            } else if (event == XMLEvent.END_ELEMENT) {
                if ("autn:hit".equals(xmlStreamReader.getLocalName())) {
                    break;
                }
            }
        }

        return tweet;
    }
}
