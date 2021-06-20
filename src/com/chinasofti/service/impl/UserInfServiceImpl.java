package com.chinasofti.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mybatis.UserInfMapper;
import com.chinasofti.pojo.Page;
import com.chinasofti.pojo.UserInf;
import com.chinasofti.service.IUserInfService;
import com.chinasofti.utils.MD5;

@Service
public class UserInfServiceImpl implements IUserInfService {

	@Autowired
	private UserInfMapper userInfMapper;
	@Override
	public void deleteByPrimaryKey(String ids) {
		
		String[] st = ids.split(",");
		for (int i = 0; i < st.length; i++) {
			userInfMapper.deleteByPrimaryKey(Integer.parseInt(st[i]));
		}
	}

	@Override
	public List<UserInf> getUsers(String username, int status, Page page) {
		// TODO Auto-generated method stub
		return userInfMapper.getUsers(username, status, page);
	}

	@Override
	public int getTotal(String username, int status) {
		// TODO Auto-generated method stub
		return userInfMapper.getTotal(username, status);
	}

	@Override
	public void insert(UserInf record) {
		record.setCreatedate(new Date());
		MD5 m = new MD5();
		record.setPassword(m.getMD5ofStr(record.getPassword()));
		userInfMapper.insert(record);
	}

	@Override
	public void insertSelective(UserInf record) {
		userInfMapper.insertSelective(record);
		
	}

	@Override
	public UserInf selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userInfMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateByPrimaryKeySelective(UserInf record) {
		// TODO Auto-generated method stub
		userInfMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void updateByPrimaryKey(UserInf record) {
		// TODO Auto-generated method stub
		userInfMapper.updateByPrimaryKey(record);
	}

	/**
	 * 一共有多少页
	 */
	@Override
	public int getPages(String username, int status, int size) {
		int t=this.getTotal(username, status);
		return t%size==0?t/size:t/size+1;
	}

	
	// 用户登录 210619
	@Override
	public UserInf login(UserInf user) {
		// TODO Auto-generated method stub
		MD5 m = new MD5();
		user.setPassword(m.getMD5ofStr(user.getPassword()));
		return userInfMapper.login(user);
	}
	
	@Override
	public void updatePassword(String newpassword, int id) {
		// TODO Auto-generated method stub
		userInfMapper.updatePassword(newpassword, id);
	}

}
