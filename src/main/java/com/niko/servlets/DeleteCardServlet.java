package com.niko.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niko.dao.ApplicationDao;

/**
 * Servlet implementation class DeleteCardServlet
 */
public class DeleteCardServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cardId = Integer.parseInt(request.getParameter("cardId"));
		ApplicationDao dao = new ApplicationDao();
		Connection connection = (Connection) getServletContext().getAttribute("dbconnection");
		
		dao.deleteCard(cardId, connection);
		
		response.sendRedirect("/blog/HomeServlet");
	}

}
