package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.entity.EmployeDetails;

@RestControllerAdvice
public class EmployeeNotFoundExceptionHandler {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> notFoundException(EmployeeNotFoundException exception) {
		String exception2 = exception.getEmployeeNotFoundException();
		return new ResponseEntity<String>(exception2,HttpStatus.NOT_FOUND);
	}
}
