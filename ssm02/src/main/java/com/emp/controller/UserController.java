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
	
	//��ת����¼ҳ��
	@RequestMapping("/user/toLogin")
	public String index() {
		return "Login";
	
	}
	@RequestMapping("user/login")//���չ������û���������ŵ�user����ȥ
	public String login(User user,Model model){
		//��ȡ��ǰ�û�   Subject ���� ����"/user/login"����Ķ���(�û�,����)
		Subject subject = SecurityUtils.getSubject();//Shiro�ṩ�ķ���
		//����һ�����ƶ���
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(), user.getPassword());
		try{
			//Ϊ��ǰ�û�������֤����Ȩ
			subject.login(token);
			
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
