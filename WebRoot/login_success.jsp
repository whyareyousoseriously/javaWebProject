<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login_success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  <body>
	<div>
		<font size='5' color='red'>单词共享平台主界面</font>
		<div>
		  <% 
		     String loginUser = "";
		     if(session.getAttribute("loginUser")!=null)
		     {
		        loginUser = session.getAttribute("loginUser").toString();
		     }    
		  %>
		     欢迎您<font color="red"><%=loginUser%></font>,登录成功！
		     <input type="button" onclick="location.href='search.jsp'"  value="查询界面" />
		     <input type="button" onclick="location.href='add.jsp'"  value="添加界面" />
		     <input type="button" onclick="location.href='login.jsp'"  value="返回登录界面" />
		</div>
	</div>
	</body>
</html>
