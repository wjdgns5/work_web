<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/view.css">
<head>
<meta charset="UTF-8">
<title>게시글 상세보기 화면</title>
</head>
<body>
	<div class="container">
		<h2>${board.title}</h2>
		<p>${board.content}</p>
		<p> <fmt:formatDate value="${board.createdAt}" pattern="yyyy-MM-dd HH:mm"/> </p>
	</div>
	<c:if test="${board.userId == principal.id}">
		<a href="${pageContext.request.contextPath}/board/edit?id=${board.id}" class="btn btn-edit">수정</a>
		<a href="${pageContext.request.contextPath}/board/delete?id=${board.id}" class= "btn btn-delete">삭제</a>
	</c:if>
	
	<a href="${pageContext.request.contextPath}/board/list?page=1" class="btn btn-edit">목록으로 돌아가기</a>
	
	<h3>댓글</h3>
	<!-- 댓글 리스트 작성 -->
	
	<!-- 댓글 작성 폼  -->
	
</body>
</html>