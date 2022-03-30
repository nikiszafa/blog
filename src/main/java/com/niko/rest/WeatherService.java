package com.niko.rest;

import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.niko.beans.Weather;

public class WeatherService {

	private static final String PATH = "https://api.open-meteo.com";

	public Weather getWeather() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(PATH));
		ClientWeatherEndpoint proxy = target.proxy(ClientWeatherEndpoint.class);

		Weather weather = proxy.getWeather();
		System.out.println("#####%%%%% REST TEMP:");
		System.out.println(weather.getTemp());
		return weather;
	}
	
	 

}
