package neumeric_tech.test.employee_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import neumeric_tech.test.employee_management.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	List<Employee> findByFirstNameOrLastName(String firstName, String lastName);
}
