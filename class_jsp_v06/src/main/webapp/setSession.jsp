<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String username = "홍길동";
    	int age = 21;
    	
    	session.setAttribute("username", username); // key value 구조 map
    	session.setAttribute("age", age);
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 설정 페이지</title>
</head>
<body>

	<h2>세션 설정이 완료되었습니다.</h2>
	<a href="getSession.jsp">세션 읽어 보기</a>
	<a href="challenge.jsp">세션 지워 보기</a>
	
</body>
</html>