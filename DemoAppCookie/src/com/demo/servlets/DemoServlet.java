package com.demo.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Student> studs = Arrays.asList(new Student(1, "Pujan"), new Student(2, "Jay"), new Student(3, "Sharvil"));
		req.setAttribute("students", studs);
		RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
		rd.forward(req, res);
	}
}
