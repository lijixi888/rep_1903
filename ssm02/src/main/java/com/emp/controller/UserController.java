package com.emp.controller;

import javax.annotation.Resource;



import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emp.entity.User;
import com.emp.service.UserService;

@Controller
public class UserController {
	
	@Resource
    private UserService userService;
	
	//跳转到登录页面
	@RequestMapping("/user/toLogin")
	public String index() {
		return "Login";
	
	}
	@RequestMapping("user/login")//接收过来的用户名和密码放到user里面去
	public String login(User user,Model model){
		//获取当前用户   Subject 主体 调用"/user/login"请求的东西(用户,程序)
		Subject subject = SecurityUtils.getSubject();//Shiro提供的方法
		//创建一个令牌对象
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(), user.getPassword());
		try{
			//为当前用户进行认证，授权
			subject.login(token);
			
			//request.setAttribute("user", user);//要展示用户名才用这个
			//重定向到主页员工列表
			return "redirect:/emp/conditionList";
			
		}catch(Exception e){
			e.printStackTrace();
			//request.setAttribute("user", user);
			model.addAttribute("msg", "用户名或密码错误！");
			return "Login";
		}
	}
	
	
}
