package com.chinasofti.action;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.pojo.Page;
import com.chinasofti.pojo.UserInf;
import com.chinasofti.service.IUserInfService;
import com.chinasofti.utils.MD5;

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
	
	
	/*
	 * @responseBodyע��������ǽ�controller�ķ������صĶ���ͨ���ʵ���ת����ת��Ϊָ���ĸ�ʽ֮��
	 * д�뵽response�����body����ͨ����������JSON���ݻ�����XML���ݡ�
ע�⣺��ʹ�ô�ע��֮�󲻻�������ͼ������������ֱ�ӽ�����д�뵽�������У�����Ч����ͬ��ͨ��response�������ָ����ʽ�����ݡ�
��������������������������������
��Ȩ����������ΪCSDN������originations����ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/originations/article/details/89492884
	 */
	@RequestMapping("ajaxlogin.action")
	public @ResponseBody String removeUser(UserInf user,HttpSession session){
		
		UserInf us = userInfService.login(user);
		if (us != null) {
			session.setAttribute("user", us);
			return "sec";
		} else {
			return "";
		}
		
	}
	
	@RequestMapping("editPassword.action")
	public @ResponseBody String editPassword(String oldPassword, String newPassword, HttpSession session){
		
		UserInf user=(UserInf)session.getAttribute("user");
		MD5 m=new MD5();
		if(user.getPassword().equals(m.getMD5ofStr(oldPassword))){
			//ҵ����޸ĵķ���
			userInfService.updatePassword(m.getMD5ofStr(newPassword),user.getId());
			return "sec";
		}else{
			return "fail";
		}
		
		
		
	}
	
}