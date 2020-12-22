<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ page isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${requestScope['login.message']}"></c:out><br/>
	<a href="<%=request.getContextPath()%>/alumnirecordsviews/manager/managerLogin.jsp">重新登陆</a>
</body>
</html>