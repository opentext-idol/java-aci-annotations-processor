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

package com.autonomy.aci.client.annotations.testobjects.bugs.subclass;

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

public class SubclassTest {

    private IdolAnnotationsProcessorFactory factory;
    private XMLStreamReader xmlStreamReader;

    @Before
    public void setUp() throws XMLStreamException {
        factory = new IdolAnnotationsProcessorFactoryImpl();
        xmlStreamReader = XmlTestUtils.getResourceAsXMLStreamReader("/com/autonomy/aci/client/annotations/find-news.xml");
    }

    @Test
    public void testSubclass() {
        final StAXProcessor<List<NewsResultDocument>> processor = factory.listProcessorForClass(NewsResultDocument.class);

        final List<NewsResultDocument> results = processor.process(xmlStreamReader);

        assertThat(results.size(), is(30));

        final NewsResultDocument document0 = results.get(0);

        assertThat(document0.getTitle(), is("No. 15 Mich. St. survives scare by UL-Lafayette"));
        assertThat(document0.getReference(), is("http://sportsillustrated.cnn.com/basketball/ncaa/men/gameflash/2012/11/25/78567_recap.html?xid=si_topstories"));
    }

    @Test
    public void testClusters() {
        final StAXProcessor<List<NewsResultCluster>> processor = factory.listProcessorForClass(NewsResultCluster.class);

        final List<NewsResultCluster> results = processor.process(xmlStreamReader);

        assertThat(results.size(), is(10));

        final NewsResultCluster cluster0 = results.get(0);
        final List<NewsResultDocument> documents0 = cluster0.getDocuments();

        assertThat(documents0.size(), is(3));

        final NewsResultDocument document00 = documents0.get(0);

        assertThat(document00.getTitle(), is("No. 15 Mich. St. survives scare by UL-Lafayette"));
        assertThat(document00.getReference(), is("http://sportsillustrated.cnn.com/basketball/ncaa/men/gameflash/2012/11/25/78567_recap.html?xid=si_topstories"));

        final NewsResultDocument document01 = documents0.get(1);
        assertThat(document01.getScore(), is(9.0f));
        assertThat(document01.getDate(), is(1353894478L));
        assertThat(document01.getDatabase(), is("Moreover"));
        assertThat(document01.getLanguage(), is("ENGLISH"));
    }

}
