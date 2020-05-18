package com.capg.pbms.accountmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.pbms.accountmanagement.model.Employee;
import com.capg.pbms.accountmanagement.service.IAddEmployeeService;
import com.capg.pbms.accountmanagement.service.ILoginService;

@RestController
@RequestMapping("/employee")
public class AddEmployeeController {

	@Autowired
	IAddEmployeeService employeeService;
	@Autowired
	ILoginService loginService;
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
		
	}
	@GetMapping("/id/{employeeId}")
	public Employee getEmployeeById(@PathVariable long employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}
	@GetMapping("/name/{employeeName}")
	public Employee getEmployeeByName(@PathVariable String employeeName) {
		return employeeService.getEmployeeName(employeeName);
	}
}
