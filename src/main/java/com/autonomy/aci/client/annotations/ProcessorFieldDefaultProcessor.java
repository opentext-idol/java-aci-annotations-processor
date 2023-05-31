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
