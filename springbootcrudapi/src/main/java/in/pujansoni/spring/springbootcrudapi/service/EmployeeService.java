package in.pujansoni.spring.springbootcrudapi.service;

import java.util.List;

import in.pujansoni.spring.springbootcrudapi.model.Employee;

public interface EmployeeService {
	
	List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id);
}
