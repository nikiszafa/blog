package com.blog.niko.domain;

public class Weather {
	private float utc_offset_seconds;
	private float latitude;
	private float longitude;
	private float elevation;
	private float generationtime_ms;
	Current_weather Current_weatherObject;

	// Getter Methods

	public float getUtc_offset_seconds() {
		return utc_offset_seconds;
	}

	public float getLatitude() {
		return latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public float getElevation() {
		return elevation;
	}

	public float getGenerationtime_ms() {
		return generationtime_ms;
	}

	public Current_weather getCurrent_weather() {
		return Current_weatherObject;
	}

	// Setter Methods

	public void setUtc_offset_seconds(float utc_offset_seconds) {
		this.utc_offset_seconds = utc_offset_seconds;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public void setElevation(float elevation) {
		this.elevation = elevation;
	}

	public void setGenerationtime_ms(float generationtime_ms) {
		this.generationtime_ms = generationtime_ms;
	}

	public void setCurrent_weather(Current_weather current_weatherObject) {
		this.Current_weatherObject = current_weatherObject;
	}
}