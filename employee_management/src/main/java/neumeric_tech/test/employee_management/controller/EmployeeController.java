package neumeric_tech.test.employee_management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import neumeric_tech.test.employee_management.model.Address;
import neumeric_tech.test.employee_management.model.Employee;
import neumeric_tech.test.employee_management.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("")
	public String getlistEmployee(Model model) {
		List<Employee> employees = employeeService.findAllEmployees();
		model.addAttribute("employees", employees);
		return "employee/list";
	}
	
	@GetMapping("/new")
	public String goToNewEmployeePage(Model model) {
		Employee emp = new Employee();
		emp.setAddress(new Address());
		model.addAttribute("employee", emp);
		return "employee/new";
	}
	
	@PostMapping("")
	public String saveEmployee(Employee emp) {
		employeeService.saveEmployee(emp);
		logger.info("employee saved, Id : "+ emp.getId());
		return "redirect:/employee";
	}
	
	@GetMapping(value="/edit/{id}")
	public String editEmployee(@PathVariable Long id, Model model) {
		Employee emp = employeeService.findEmployeeById(id);
		if(emp == null) {
			throw new EmployeeNotFoundException();
		}
		model.addAttribute("employee", emp);
		return "employee/new";
	}
	
	@GetMapping(value="/search")
	public String editEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,  Model model) {
		List<Employee> employees = employeeService.searchEmployeeByName(firstName, lastName);
		model.addAttribute("employees", employees);
		return "employee/list";
	}
	
	@GetMapping(value="/remove")
	public String removeEmployee(@RequestParam("id") Long id) {
		employeeService.deleteEmployee(id);
		logger.info("employee deleted, Id : "+ id);
		return "redirect:/employee";
	}
	
}
