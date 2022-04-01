package com.blog.niko.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.niko.beans.PostBean;

public class DeletePostServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	PostBean postBean;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int postId = Integer.parseInt(request.getParameter("postId"));

		postBean.deletePost(postId);

		response.sendRedirect("/blog/BlogServlet");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
