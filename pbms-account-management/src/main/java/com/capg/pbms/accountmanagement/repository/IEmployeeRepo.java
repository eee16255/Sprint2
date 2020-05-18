package com.capg.pbms.accountmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.pbms.accountmanagement.model.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee,Long> {

	public Employee getUserByEmployeeName(String employeeName);

	
	public boolean existsByEmployeeName(String employeeName);

}
