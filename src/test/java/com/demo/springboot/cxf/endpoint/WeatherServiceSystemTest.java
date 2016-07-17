/**
 *
 */
package com.demo.springboot.cxf.endpoint;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.springboot.cxf.test.config.SimpleBootCxfSystemTestApplication;
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
@SpringApplicationConfiguration(classes = SimpleBootCxfSystemTestApplication.class)
@WebIntegrationTest("server.port:8095")
public class WeatherServiceSystemTest {

	private static final Logger LOG = LoggerFactory.getLogger(WeatherServiceSystemTest.class);

	@Autowired
	private WeatherService weatherServiceSystemTestClient;

	@Test
	public void getCityForcastByZIP() throws WeatherException, InterruptedException {

		WeatherServiceSystemTest.LOG
		.debug("--- Starting system test getForcaseByZIP execution ---");
		Thread.sleep(3000);
		// Given
		ForecastRequest forecastRequest = TestHelper.generateDummyForecastRequest();

		// When
		ForecastReturn forecastReturn = this.weatherServiceSystemTestClient
				.getCityForecastByZIP(forecastRequest);

		// Then
		Assert.assertNotNull(forecastReturn);
		Assert.assertEquals(true, forecastReturn.isSuccess());
		Assert.assertEquals("Forcast city incorrect", "Weimar", forecastReturn.getCity());
		Assert.assertEquals("Forcast probability of perception incorrect", "22%", forecastReturn
				.getForecastResult().getForecast().get(0).getProbabilityOfPrecipiation()
				.getDaytime());
	}

}
