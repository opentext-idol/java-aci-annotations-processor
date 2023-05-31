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

import com.autonomy.aci.client.services.StAXProcessor;

import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Factory for producing IdolAnnotationsProcessors.
 */
public interface IdolAnnotationsProcessorFactory {

    /**
     * Returns a processor for the given class. When the {@code StAXProcessor#process} method is called the given
     * {@code XMLStreamReader} should be on the root field for the class.
     * @param clazz The class object for which a processor is required
     * @param <T>   The type which for which a processor will be produced
     * @return A {@code StAXProcessor} for {@code <T>}
     */
    <T> StAXProcessor<T> forClass(Class<T> clazz);

    /**
     * Returns a processor which returns a list of objects of type {@code <T>}. This processor places no restrictions
     * on the initial state of the {@code XMLStreamReader}.
     * @param clazz The class object for which a processor is required
     * @param <T>   The type which for which a processor will be produced
     * @return A {@code StAXProcessor} for {@code List<T>}
     */
    <T> StAXProcessor<List<T>> listProcessorForClass(Class<T> clazz);

    /**
     * Set the properties to use when a configured value is required via a {@code Properties} instance. Replaces existing configuration.
     * The new properties will apply to any new processors that are created but will not apply to previously existing ones.
     * @param properties The Properties object to use for configuration
     */
    void setProperties(Properties properties);

    /**
     * Set the properties to use when a configured value is required via a {@code ResourceBundle} instance. Replaces existing configuration.
     * The new properties will apply to any new processors that are created but will not apply to previously existing ones.
     * <p>
     * RENAMED in 0.9.2 to comply with JavaBeans specification
     * @param resourceBundle The ResourceBundle object to use for configuration
     */
    void setResourceBundle(ResourceBundle resourceBundle);

}
