package com.exception;

public class EmployeeValidationException extends RuntimeException{
	
	private String EmployeeValidationException;
	

	public EmployeeValidationException() {
		super();
	}


	public EmployeeValidationException(String employeeValidationException) {
		super();
		EmployeeValidationException = employeeValidationException;
	}


	public String getEmployeeValidationException() {
		return EmployeeValidationException;
	}


	public void setEmployeeValidationException(String employeeValidationException) {
		EmployeeValidationException = employeeValidationException;
	}


	@Override
	public String toString() {
		return "EmployeeException [EmployeeValidationException=" + EmployeeValidationException + "]";
	} 
	
	
	
}
