package com.chinasofti.service.impl;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chinasofti.pojo.DeptInf;
import com.chinasofti.pojo.Page;

public class DeptInfServiceImplTest {
	BeanFactory bean=new ClassPathXmlApplicationContext("spring.xml");
	DeptInfServiceImpl ds=(DeptInfServiceImpl)bean.getBean("deptInfServiceImpl");
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
	public void testInsert() {
		DeptInf d=new DeptInf("aa","aa");
		ds.insert(d);
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

	@Test
	public void testGetDepts() {
		Page page=new Page();
		page.setCur(1);
		List<DeptInf> depts=ds.getDepts(page,"");
		System.out.println(depts);
	}
	@Test
	public void testTotal() {
		
		System.out.println(ds.getTotal("²¿"));
	}

}
