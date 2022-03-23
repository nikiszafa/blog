package com.niko.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niko.beans.Card;
import com.niko.dao.CardDao;

public class AddCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	CardDao cardDao;

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

		cardDao.addCard(card);
		
		response.sendRedirect("/blog/HomeServlet");

	}

}
