<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<div >
		<div >
			<font size='5' color='red'>单词共享平台登录界面</font>
			<font size='3' color='red'>简介:单词共享平台提供查询功能和向共享平台单词库中添加单词的功能</font>
			<form action="servlet/LoginServlet" method="post">
			<p >
				<label>用户: </label>
				<input name="username" value="" /> <br>
				<label>密码: </label>
				<input type="password" name="password" value="">	
			</p>
			<p >
				<input type="submit" value="登录"  />
				<input type="button" onclick="location.href='register.jsp'"  value="注册" />
			</p>
			</form>
		</div>
	</div>
	</body>
</html>
