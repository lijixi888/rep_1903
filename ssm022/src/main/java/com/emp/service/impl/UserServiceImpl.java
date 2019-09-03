package com.emp.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

import com.emp.dao.UserDao;
import com.emp.entity.User;

import com.emp.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;

	@Override
	public User getByUserName(String username) {
		// TODO Auto-generated method stub
		User user = userDao.getByUserName(username);
		return user;
	}

	@Override
	public Set<String> getRoles(String username) {
		// TODO Auto-generated method stub
		Set<String> roles = userDao.getRoles(username);
		return roles;
	}

	@Override
	public Set<String> getPermissions(String username) {
		// TODO Auto-generated method stub
		Set<String> pers = userDao.getPermissions(username);
		return pers;
	}

	@Override
	public void addUser(User user) {
		//加盐,加密的效果
		//MD5(加密方法)
		//加密密码
		String password   //算法, 需要加密的密码    盐   加密的次数
		= new SimpleHash("MD5", user.getPassword(), user.getUsername(), 1024).toString();
		//password就是加密后的密码
		//用户加密后的密码置换原来从页面传来的密码
		user.setPassword(password);
		//将user保存到数据库
		userDao.save(user);
		
	}

	@Override
	public Set<String> getrolename() {
		// TODO Auto-generated method stub
		Set<String> set = userDao.getrolename();
		return set;
	}

}
