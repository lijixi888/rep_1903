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
	//����Ա����Ų�ѯ��������Ա��
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
		List<Emp> es = empDao.queryListName("��");
		for(Emp e:es){
			//System.out.println(e);
		}
	}
	//���Ա��
	@Test
	public void testAddEmp(){
		Emp e=new Emp();
		e.setEmpno("e066");
		e.setEname("�ż�");
		e.setEsex("��");
		e.setEage(33);
		e.setEsalary(23000f);
		
		//����һ�����Ŷ���
		Dept dept=new Dept();
		dept.setDeptno("d001");
		e.setDept(dept);
		//����һ���������
		Emp mgr=new Emp();
		mgr.setEmpno("e001");
		e.setMgr(mgr);
		//��������󱣴浽���ݿ���
		empDao.addEmp(e);
		System.out.println("OK");
		
	}
	
	//ɾ��
	@Test
	public void testDelete(){
		empDao.deleteEmp("e066");
		System.out.println("OK");
	}
	//�޸�
	@Test
	public void testUpdate(){
		Emp e = empDao.queryById("05c98934-0ee7-483f-b37a-fdfd74b830a0");
		
		e.setEsalary(15000f);
		e.getDept().setDeptno("d002");
		e.getMgr().setEmpno("e004");
		//���޸ĵ����ݸ��µ����ݿ���
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
	
	//��������
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
 //ģ����ѯ
 @Test
	public void testLazy3(){
		 List<Emp> list = emplazyDao.queryListName("��");
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
