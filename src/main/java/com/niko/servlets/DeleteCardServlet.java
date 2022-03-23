package com.niko.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niko.dao.CardDao;


public class DeleteCardServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@EJB
	CardDao cardDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cardId = Integer.parseInt(request.getParameter("cardId"));

		cardDao.deleteCard(cardId);

		response.sendRedirect("/blog/HomeServlet");
	}

}
