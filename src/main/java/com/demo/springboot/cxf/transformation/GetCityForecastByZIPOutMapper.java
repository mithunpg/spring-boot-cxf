/**
 *
 */
package com.demo.springboot.cxf.transformation;

import de.codecentric.namespace.weatherservice.datatypes.ArrayOfForecast;
import de.codecentric.namespace.weatherservice.datatypes.Forecast;
import de.codecentric.namespace.weatherservice.datatypes.POP;
import de.codecentric.namespace.weatherservice.datatypes.Temp;
import de.codecentric.namespace.weatherservice.general.ForecastReturn;

/**
 * @author mpissa
 *
 */
public class GetCityForecastByZIPOutMapper {

	private static de.codecentric.namespace.weatherservice.general.ObjectFactory objectFactoryGeneral = new de.codecentric.namespace.weatherservice.general.ObjectFactory();
	private static de.codecentric.namespace.weatherservice.datatypes.ObjectFactory objectFactoryDatatypes = new de.codecentric.namespace.weatherservice.datatypes.ObjectFactory();

	public static ForecastReturn mapGeneralOutlook2Forecast() {
		ForecastReturn forecastReturn = GetCityForecastByZIPOutMapper.objectFactoryGeneral
				.createForecastReturn();
		forecastReturn.setCity("Weimar");
		forecastReturn.setState("Deutschland");
		forecastReturn.setSuccess(true);
		forecastReturn.setWeatherStationCity("Weimar");
		forecastReturn.setForecastResult(GetCityForecastByZIPOutMapper
				.generateForecastResult(forecastReturn.getCity()));
		return forecastReturn;
	}

	private static ArrayOfForecast generateForecastResult(final String city) {
		ArrayOfForecast forecastContainer = GetCityForecastByZIPOutMapper.objectFactoryDatatypes
				.createArrayOfForecast();
		forecastContainer.getForecast().add(GetCityForecastByZIPOutMapper.generateForecast(city));
		return forecastContainer;
	}

	private static Forecast generateForecast(final String city) {
		Forecast forecast = GetCityForecastByZIPOutMapper.objectFactoryDatatypes.createForecast();
		// forecast.setDate(GetCityForecastByZIPOutMapper.generateCalendarFromNow());
		forecast.setDesciption("Vorhersage für " + city);
		forecast.setTemperatures(GetCityForecastByZIPOutMapper.generateTemp());
		forecast.setProbabilityOfPrecipiation(GetCityForecastByZIPOutMapper
				.generateRegenwahrscheinlichkeit());
		return forecast;
	}

	private static POP generateRegenwahrscheinlichkeit() {
		POP pop = GetCityForecastByZIPOutMapper.objectFactoryDatatypes.createPOP();
		pop.setDaytime("22%");
		pop.setNighttime("5000%");
		return pop;
	}

	private static Temp generateTemp() {
		Temp temp = GetCityForecastByZIPOutMapper.objectFactoryDatatypes.createTemp();
		temp.setDaytimeHigh("90°");
		temp.setMorningLow("0°");
		return temp;
	}

	// private static XMLGregorianCalendar generateCalendarFromNow() {
	// GregorianCalendar gregCal = GregorianCalendar.from(ZonedDateTime.now());
	// XMLGregorianCalendar xmlGregCal = null;
	// try {
	// xmlGregCal =
	// DatatypeFactory.newInstance().newXMLGregorianCalendar(gregCal);
	// } catch (DatatypeConfigurationException exception) {
	// // LOG.calenderMappingNotWorking(exception);
	// }
	// return xmlGregCal;
	// }

}
