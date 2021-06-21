package com.chinasofti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mybatis.DocumentInfMapper;
import com.chinasofti.pojo.DocumentInf;
import com.chinasofti.pojo.Page;
import com.chinasofti.service.IDocumentInfService;
@Service	
public class DocumentInfServiceImpl implements IDocumentInfService{
	@Autowired
	DocumentInfMapper documentInfMapper;
	@Override
	public int insert(DocumentInf record) {
		documentInfMapper.insert(record);
		return 0;
	}

	@Override
	public int insertSelective(DocumentInf record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DocumentInf> getDocs(String title, Page page) {
		// TODO Auto-generated method stub
		return documentInfMapper.getDocs(title, page);
	}

}
