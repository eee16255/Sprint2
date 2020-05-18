package com.capg.pbms.accountmanagement.service;

import com.capg.pbms.accountmanagement.model.Employee;

public interface IAddEmployeeService {
	
	public Employee addEmployee(Employee employee);
	public Employee getEmployeeById(long employeeId);
	public Employee getEmployeeName(String employeeName);
	

}
