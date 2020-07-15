package com.journaldev.spring.jdbc.service;

import com.journaldev.spring.jdbc.model.Employee;

public interface EmployeeManager {

	public void withdraw(int  empId, int amount);
	public void deposit(int empId, int amount);
	public void trasnsfefCommision(int fromEmpId,int toEmpId, int amount);
	public void depo(int empId, int amount);
	public Employee getEmployee(int empId);
	
}
