<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>

  </head>
	<body>
	<div>
		<div>
		     登录失败！请检查用户或者密码!<br>
		  <a href="login.jsp">返回登录</a>   
		</div>
	</div>
	</body>
</html>