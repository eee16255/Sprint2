package com.capg.pbms.accountmanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Emp_info")
public class Employee {
	@Id
	private long employeeId;
	private String employeeName;
	private String employeeBranchId;
	private String employeeDesignation;
	private String employeeSal;
	private String employeePassword;
	public Employee() {
		
	}
	public Employee(long employeeId, String employeeName, String employeeBranchId, String employeeDesignation,
			String employeeSal, String employeePassword) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeBranchId = employeeBranchId;
		this.employeeDesignation = employeeDesignation;
		this.employeeSal = employeeSal;
		this.employeePassword = employeePassword;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeBranchId() {
		return employeeBranchId;
	}
	public void setEmployeeBranchId(String employeeBranchId) {
		this.employeeBranchId = employeeBranchId;
	}
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	public String getEmployeeSal() {
		return employeeSal;
	}
	public void setEmployeeSal(String employeeSal) {
		this.employeeSal = employeeSal;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeBranchId="
				+ employeeBranchId + ", employeeDesignation=" + employeeDesignation + ", employeeSal=" + employeeSal
				+ ", employeePassword=" + employeePassword + "]";
	}
	


}
