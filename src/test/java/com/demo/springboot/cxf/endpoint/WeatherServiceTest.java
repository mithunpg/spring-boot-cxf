/**
 *
 */
package com.demo.springboot.cxf.endpoint;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.springboot.cxf.ApplicationTestConfiguration;
import com.demo.springboot.cxf.endpoint.v1.WeatherServiceEndpoint;
import com.demo.springboot.cxf.utils.TestHelper;

import de.codecentric.namespace.weatherservice.WeatherException;
import de.codecentric.namespace.weatherservice.general.ForecastRequest;
import de.codecentric.namespace.weatherservice.general.ForecastReturn;

/**
 * @author mpissa
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationTestConfiguration.class)
public class WeatherServiceTest {

	@Autowired
	private WeatherServiceEndpoint weatherServiceEndpoint;

	@Test
	public void getCityForecastByZIP() throws WeatherException {

		// Given
		ForecastRequest forecastRequest = TestHelper.generateDummyForecastRequest();

		// When
		ForecastReturn forecastReturn = this.weatherServiceEndpoint
				.getCityForecastByZIP(forecastRequest);

		// Then
		Assert.assertNotNull(forecastReturn);
		Assert.assertEquals(true, forecastReturn.isSuccess());
		Assert.assertEquals("Weimar", forecastReturn.getCity());
		Assert.assertEquals("22%", forecastReturn.getForecastResult().getForecast().get(0)
				.getProbabilityOfPrecipiation().getDaytime());
	}

}
