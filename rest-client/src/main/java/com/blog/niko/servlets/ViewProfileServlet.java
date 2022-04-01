package com.blog.niko.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = (String) request.getSession().getAttribute("username");

//		User user = userDao.getProfileDetails(username);
		
//		request.setAttribute("user", user);
		request.getRequestDispatcher("/html/profile.jsp").forward(request, response);

	}

}
