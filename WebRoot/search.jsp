<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'search.jsp' starting page</title>
    
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
  	<font size='5' color='red'>单词共享平台查询界面</font>
     <%-- 查询单词的表单--%>
		 <form action="servlet3/SearchServlet" method="post">
			<p >
				<label>查询单词输入框: </label>
				<input name="word" value="" /> <br>
				<%
				String meaning="";
		     	if(session.getAttribute("meaning")!=null){
		     	meaning=session.getAttribute("meaning").toString();
		    	}
		    	String word="";
		     	if(session.getAttribute("word")!=null){
		     	word=session.getAttribute("word").toString();
		    	}
		    	String mark="";
		     	if(session.getAttribute("mark")!=null){
		     	mark=session.getAttribute("mark").toString();
		    	}
				 %>
				 <label>是否查询成功:</label>
				 <font color='red'><%=mark %></font><br>
				 <label>所查询的单词:</label>
				 <font color='green'><%=word %></font><br>
				 <label>所查询的单词的意思:</label>
				 <font color='green'><%=meaning %></font><br>
			</p>
			<p >
				<input type="submit" value="查询单词"  />
				 <input type="button" onclick="location.href='login_success.jsp'"  value="返回主界面" />
			</p>
			</form>
  </body>
</html>
