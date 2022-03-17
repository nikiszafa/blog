package com.niko.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niko.beans.Post;
import com.niko.dao.ApplicationDao;

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/html/admin.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		String autor = request.getParameter("autor");
		String date = request.getParameter("date");
		String img = request.getParameter("postImg");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date datef = null;
		try {
			datef = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sql = new java.sql.Date(datef.getTime());
		String text = request.getParameter("text");
		Post post = new Post(title,text, autor, sql, img);
		
		ApplicationDao dao = new ApplicationDao();
		Connection connection = (Connection) getServletContext().getAttribute("dbconnection");

		dao.addPost(post, connection);

		response.sendRedirect("/blog/BlogServlet");

		
	}

}
