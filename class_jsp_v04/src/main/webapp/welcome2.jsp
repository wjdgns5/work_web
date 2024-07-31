<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환영해요</title>
</head>
<body>
 <%-- <% %> 스크립트 릿 이라고한다. --%>
 
 	<%
 		// http://localhost:8080/jsp/welcome2.jsp
 		
 		// session 객체를 사용하여 사용자 정보 여부를 확인하자.
 		String username = (String)session.getAttribute("username");
 		
 		if(username == null || username.trim().isEmpty()){
 			// 여기에 들어 온다면 최초 요청이 아닐까??
 			// 폼 데이터 있는지 없는지 확인 .... 가정 있다면
 			session.setAttribute("username", "홍길동");
 			session.setAttribute("visitCount", 1);
 			
 		} else {
 			
 			Integer visitCount = (Integer)session.getAttribute("visitCount");
 			
 			if(visitCount == null){
 				visitCount = 1;
 			} else {
 				visitCount++;
 			}
 				// 두번째 요청 인듯 ...
 				session.setAttribute("visitCount", 1);
 		}
 		
 	%>
 	
 	<h2>환영 합니다, <%= username %> </h2>
 	<p>방문 횟수 : <%= session.getAttribute("visitCount") %> </p>
 
</body>
</html>