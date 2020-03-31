package com.kayak.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.beans.User;
import com.test.dao.ApplicationDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// collect all form data
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");		

		// fill it up in a User bean
		User user = new User(firstname, lastname, email, phoneNumber, address_1, address_2, password, dob, );
		
		// call DAO layer and save the user object to DB
		ApplicationDao dao = new ApplicationDao();
		int rows = dao.registerUser(user);
		
		// prepare an information message for user about the success or failure of the operation
		String infoMessage = null;
		if(rows == 0) {
			infoMessage = "Sorry, an error occurred!";
		} else {
			infoMessage = "User registered successfully!";
		}

		// write the message back to the page in client browser
		String page = getHTMLString(req.getServletContext().getRealPath("/html/register.html"), infoMessage);
		resp.getWriter().write(page);
	}

}
