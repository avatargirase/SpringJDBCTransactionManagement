package com.journaldev.spring.jdbc.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.jdbc.dao.mapper.EmployeeRowMapper;
import com.journaldev.spring.jdbc.model.Employee;


public class EmployeeDAOImpl  implements EmployeeDAO{

	public DataSource datasource;
	
	public JdbcTemplate jdbcTemplate;
	

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	public void withdraw(int  empId, int amount) {
		
		String transferQuery = "update emp set COMM = COMM - ? " + "where EMPNO = ?";
		jdbcTemplate.update(transferQuery, new Object[] {amount,empId });
		System.out.println("WithDraw Complated");
				
		
	}
	
	public void deposit(int empId, int amount) {
		
		String depositQuery = "update emp set COMM = COMM + ? " + "where EMPNO = ?";
		jdbcTemplate.update(depositQuery, new Object[] {amount,empId });
		System.out.println("Deposit Complated");
		
	}
	
	public Employee getEmployee(int id) {
		String query = "select empno, comm from emp where empno = ?";
		Employee employee = jdbcTemplate.queryForObject(query, new EmployeeRowMapper(),id);
		return employee;
		
	}

}
