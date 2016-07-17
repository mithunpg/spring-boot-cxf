/**
 *
 */
package com.demo.springboot.cxf.test.config;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.springboot.cxf.configuration.WebServiceConfiguration;

import de.codecentric.namespace.weatherservice.WeatherService;

/**
 * @author mpissa
 *
 */
@Configuration
public class WebServiceSystemTestConfiguration {

	@Bean
	public WeatherService weatherServiceSystemTestClient() {
		JaxWsProxyFactoryBean jaxWsProxyFactory = new JaxWsProxyFactoryBean();
		jaxWsProxyFactory.setServiceClass(WeatherService.class);
		jaxWsProxyFactory.setAddress("http://localhost:8095" + WebServiceConfiguration.BASE_URL
				+ WebServiceConfiguration.SERVICE_URL);

		return (WeatherService) jaxWsProxyFactory.create();
	}
}
