package com.chinasofti.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.chinasofti.pojo.DocumentInf;
import com.chinasofti.pojo.Page;
import com.chinasofti.pojo.UserInf;
import com.chinasofti.service.IDocumentInfService;

@Controller
@RequestMapping("/document")
public class DocumentInfAction {
	@Autowired
	IDocumentInfService documentInfService;
	
	@RequestMapping("insertDoc.action")
	public String insertDoc(@RequestParam MultipartFile file,DocumentInf doc,HttpSession  session){
		if(file!=null&&!file.isEmpty()){
			try {
				byte[] bt=file.getBytes();
				//�ļ�������
				String name=file.getOriginalFilename();
				System.out.println(name);
				doc.setFilename(name);//file��name
				doc.setCreateDate(new Date());//����
				UserInf user=(UserInf)session.getAttribute("user");
				doc.setUserId(user.getId());//Userid
				documentInfService.insert(doc);
				OutputStream out=new FileOutputStream("d:\\file\\"+name);
				out.write(bt);
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		return "";
	}
	
	
	@RequestMapping("selectDocuments.action")
	public String selectDocuments(String title,Page page,HttpSession  session,Model model){
		List<DocumentInf> docs=documentInfService.getDocs(title, page);
		model.addAttribute("docs", docs);
		session.setAttribute("page", page);
		model.addAttribute("title", title);
		return "/document/document";
	}
	
	
	@RequestMapping("down.action")
	public ResponseEntity<byte[]> down(String filename) throws Exception{
		
		  HttpHeaders headers = new HttpHeaders(); //ͷ����Ϣ����
		  
		String path="d:\\file\\"+filename;
		System.out.println(path);
		File file=new File(path);
		String str=(UUID.randomUUID().toString());//������ַ���
		str=str.replace("-","");//��- �滻
		String s=filename.substring(filename.indexOf("."));//�ҵ��ļ����ֵĺ�׺
	     headers.setContentDispositionFormData("attachment", str.concat(s));//���Զ���   str.concat(s)������ַ����ͺ�׺ƴ��
	     headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   //ͷ�ļ���������
	     
	     return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
	                                       headers, HttpStatus.OK);
	     
	}
	
	
}
