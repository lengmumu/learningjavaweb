<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="util2" uri="http://taglib.com/taglib/util" %>
<%@page import = "java.util.Date,com.utiltool.StringUtil" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%response.getWriter().print("<h1>试试标签</h1>  ".replaceAll("<", "&lt;")); %>
	<util2:timer>
	程序运行时间：
	<%
		for(int i=0;i<1000000000;i++){
		}
	%>
	</util2:timer>
	<br/>
	
	输出格式化时间不传参:
	<util2:datetime></util2:datetime>
	<br/>
	
	
	<util2:datetime pattern="yy年MM月" date="<%=new Date() %>">
		输出格式化时间：<br/>
	</util2:datetime>
	<br/>
	
	<util2:loop times="3">
		循环输出内容：<util2:datetime></util2:datetime></br>
	</util2:loop>
	
	<util2:filter-html>
		<br/>过滤他
		<h2>为啥替换的是字符</h2>
	</util2:filter-html>
</body>
</html>