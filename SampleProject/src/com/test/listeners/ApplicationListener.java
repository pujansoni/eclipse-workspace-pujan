package com.test.listeners;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.test.dao.DBConnection;

public class ApplicationListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("in contextDestroy method");
		Connection connection = (Connection)arg0.getServletContext().getAttribute("dbConnection");
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("in contextInitialized method");		
		Connection connection = DBConnection.getConnectionToDatabase();
		arg0.getServletContext().setAttribute("dbConnection", connection);
	}
	
}
