package com.controller;
import com.service.DeptService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.DeptDetails;

@RestController
public class DepartmentController {

    private final DeptService deptService;

    DepartmentController(DeptService deptService) {
        this.deptService = deptService;
    }
	
		@PostMapping("/deptregister")
		public DeptDetails insertDepartment(@RequestBody DeptDetails deptDetails) {
			DeptDetails details = deptService.insertDeptDetails(deptDetails);
			return details;
			
		}
		
		@GetMapping("/deptdisplay")
		public String displayDepartment() {
			return"display department";
		}
		
		@PutMapping("/deptupdate")
		public String updateDepartment() {
			return"update department";
		}
		
		@DeleteMapping("/deptdelete")
		public String deleteDepartment() {
			return"delete department";
		}
}
