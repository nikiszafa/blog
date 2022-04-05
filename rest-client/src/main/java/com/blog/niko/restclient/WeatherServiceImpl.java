package com.blog.niko.restclient;


import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.blog.niko.domain.Weather;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ApplicationScoped
public class WeatherServiceImpl implements WeatherService {

	private static final String API_URL = "https://api.open-meteo.com/v1/forecast?latitude=52.2297&longitude=21.0122&current_weather=true";

	private Client client;

	@PostConstruct
	public void initialise() {
		client = ClientBuilder.newClient();
	}

	@Override
	public Weather getWeather() {
		WebTarget target = client.target(API_URL);
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		String jsonString = response.readEntity(String.class);

		ObjectMapper objectMapper = new ObjectMapper();

		Weather weather = null;

		try {
			weather = objectMapper.readValue(jsonString, Weather.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return weather;
	}

}
