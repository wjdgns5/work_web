<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 확인 페이지</title>
</head>
<body>
	<h2>결과 확인 페이지</h2>
	<%
		String message = request.getParameter("message");
	
		if(("create-success").equals(message)){
			out.println("<p> 게시글 작성에 성공 </p>");
		
		} else if(("delete-success").equals(message)) {
			out.println("<p> 게시글 삭제에 성공 </p>");
			
		} else if(("update-success").equals(message)){
			out.println("<p> 게시글 수정에 성공 </p>");
		}else {
			out.println("<p> 작업에 실패하였습니다. </p>");
		}
	%>
	
	<br><br>
	<%-- 게시글 작성 화면으로 이동 --%>
	<a href="createPost.jsp"> 게시글 작성 페이지  </a>
	<br><br>
	<%-- 게시글 목록 화면으로 이동 --%>
	<a href="read-posts"> 게시글 리스트 페이지  </a>
	
	
	
</body>
</html>