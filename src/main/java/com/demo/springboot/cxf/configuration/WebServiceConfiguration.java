/**
 *
 */
package com.demo.springboot.cxf.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.databinding.DataBinding;
import org.apache.cxf.feature.AbstractFeature;
import org.apache.cxf.feature.Feature;
import org.apache.cxf.feature.StaxTransformFeature;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.springboot.cxf.endpoint.v1.WeatherServiceEndpoint;

import de.codecentric.namespace.weatherservice.Weather;
import de.codecentric.namespace.weatherservice.WeatherService;

/**
 * @author mpissa
 *
 */
@Configuration
public class WebServiceConfiguration {

	public static final String BASE_URL = "/soap-api";
	public static final String SERVICE_URL = "/WeatherSoapService_1.0";

	/**
	 * Replaces the need for web.xml
	 * @return
	 */
	@Bean
	public ServletRegistrationBean dispatcherServlet() {
		return new ServletRegistrationBean(new CXFServlet(), BASE_URL + "/*");
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}

	@Bean
	public WeatherService weatherService() {
		return new WeatherServiceEndpoint();
	}

	@Bean
	public Weather weather() {
		// Needed for correct ServiceName & WSDLLocation to publish contract
		// first incl. original WSDL
		return new Weather();
	}

	@Bean
	public StaxTransformFeature staxTransformFeature() {
		StaxTransformFeature staxTransformFeature = new StaxTransformFeature();
		Map<String, String> outElements = new HashMap<>();
		outElements.put("{ns2}Forecast", "Forecast");
		staxTransformFeature.setOutTransformElements(outElements);

		return staxTransformFeature;
	}

	/**
	 * Replaces cxf-servlet.xml
	 * 
	 * @return
	 */
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(this.springBus(), this.weatherService());
		// CXF JAX-WS implementation relies on the correct ServiceName as
		// QName-Object with
		// the name-Attribute´s text <wsdl:service name="Weather"> and the
		// targetNamespace
		// "http://www.codecentric.de/namespace/weatherservice/"
		// Also the WSDLLocation must be set
		endpoint.setServiceName(this.weather().getServiceName());
		endpoint.setWsdlLocation(this.weather().getWSDLDocumentLocation().toString());
		endpoint.publish(WebServiceConfiguration.SERVICE_URL);
		
//		DataBinding dataBinding = new JAXBDataBinding();
//		Map<String, String> nameSpaceMapping = dataBinding.getDeclaredNamespaceMappings();
//		nameSpaceMapping.put("http://www.codecentric.de/namespace/weatherservice/datatypes", "x");
//		endpoint.setDataBinding(dataBinding );

		 List<Feature> transformationFeature = new ArrayList<>();
		 transformationFeature.add(this.staxTransformFeature());
		 endpoint.setFeatures(transformationFeature);

		return endpoint;
	}
}
