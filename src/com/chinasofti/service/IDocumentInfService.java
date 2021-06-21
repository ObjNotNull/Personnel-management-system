package com.chinasofti.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chinasofti.pojo.DocumentInf;
import com.chinasofti.pojo.Page;

public interface IDocumentInfService {
	 int insert(DocumentInf record);

	    
	    int insertSelective(DocumentInf record);
	    List<DocumentInf> getDocs(@Param("title") String title,@Param("page") Page page);
}
