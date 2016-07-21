/**
 *
 */
package com.demo.springboot.cxf;

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
public class WebServiceIntegrationTestConfiguration {

	@Bean
	public WeatherService weatherServiceIntegrationTestClient() {
		JaxWsProxyFactoryBean proxyFactoryBean = new JaxWsProxyFactoryBean();
		proxyFactoryBean.setServiceClass(WeatherService.class);
		proxyFactoryBean.setAddress("http://localhost:8090" + WebServiceConfiguration.BASE_URL
				+ WebServiceConfiguration.SERVICE_URL);

		return (WeatherService) proxyFactoryBean.create();
	}
}
