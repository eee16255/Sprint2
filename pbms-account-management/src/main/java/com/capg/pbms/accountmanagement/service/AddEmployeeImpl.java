package com.capg.pbms.accountmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.pbms.accountmanagement.model.Employee;
import com.capg.pbms.accountmanagement.repository.IEmployeeRepo;
@Service
public class AddEmployeeImpl implements IAddEmployeeService{

	@Autowired
	IEmployeeRepo employeeRepo;
	@Override
	public Employee addEmployee(Employee employee) {
		
		return employeeRepo.save(employee);
	}

	@Override
	public Employee getEmployeeById(long employeeId) {
		
		return employeeRepo.getOne(employeeId);
	}

	@Override
	public Employee getEmployeeName(String employeeName) {
		
		return employeeRepo.getUserByEmployeeName(employeeName);
	}

}
