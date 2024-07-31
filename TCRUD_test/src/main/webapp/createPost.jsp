<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<link style="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<!--  http:localhost:8080/board/createPost.jsp -->
	<h2>게시글 작성</h2>
	// 글 작성 버튼 클릭 시 create-post가 매핑되어 있는 곳으로 이동한다.
	<form action="create-post" method="post">
		<label for="QQ">제목 : </label>
		<input type="text" id="QQ" name="title" value="게시글 title 1">
		
		<br> <br>
		
		<label for="EE">내용 : </label>
		<input type="text" id="EE" name="content" value="게시글 content 1">
		
		<br> <br>
		
		<button type="submit">글 작성</button>
	</form>
	
	<br> <br>
	<a href="read-posts">게시글 이동</a>
	
	
	
</body>
</html>