/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.speedtest;

import com.autonomy.aci.client.annotations.IdolAnnotationsProcessorFactoryImpl;
import com.autonomy.aci.client.annotations.testobjects.tweets.StandardTweetProcessor;
import com.autonomy.aci.client.annotations.testobjects.tweets.Tweet;
import com.autonomy.aci.client.services.StAXProcessor;
import com.hp.autonomy.test.xml.XmlTestUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.List;

public class ReflectionProcessorSpeedTest {

    private IdolAnnotationsProcessorFactoryImpl reflectionProcessorFactory;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionProcessorSpeedTest.class);

    @Before
    public void setUp() {
        reflectionProcessorFactory = new IdolAnnotationsProcessorFactoryImpl();
    }

    @Test
    public void speedTest() throws XMLStreamException {
        speedTest("/com/autonomy/aci/client/annotations/tweets.xml");
    }

    @Test
    @Ignore
    public void speedTestLarge() throws XMLStreamException {
        speedTest("/com/autonomy/aci/client/annotations/tweetsLarge.xml");
    }

    @Test
    @Ignore
    public void speedTestLargePrintfields() throws XMLStreamException {
        speedTest("/com/autonomy/aci/client/annotations/tweetsLargePrintfields.xml");
    }

    private void speedTest(final String resource) throws XMLStreamException {
        final long startReflection = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            final XMLStreamReader xmlStreamReader = XmlTestUtils.getResourceAsXMLStreamReader(resource);

            final StAXProcessor<List<Tweet>> processor = reflectionProcessorFactory.listProcessorForClass(Tweet.class);

            processor.process(xmlStreamReader);
        }

        final long endReflection = System.nanoTime();

        LOGGER.info("Reflection Processor took {} seconds", (double) (endReflection - startReflection) / 1000000000);

        final long startStandard = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            final XMLStreamReader xmlStreamReader = XmlTestUtils.getResourceAsXMLStreamReader(resource);

            final StandardTweetProcessor processor = new StandardTweetProcessor();

            processor.process(xmlStreamReader);
        }

        final long endStandard = System.nanoTime();

        LOGGER.info("Standard Processor took {} seconds", (double) (endStandard - startStandard) / 1000000000);
    }

}
