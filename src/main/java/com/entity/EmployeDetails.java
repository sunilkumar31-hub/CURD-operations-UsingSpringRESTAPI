package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class EmployeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;
	private String empname;
	private String email;
	private double empsalary;
	private int empdeptno;
	
	
	
	public EmployeDetails() {
		super();
	}



	public EmployeDetails(int empid, String empname, String email, double empsalary, int empdeptno) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.email = email;
		this.empsalary = empsalary;
		this.empdeptno = empdeptno;
	}



	public int getEmpid() {
		return empid;
	}



	public void setEmpid(int empid) {
		this.empid = empid;
	}



	public String getEmpname() {
		return empname;
	}



	public void setEmpname(String empname) {
		this.empname = empname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public double getEmpsalary() {
		return empsalary;
	}



	public void setEmpsalary(double empsalary) {
		this.empsalary = empsalary;
	}



	public int getEmpdeptno() {
		return empdeptno;
	}



	public void setEmpdeptno(int empdeptno) {
		this.empdeptno = empdeptno;
	}
	
	
	

}
