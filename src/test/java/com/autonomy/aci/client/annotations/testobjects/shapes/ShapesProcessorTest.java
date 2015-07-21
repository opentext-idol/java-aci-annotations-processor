/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.shapes;

import com.autonomy.aci.client.annotations.IdolAnnotationsProcessorFactory;
import com.autonomy.aci.client.annotations.IdolAnnotationsProcessorFactoryImpl;
import com.autonomy.aci.client.services.StAXProcessor;
import com.hp.autonomy.test.xml.XmlTestUtils;
import org.junit.Before;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ShapesProcessorTest {

    private IdolAnnotationsProcessorFactory idolAnnotationsProcessorFactory;
    private XMLStreamReader xmlStreamReader;

    @Before
    public void setUp() throws XMLStreamException, IOException {
        idolAnnotationsProcessorFactory = new IdolAnnotationsProcessorFactoryImpl();

        final Properties properties = new Properties();

        properties.load(ShapesProcessorTest.class.getResourceAsStream("/com/autonomy/aci/client/annotations/fields.properties"));

        idolAnnotationsProcessorFactory.setProperties(properties);

        xmlStreamReader = XmlTestUtils.getResourceAsXMLStreamReader("/com/autonomy/aci/client/annotations/xmlDocument.xml");
    }

    @Test
    public void testProcessorAnnotation() {
        final StAXProcessor<List<Shapes>> processor = idolAnnotationsProcessorFactory.listProcessorForClass(Shapes.class);

        final List<Shapes> list = processor.process(xmlStreamReader);

        assertThat(list.size(), is(1));

        final Shapes shapes = list.get(0);

        assertThat(shapes.getScalar(), is("SOME SCALAR"));

        final Rectangle rectangle = shapes.getRectangle();

        assertThat(rectangle.getX0(), is(0));
        assertThat(rectangle.getY0(), is(0));
        assertThat(rectangle.getX1(), is(10));
        assertThat(rectangle.getY1(), is(10));

        final Circle circle = shapes.getCircle();

        assertThat(circle.getX(), is(2));
        assertThat(circle.getY(), is(3));
        assertThat(circle.getRadius(), is(5));
    }

    @Test
    public void testConfiguredProcessorAnnotation() {
        final StAXProcessor<List<ConfiguredShapes>> processor = idolAnnotationsProcessorFactory.listProcessorForClass(ConfiguredShapes.class);

        final List<ConfiguredShapes> list = processor.process(xmlStreamReader);

        assertThat(list.size(), is(1));

        final ConfiguredShapes shapes = list.get(0);

        assertThat(shapes.getScalar(), is("SOME SCALAR"));

        final Rectangle rectangle = shapes.getRectangle();

        assertThat(rectangle.getX0(), is(0));
        assertThat(rectangle.getY0(), is(0));
        assertThat(rectangle.getX1(), is(10));
        assertThat(rectangle.getY1(), is(10));

        final Circle circle = shapes.getCircle();

        assertThat(circle.getX(), is(2));
        assertThat(circle.getY(), is(3));
        assertThat(circle.getRadius(), is(5));
    }

    @Test
    public void testPathProcessorAnnotation() {
        final StAXProcessor<List<PathShapes>> processor = idolAnnotationsProcessorFactory.listProcessorForClass(PathShapes.class);

        final List<PathShapes> list = processor.process(xmlStreamReader);

        assertThat(list.size(), is(1));

        final PathShapes shapes = list.get(0);

        assertThat(shapes.getScalar(), is("SOME SCALAR"));

        final Rectangle rectangle = shapes.getRectangle();

        assertThat(rectangle.getX0(), is(0));
        assertThat(rectangle.getY0(), is(0));
        assertThat(rectangle.getX1(), is(10));
        assertThat(rectangle.getY1(), is(10));

        final Circle circle = shapes.getCircle();

        assertThat(circle.getX(), is(2));
        assertThat(circle.getY(), is(3));
        assertThat(circle.getRadius(), is(5));
    }

    @Test
    public void testConfiguredPathProcessorAnnotation() {
        final StAXProcessor<List<ConfiguredPathShapes>> processor = idolAnnotationsProcessorFactory.listProcessorForClass(ConfiguredPathShapes.class);

        final List<ConfiguredPathShapes> list = processor.process(xmlStreamReader);

        assertThat(list.size(), is(1));

        final ConfiguredPathShapes shapes = list.get(0);

        assertThat(shapes.getScalar(), is("SOME SCALAR"));

        final Rectangle rectangle = shapes.getRectangle();

        assertThat(rectangle.getX0(), is(0));
        assertThat(rectangle.getY0(), is(0));
        assertThat(rectangle.getX1(), is(10));
        assertThat(rectangle.getY1(), is(10));

        final Circle circle = shapes.getCircle();

        assertThat(circle.getX(), is(2));
        assertThat(circle.getY(), is(3));
        assertThat(circle.getRadius(), is(5));
    }

}
