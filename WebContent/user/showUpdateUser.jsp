<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>人事管理系统——修改用户</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link href="../css/css.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="../js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
	<link href="../js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="../js/jquery-migrate-1.2.1.js"></script>
	<script src="../js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="../js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="../js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="../js/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
	<link href="../css/pager.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript">
	
function submit(){
		$("#status").val($("#sta").val());
    	/** 员工表单提交 */
		
			var username = $("#username");
			var status = $("#status");
			var loginname = $("#loginname");

			var msg = "";
			if ($.trim(username.val()) == ""){
				msg = "姓名不能为空！";
				username.focus();
			}else if ($.trim(loginname.val()) == ""){
				msg = "登录名不能为空！";
				loginname.focus();
			}else if($.trim(loginname.val()).length<6 || $.trim(loginname.val()).length>20){
				msg = "登录名需要大于6位小于20位！";
				loginname.focus();
			}
			if (msg != ""){
				$.ligerDialog.error(msg);
				return false;
			}else{
				return true;
			}
			//$("#userForm").submit();
	
}
		

	</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr><td height="10"></td></tr>
  <tr>
    <td width="15" height="32"><img src="../images/main_locleft.gif" width="15" height="32"></td>
	<td class="main_locbg font2"><img src="../images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：用户管理  &gt; 修改用户</td>
	<td width="15" height="32"><img src="../images/main_locright.gif" width="15" height="32"></td>
  </tr>
</table>
<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
  <tr valign="top">
    <td>
    	 
    	 	<!-- 隐藏表单，flag表示添加标记 -->
    	 	<form action="/project/user/updateUser.action" method="post">
			<input type="hidden" name="id" value="${user.id}">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tr><td class="font3 fftd">
		    	<table>
		    		<tr>
		    			<td class="font3 fftd">姓名：<input type="text" name="username" id="username" size="20"
		    			 value="${user.username}"/></td>
		    			<td class="font3 fftd">
		    				用户状态：<select name="status">
					    			<option value="0" <c:if test="${user.status==0}">selected</c:if> >全部</option>
									<option value="1" <c:if test="${user.status==1}">selected</c:if>>管理员</option>
									<option value="2" <c:if test="${user.status==2}">selected</c:if>>普通用户</option>
									</select>
							
							</td>
							
		    		</tr>
		    			
		    		<tr>
		    			<td class="font3 fftd">登录名：
		    			<input name="loginname" id="loginname" size="20" value="${user.loginname}"/>
		    		
		    			</td>
		    			
		    		</tr>
		    		
		    	</table>
		    	
		    </td></tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr><td align="left" class="fftd"><input type="submit" value="修改 ">&nbsp;&nbsp;<input type="reset" value="取消 "></td></tr>

	</td>
  </tr>
</table>
</form>
<div style="height:10px;"></div>
</body>
</html>