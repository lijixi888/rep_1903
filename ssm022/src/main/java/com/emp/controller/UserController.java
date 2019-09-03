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
	//ע��ҵ������
	@Resource
    private UserService userService;
	
	/*//��������
	public void loadData(HttpSession session){
		Set<String> getrolename = userService.getrolename();
		session.setAttribute("role", getrolename);
	}*/
	
	//��ת��δ��Ȩҳ��
	@RequestMapping("/user/Unauthorized")
	public String toUnauthorized() {
		return "Unauthorized";
	
	}
	
	//ע���û�
	@RequestMapping("/user/register")
	public String register(User user) {
		userService.addUser(user);
		//�ض��򵽵�¼ҳ��
		return "redirect:/user/toLogin";
	
	}
	//��ת��ע��ҳ��
	@RequestMapping("/user/toRegister")
	public String toRegister() {
		//loadData(session);
		return "Register";
	
	}
	
	//��ת����¼ҳ��
		@RequestMapping("/user/toLogin")
		public String index() {
			return "Login";
		
		}
	@RequestMapping("user/login")//���չ������û���������ŵ�user����ȥ
	public String login(User user,
			@RequestParam(value="rememberMe", defaultValue="0")Integer rememberMe,Model model){
		//��ȡ��ǰ�û�   Subject ���� ����"/user/login"����Ķ���(�û�,����)
		Subject subject = SecurityUtils.getSubject();//Shiro�ṩ�ķ���
		//����һ�����ƶ���
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(), user.getPassword());
		try{
			//�ж��Ƿ�ʹ�ü�ס��
			if(rememberMe==1){
				//ʹ�ü�ס�ҹ���
				token.setRememberMe(true);
			}
			
			//Ϊ��ǰ�û�������֤����Ȩ
			subject.login(token);
			//subject.logout();  �ǳ�
			//request.setAttribute("user", user);//Ҫչʾ�û����������
			//�ض�����ҳԱ���б�
			return "redirect:/emp/conditionList";
			
		}catch(Exception e){
			e.printStackTrace();
			//request.setAttribute("user", user);
			model.addAttribute("msg", "�û������������");
			return "Login";
		}
	}
	
	
}
