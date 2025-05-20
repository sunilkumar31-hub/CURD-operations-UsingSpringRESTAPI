package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.DeptDetails;

public interface DepartmentRepository extends JpaRepository<DeptDetails, Integer> {

}
