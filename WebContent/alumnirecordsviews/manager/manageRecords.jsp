<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,com.mysql.MysqlUtil,com.pagebar.PageBarDaoImp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- v3版本：添加分页 -->
	欢迎<%=session.getAttribute("login.manager.username")%><br/>
	<a href="<%=request.getContextPath() %>/alumnirecordsviews/manager/ManageRecords?method=loginout">退出登录</a>
	<%
		System.out.println(request.getAttribute("list"));
		if(request.getAttribute("list") == null) request.getRequestDispatcher("/PageBar?method=first").forward(request,response);
		else{List list =(List) request.getAttribute("list");
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
	<%}}%>
	<div>
		<span>
			每页显示
			<select>
				<option>5</option>
				<option selected="selected">10</option>
				<option>20</option>
			</select>
			条
		</span>
		<span>
			<a href="<%=request.getContextPath() %>/PageBar?method=first">首页</a>
			<a href="<%=request.getContextPath() %>/PageBar?method=previous">上一页</a>
			<a href="<%=request.getContextPath() %>/PageBar?method=getpage&pagenum=1">1</a>
			<a href="<%=request.getContextPath() %>/PageBar?method=getpage&pagenum=2">2</a>
			<a href="<%=request.getContextPath() %>/PageBar?method=getpage&pagenum=3">3</a>
			<a href="<%=request.getContextPath() %>/PageBar?method=next">下一页</a>
			<a href="<%=request.getContextPath() %>/PageBar?method=last">尾页</a>
		</span>
	</div>
</body>
</html>