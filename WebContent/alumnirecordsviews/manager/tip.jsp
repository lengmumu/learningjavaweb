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
<%=session.getAttribute("login.manager.username")%><br/>
	<%=session.getAttribute("message") %><br/>
	<a href="<%=request.getContextPath() %>/alumnirecordsviews/manager/manageRecords.jsp">返回</a>
</body>
</html>