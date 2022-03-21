package com.niko.listeners;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("In contextINIT");

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("In contextDestroy");

	}

}
