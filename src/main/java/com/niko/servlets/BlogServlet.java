package com.niko.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niko.beans.Post;
import com.niko.dao.ApplicationDao;


public class BlogServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection connection = (Connection) getServletContext().getAttribute("dbconnection");
		ApplicationDao dao = new ApplicationDao();
		List<Post> posts = dao.getPosts(connection);
		request.setAttribute("posts", posts);
		for(Post mes:posts) {
			System.out.println(mes.getPostTitle());
		}
		request.getRequestDispatcher("/html/blog.jsp").forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
