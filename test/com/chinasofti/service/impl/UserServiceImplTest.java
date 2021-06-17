package com.chinasofti.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chinasofti.pojo.Page;
import com.chinasofti.pojo.UserInf;

public class UserServiceImplTest {

	BeanFactory bean = new ClassPathXmlApplicationContext("spring.xml");
	UserInfServiceImpl ds = (UserInfServiceImpl)bean.getBean("userInfServiceImpl");
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeleteByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUsers() {
		Page page=new Page();
		page.setCur(1);
		List<UserInf> users=ds.getUsers("", 0, page);
		for (UserInf userInf : users) {
			System.out.println(userInf);
		}
//		System.out.println(users);
	}

	@Test
	public void testGetTotal() {
		int t=ds.getTotal("g", 0);
		System.out.println(t);
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		fail("Not yet implemented");
	}

}
