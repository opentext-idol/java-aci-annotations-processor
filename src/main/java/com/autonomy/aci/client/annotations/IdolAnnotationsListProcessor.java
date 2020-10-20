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

package com.autonomy.aci.client.annotations;

import com.autonomy.aci.client.services.AciServiceException;
import com.autonomy.aci.client.services.StAXProcessor;
import com.autonomy.aci.client.services.impl.AbstractStAXProcessor;
import com.autonomy.aci.client.services.impl.ErrorProcessor;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Processor that returns a list of objects of type {@code <T>}.  Intended for creation via static factory.
 * @param <T> The type of the items in the list
 */
class IdolAnnotationsListProcessor<T> extends AbstractStAXProcessor<List<T>> {

    private static final long serialVersionUID = -5340264175485205976L;

    private StAXProcessor<T> innerProcessor;

    private String rootField = AnnotationHelper.ROOT_FIELD_DEFAULT;
    private Path rootPath = new Path("");

    <U> IdolAnnotationsListProcessor(final Class<U> clazz, final IdolAnnotationsProcessorFactory idolAnnotationsProcessorFactory, final Properties properties) {
        final IdolDocument documentAnnotation = clazz.getAnnotation(IdolDocument.class);

        if (documentAnnotation != null) {
            final AnnotationHelper annotationHelper = new AnnotationHelper(documentAnnotation);

            switch (documentAnnotation.fieldType()) {
                case PATH:
                    rootPath = annotationHelper.getPath(properties);

                    rootField = null;
                    break;
                case FIELD:
                default:
                    rootField = annotationHelper.getFieldName(properties);
            }
        }

        setInnerProcessor(idolAnnotationsProcessorFactory.forClass(clazz));
    }

    @Override
    public List<T> process(final XMLStreamReader xmlStreamReader) {
        try {
            if (isErrorResponse(xmlStreamReader)) {
                this.setErrorProcessor(new ErrorProcessor());
                processErrorResponse(xmlStreamReader);
            }

            final List<T> items = new ArrayList<>();
            Path path = new Path("");

            final boolean hasRootPath = !rootPath.isEquivalent(new Path(""));

            while (xmlStreamReader.hasNext()) {
                final int event = xmlStreamReader.next();

                if (event == XMLEvent.START_ELEMENT) {
                    final String localName = xmlStreamReader.getLocalName();
                    path = path.append(localName);

                    if (localName.equals(rootField) || (hasRootPath && path.isEquivalent(rootPath))) {
                        final T item = innerProcessor.process(xmlStreamReader);
                        items.add(item);
                        path = path.removeLastComponent();
                    }
                } else if (event == XMLEvent.END_ELEMENT) {
                    if (!path.isEmpty()) {
                        path = path.removeLastComponent();
                    }
                }
            }

            return items;
        } catch (final XMLStreamException e) {
            throw new AciServiceException(e);
        }
    }

    // private method that is only called with a ReflectionProcessor
    @SuppressWarnings("unchecked")
    private void setInnerProcessor(final Object processor) {
        this.innerProcessor = (StAXProcessor<T>) processor;
    }
}
