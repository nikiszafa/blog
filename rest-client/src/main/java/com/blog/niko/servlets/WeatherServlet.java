package com.blog.niko.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.niko.beans.WeatherBean;
import com.blog.niko.domain.Current_weather;
import com.blog.niko.domain.Weather;

@WebServlet("/WeatherServlet")
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	WeatherBean weatherBean;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Weather weather = weatherBean.getWeather();
		Current_weather current_weather = weather.getCurrent_weather();
		
		request.setAttribute("weather", weather);
		request.setAttribute("currentWeather", current_weather);

		request.getRequestDispatcher("/html/weather.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
