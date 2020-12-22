<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/fileupload/FileUpload" enctype="multipart/form-data" method="post">
		<input type="text" name="name" placeholder="上传人"/>
		<input type="file" name="uploadFile" placeholder="选择文件"/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>