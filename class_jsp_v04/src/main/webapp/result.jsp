<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>폼 제출 결과 확인 페이지</h1>
	
	<%
		String username = request.getParameter("username");
		String[] hobbies = request.getParameterValues("hobbies");
		String faColor = request.getParameter("favoriteColor");
	//	out.print("xxxx " + hobbies.length);
	//	out.print("이름 " + username);
	%>
	
	<p>Username : <%= username %> </p>
 	
	<%
		if(hobbies != null) {
			
	%>
		<!-- html 영역   -->
		<p>Hobbies : </p>
		<ul>
			<% for(String bobby : hobbies) { %>
			<li><%= bobby %></li>
			<%} %>
		</ul>		
	<%} else {%>
	
		 <!-- HTML 영역 -->
		 <p>선택된 취미가 없습니다.</p>
	<%		
		}
		
	%>
	<ul>
		<li></li>
		<li></li>
	</ul>
	
	<p> color : <%= faColor != null ? faColor : "선택한 색상이 없네요" %>
	
	

</body>
</html>