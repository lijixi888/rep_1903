package com.emp.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emp.dao.EmpDao;
import com.emp.dao.EmplazyDao;
import com.emp.entity.Dept;
import com.emp.entity.Emp;
import com.emp.service.EmpService;


@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext.xml"}) 
public class EmpDaoTest {
	@Resource
private EmpDao empDao;
	@Resource
private EmpService empService;
	
	@Test
	public void testQueryAll() {
		List<Emp> emps = empDao.queryAll();
		for(Emp e:emps){
			System.out.println(e);
			//System.out.println(e.getEmpno()+","+e.getEname()+","+e.getDept().getDname()+","+e.getMgr().getEname());
		}
	}
	//根据员工编号查询部下所有员工
	@Test
	public void testselectBu(){
		List<Emp> ee = empDao.selectBu("d002");
		for(Emp s:ee){
		//System.out.println(s);
		}
	}
	@Test
	public void testQueryById(){
		Emp e = empDao.queryById("e001");
		//System.out.println(e);
		
	}
	@Test
	public void testQueryLike(){
		List<Emp> es = empDao.queryListName("张");
		for(Emp e:es){
			//System.out.println(e);
		}
	}
	//添加员工
	@Test
	public void testAddEmp(){
		Emp e=new Emp();
		e.setEmpno("e066");
		e.setEname("张佳");
		e.setEsex("男");
		e.setEage(33);
		e.setEsalary(23000f);
		
		//创建一个部门对象
		Dept dept=new Dept();
		dept.setDeptno("d001");
		e.setDept(dept);
		//创建一个经理对象
		Emp mgr=new Emp();
		mgr.setEmpno("e001");
		e.setMgr(mgr);
		//将经理对象保存到数据库中
		empDao.addEmp(e);
		System.out.println("OK");
		
	}
	
	//删除
	@Test
	public void testDelete(){
		empDao.deleteEmp("e066");
		System.out.println("OK");
	}
	//修改
	@Test
	public void testUpdate(){
		Emp e = empDao.queryById("05c98934-0ee7-483f-b37a-fdfd74b830a0");
		
		e.setEsalary(15000f);
		e.getDept().setDeptno("d002");
		e.getMgr().setEmpno("e004");
		//将修改的数据更新到数据库中
		empDao.updateEmp(e);
		System.out.println("OK");
		
	}
	@Test
	public void testQueryMgr(){
		List<Emp> mgrs = empService.queryMgrs();
		for(Emp e:mgrs){
			System.out.println(e.getEmpno()+","+e.getEname());
		}
	}
	
	//懒汉加载
	@Resource
	private EmplazyDao emplazyDao;
 @Test
	public void testLazy(){
		Emp e = emplazyDao.queryById("e004");
		/*System.out.println(e.getEname());
		System.out.println("------------------");
		System.out.println(e.getDept().getDname());*/
		//System.out.println(e);
	}
 @Test
	public void testLazy2(){
		List<Emp> es = emplazyDao.queryAll();
		for(Emp e:es){
			/*if(e.getDept()!=null)
			System.out.println(e.getEname()+","+e.getDept().getDname());*/
		}
	}
 //模糊查询
 @Test
	public void testLazy3(){
		 List<Emp> list = emplazyDao.queryListName("张");
		 for(Emp l:list){
			// System.out.println(l.getEname());
		 }
		
		}
 
 @Test
	public void testLazy4(){
	 		Emp emp = empService.queryEmpById("e003");
			 System.out.println(emp.getEname()+","+emp.getMgr().getEmpno()+","+emp.getMgr().getEname());
		
		}
 
	
}
