<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>DEL</h1>
<%
	session.removeAttribute("id");
%>
<script>
	window.location.href="sessionTest.jsp";
</script>
</body>
</html>