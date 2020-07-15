package com.journaldev.spring.jdbc.dao;

import com.journaldev.spring.jdbc.model.Employee;

public interface EmployeeDAO {

	public void withdraw(int  empId, int amount);
	public void deposit(int empId, int amount);
	public Employee getEmployee(int id);
}
