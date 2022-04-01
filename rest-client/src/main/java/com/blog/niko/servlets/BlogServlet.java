package com.blog.niko.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.niko.beans.PostBean;
import com.blog.niko.domain.Post;

public class BlogServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	PostBean postBean;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Post> posts = postBean.getPosts();

		request.setAttribute("posts", posts);
		request.getRequestDispatcher("/html/blog.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
