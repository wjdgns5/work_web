<%@page import="com.tenco.models.User"%>
<%@page import="java.util.List"%>
<%@page import="com.tenco.models.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>USERLIST PAGE</h1>
	
	<c:choose>
		<c:when test="${not empty userList}">
			<!--  userList가 null 이 아니라면 사용 HTML 태그 및 값 사용 -->
			
			<table border="1">
				<tr>
					<th>ID</th>
					<th>이름</th>
					<th>이메일</th>
				</tr>
				
				<c:forEach var="user" items="${userList}">
					<tr>
						<td><c:out value="${user.id}"></c:out></td>
						<td><c:out value="${user.username}"></c:out></td>
						<td><c:out value="${user.email}"></c:out></td>
					</tr>
				</c:forEach>
				
			</table>
		</c:when>
		
		<c:otherwise>
			<p>등록된 사용자가 없습니다.</p>
		</c:otherwise>
	</c:choose>

</body>
</html>