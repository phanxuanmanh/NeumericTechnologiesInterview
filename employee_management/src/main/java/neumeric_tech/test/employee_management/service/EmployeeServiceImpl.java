package neumeric_tech.test.employee_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neumeric_tech.test.employee_management.model.Employee;
import neumeric_tech.test.employee_management.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void saveEmployee(Employee e) {
		employeeRepository.save(e);
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public void updateEmployee(Employee e) {
		employeeRepository.save(e);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> searchEmployeeByName(String firstName, String lastName) {
		return employeeRepository.findByFirstNameOrLastName(firstName, lastName);
	}

	@Override
	public Employee findEmployeeById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}

}
