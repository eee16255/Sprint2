package com.capg.pbms.accountmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.pbms.accountmanagement.model.Employee;
import com.capg.pbms.accountmanagement.service.ILoginService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class LoginServiceController {

	@Autowired
	ILoginService loginService;
	
	@GetMapping("/{employeeName}/{employeePassword}")

	public ResponseEntity<Employee> checkEmployeeDetails(@PathVariable String employeeName,@PathVariable String employeePassword) {
		if(loginService.checkEmployeeDetails(employeeName, employeePassword)) {
			 return  new ResponseEntity<Employee>(loginService.getEmployeeName(employeeName),HttpStatus.OK);}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
			 
		
		
	}
	
}
