package com.niko.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niko.dao.ApplicationDao;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/html/login.jsp");
		dispatcher.include(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		ApplicationDao dao = new ApplicationDao();
		Connection connection = (Connection) getServletContext().getAttribute("dbconnection");

		boolean isValidUser = dao.validateUser(username, password, connection);

		if (isValidUser) {
			System.out.println("User valid");
			HttpSession session = request.getSession();
			session.setAttribute("username",username);
			response.sendRedirect("/blog/HomeServlet");
		} else {
			System.out.println("User invalid");
			String errorMessage = "Invalid credentials";
			request.setAttribute("error", errorMessage);
			request.getRequestDispatcher("html/login.jsp").forward(request, response);
		}
	}

}
