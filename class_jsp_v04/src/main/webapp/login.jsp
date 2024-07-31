<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<h2>로그인</h2>
	<%-- welcome2.jsp : 상대경로 --%>
	<!-- 로그인 처리는 예외적인 사항으로 POST 요청을 하자! 이유: GET 방식은 주소창에 데이터가 보이고 취약하다. -->
	<form action="welcome2.jsp" method="POST">
		<label for="username">username : </label>
		<input type="text" id="username" name="username" value="홍길동">
		
		<label for="password">password : </label>
		<input type="text" id="password" name="password" value="1234">
		
		<button type="submit">로그인</button>
		
	</form>

</body>
</html>