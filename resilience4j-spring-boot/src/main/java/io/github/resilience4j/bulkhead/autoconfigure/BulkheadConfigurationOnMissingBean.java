/*
 * Copyright 2019 Mahmoud Romeh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.resilience4j.bulkhead.autoconfigure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.github.resilience4j.bulkhead.event.BulkheadEvent;
import io.github.resilience4j.common.IntegerToDurationConverter;
import io.github.resilience4j.common.StringToDurationConverter;
import io.github.resilience4j.consumer.DefaultEventConsumerRegistry;
import io.github.resilience4j.consumer.EventConsumerRegistry;

/**
 * {@link Configuration
 * Configuration} for resilience4j-bulkhead.
 */
@Configuration
@Import({IntegerToDurationConverter.class, StringToDurationConverter.class})
public class BulkheadConfigurationOnMissingBean extends AbstractBulkheadConfigurationOnMissingBean {
	/**
	 * The EventConsumerRegistry is used to manage EventConsumer instances.
	 * The EventConsumerRegistry is used by the BulkheadHealthIndicator to show the latest Bulkhead events
	 * for each Bulkhead instance.
	 *
	 * @return a default EventConsumerRegistry {@link DefaultEventConsumerRegistry}
	 */
	@Bean
	public EventConsumerRegistry<BulkheadEvent> bulkheadEventConsumerRegistry() {
		return bulkheadConfiguration.bulkheadEventConsumerRegistry();
	}
}
