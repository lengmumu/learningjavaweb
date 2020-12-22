<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- 设置值 --%>
	<c:set var="username" value="set"/>
	
	<%--删除值 --%>
	<c:remove var="username" scope="page"/>
	
	<%--显示值 --%>
	<c:out value="${username}"  default="刘伟"  escapeXml="true"/>
	<c:out value="${pageContext.request.contextPath}"  default="刘伟"  escapeXml="true"/>
	
	<%--将异常存放到变量 --%>
	<c:catch var="ex">
		<%
			String number="none";
			int i = Integer.parseInt(number);
		 %>
	</c:catch>
	${ex}
	
	<%--条件语句 --%>
	<c:choose>
		<c:when test="${param.age>70}">欢迎老年人
		</c:when>
		<c:when test="${param.age>=35 and param.age<=70}">欢迎中年人
		</c:when>
		<c:otherwise>你还没出生呢</c:otherwise>
	</c:choose>
</body>
</html>