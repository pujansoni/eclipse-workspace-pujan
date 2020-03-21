package com.test.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.DBConnection;

public class HomeServlet extends HttpServlet{
	public Connection connection = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/html/index.html").forward(req, resp);
	}
	
	@Override
	public void init() throws ServletException {
		//initialization activity - set up DB connection object
		connection = DBConnection.getConnectionToDatabase();
	}
	
	@Override
	public void destroy() {
		//cleap up activity - close DB connection objects
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
