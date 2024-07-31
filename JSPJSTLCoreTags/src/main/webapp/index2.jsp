<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 예제</title>
</head>
<body>

	<h1>테스트</h1>
	
	<c:set var="message" value="메시지를 출력합니다."></c:set>
	<p>메세지 출력 : <c:out value="${message}"></c:out> </p> 
	
	
	<h2>if 구문 테스트</h2>
	
	<c:if test="${message != null}">
	<p>메세지 값이 존재합니다.</p>
	</c:if>
	
	
	<h2>for each 구문 테스트</h2>
	
	<c:forEach var="e" begin="2" end="11" >
	<p>Number : ${e}</p>
	</c:forEach>
	
	
	<h2>JSTL Formatting Example</h2>
	<c:set var="now" value="<%= new Date() %>"></c:set>
	<fmt:formatDate var="formattedDate" value="${now}" pattern="yyyy-MM-dd-HH:mm:Ss"/>
	
	<p>현재시간 : ${formattedDate}</p>
	
	

</body>
</html>