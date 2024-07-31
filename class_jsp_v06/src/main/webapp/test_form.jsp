<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ㅇㅇ</h1>
	
	<%
	String username = "홍길동";
    	int age = 21;
    	
    	session.setAttribute("username", username); // key value 구조 map
    	session.setAttribute("age", age);
    %>
	
	<!--  http:localhost:8080/jsp/test_form.jsp -->
	<form action="challenge.jsp" method="POST">
		<label for="qq">이름</label>
		<input type="text" id="qq" name="username" value="가을">
		
		<label for="ee">나이</label>
		<input type="text" id="ee" name="age" value="21">
		
		<button type="submit">제출</button>
		
	</form>

</body>
</html>