package com.blog.niko.domain;

public class Current_weather {
	private float winddirection;
	private float weathercode;
	private float temperature;
	private float windspeed;
	private String time;

	// Getter Methods

	public float getWinddirection() {
		return winddirection;
	}

	public float getWeathercode() {
		return weathercode;
	}

	public float getTemperature() {
		return temperature;
	}

	public float getWindspeed() {
		return windspeed;
	}

	public String getTime() {
		return time;
	}

	// Setter Methods

	public void setWinddirection(float winddirection) {
		this.winddirection = winddirection;
	}

	public void setWeathercode(float weathercode) {
		this.weathercode = weathercode;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public void setWindspeed(float windspeed) {
		this.windspeed = windspeed;
	}

	public void setTime(String time) {
		this.time = time;
	}
}