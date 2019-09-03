package com.emp.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.emp.entity.User;

public interface UserDao {
	//通过用户名查找用户
	  //登录用的
	@Select("select id,username,password,role_id from s_user where username=#{username}")
	@Results(id="userMapper",value={
			@Result(id=true,column="id",property="id"),
			@Result(column="username",property="username"),
			@Result(column="password",property="password"),
			@Result(column="role_id",property="role_id")
	})
	public User getByUserName(@Param("username")String username);
	//通过用户名查找该用户所有的角色
	  //返回值类型是Shiro框架定义的,所以用的set
	@Select("select r.rolename from s_user u inner join s_role r on u.role_id=r.id where u.username=#{username}")
	public Set<String> getRoles(@Param("username")String username);
	//通过用户名查找该用户所有的权限
	@Select("select p.permission_name "
			+ "from s_user u inner join s_role r on u.role_id=r.id "
			+ "inner JOIN s_permission p ON r.id=p.role_id where u.username=#{username}")
	public Set<String> getPermissions(@Param("username")String username);

}
