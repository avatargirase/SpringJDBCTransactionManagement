package com.journaldev.spring.jdbc.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.jdbc.dao.EmployeeDAO;
import com.journaldev.spring.jdbc.model.Employee;

public class EmployeeManagerImpl implements EmployeeManager {

	public EmployeeDAO employeeDAO;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void withdraw(int empId, int amount) {

		employeeDAO.withdraw(empId, amount);
	}

	
	
	public void deposit(int empId, int amount) {

		employeeDAO.deposit(empId, amount);
		 throw new RuntimeException();

	}

	
	public void depo(int empId, int amount) {
		deposit(empId, amount);
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

		@Transactional(isolation = Isolation.READ_COMMITTED , propagation = Propagation.REQUIRED)
		public void trasnsfefCommision(int fromEmpId, int toEmpId, int amount) {

		withdraw(fromEmpId, amount);

		deposit(toEmpId, amount);

	}

	public Employee getEmployee(int empId) {

		return employeeDAO.getEmployee(empId);
	}

}
