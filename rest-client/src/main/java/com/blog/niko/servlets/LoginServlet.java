package com.blog.niko.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.niko.beans.UserBean;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	UserBean userBean;

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

		String isValidUser = userBean.validateUser(username, password);

		if (isValidUser.equals("true")) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("/client/HomeServlet");
		} else {
			String errorMessage = "Invalid credentials";
			request.setAttribute("error", errorMessage);
			request.getRequestDispatcher("html/login.jsp").forward(request, response);
		}
	}

}
