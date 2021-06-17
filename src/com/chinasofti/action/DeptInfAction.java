package com.chinasofti.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasofti.pojo.DeptInf;
import com.chinasofti.pojo.Page;
import com.chinasofti.service.IDeptInfService;

@Controller
public class DeptInfAction {
	@Autowired
	private IDeptInfService deptInfService;
	
	@RequestMapping("selectDepts.action")
	public String selectDepts(Page page,Model model,String name,HttpSession session){
		List<DeptInf> depts=deptInfService.getDepts(page, name);
		int count=deptInfService.getTotal(name);
		int total=deptInfService.getPages(name, page.getSize());
		page.setTotal(total);
		model.addAttribute("depts", depts);//dept集合
		model.addAttribute("dname", name);//查询条件
		model.addAttribute("count", count);//总记录数
		session.setAttribute("page", page);
		return "/dept/dept";
	}
	@RequestMapping("toUpdateDept.action")
	public String toUpdateDept(int id,Model model){
		DeptInf dept=deptInfService.selectByPrimaryKey(id);
		model.addAttribute("dept", dept);
		return "/dept/showUpdateDept";
	}
	@RequestMapping("updateDept.action")
	public String updateDept(DeptInf dept,HttpSession session){
		deptInfService.updateByPrimaryKey(dept);
		//页面没有当前页，就从session范围内取
		Page page=(Page)session.getAttribute("page");
		
		return "redirect:/selectDepts.action?cur="+page.getCur();
	}
	@RequestMapping("removeDept.action")
	public String removeDept(String ids,HttpSession session){
		String[]st=ids.split(",");
		deptInfService.deleteByPrimaryKey(st);
		Page page=(Page)session.getAttribute("page");
		return "redirect:/selectDepts.action?cur="+page.getCur();
	}
	
	@RequestMapping("addDept.action")
	public String addDept(DeptInf dept, HttpSession session){
		deptInfService.insert(dept);
		Page page = (Page)session.getAttribute("page");
		return "redirect:/selectDepts.action?cur="+page.getTotal();
	}
}
