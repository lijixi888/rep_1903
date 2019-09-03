package com.emp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.emp.entity.Dept;
import com.emp.entity.Emp;
import com.emp.service.DeptService;
import com.emp.service.EmpService;
import com.emp.utils.PageBean;
@Controller
public class EmpController {
	@Resource
	private EmpService empService;
	@Resource
	private DeptService deptService;
	
	//��������
		public void loadData(HttpSession session){
			//���������Ա�radio��map
			Map<String,String> map = new HashMap<String,String>();
			map.put("��", "��");
			map.put("Ů", "Ů");
			//���������б���
			session.setAttribute("map", map);
			//���ɲ�������
			List<Dept> depts = deptService.queryAll();
			session.setAttribute("depts", depts);
			//���ɾ�������
			List<Emp> mgrs = empService.queryMgrs();
			session.setAttribute("mgrs", mgrs);
			
			
		}
		
	@RequestMapping("/emp/list")
   public String queryByPage(@RequestParam(value="pageNo",required=false,defaultValue="1")Integer pageNo,
		   @RequestParam(value="pageSize",required=false,defaultValue="3")Integer pageSize,
		   Model model){
	   PageBean<Emp> pageBean = empService.queryBypage(pageNo, pageSize);
	   model.addAttribute("pageBean", pageBean);
	   return "ListEmp";
   }
	@RequestMapping("/emp/conditionList")
	public String queryCondition(@RequestParam(value="pageNo",required=false,defaultValue="1")Integer pageNo,
			@RequestParam(value="pageSize",required=false,defaultValue="3")Integer pageSize,
			@RequestParam(value="cd",required=false,defaultValue="")String cd,
			Model model,HttpSession session){
		PageBean<Emp> pageBean = empService.queryByCondition(pageNo, pageSize, cd);
		//model.addAttribute("pageBean", pageBean);
		//model.addAttribute("cd", cd);
		session.setAttribute("pageBean", pageBean);
		session.setAttribute("cd", cd);
		return "ListEmp";
	}
	
	//��ת����Ա��ҳ��
		@RequestMapping("/emp/toAdd")
		public String toAddEmp(@ModelAttribute("emp") Emp emp,
				 HttpSession session){
			loadData(session);
			return "AddEmp";
		}
		//���Ա��
		@RequestMapping(value="/emp/add",method=RequestMethod.POST)
		public String addEmp(Emp emp){
			String empno = UUID.randomUUID().toString();
			emp.setEmpno(empno);
			empService.addEmp(emp);		
			return "redirect:/emp/conditionList";
		}
		
		//��ת���޸�ҳ��
		@RequestMapping("/emp/toUpdate")
		public String toUpdateEmp(@ModelAttribute("emp") Emp emp,
				@RequestParam("empno")String empno,
				 Model model,HttpSession session){
			System.out.println("toUpdate");
			//��Ҫ�Ա����ݣ���loadDataһ��
			loadData(session);//�����Ա𣬾�����������
		     emp = empService.queryEmpById(empno);
			model.addAttribute("emp", emp);		 
			return "UpdateEmp";
		}
			
		//�޸�Ա��
		@RequestMapping(value="/emp/update",method=RequestMethod.PUT)
		public String updateEmp(Emp emp,HttpSession session){
			 empService.updateEmp(emp);
			 PageBean<Emp> pageBean = (PageBean<Emp>)session.getAttribute("pageBean");
			 String cd = (String)session.getAttribute("cd");
			 pageBean = empService.queryByCondition(pageBean.getPageNo(),pageBean.getPageSize(),cd );
			 session.setAttribute("pageBean", pageBean);
			 return "redirect:/emp/conditionList";
		}
		
		//ɾ��Ա��
		@RequestMapping("/emp/delete")
		public String delete(@RequestParam("empno") String empno){
			   empService.deleteEmp(empno);
			   return "redirect:/emp/conditionList";
		}
}
