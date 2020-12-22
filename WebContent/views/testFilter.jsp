<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${param.username }" default="none"/>
	<c:out value="${param.password }" default="none"/>
	<form method="post" action="./testFilter.jsp">
		用户名：<input type="text" name="username"/>
		密码：<input type="password" name="password"/>
		<input type="submit"/>
	</form>
</body>
</html>