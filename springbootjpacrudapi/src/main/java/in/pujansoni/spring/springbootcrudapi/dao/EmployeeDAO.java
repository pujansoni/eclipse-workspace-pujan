package in.pujansoni.spring.springbootcrudapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.pujansoni.spring.springbootcrudapi.model.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
	

}
