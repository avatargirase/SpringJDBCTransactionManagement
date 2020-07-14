package com.journaldev.spring.jdbc.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.journaldev.spring.jdbc.model.Address;
import com.journaldev.spring.jdbc.model.Customer;
import com.journaldev.spring.jdbc.service.CustomerManager;
import com.journaldev.spring.jdbc.service.CustomerManagerImpl;

public class TransactionManagerMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		CustomerManager customerManager = ctx.getBean("customerManager",
				CustomerManagerImpl.class);

		Customer cust = createDummyCustomer();
		customerManager.createCustomer(cust);

		ctx.close();
	}

	private static Customer createDummyCustomer() {
		
		Customer customer = new Customer();
		customer.setId(2);
		customer.setName("Avatar");
		
		Address address = new Address();
		address.setId(2);
		address.setCountry("USA");
		// setting value more than 20 chars, so that SQLException occurs
		address.setAddress("Dean Martin Drive, NV 89129");
		customer.setAddress(address);
		return customer;
	}

}

