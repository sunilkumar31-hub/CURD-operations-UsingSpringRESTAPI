package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.EmployeDetails;
import com.service.EmployeeService;

import jakarta.websocket.server.PathParam;
/*RestController it is the combination of Controller,ResponseBody annotations 
 * it is used to specify the class is used to handle the request and response
 * it is also give the response in the form of JSON object
 * */
@RestController
public class EmployeController {
	
	@Autowired
	EmployeeService employeeService;
	/*it is used to create the end point for insertion operation*/
		@PostMapping("/registration")
		public ResponseEntity<EmployeDetails> insertEmployeeDetails(@RequestBody EmployeDetails employeDetails){
			ResponseEntity<EmployeDetails> details = employeeService.insertEmployeeDetails(employeDetails);
			return details;
		}
		/*it is used to create the end point for selection operation*/
		/*QUERY STRING 
		 * Query String declaring the keys and values from query string
		 * localhost:8080/coustmerlogin?key=value & key = value &key=value
		 * @requestparam is used to get the value from query string
		 * 
		 * PATH PARAM 
		 * path param declaring the direct value in the url
		 * localhost:8080/coustmerlogin/value/value
		 * but while creating the end point we need to create the key syntax
		 * 
		 * @Getmapping ("/coustmerlogin/(key)/(key)")
		 * 
		 * @path variable is used to get the value from the path param
		 */
		@GetMapping("/selectEmployeeDetails")
		public ResponseEntity<EmployeDetails> selectEmployeeDetails(@RequestParam("email") String email){
			
			 ResponseEntity<EmployeDetails> empDetailsByEmail = employeeService.readByUsingEmail(email);
			 return empDetailsByEmail;
		}
		/*it is used to create the end point for update operation*/
		@PutMapping("/updateEmployee/{deptno}/{email}")
		public ResponseEntity<String> updateEmployeeDetails(@PathVariable("deptno") int deptno,@PathVariable ("email") String email) {
			
			return employeeService.updateEmployeeEmailUsingDeptno(deptno,email);
		}
		/*it is used to create the end point for delete operation*/
		@DeleteMapping("/deleteEmployee/{useremail}")
		public ResponseEntity<String> deleteEmployeeDetails(@PathVariable("useremail") String email) {
		//	return employeeService.deleteEmployeDetails(email);
			ResponseEntity<String> deleteByUsingEmail = employeeService.deleteByUsingEmail(email);
			return deleteByUsingEmail;
		} 
		
		
}
