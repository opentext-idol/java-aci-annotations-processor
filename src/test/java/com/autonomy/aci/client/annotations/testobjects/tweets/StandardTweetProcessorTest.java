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

import com.hp.autonomy.test.xml.XmlTestUtils;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.List;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StandardTweetProcessorTest {
    @Test
    public void testStandardProcessor() throws XMLStreamException {
        final XMLStreamReader xmlStreamReader = XmlTestUtils.getResourceAsXMLStreamReader("/com/autonomy/aci/client/annotations/tweets.xml");

        final StandardTweetProcessor processor = new StandardTweetProcessor();

        final List<Tweet> tweets = processor.process(xmlStreamReader);

        assertThat(tweets.size(), is(6));

        final Tweet tweet0 = tweets.get(0);

        assertThat(tweet0.getCleanTweet(), is(" Correction: The Supreme Court backs all parts of President Obama\u2019s health care law. "));
        assertThat(tweet0.getReference(), is("218348440483151873"));
        assertThat(tweet0.getPositivity(), is(closeTo(21.62, 0.005)));
    }
}
