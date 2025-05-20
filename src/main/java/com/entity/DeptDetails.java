package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DeptDetails {
	@Id
	private int deptid;
	private String deptname;
	private int deptno;
	private String deptlocation;
	
	public DeptDetails() {
		super();
	}

	public DeptDetails(int deptid, String deptname, int deptno, String deptlocation) {
		super();
		this.deptid = deptid;
		this.deptname = deptname;
		this.deptno = deptno;
		this.deptlocation = deptlocation;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDeptlocation() {
		return deptlocation;
	}

	public void setDeptlocation(String deptlocation) {
		this.deptlocation = deptlocation;
	}
	
}
