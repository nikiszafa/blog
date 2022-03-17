package com.niko.listeners;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.niko.dao.DBConnection;

public class ApplicationListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("In contextINIT");
		Connection connection = DBConnection.getConnectionToDB();
		sce.getServletContext().setAttribute("dbconnection", connection);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("In contextDestroy");
		Connection connection = (Connection) sce.getServletContext().getAttribute("dbconnection");
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
