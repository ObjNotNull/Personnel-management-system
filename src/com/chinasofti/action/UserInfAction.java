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
	 * @responseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，
	 * 写入到response对象的body区，通常用来返回JSON数据或者是XML数据。
注意：在使用此注解之后不会再走视图处理器，而是直接将数据写入到输入流中，他的效果等同于通过response对象输出指定格式的数据。
————————————————
版权声明：本文为CSDN博主「originations」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/originations/article/details/89492884
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
			//业务层修改的方法
			userInfService.updatePassword(m.getMD5ofStr(newPassword),user.getId());
			return "sec";
		}else{
			return "fail";
		}
		
		
		
	}
	
}