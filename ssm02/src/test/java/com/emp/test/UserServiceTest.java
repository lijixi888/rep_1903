package com.emp.test;

import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emp.entity.User;
import com.emp.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext.xml"}) 
public class UserServiceTest {
	@Resource
private UserService userService;
@Test
public void testQueryUser(){
	User user = userService.getByUserName("ls");
	System.out.println(user);
}
@Test
public void qq(){
	Set<String> roles = userService.getRoles("ls");
	System.out.println(roles);
}

@Test
public void pim(){
Set<String> permissions = userService.getPermissions("ls");
	System.out.println(permissions);
}


}
