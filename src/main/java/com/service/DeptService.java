package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.DAO.DeptDAO;
import com.entity.DeptDetails;

@Component
public class DeptService {
	@Autowired
	DeptDAO deptDAO;
	
	public DeptDetails insertDeptDetails(DeptDetails deptDetails) {
		return deptDAO.inssertDepartment(deptDetails);
	}
}
