package com.emp.service;


import java.util.Set;

import com.emp.entity.User;

public interface UserService {
	//通过用户名查找用户
	public User getByUserName(String username);
	//通过用户名查找该用户所有的角色
	public Set<String> getRoles(String username);
	//通过用户名查找该用户所有的权限
	public Set<String> getPermissions(String username);
}
