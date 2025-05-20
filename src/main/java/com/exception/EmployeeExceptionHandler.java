package com.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler(EmployeeValidationException.class)
	public ResponseEntity<String> employeeException(EmployeeValidationException employeeValidationException) {
		String exception = employeeValidationException.getEmployeeValidationException();	
		return new ResponseEntity<String>(exception,HttpStatus.BAD_REQUEST);
	//	return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
}
