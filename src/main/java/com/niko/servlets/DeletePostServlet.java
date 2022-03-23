package com.niko.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niko.dao.PostDao;

public class DeletePostServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@EJB
	PostDao postDao;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int postId = Integer.parseInt(request.getParameter("postId"));

		postDao.deletePost(postId);

		response.sendRedirect("/blog/BlogServlet");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
