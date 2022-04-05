package com.blog.niko.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.blog.niko.domain.Weather;
import com.blog.niko.restclient.WeatherServiceImpl;

@RequestScoped
public class WeatherBean {

	@Inject
	WeatherServiceImpl weatherService;

	public Weather getWeather() {
		return weatherService.getWeather();
	}


}
