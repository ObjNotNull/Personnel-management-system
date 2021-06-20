package com.chinasofti.service;

import java.util.List;

import com.chinasofti.pojo.Page;
import com.chinasofti.pojo.UserInf;

public interface IUserInfService {
	
	void deleteByPrimaryKey(String ids);
    List<UserInf> getUsers(String username, int status,Page page);
    int getPages(String username,int status,int size);
    
    
    int getTotal(String username, int status);

  
    void insert(UserInf record);

    
    void insertSelective(UserInf record);

    
    UserInf selectByPrimaryKey(Integer id);

    
    void updateByPrimaryKeySelective(UserInf record);

    
    void updateByPrimaryKey(UserInf record);
    
    
    // 用户登录 注销 修改密码
    UserInf login(UserInf user);
    void updatePassword(String newpassword,int id);
}
