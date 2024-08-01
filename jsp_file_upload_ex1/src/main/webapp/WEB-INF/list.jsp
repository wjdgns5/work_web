<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  주소 : http://localhost:8080/imageList -->
	<h1>이미지 리스트 출력하기 </h1>
	<ul>
	 <%
		List<String> fileNames = (List<String>)request.getAttribute("fileNames");
	 	if(fileNames != null && !fileNames.isEmpty() ){
	 		// 파일명들이 존재 한다면
	 		for(String fileName : fileNames) {
	 %>	
	 		<li><img src="images/<%=fileName%>" width="200px">
	 <%
	 	}
	 }	
	 %>
	</ul>
</body>
</html>