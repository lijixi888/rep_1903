package com.emp.service.impl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.emp.dao.DeptDao;
import com.emp.entity.Dept;
import com.emp.entity.Emp;
import com.emp.service.DeptService;
@Service
public class DeptServiceImpl implements DeptService {
	@Resource
	private DeptDao deptDao;
	private DeptService deptService;
	@Override
	public List<Dept> queryAll() {
		List<Dept> list = deptDao.selectAll();
		return list;
	}

	
	@Override
	public Dept queryById(String deptno) {
		Dept d = deptDao.selectId(deptno);
		return d;
	}

	

	@Override
	public void addDept(Dept dept) {
		deptDao.addDept(dept);
		System.out.println("��ӳɹ�");
	}

	@Override
	public void updateDept(Dept dept) {
		deptDao.updateDept(dept);
		System.out.println("�޸ĳɹ�");
		
	}

	@Override
	public void deleteDept(String dept) {
		deptDao.deleteDept(dept);
		System.out.println("ɾ���ɹ�");
		
	}


	/*@Override   dao��ûд�������
	public List<Emp> queryMgrs() {
		List<Emp> mgrs = deptDao.queryMgrs();
		return mgrs;
	}*/
	


}
