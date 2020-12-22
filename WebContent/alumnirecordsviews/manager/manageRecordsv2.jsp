<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,com.mysql.MysqlUtil"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	欢迎<%=session.getAttribute("login.manager.username")%><br/>
	<a href="<%=request.getContextPath() %>/alumnirecordsviews/manager/ManageRecords?method=loginout">退出登录</a>
	<%
		MysqlUtil m = new MysqlUtil();
		m.init("java:comp/env/jdbc/mysql");
		Object id = request.getParameter("id");
		List list = m.query("select * from alumni_records");
		int len = list.size();
		Map<String,Object> map = null;
		for(int i=0;i<len;i++){
	%>
	
			<table style="border:1px solid;margin:0 auto;">
	<%
			map = (Map<String,Object>)list.get(i);
			for(String key:map.keySet()){
	%>
		
			<tr>
				<td><%=key%></td>
				<td><%=map.get(key) %></td>
			</tr>
		
	<%}%>	
			<tr><td></td><td>
			<a href="<%=request.getContextPath() %>/alumnirecordsviews/manager/editAr.jsp?id=<%=map.get("id")%>">编辑</a>
			<a href="<%=request.getContextPath() %>/alumnirecordsviews/manager/ManageRecords?method=delete&id=<%=map.get("id")%>" style="float:right;">删除</a></td></tr>
			</table></br>
	<%}%>
</body>
</html>