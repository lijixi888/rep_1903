package com.emp.service.impl;

import java.util.Set;

import javax.annotation.Resource;

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

}
