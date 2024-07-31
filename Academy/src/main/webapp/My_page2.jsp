<%@page import="com.tenco.model.student.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>스튜던트 정보</p>
			<% StudentDTO studentDTO=(StudentDTO) request.getAttribute("studentDTO"); %>
			<p>
			<%= studentDTO.getName() %>
			</p>
</body>
</html>