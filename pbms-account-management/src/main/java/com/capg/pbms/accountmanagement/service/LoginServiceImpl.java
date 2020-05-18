package com.capg.pbms.accountmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.pbms.accountmanagement.model.Employee;
import com.capg.pbms.accountmanagement.repository.IEmployeeRepo;
@Service
public class LoginServiceImpl implements ILoginService{

	@Autowired
	IEmployeeRepo employeeRepo;
	@Override
	public boolean checkEmployeeDetails(String employeeName, String employeePassword) {
		if(!employeeRepo.existsByEmployeeName(employeeName)) {
			System.out.println("no data found");
		}
		if(employeeRepo.existsByEmployeeName(employeeName)) {
			if(!employeePassword.equals(employeeRepo.getUserByEmployeeName(employeeName).getEmployeePassword())) {
			System.out.println("Password mismatch");
			}
			
		}
		return true;
	}

	@Override
	public Employee getEmployeeName(String employeeName) {
		
		return employeeRepo.getUserByEmployeeName(employeeName);
	}

}
