package com.service;

import java.util.List;
import com.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.DAO.EmployeeDAO;
import com.config.EmailConfig;
import com.entity.EmployeDetails;
import com.exception.EmployeeNotFoundException;
import com.exception.EmployeeValidationException;

@Component
public class EmployeeService {
	@Autowired
    EmployeeRepository employeeRepository;
	@Autowired
	EmployeeDAO employeeDAO;
	@Autowired
	EmailConfig emailConfig;
	public ResponseEntity<EmployeDetails> insertEmployeeDetails(EmployeDetails employeDetails) {
		
		List<EmployeDetails> allEmployeeDetails = employeeDAO.allEmployeeDetails();
		long emailcount= allEmployeeDetails.stream().filter((emp) -> emp.getEmail().equals(employeDetails.getEmail())).count();
		if(emailcount==0) {
			EmployeDetails details = employeeDAO.insertEmployee(employeDetails);
			if(details.getEmpid()!=0) {
			emailConfig.sendTextMsg(details.getEmail(), details.getEmpname()+"  your account created successfully...");
			
			return new ResponseEntity<EmployeDetails>(details,HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}      
		}
		else {
			throw new EmployeeValidationException("email already existed");
		}
		
	}
	public ResponseEntity<EmployeDetails> readByUsingEmail(String email) {
		EmployeDetails byEmail = employeeDAO.readByEmail(email);
		if(byEmail!=null) {
			return new ResponseEntity<EmployeDetails>(byEmail,HttpStatus.OK);
		}
		else {
			throw new EmployeeNotFoundException("no data found");
		}
	}
	public ResponseEntity<String> deleteEmployeDetails(String email) {
		  boolean deleteEmployee = employeeDAO.deleteEmployee(email);
		if(deleteEmployee) {
			return new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
		}
		else {
			throw new EmployeeNotFoundException("no data found");
		}
	}
	
	
	
	public ResponseEntity<String> deleteByUsingEmail(String email) {
		 int removeByEmail = employeeDAO.removeByEmail(email);
		 if(removeByEmail!=0) {
			 return new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
		 }
		 else {
			 throw new EmployeeNotFoundException("no data found");
		 }
	}
	
	
	public ResponseEntity<String>  updateEmployeeEmailUsingDeptno(int deptno,String email)
	{
		 EmployeDetails details = employeeDAO.getDataByDeptno(deptno);
		
		 
		 if(details!=null)
		 {
			 details.setEmail(email);
			 employeeRepository.save(details);
			 return new ResponseEntity<String>("Email updated successfully",HttpStatus.OK);
		 }
		 else {
			 throw new EmployeeNotFoundException("no data found");
		 }
	}
}
