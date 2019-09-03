package com.emp.service;

import java.util.List;

import com.emp.entity.Dept;
import com.emp.entity.Emp;

public interface DeptService {
	//查询所有员工
	List<Dept> queryAll();
	
	//依据部门编号查询部门
	Dept queryById(String deptno);
	
	
	//添加部门
	void addDept(Dept dept);
	
	//修改部门
	void updateDept(Dept dept);
	
	//依据编号删除部门
	void deleteDept(String dept);
	
	/*dao层没写这个方法
	 * List<Emp> queryMgrs();*/
}
