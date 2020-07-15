package com.journaldev.spring.jdbc.model;

public class Employee {
	double empno;
	double commision;
	
	public Employee() {
		
	}
	
	
	public Employee(int empno, double commision) {
		super();
		this.empno = empno;
		this.commision = commision;
	}
	
	
	public double getEmpno() {
		return empno;
	}
	public void setEmpno(double d) {
		this.empno = d;
	}
	public double getCommision() {
		return commision;
	}
	public void setCommision(double commision) {
		this.commision = commision;
	}


	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", commision=" + commision + "]";
	}
	
	
	

}
