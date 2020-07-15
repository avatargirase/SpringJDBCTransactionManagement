package com.journaldev.spring.jdbc.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.journaldev.spring.jdbc.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee employee = new Employee();
		employee.setEmpno(rs.getDouble(1));
		employee.setCommision(rs.getDouble(2));
		return employee;
	}
	

}
