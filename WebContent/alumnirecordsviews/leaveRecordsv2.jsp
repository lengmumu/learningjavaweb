<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@page import = "com.mysql.MysqlConnect,java.io.*,com.mysql.jdbc.*,java.util.Arrays" %>
	<%
		request.setCharacterEncoding("utf-8");
		
	%>
	<jsp:useBean id="arObject1" scope="request" class="com.alumnirecords.ARBean"/>
	<jsp:setProperty name="arObject1" property="*"/>
	<jsp:setProperty name="arObject1" property="imageToInviter" value='<%=Arrays.toString(request.getParameterValues("imageToInviter"))%>'/>
	<%--进行数据库存储数据 --%>
	<%
		
		MysqlConnect m = new MysqlConnect();
		Connection con = m.getMysqlConnection(3307, "test", "root", "root");
		String insertSql = "insert into alumni_records(user_id, delete_flag, invited_code, image, name, sex, birthday, mobile, email, address, interests, yearning_city, image_to_inviter, leave_message) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = (PreparedStatement)con.prepareStatement(insertSql);
		Object[] objects = arObject1.getObjectsArray();
		String[] names = arObject1.getNamesArray();
		ps.setObject(1,2);
		ps.setObject(2,2);
		for(int i=3;i<objects.length;i++){
			ps.setObject(i,objects[i]);
	%>
		索引值：<%=i%>&nbsp;&nbsp;
		属性名：<%=names[i] %>&nbsp;&nbsp;
		属性值：<%=objects[i] %><br/>
	
	<% }
		int x = ps.executeUpdate();
		m.colseMysqlConnection(con, ps);
	%>
	<%=x%>”行受影响"
</body>
</html>