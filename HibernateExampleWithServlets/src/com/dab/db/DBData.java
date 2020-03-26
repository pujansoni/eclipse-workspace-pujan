package com.dab.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dab.model.EmployeeModel;

public class DBData {

	public List<EmployeeModel> getAllEMpEmployeeModels() {

		List<EmployeeModel> employeeModels = new ArrayList<>();

		FactoryConnection fac = new FactoryConnection();
		Session session = fac.getSessionFactory().openSession();

		Query query = session.createQuery("from EmployeeModel emp");
		employeeModels = query.list();

		return employeeModels;

	}

	public void saveEmployee(EmployeeModel emp) {
		FactoryConnection fac = new FactoryConnection();
		Session session = fac.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		session.save(emp);
		t.commit();
		System.out.println("inserted.......");
	}

	public void updateEmployee(EmployeeModel emp) {
		FactoryConnection fac = new FactoryConnection();
		Session session = fac.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		session.update(emp);
		t.commit();
		System.out.println("updated....");
	}

	public void deleteEmployee(EmployeeModel emp) {
		FactoryConnection fac = new FactoryConnection();
		Session session = fac.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		session.delete(emp);
		t.commit();
		System.out.println("deleted....");
	}
	
	public EmployeeModel getEmployeeById(int id){
		
		String query = "from EmployeeModel emp where emp.employeeId="+id;
		
		FactoryConnection fac = new FactoryConnection();
		Session session = fac.getSessionFactory().openSession();
		
		Query query2 = session.createQuery(query);
		
		EmployeeModel emp = (EmployeeModel) query2.list().get(0);
		
		return emp;
	}
	
}
