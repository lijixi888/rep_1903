package com.emp.service;


import java.util.Set;

import com.emp.entity.User;

public interface UserService {
	//ͨ���û��������û�
	public User getByUserName(String username);
	//ͨ���û������Ҹ��û����еĽ�ɫ
	public Set<String> getRoles(String username);
	//ͨ���û������Ҹ��û����е�Ȩ��
	public Set<String> getPermissions(String username);
}
