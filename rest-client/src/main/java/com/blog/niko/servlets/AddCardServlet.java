package com.blog.niko.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.niko.beans.CardBean;
import com.blog.niko.domain.Card;


public class AddCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	CardBean cardBean;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String imgPath = request.getParameter("imgPath");
		String content = request.getParameter("content");
		String buttonText = request.getParameter("buttonText");
		String buttonLink = request.getParameter("buttonLink");

		Card card = new Card(imgPath, title, content, buttonText, buttonLink);

		cardBean.addCard(card);
		
		response.sendRedirect("/blog/HomeServlet");

	}

}
