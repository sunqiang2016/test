<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=basePath%>mvc/multiUpload" method="post" enctype="multipart/form-data">
		<input type="file" name="file"><br> <input type="submit"
			value="submit">
	</form>
</body>
</html>