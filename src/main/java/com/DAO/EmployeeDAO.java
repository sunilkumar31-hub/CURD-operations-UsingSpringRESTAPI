package com.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.entity.EmployeDetails;
import com.exception.EmployeeNotFoundException;
import com.repository.DepartmentRepository;
import com.repository.EmployeeRepository;

@Component
public class EmployeeDAO {

    private final DepartmentRepository departmentRepository;
	@Autowired
	EmployeeRepository employeeRepository;

    EmployeeDAO(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
	
	public EmployeDetails insertEmployee( EmployeDetails employeDetails) {
		
		return employeeRepository.save(employeDetails);
	}
	public List< EmployeDetails> allEmployeeDetails(){
		return employeeRepository.findAll();
	}
	public EmployeDetails readByEmail(String email) {
		return employeeRepository.readByEmail(email);
	}
	
	public boolean deleteEmployee(String email) {
		EmployeDetails deleteEmail = employeeRepository.readByEmail(email);
		if(deleteEmail!=null) {
			employeeRepository.delete(deleteEmail);
			return true;
			
		}
		else {
			return false;
		}
	}
	
	
	public int removeByEmail(String email) {
		return employeeRepository.removeByEmail(email);	
	}
	
	
	public EmployeDetails getDataByDeptno(int deptno) {
		return employeeRepository.readByEmpdeptno(deptno);
	}
}
