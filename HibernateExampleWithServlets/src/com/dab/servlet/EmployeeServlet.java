package com.dab.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dab.db.DBData;
import com.dab.model.EmployeeModel;

public class EmployeeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("***************************");
		System.out.println("*    Welcome to Servlet   *");
		System.out.println("***************************");
		RequestDispatcher rd = null;
		DBData db = new DBData();
		if(req.getParameter("action") != null){
			if(req.getParameter("action").toString().equals("new")){
				EmployeeModel emp = new EmployeeModel();
				req.setAttribute("employee", emp);
				req.setAttribute("action", "new");
				rd = req.getRequestDispatcher("/register.jsp");
			}else if(req.getParameter("action").toString().equals("update")){
				int id = Integer.parseInt(req.getParameter("id").toString());
				System.out.println("ID:: "+id);
				
				EmployeeModel emp = db.getEmployeeById(id);
				req.setAttribute("employee", emp);
				req.setAttribute("action", "update");
				rd = req.getRequestDispatcher("/register.jsp");
				
			}else if(req.getParameter("action").toString().equals("delete")){
				
				int id = Integer.parseInt(req.getParameter("id").toString());
				System.out.println("ID:: "+id);
				EmployeeModel emp = new EmployeeModel();
				emp.setEmployeeId(id);
				
				db.deleteEmployee(emp);
				System.out.println("succefully deletd...");
				
				List<EmployeeModel> getEmployeeModels = db.getAllEMpEmployeeModels();
				req.setAttribute("employees", getEmployeeModels);
				rd = req.getRequestDispatcher("/index.jsp");
			}
			
		}else{
			
			List<EmployeeModel> getEmployeeModels = db.getAllEMpEmployeeModels();
			req.setAttribute("employees", getEmployeeModels);
			rd = req.getRequestDispatcher("/index.jsp");
		}
		
		

		rd.forward(req, resp);

	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String action = req.getParameter("action").toString();
		RequestDispatcher rd = null;
		if (action.equals("new")){
			EmployeeModel emp = new EmployeeModel();
			emp.setEmployeeName(req.getParameter("name").toString());
			emp.setNic(req.getParameter("nic").toString());
			emp.setDesignation(req.getParameter("designation").toString());
			emp.setEmail(req.getParameter("email").toString());
			emp.setCompany(req.getParameter("company").toString());
			DBData db = new DBData();
			db.saveEmployee(emp);
			List<EmployeeModel> getEmployeeModels = db.getAllEMpEmployeeModels();
			req.setAttribute("employees", getEmployeeModels);
			rd = req.getRequestDispatcher("/index.jsp");
		} else if (action.equals("update")){
			EmployeeModel emp = new EmployeeModel();
			emp.setEmployeeName(req.getParameter("name").toString());
			emp.setNic(req.getParameter("nic").toString());
			emp.setDesignation(req.getParameter("designation").toString());
			emp.setEmail(req.getParameter("email").toString());
			emp.setCompany(req.getParameter("company").toString());
			emp.setEmployeeId(Integer.parseInt(req.getParameter("employeeId").toString()));
			DBData db = new DBData();
			db.updateEmployee(emp);
			List<EmployeeModel> getEmployeeModels = db.getAllEMpEmployeeModels();
			req.setAttribute("employees", getEmployeeModels);
			rd = req.getRequestDispatcher("/index.jsp");	
		}	
		rd.forward(req, resp);
	}
}
