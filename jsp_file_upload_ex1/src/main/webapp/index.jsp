<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="main--container">
	<!-- 파일은 post 방식으로 던진다. -->
	<!-- 파일을 전송하기 위한 설정 -->
		<form action="/upload" method="post" enctype="multipart/form-data">
			<label for="title">제목 : </label>
			<input type="text" name="title" id="title">
			
			<label for="mFile">첨부 파일 : </label>
			<input type="file" name ="mFile" id ="mFile">
			
			<button type="submit">전송</button>
		</form>
		
	</div>

</body>
</html>