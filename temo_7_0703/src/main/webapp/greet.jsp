<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>인사말을 완성 하였습니다.</h1>
	
	<%
		
	String name = request.getParameter("name");
	
		if(name == null || name.trim().isEmpty()){
			
			out.println("<p> 앗! 당신에 이름을 먼저 입력해주세요! </p>");
		} else {
			out.println("<p> 반가워," +name +"! 나의 JSP Site 잘 왔어 환영~~"+"<p>");
		}
	%>
	
	<a href="greet_from_page.html">돌아가기</a>
	
</body>
</html>