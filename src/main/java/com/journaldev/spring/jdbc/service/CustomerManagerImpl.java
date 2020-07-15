package com.journaldev.spring.jdbc.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.jdbc.dao.CustomerDAO;
import com.journaldev.spring.jdbc.model.Customer;

public class CustomerManagerImpl implements CustomerManager {

	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED,readOnly = true, rollbackFor = Exception.class)
	public void createCustomer(Customer cust) {
		customerDAO.create(cust);
	}

}
