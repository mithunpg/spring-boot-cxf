/**
 *
 */
package com.demo.springboot.cxf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.demo.springboot.cxf.configuration.ApplicationConfiguration;
import com.demo.springboot.cxf.endpoint.v1.WeatherServiceEndpoint;

import de.codecentric.namespace.weatherservice.WeatherService;

/**
 * @author mpissa
 *
 */
@Configuration
@Import(ApplicationConfiguration.class)
public class ApplicationTestConfiguration {

	@Bean
	public WeatherService weatherService() {
		return new WeatherServiceEndpoint();
	}
}
