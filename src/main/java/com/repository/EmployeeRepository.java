package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.EmployeDetails;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<EmployeDetails, Integer> {
		EmployeDetails readByEmail(String email);
		@Transactional
		/*all database operations inside the method happen in a single transaction
		 * if any exception occurs , the transaction is rolled back automatically
		 * if everything run successfully the transaction is committed 
		 * */
		int removeByEmail(String email);
		
		EmployeDetails readByEmpdeptno(int deptno);
}
