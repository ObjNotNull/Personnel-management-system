<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>人事管理系统——修改部门</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link href="/project/css/css.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="/project/js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
	<link href="/project/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="/project/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="/project/js/jquery-migrate-1.2.1.js"></script>
	<script src="/project/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="/project/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="/project/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="/project/js/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
	<link href="/project/css/pager.css" type="text/css" rel="stylesheet" />
	
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr><td height="10"></td></tr>
  <tr>
    <td width="15" height="32"><img src="/project/images/main_locleft.gif" width="15" height="32"></td>
	<td class="main_locbg font2"><img src="/project/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：部门管理  &gt; 修改部门</td>
	<td width="15" height="32"><img src="/project/images/main_locright.gif" width="15" height="32"></td>
  </tr>
</table>
<form id="deptForm" action="/project/updateDept.action">
<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
  <tr valign="top">
    <td>
    	 
    	 	
    	 	<input type="hidden" name="id" value="${dept.id}">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tr><td class="font3 fftd">
		    	<table>
		    		<tr>
		    			<td class="font3 fftd">部门名称：<input type="text" name="name" id="name" size="20" value="${dept.name}"/></td>
		    			<td class="font3 fftd">详细描述：<input type="text" name="remark" id="remark" size="20" value="${dept.remark}"/></td>
		    		</tr>
		    			
		    	</table>
		    </td></tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr><td align="left" class="fftd"><input type="submit"  value="修改">&nbsp;&nbsp;<input type="reset" value="取消 "></td></tr>
		  </table>
		
	</td>
  </tr>
</table>
</form>
<div style="height:10px;"></div>
<script type="text/javascript">
	$(function(){
		$("#deptForm").submit(function(){
			var name = $("#name");
			var remark = $("#remark");
			var msg = "";
			if ($.trim(name.val()) == ""){
				msg = "部门名称不能为空！";
				name.focus();
			}else if ($.trim(remark.val()) == ""){
				msg = "详细描述不能为空！";
				remark.focus();
			}
			if (msg != ""){
				$.ligerDialog.error(msg);
				return false;
			}else{
				return true;
			}
		
		});
	});
	    

	</script>
</body>
</html>