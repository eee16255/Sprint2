package com.capg.pbms.accountmanagement.service;

import com.capg.pbms.accountmanagement.model.Employee;

public interface ILoginService {
public boolean checkEmployeeDetails(String employeeName,String employeePassword);
public Employee getEmployeeName(String employeeName);
}
