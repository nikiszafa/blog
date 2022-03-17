package com.niko.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niko.dao.ApplicationDao;


public class DeletePostServlet extends HttpServlet {



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int postId = Integer.parseInt(request.getParameter("postId"));
		ApplicationDao dao = new ApplicationDao();
		Connection connection = (Connection) getServletContext().getAttribute("dbconnection");
		
		dao.deletePost(postId, connection);

		response.sendRedirect("/blog/BlogServlet");
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
