<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,com.mysql.MysqlUtil"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑留言</title>
</head>
<body>
	<%
		MysqlUtil m = new MysqlUtil();
		m.init("java:comp/env/jdbc/mysql");
		Object id = request.getParameter("id");
		Object[] params = {id};
		List list = m.query("select * from alumni_records where id=?",params);
		Map<String,Object> map = null;
	%>
	
			<table style="border:1px solid;margin:0 auto;">
			<form action="<%=request.getContextPath() %>/alumnirecordsviews/manager/ManageRecords?method=edit&id=<%=id%>" method="post">
	<%
			map = (Map<String,Object>)list.get(0);
			for(String key:map.keySet()){
	%>
		
			<tr>
				<td><%=key%></td>
				<td><input type="text" name="<%=key%>" value="<%=map.get(key) %>"/></td>
			</tr>
		
	<%}%>	
			<tr><td></td><td>
			<input type="submit" value="确定"></a>
			<a href="<%=request.getContextPath()%>/alumnirecordsviews/manager/manageRecords.jsp" style="float:right;">取消</a></td></tr>
			</form></table></br>
</body>
</html>