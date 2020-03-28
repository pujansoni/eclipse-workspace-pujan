package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("Hi ");
		ServletContext ctx = getServletContext();
		String str = ctx.getInitParameter("Phone");
		out.println(str);
		out.print("Hi ");
		ServletConfig cif = getServletConfig();
		String str1 = cif.getInitParameter("name");
		out.println(str1);
	}
}
