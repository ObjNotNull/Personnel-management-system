package com.chinasofti.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mybatis.DeptInfMapper;
import com.chinasofti.pojo.DeptInf;
import com.chinasofti.pojo.Page;
import com.chinasofti.service.IDeptInfService;
@Service
public class DeptInfServiceImpl implements IDeptInfService {
	@Autowired
	DeptInfMapper deptInfMapper;
	@Override
	public void deleteByPrimaryKey(String[] id) {
		
		for (int i = 0; i < id.length; i++) {
			deptInfMapper.deleteByPrimaryKey(Integer.parseInt(id[i]));
		}

	}

	@Override
	public void insert(DeptInf record) {
		deptInfMapper.insert(record);

	}

	@Override
	public void insertSelective(DeptInf record) {
		deptInfMapper.insertSelective(record);

	}

	@Override
	public DeptInf selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return deptInfMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateByPrimaryKeySelective(DeptInf record) {
		deptInfMapper.updateByPrimaryKeySelective(record);

	}

	@Override
	public void updateByPrimaryKey(DeptInf record) {
		deptInfMapper.updateByPrimaryKey(record);

	}

	@Override
	public List<DeptInf> getDepts(Page page,String dname) {
		// TODO Auto-generated method stub
		return deptInfMapper.getDepts(page, dname);
	}
	 public int getTotal(String dname){
		 return deptInfMapper.getTotal(dname);
	 }

	@Override
	public int getPages(String dname, int size) {
		int t = this.getTotal(dname);
		return t%size==0?t/size:t/size+1;
	}

}
