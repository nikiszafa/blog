package com.niko.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.niko.beans.Weather;

@Path("/weather")
public interface ClientWeatherEndpoint {
	
	@GET
	@Path("/v1/forecast?latitude=52.2297&longitude=21.0122&current_weather=true")
	@Produces(MediaType.APPLICATION_JSON)
	Weather getWeather();
	
}
