package com.niko.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niko.dao.ApplicationDao;


public class DeleteCardServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cardId = Integer.parseInt(request.getParameter("cardId"));
		ApplicationDao dao = new ApplicationDao();

		dao.deleteCard(cardId);

		response.sendRedirect("/blog/HomeServlet");
	}

}
