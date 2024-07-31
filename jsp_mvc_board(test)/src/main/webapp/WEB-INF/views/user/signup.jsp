<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/signup.css">
</head>
<body>
	<h2>회원가입</h2>
	<form action="" method="post">
		<div class="form-group">
			<label for="id">아이디 : </label>
			<input type="text" id="ee" name="username" required="required" value="고기">
		</div>
		
		<div class="form-group">
		<label for="pw">패스워드 : </label>
		<input type="text" id==pw name="password" required="required"  value="asd1234">
		</div>
		
		<div class="form-group">
		<input class="btn btn-primary" type="submit" value="회원가입">
		
	</form>
	
</body>
</html>