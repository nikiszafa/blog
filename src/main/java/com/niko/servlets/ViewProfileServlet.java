package com.niko.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niko.beans.User;
import com.niko.dao.ApplicationDao;


public class ViewProfileServlet extends HttpServlet {
       

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("UserName in servlet: " + request.getSession().getAttribute("username"));
		ApplicationDao dao = new ApplicationDao();
		Connection connection = (Connection) getServletContext().getAttribute("dbconnection");
		
		String username = (String) request.getSession().getAttribute("username");
		
		User user = dao.getProfileDetails(username, connection);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/html/profile.jsp").forward(request, response);
		
	}

}
