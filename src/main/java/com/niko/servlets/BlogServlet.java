package com.niko.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niko.beans.Post;
import com.niko.dao.PostDao;

public class BlogServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@EJB
	PostDao postDao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		List<Post> posts = postDao.getPosts();
		
		request.setAttribute("posts", posts);
		request.getRequestDispatcher("/html/blog.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
