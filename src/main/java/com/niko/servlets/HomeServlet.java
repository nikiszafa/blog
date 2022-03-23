package com.niko.servlets;

import java.io.IOException;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niko.beans.Card;
import com.niko.dao.CardDao;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	CardDao cardDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Card> cards = cardDao.getCards();
		
		request.setAttribute("cards", cards);
		request.getRequestDispatcher("/html/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
