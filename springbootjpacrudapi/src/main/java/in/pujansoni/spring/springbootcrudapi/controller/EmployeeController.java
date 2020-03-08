package in.pujansoni.spring.springbootcrudapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pujansoni.spring.springbootcrudapi.dao.EmployeeDAO;
import in.pujansoni.spring.springbootcrudapi.model.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@GetMapping("/employee")
	public List<Employee> get() {
		return employeeDAO.findAll();
	}
	
	@PostMapping("/employee")
	public Employee save(@RequestBody Employee employeeObject) {
		employeeDAO.save(employeeObject);
		return employeeObject;
	}
	
	@GetMapping("/employee/{id}")
	public Employee get(@PathVariable int id) {
		Optional<Employee> employee = employeeDAO.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		} else {
			throw new RuntimeException("Employee Not Found for the id: " + id);
		}
	}
	
	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable int id) {
		Optional<Employee> employee = employeeDAO.findById(id);
		if(employee.isPresent()) {
			employeeDAO.delete(employee.get());
			return "Employee is deleted with id: " + id;
		} else {
			throw new RuntimeException("Employee Not Found for the id: " + id);
		}
	}
	
	@PutMapping("/employee")
	public Employee update(@RequestBody Employee employeeObject) {
		return employeeDAO.save(employeeObject);
	}
}
