package com.exception;

public class EmployeeNotFoundException extends RuntimeException{
	private String employeeNotFoundException;
	
	public EmployeeNotFoundException() {
		super();
	}

	public EmployeeNotFoundException(String employeeNotFoundException) {
		super();
		this.employeeNotFoundException = employeeNotFoundException;
	}

	public String getEmployeeNotFoundException() {
		return employeeNotFoundException;
	}

	public void setEmployeeNotFoundException(String employeeNotFoundException) {
		this.employeeNotFoundException = employeeNotFoundException;
	}

	@Override
	public String toString() {
		return "EmployeeNotFoundException [employeeNotFoundException=" + employeeNotFoundException + "]";
	}
	
	
}
