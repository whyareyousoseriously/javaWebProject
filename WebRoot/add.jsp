<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
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
  <font size='5' color='red'>单词共享平台添加界面（添加的单词将会提交给管理员审核，通过即可添加入平台</font>
  <%-- 添加单词的表单--%>
		 <form action="servlet3/addServlet" method="post">
			<p >
				<label>添加单词输入框: </label>
				<input name="word" value="" /> <br>
				<label>添加单词意思输入框:</label>
				<input name="meaning" value="" /> <br>
			</p>
			<p >
				<input type="submit" value="添加单词"  />
				 <input type="button" onclick="location.href='login_success.jsp'"  value="返回主界面" />
			</p>
			</form>
  </body>
</html>
