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
//ע��Ա��Dao
	@Resource
	private EmpDao empDao;
	//��ҳ��ѯ   ���÷�ҳ����
	public PageBean<Emp> queryBypage(Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		List<Emp> list = empDao.queryAll();
		PageInfo<Emp> pageInfo = new PageInfo<Emp>(list);
		//����һ��PageBean����
		PageBean<Emp> pageBean=new PageBean<Emp>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int)(pageInfo.getTotal()));
		return pageBean;
	}

	@Override//������ҳ
	public PageBean<Emp> queryByCondition(Integer pageNo, Integer pageSize, String ename) {
		PageHelper.startPage(pageNo,pageSize);
		List<Emp> list = empDao.queryListName(ename);
		PageInfo<Emp> pageInfo = new PageInfo<Emp>(list);
		//����һ��PageBean����
		PageBean<Emp> pageBean=new PageBean<Emp>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int)(pageInfo.getTotal()));
		return pageBean;
	}

	@Override//���ݱ�Ų�ѯԱ��
	public Emp queryEmpById(@PathVariable("empno")String empno) {
		Emp emp = empDao.queryById(empno);
		return emp;
	}

	@Override//���Ա��
	public void addEmp(Emp emp) {
		empDao.addEmp(emp);
		System.out.println("��ӳɹ�");
		
	}

	@Override//�޸�Ա��
	public void updateEmp(Emp emp) {
		empDao.updateEmp(emp);
		System.out.println("���³ɹ�");
		
	}

	@Override//ɾ��Ա��
	public void deleteEmp(String empno) {
		empDao.deleteEmp(empno);
		System.out.println("ɾ���ɹ�");
	}

	@Override
	public List<Emp> queryMgrs() {
		List<Emp> mgrs = empDao.queryMgrs();
		return mgrs;
	}

}
