package com.emp.controller;

import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emp.entity.User;
import com.emp.service.UserService;

@Controller
public class UserController {
	//注入业务层对象
	@Resource
    private UserService userService;
	
	/*//加载数据
	public void loadData(HttpSession session){
		Set<String> getrolename = userService.getrolename();
		session.setAttribute("role", getrolename);
	}*/
	
	//跳转到未授权页面
	@RequestMapping("/user/Unauthorized")
	public String toUnauthorized() {
		return "Unauthorized";
	
	}
	
	//注册用户
	@RequestMapping("/user/register")
	public String register(User user) {
		userService.addUser(user);
		//重定向到登录页面
		return "redirect:/user/toLogin";
	
	}
	//跳转到注册页面
	@RequestMapping("/user/toRegister")
	public String toRegister() {
		//loadData(session);
		return "Register";
	
	}
	
	//跳转到登录页面
		@RequestMapping("/user/toLogin")
		public String index() {
			return "Login";
		
		}
	@RequestMapping("user/login")//接收过来的用户名和密码放到user里面去
	public String login(User user,
			@RequestParam(value="rememberMe", defaultValue="0")Integer rememberMe,Model model){
		//获取当前用户   Subject 主体 调用"/user/login"请求的东西(用户,程序)
		Subject subject = SecurityUtils.getSubject();//Shiro提供的方法
		//创建一个令牌对象
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(), user.getPassword());
		try{
			//判断是否使用记住我
			if(rememberMe==1){
				//使用记住我功能
				token.setRememberMe(true);
			}
			
			//为当前用户进行认证，授权
			subject.login(token);
			//subject.logout();  登出
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
