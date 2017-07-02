<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'test.jsp' starting page</title>

<script type="text/javascript" src="script/jquery/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="script/js/a.js"></script>

</head>

<body>
	<h2>This is a heading</h2>
	<p>This is a paragraph.</p>
	<p>This is another paragraph.</p>
	<button type="button" id="but">Click me</button>
	<button id="btn1">点击调用</button>
</body>
</html>
<script type="text/javascript">
	$(function() {
		$(document).ready(function() {
			$("#but1").click(function() {
				alert("bb");
				$.ajax({
					url : 'mvc/ajax',
					dataType : 'json',
					success : function(result, status) {
						alert(result);
					}
				});

			});
		});
	});
</script>


