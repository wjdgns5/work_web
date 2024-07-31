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
 		// http://localhost:8080/jsp/welcome.jsp
 		
 		// session 객체를 사용하여 사용자 정보 여부를 확인하자.
 		String username = (String)session.getAttribute("username");
 		
 		if(username == null || username.trim().isEmpty()){
 			// request 객체에서 사용자 정보를 추출하자.
 			username = request.getParameter("username");
 			if(username != null && !username.trim().isEmpty()) {
 			// 홍길동 ok
 			// ""				&&  !""
 			
 			// 세션 객체를 사용해서 사용자 정보를 저장(속성과 같음)
 			session.setAttribute("username", username);
 			} else {
 				// 사용자가 정상적인 데이터를 보내지 않는다면 (클라이언트를 다시 뒤로 돌린다.)
 				response.sendRedirect("login.jsp"); // login.jsp 로 응답해서 돌려보낸다.
 				return;
 			}
 		}
 		
 		// application 내장 객체를 사용하여 방문 횟수 증가 
 		Integer visitCount = (Integer)application.getAttribute("visitCount");
 		if(visitCount == null){
 			visitCount = 1;
 		} else {
 			visitCount++;
 		}
 		
 		// chrome 이나 edge에서 각각 로그인 해서 새로고침 하면 방문 횟수는 공유가 된다.
 		application.setAttribute("visitCount", visitCount);
 		
 		Date now = new Date();
 	%>
 	
 	<h2>환영 합니다. <%= username %> </h2>
 	
 	<p>현재 시간 : <%= now %></p>
 	<p>방문 횟수 : <%= visitCount %> </p>
 
</body>
</html>