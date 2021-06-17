package com.chinasofti.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chinasofti.pojo.DeptInf;
import com.chinasofti.pojo.Page;

public interface IDeptInfService {
	  void deleteByPrimaryKey(String[] id);

	   void insert(DeptInf record);

	 
	    void insertSelective(DeptInf record);

	   
	    DeptInf selectByPrimaryKey(Integer id);

	   
	    void updateByPrimaryKeySelective(DeptInf record);

	    void  updateByPrimaryKey(DeptInf record);
	    List<DeptInf> getDepts(Page page,String dname);
	    int getTotal(String dname);
	    int getPages(String dname,int size);
}
