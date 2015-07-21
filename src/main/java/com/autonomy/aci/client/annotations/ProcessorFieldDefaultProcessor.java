/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations;

import com.autonomy.aci.client.services.impl.AbstractStAXProcessor;

import javax.xml.stream.XMLStreamReader;

/**
 * Used as a sentinel value in {@link com.autonomy.aci.client.annotations.IdolProcessorField}. Not intended for use.
 */
class ProcessorFieldDefaultProcessor extends AbstractStAXProcessor<Object> {
    private static final long serialVersionUID = -5071520986155480470L;

    private ProcessorFieldDefaultProcessor() {
        throw new AssertionError(ProcessorFieldDefaultProcessor.class.getCanonicalName() + " is intended as a null value and cannot be instantiated");
    }

    @Override
    public Object process(final XMLStreamReader xmlStreamReader) {
        throw new AssertionError(ProcessorFieldDefaultProcessor.class.getCanonicalName() + " is not intended for use.");
    }
}
