<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>결과 확인 페이지</h1>
	<%
		String result =	request.getParameter("message");
	%>
	
	<p>결과 : <%= result %></p>

</body>
</html>