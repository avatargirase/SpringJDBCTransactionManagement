package com.journaldev.spring.jdbc.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.journaldev.spring.jdbc.model.Customer;


public class CustomerDAOImpl implements CustomerDAO {

	
	private DataSource dataSource;

	/* If you want to use Autowiring
	 * 1)  Use https://www.javatpoint.com/autowiring-in-spring this way
	 * 2)   If you want to use @Autowired then add <context:annotation-config
	 * /> to spring.xml file and add that annotation to setter/property of the datasource
	 */	
	
	public void setDataSource(DataSource dataSource) {
		 
		this.dataSource = dataSource;
	}

	public void create(Customer customer) {
		String queryCustomer = "insert into Customer (id, name) values (?,?)";
		String queryAddress = "insert into Address (id, address,country) values (?,?,?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(queryCustomer, new Object[] { customer.getId(),
				customer.getName() });
		System.out.println("Inserted into Customer Table Successfully");
		jdbcTemplate.update(queryAddress, new Object[] { customer.getId(),
				customer.getAddress().getAddress(),
				customer.getAddress().getCountry() });
		
		System.out.println("Inserted into Address Table Successfully");
	}

}
