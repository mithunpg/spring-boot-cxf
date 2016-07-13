/**
 *
 */
package com.demo.springboot.cxf.controller;

import org.springframework.stereotype.Component;

import com.demo.springboot.cxf.transformation.GetCityForecastByZIPOutMapper;

import de.codecentric.namespace.weatherservice.general.ForecastRequest;
import de.codecentric.namespace.weatherservice.general.ForecastReturn;

/**
 * @author mpissa
 *
 */
@Component
public class WeatherServiceController {

	public ForecastReturn getCityForecastByZIP(final ForecastRequest forecastRequest) {
		/*
		 * We leave out inbound transformation, plausibility-checking, logging,
		 * backend-calls e.g. for the moment
		 */
		return GetCityForecastByZIPOutMapper.mapGeneralOutlook2Forecast();
	}

	/*
	 * Other Methods would follow here...
	 */
	// public WeatherReturn getCityWeatherByZIP(ForecastRequest forecastRequest)
	// throws BusinessException {}

	// public WeatherInformationReturn getWeatherInformation(String zip) throws
	// BusinessException {}

}
