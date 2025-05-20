package com.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entity.DeptDetails;
import com.repository.DepartmentRepository;

@Component
public class DeptDAO {
	@Autowired
	DepartmentRepository departmentRepository;
				
			public DeptDetails inssertDepartment(DeptDetails deptDetails) {
				return departmentRepository.save(deptDetails);
			}
}
