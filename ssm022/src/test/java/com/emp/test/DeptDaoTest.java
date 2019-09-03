package com.emp.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emp.dao.DeptDao;
import com.emp.dao.DeptLazyDao;
import com.emp.entity.Dept;
import com.emp.entity.Emp;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext.xml"}) 
public class DeptDaoTest {
@Resource
private DeptDao deptDao;
@Resource
private DeptLazyDao deptLazyDao;
	@Test
	public void test() {
		List<Dept> list = deptDao.selectAll();
		for(Dept e:list){
			System.out.println(e);
		}
	}
	
	@Test
	public void testId() {
		Dept dd = deptDao.selectId("d001");
		System.out.println(dd);
		
	}
	//增加
	@Test
	public void addDept(){
		Dept dd=new Dept();
		dd.setDeptno("d005");
		dd.setDname("服务部");
		dd.setLocation("日本");
		deptDao.addDept(dd);
		System.out.println("OK");
	}
	
	
	@Test
	public void update(){
		Dept id = deptDao.selectId("d005");
		id.setDname("东京部");
		deptDao.updateDept(id);
		System.out.println("Ok");
	}
	
	@Test
	public void delete(){
		deptDao.deleteDept("d005");
	
		System.out.println("Ok");
	}
	@Test
	public void testQueryall(){
		List<Dept> depts = deptLazyDao.queryAll();
		for(Dept d:depts){
			//System.out.println(d.getDname());
			System.out.println("--------------");
			//打印部下所有员工
			/*List<Emp> es=d.getEmps();
			for(Emp e:es){
				System.out.println(e.getEname());
			}*/
		}
	
		System.out.println("Ok");
	}
  
	@Test
	public void testQueryById(){
		Dept dept = deptLazyDao.queryById("d001");
		//System.out.println(dept.getDname());
		List<Emp> es=dept.getEmps();
		for(Emp e:es){
			//System.out.println(e.getEname());
		}
	}
}
