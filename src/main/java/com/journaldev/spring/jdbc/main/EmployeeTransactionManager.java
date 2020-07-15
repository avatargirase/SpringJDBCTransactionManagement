package com.journaldev.spring.jdbc.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.journaldev.spring.jdbc.model.Address;
import com.journaldev.spring.jdbc.model.Customer;
import com.journaldev.spring.jdbc.service.EmployeeManager;
import com.journaldev.spring.jdbc.service.EmployeeManagerImpl;

public class EmployeeTransactionManager {
	


	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		EmployeeManager employeeManager = ctx.getBean("employeeManager",
				EmployeeManagerImpl.class);

		employeeManager.trasnsfefCommision(7499, 7521, 10);
		
		System.out.println(employeeManager.getEmployee(7521));

		ctx.close();
	}

	


}
