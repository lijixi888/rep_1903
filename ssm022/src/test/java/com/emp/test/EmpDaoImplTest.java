package com.emp.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emp.dao.EmpDao;
import com.emp.entity.Emp;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext.xml"})  
public class EmpDaoImplTest {
   
	//�ýӿ���������Ҫ��ʵ��������
	@Resource
	private EmpDao empDao;
/*	@Test
	public void testQueryAll() {
		//System.out.println(empDao);
		List<Emp> es = empDao.queryAll();
		for(Emp e:es){
			 System.out.println(e.getEname());
		}
	}
	
	@Test
	public void testQueryById(){
		   Emp e = empDao.queryEmpById("e001");
		   System.out.println(e);
	}
	
	@Test//ģ����ѯ
	public void testQueryLike(){
		   List<Emp> es = empDao.queryLikeByName("��");
		   for(Emp e:es){
			    System.out.println(e);
		   }
	}
	
	@Test//��������ҳ
	public void testQueryPage(){
		  List<Emp> es = empDao.queryByPage(2, 5);
		  for(Emp e:es){
			   System.out.println(e);
		  }
	}
	
	@Test//����������ҳ
	public void testQueryPageCondition(){
		    List<Emp> es = empDao.queryByPageCondition(1, 3, "");
		    for(Emp e:es){
		    	 System.out.println(e);
		    }
	}
	
	@Test
	public void testSaveEmp(){
		     //����Ա������
		   Emp e = new Emp();
		   e.setEmpno("e888");
		   e.setEname("������");
		   e.setEsex("��");
		   e.setEage(25);
		   e.setEsalary(20000F);
		   e.setDeptno("d001");
		   e.setMgrno("e001");
		   //��e���浽���ݿ���
		    empDao.saveEmp(e);
		    System.out.println("OK");
	}
	
	@Test//ɾ��
	public void testDelete(){
		  empDao.delete("e888");
		  System.out.println("OK");
	}
	
	@Test//�޸�
	public void testUpdate(){
		  Emp e = empDao.queryEmpById("e006");
		  System.out.println(e);
		  e.setEage(27);
		  e.setEsalary(12000F);
		  //���޸ĵ����ݸ��µ����ݿ���
		  empDao.update(e);
		  //��������ٲ�ѯ
		  e = empDao.queryEmpById("e006");
		  System.out.println(e);
	}
	
	@Test
	public void testDaoSupport(){
		List<Emp> es = empDao.queryAll();
		for(Emp e:es){
			 System.out.println(e);
		}
	}*/

}
