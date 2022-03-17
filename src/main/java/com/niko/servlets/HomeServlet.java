package com.niko.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niko.beans.Card;
import com.niko.beans.Post;
import com.niko.dao.ApplicationDao;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = (Connection) getServletContext().getAttribute("dbconnection");
		ApplicationDao dao = new ApplicationDao();
		List<Card> cards = dao.getCards(connection);
		request.setAttribute("cards", cards);
		for(Card mes:cards) {
			System.out.println(mes.getTitle());
		}
		request.getRequestDispatcher("/html/index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
