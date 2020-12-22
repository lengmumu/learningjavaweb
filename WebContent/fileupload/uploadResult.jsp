<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${requestScope['upload.message']}"></c:out><br/>
	<a href="<%=request.getContextPath()%>/fileupload/testUpload.jsp">重新上传</a>
	
</body>
</html>