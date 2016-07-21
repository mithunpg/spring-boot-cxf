/**
 *
 */
package com.demo.springboot.cxf.endpoint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.springboot.cxf.SimpleBootCxfSystemTestApplication;
import com.demo.springboot.cxf.utils.TestHelper;

import de.codecentric.namespace.weatherservice.WeatherException;
import de.codecentric.namespace.weatherservice.WeatherService;
import de.codecentric.namespace.weatherservice.general.ForecastRequest;
import de.codecentric.namespace.weatherservice.general.ForecastReturn;

/**
 * @author mpissa
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SimpleBootCxfSystemTestApplication.class)
@WebIntegrationTest("server.port:8090")
public class WeatherServiceSystemTest {

	private static final Logger LOG = LoggerFactory.getLogger(WeatherServiceSystemTest.class);

	@Autowired
	private WeatherService weatherServiceSystemTestClient;

	@Test
	public void getCityForcastByZIP() throws WeatherException, InterruptedException {
		
		// Given
        ForecastRequest forecastRequest = TestHelper.generateDummyForecastRequest();
        
        // When
        ForecastReturn forecastReturn = weatherServiceSystemTestClient.getCityForecastByZIP(forecastRequest);
        
        // Then
        assertNotNull(forecastReturn);
        assertEquals(true, forecastReturn.isSuccess());
        assertEquals("Weimar", forecastReturn.getCity());
        assertEquals("22%", forecastReturn.getForecastResult().getForecast().get(0).getProbabilityOfPrecipiation().getDaytime());
        
	}

}
