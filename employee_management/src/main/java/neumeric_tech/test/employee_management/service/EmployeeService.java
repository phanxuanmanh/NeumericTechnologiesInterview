package neumeric_tech.test.employee_management.service;

import java.util.List;

import neumeric_tech.test.employee_management.model.Employee;

public interface EmployeeService {
	
	/**
	 * Create new Employee
	 * @param e the employee to create
	 */
	public void saveEmployee(Employee e);

	/**
	 * Delete employee
	 * @param id the employee ID
	 */
	public void deleteEmployee(Long id);

	/**
	 * Update the employee
	 * @param e the employee to update
	 */
	public void updateEmployee(Employee e);
	
	/**
	 * Get the employee by ID
	 * @return the list of all employees in the database
	 */
	public Employee findEmployeeById(Long id);

	/**
	 * Get all the employees
	 * @return the list of all employees in the database
	 */
	public List<Employee> findAllEmployees();

	/**
	 * Search employees by name
	 * @param name  the name to search
	 * @return List of matched employees
	 */
	public List<Employee> searchEmployeeByName(String firstName, String lastName);

}
