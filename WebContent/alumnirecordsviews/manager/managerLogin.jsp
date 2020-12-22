<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员登陆</title>
</head>
<body>
	 <div class="loginBox">
		<div class="rtop">
			<a href="home.html" style="float: right;">×</a>
		</div>
    	<div> 
			<form action="<%=request.getContextPath() %>/alumnirecordsviews/manager/ValidateManagerLogin" method="post" class="innerbox">
				<input type="text" name="musername" placeholder="账号" />
				<input type="password" name="mpassword" placeholder="密码" />
				<input type="submit" value="登陆"   class="submit_button"/>
		    </form>
        </div>
      </div>
</body>
</html>