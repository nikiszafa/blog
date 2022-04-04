package com.blog.niko.servlets;

import java.io.IOException;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.niko.beans.CardBean;
import com.blog.niko.domain.Card;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	CardBean cardBean;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Card> cards = cardBean.getCards();
		
		request.setAttribute("cards", cards);
		request.getRequestDispatcher("/html/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}