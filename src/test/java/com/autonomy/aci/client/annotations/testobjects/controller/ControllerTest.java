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

package com.autonomy.aci.client.annotations.testobjects.controller;

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

public class ControllerTest {

    private StAXProcessor<List<Controller>> processor;

    @Before
    public void setUp() {
        final IdolAnnotationsProcessorFactory factory = new IdolAnnotationsProcessorFactoryImpl();

        processor = factory.listProcessorForClass(Controller.class);
    }

    @Test
    public void testAttributes() throws XMLStreamException {
        final XMLStreamReader reader = XmlTestUtils.getResourceAsXMLStreamReader("/com/autonomy/aci/client/annotations/controller.xml");

        final List<Controller> controllers = processor.process(reader);

        assertThat(controllers.size(), is(1));

        final Controller controller = controllers.get(0);

        assertThat(controller.getUUID(), is("123-456-789"));
        assertThat(controller.getPort(), is(41200));

        final List<Service> services = controller.getServices();

        assertThat(services.size(), is(1));

        final Service service = services.get(0);

        assertThat(service.getPort(), is(9000));
        assertThat(service.getName(), is("content1"));
        assertThat(service.getLabels(), is("twitterdata"));
        assertThat(service.getRunState(), is(RunState.running));

        final List<Monitor> serviceMonitors = service.getMonitors();

        assertThat(serviceMonitors.size(), is(1));

        final Monitor serviceMonitor = serviceMonitors.get(0);

        assertThat(serviceMonitor.getName(), is("aci ping"));
        assertThat(serviceMonitor.getLastStatus(), is(Status.success));
        assertThat(serviceMonitor.getLastResultTime(), is(1234587890L));
        assertThat(serviceMonitor.getInterval(), is(30L));

        final List<Error> serviceErrors = serviceMonitor.getErrors();

        assertThat(serviceErrors.size(), is(3));

        final Error serviceError0 = serviceErrors.get(0);

        assertThat(serviceError0.getId(), is("abcde123"));
        assertThat(serviceError0.getCount(), is(10));
        assertThat(serviceError0.getStart(), is(1234567890L));
        assertThat(serviceError0.getEnd(), is("1234569890"));
        assertThat(serviceError0.getValue(), is("Failed (timeout)"));

        final Error serviceError1 = serviceErrors.get(1);

        assertThat(serviceError1.getId(), is("abcde124"));
        assertThat(serviceError1.getCount(), is(2));
        assertThat(serviceError1.getStart(), is(1234587890L));
        assertThat(serviceError1.getEnd(), is("n/a"));
        assertThat(serviceError1.getValue(), is("Failed (timeout)"));

        final Error serviceError2 = serviceErrors.get(2);

        assertThat(serviceError2.getId(), is("abcde124"));
        assertThat(serviceError2.getCount(), is(2));
        assertThat(serviceError2.getStart(), is(1234587890L));
        assertThat(serviceError2.getEnd(), is(""));
        assertThat(serviceError2.getValue(), is("It all went wrong"));

        final List<Warning> serviceWarnings = serviceMonitor.getWarnings();

        assertThat(serviceWarnings.size(), is(1));

        final Warning serviceWarning = serviceWarnings.get(0);

        assertThat(serviceWarning.getId(), is("abcde125"));
        assertThat(serviceWarning.getCount(), is(1));
        assertThat(serviceWarning.getStart(), is(1234577890L));
        assertThat(serviceWarning.getEnd(), is("1234578190"));
        assertThat(serviceWarning.getValue(), is("Slow response"));

        final System system = controller.getSystem();

        assertThat(system.getHostName(), is("contentbox1"));
        assertThat(system.getIpAddress(), is("10.1.0.11"));
        assertThat(system.getOs(), is("windows server 2003"));

        final List<Monitor> systemMonitors = system.getMonitors();

        assertThat(systemMonitors.size(), is(1));

        final Monitor systemMonitor = systemMonitors.get(0);

        assertThat(systemMonitor.getName(), is("diskspace"));
        assertThat(systemMonitor.getLastStatus(), is(Status.success));
        assertThat(systemMonitor.getLastResultTime(), is(1234587890L));
        assertThat(systemMonitor.getInterval(), is(600L));

        assertThat(systemMonitor.getErrors().size(), is(0));

        final List<Warning> systemWarnings = systemMonitor.getWarnings();

        assertThat(systemWarnings.size(), is(1));

        final Warning systemWarning = systemWarnings.get(0);

        assertThat(systemWarning.getId(), is("def1234"));
        assertThat(systemWarning.getCount(), is(1));
        assertThat(systemWarning.getStart(), is(1234587890L));
        assertThat(systemWarning.getEnd(), is("n/a"));
        assertThat(systemWarning.getValue(), is("Low disk space (25%)"));
    }

}
