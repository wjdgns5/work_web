<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}

input[type=number] {
	-moz-appearance: textfield;
}
</style>
</head>
<body>
		
		<!-- TODO - url 수정 필수-->
	<div class="login--div">
		<div class="main--logo">
			<a href="#"><img class="logo" alt="" src="/images/logo.png"></a>
		</div>

		<form action="${pageContext.request.contextPath}/user/login" method="post">
			<div class="form-group">
				<label for="id">학번 : </label> 
				<input type="text" id="id" name="id" value="23000001" required>
			</div>
			<div class="form-group">
				<label for="password">비밀번호 : </label> 
				<input type="text" id="password" name="password" value="123123" required>
			</div>
			<div class="form-group">
				<input class="btn btn-primary" type="submit" value="로그인">
			</div>
		</form>
		
		<a href="/find/id" onclick="window.open(this.href, '_blank', 'width=500, height=300'); return false;"> ID 찾기 </a>
		<a href="/find/password" onclick="window.open(this.href, '_blank', 'width=500, height=350'); return false;"> 비밀번호 찾기 </a>
		
		
</body>
</html>