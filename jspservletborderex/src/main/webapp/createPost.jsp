<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">

</head>
<body>
 	<!--  http://localhost:8080/board/createPost.jsp -->
	<h2>게시글 작성</h2>
	<form action="create-post" method="post">
		
		<label for="title">제목</label>
		<input type="text" id="title" name="title" value="게시글 제목 1">
		
		<br><br>
		
		<label for="content">내용</label>
		<input type="text" id="content" name="content" value="JSP 웹 프로그래밍 ....">
		
		<button type="submit">글 작성</button>
		
	</form>
	
	<br>
	
	<a href="read-posts">게시글 목록</a>

</body>
</html>