package com.emp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.emp.dao.EmpDao;
import com.emp.entity.Emp;
import com.emp.service.EmpService;
import com.emp.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class EmpServiceImpl implements EmpService{
//注入员工Dao
	@Resource
	private EmpDao empDao;
	//分页查询   配置分页助手
	public PageBean<Emp> queryBypage(Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		List<Emp> list = empDao.queryAll();
		PageInfo<Emp> pageInfo = new PageInfo<Emp>(list);
		//创建一个PageBean对象
		PageBean<Emp> pageBean=new PageBean<Emp>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int)(pageInfo.getTotal()));
		return pageBean;
	}

	@Override//条件分页
	public PageBean<Emp> queryByCondition(Integer pageNo, Integer pageSize, String ename) {
		PageHelper.startPage(pageNo,pageSize);
		List<Emp> list = empDao.queryListName(ename);
		PageInfo<Emp> pageInfo = new PageInfo<Emp>(list);
		//创建一个PageBean对象
		PageBean<Emp> pageBean=new PageBean<Emp>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int)(pageInfo.getTotal()));
		return pageBean;
	}

	@Override//依据编号查询员工
	public Emp queryEmpById(@PathVariable("empno")String empno) {
		Emp emp = empDao.queryById(empno);
		return emp;
	}

	@Override//添加员工
	public void addEmp(Emp emp) {
		empDao.addEmp(emp);
		System.out.println("添加成功");
		
	}

	@Override//修改员工
	public void updateEmp(Emp emp) {
		empDao.updateEmp(emp);
		System.out.println("更新成功");
		
	}

	@Override//删除员工
	public void deleteEmp(String empno) {
		empDao.deleteEmp(empno);
		System.out.println("删除成功");
	}

	@Override
	public List<Emp> queryMgrs() {
		List<Emp> mgrs = empDao.queryMgrs();
		return mgrs;
	}

}
