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
   
	//用接口声明，不要是实现类声明
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
	
	@Test//模糊查询
	public void testQueryLike(){
		   List<Emp> es = empDao.queryLikeByName("熊");
		   for(Emp e:es){
			    System.out.println(e);
		   }
	}
	
	@Test//无条件分页
	public void testQueryPage(){
		  List<Emp> es = empDao.queryByPage(2, 5);
		  for(Emp e:es){
			   System.out.println(e);
		  }
	}
	
	@Test//测试条件分页
	public void testQueryPageCondition(){
		    List<Emp> es = empDao.queryByPageCondition(1, 3, "");
		    for(Emp e:es){
		    	 System.out.println(e);
		    }
	}
	
	@Test
	public void testSaveEmp(){
		     //创建员工对象
		   Emp e = new Emp();
		   e.setEmpno("e888");
		   e.setEname("李世民");
		   e.setEsex("男");
		   e.setEage(25);
		   e.setEsalary(20000F);
		   e.setDeptno("d001");
		   e.setMgrno("e001");
		   //将e保存到数据库中
		    empDao.saveEmp(e);
		    System.out.println("OK");
	}
	
	@Test//删除
	public void testDelete(){
		  empDao.delete("e888");
		  System.out.println("OK");
	}
	
	@Test//修改
	public void testUpdate(){
		  Emp e = empDao.queryEmpById("e006");
		  System.out.println(e);
		  e.setEage(27);
		  e.setEsalary(12000F);
		  //将修改的数据更新到数据库中
		  empDao.update(e);
		  //更新完后再查询
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
