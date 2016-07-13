/**
 *
 */
package com.demo.springboot.cxf.endpoint.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.springboot.cxf.controller.WeatherServiceController;

import de.codecentric.namespace.weatherservice.WeatherException;
import de.codecentric.namespace.weatherservice.WeatherService;
import de.codecentric.namespace.weatherservice.general.ForecastRequest;
import de.codecentric.namespace.weatherservice.general.ForecastReturn;
import de.codecentric.namespace.weatherservice.general.WeatherInformationReturn;
import de.codecentric.namespace.weatherservice.general.WeatherReturn;

/**
 * @author mpissa
 *
 */
public class WeatherServiceEndpoint implements WeatherService {

	private static final Logger LOG = LoggerFactory.getLogger(WeatherServiceEndpoint.class);

	@Autowired
	private WeatherServiceController weatherServiceController;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.codecentric.namespace.weatherservice.WeatherService#getWeatherInformation
	 * (java.lang.String)
	 */
	@Override
	public WeatherInformationReturn getWeatherInformation(final String zip) throws WeatherException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.codecentric.namespace.weatherservice.WeatherService#getCityForecastByZIP
	 * (de.codecentric.namespace.weatherservice.general.ForecastRequest)
	 */
	@Override
	public ForecastReturn getCityForecastByZIP(final ForecastRequest forecastRequest)
			throws WeatherException {
		WeatherServiceEndpoint.LOG.warn("Started service processing for City Forecast");
		return this.weatherServiceController.getCityForecastByZIP(forecastRequest);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.codecentric.namespace.weatherservice.WeatherService#getCityWeatherByZIP
	 * (de.codecentric.namespace.weatherservice.general.ForecastRequest)
	 */
	@Override
	public WeatherReturn getCityWeatherByZIP(final ForecastRequest forecastRequest)
			throws WeatherException {
		return null;

	}

}
