<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--设置选项框取值变量 --%>
	<c:set var="isRegist" value="true" scope="request"></c:set>
	<c:out value="${requestScope.isRegist }"></c:out>
	<div>注册</div>
	 <div class="loginBox">
		<div class="rtop">
			<a href="home.html" style="float: right;">×</a>
		</div>
    	<div>    	
			<c:if test="${!isRegist}">
				<form action="<%=request.getContextPath() %>/alumnirecordsviews/arv2.jsp" method="post" class="innerbox">
					<input type="text" class="username" placeholder="账号" />
					<input type="password" class="password" placeholder="密码" />
						<input type="submit" value="登陆"   class="submit_button"/>
		    	</form>
			</c:if>
	    	<c:if test="${isRegist}">
				<form action="<%=request.getContextPath() %>/alumnirecordsviews/arv2.jsp" method="post" class="innerbox">
					<input type="text" class="username" placeholder="账号" />
					<input type="password" class="password" placeholder="密码" />
						<input type="submit" value="注册"   class="submit_button"/>
		    	</form>
			</c:if>
        </div>
      </div>
</body>
</html>