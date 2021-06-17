package com.chinasofti.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasofti.pojo.Page;
import com.chinasofti.pojo.UserInf;
import com.chinasofti.service.IUserInfService;

@Controller
@RequestMapping("/user")
public class UserInfAction {
	
	@Autowired
	private IUserInfService userInfService;
	
	@RequestMapping("selectUserInf.action")
	public String selectUserInf(Page page,String username,int status,Model model,HttpSession session){
		
		List<UserInf> users=userInfService.getUsers(username, status, page);
		int count=userInfService.getTotal(username, status);
		int total=userInfService.getPages(username, status, page.getSize());
		page.setTotal(total);
		session.setAttribute("page", page);
		model.addAttribute("users", users);
		model.addAttribute("uname", username);
		model.addAttribute("status", status);
		model.addAttribute("count", count);
		return "/user/user";
	}
	
	
	@RequestMapping("addUser.action")
	public String addUser(UserInf user){
		userInfService.insert(user);
		return "redirect:/user/selectUserInf.action?cur=1&status=0";
	}
	
	
	@RequestMapping("toUpdateUser.action")
	public String toUpdateUser(int id,Model model){
		UserInf user=userInfService.selectByPrimaryKey(id);
		model.addAttribute("user", user);
		return "/user/showUpdateUser";
		
	}
	
	
	@RequestMapping("updateUser.action")
	public String updateUser(UserInf user,HttpSession session){
		userInfService.updateByPrimaryKey(user);
		Page page=(Page)session.getAttribute("page");
		return "redirect:/user/selectUserInf.action?cur="+page.getCur()+"&status=0";
	}
	
	
	@RequestMapping("removeUser.action")
	public String removeUser(String ids, HttpSession session){
		
		userInfService.deleteByPrimaryKey(ids);
		Page page = (Page)session.getAttribute("page");
		return "redirect:/user/selectUserInf.action?cur="+page.getCur()+"&status=0";
		
	}
}