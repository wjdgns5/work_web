<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="sty"><link rel="stylesheet" type="text/css" href="../css/styles.css">
</head>
<body>
<!--  // http://localhost:8080/mvc/user/signIn -->
	


<div class="container">
        <h1>로그인 JSP 파일 입니다.</h1>
        
        <!-- 회원 가입 성공 메세지 출력 -->
        
        
        <c:set var="success" value="(String)request.getParameter('message')"></c:set>
        <c:if test="${success != null }">
        
        	<p class="message"> <c:out value="${success}"></c:out> </p>
        
        </c:if>
   


        <!--  절대 경로로 사용 해보기 -->
        <form action="/mvc/user/signIn" method="POST">
            <div class="form-group">
                <label for="username">사용자 이름 : </label>
                <input type="text" id="username" name="username" value="야스오1">
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password" value="1234">
            </div>
            <button type="submit">로그인</button>
        </form>
    </div>
	
	
</body>
</html>