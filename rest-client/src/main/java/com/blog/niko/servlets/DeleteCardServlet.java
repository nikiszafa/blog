package com.blog.niko.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.niko.beans.CardBean;


public class DeleteCardServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	CardBean cardBean;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cardId = Integer.parseInt(request.getParameter("cardId"));

		cardBean.deleteCard(cardId);

		response.sendRedirect("/client/HomeServlet");
	}

}
