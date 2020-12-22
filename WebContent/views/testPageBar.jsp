<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.pagebar.PageBarDaoImp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>测试分页</title>
</head>
<body>
	<table>
		
	</table>
	<div>
		每页显示
		<select>
			<option>5</option>
			<option selected="selected">10</option>
			<option>20</option>
		</select>
		条
	</div>
	<div>
		<a href="<%=request.getContextPath() %>/PageBar?method=first">首页</a>
		<a href="<%=request.getContextPath() %>/PageBar?method=previous">上一页</a>
		<a href="<%=request.getContextPath() %>/PageBar?method=getpage&pagenum=1">1</a>
		<a href="<%=request.getContextPath() %>/PageBar?method=getpage&pagenum=2">2</a>
		<a href="<%=request.getContextPath() %>/PageBar?method=getpage&pagenum=3">3</a>
		<a href="<%=request.getContextPath() %>/PageBar?method=next">下一页</a>
		<a href="<%=request.getContextPath() %>/PageBar?method=last">尾页</a>
	</div>
</body>
</html>