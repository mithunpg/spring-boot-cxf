/**
 *
 */
package com.demo.springboot.cxf.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.springboot.cxf.controller.WeatherServiceController;

/**
 * @author mpissa
 *
 */
@Configuration
public class ApplicationConfiguration {

	@Bean
	public WeatherServiceController weatherServiceController() {
		return new WeatherServiceController();
	}

}
