 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="<%=request.getContextPath()%>/mail/SendAttachmentMail"  enctype="multipart/form-data">
	收件人：<input type="text" name="to"/>
	发件人：<input type="text" name="from"/>
	主题：<input type="text" name="subject"/>
	附件：<input type="file" name="attachment"/>
	内容：<input type="textarea" name="content"/>
	<input type="submit" value="提交"/> 
	</form>
</body>
</html>