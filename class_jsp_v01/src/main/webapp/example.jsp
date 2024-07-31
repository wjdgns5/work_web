<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.*" %>
    
    <%
		// 주소 - http://localhost:8080/jsp/example.jsp	
		// getAttribute - 특정 요소노드 내에서 특정 한 속성값을 가져오는 메소드 
		
		// 초기화 단계(jspInit 역할)
		if(application.getAttribute("initialized") == null){ // 자료구조 Map을 다시 보자.
			application.setAttribute("initialized", true);
			application.setAttribute("initialized", new Date());
			out.println("JSP가 초기화 되었습니다. <br>");
		}
	
		out.println("요청이 완료 되었습니다. <br>");
		out.println("현재 시간 : " + new Date() + " <br>");
		
		// 세션이라는 전역 메모리지에 데이터를 저장하고 확인해 보자
		String message = (String)session.getAttribute("message");
		
		if(message != null){
			out.println("세션 메시지 : " + message);
		} else {
			out.println("저장된 세션 메시지가 없습니다.");
		}
		
		// 세션이라는 메모리에 key, value 를 할당하자.
		session.setAttribute("message", "안녕 ~ 세션에 저장한 메세지야");
		
	%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>JSP 라이프 사이클 확인</h1>
	<p>이 페이지에 학습 목적은 JSP 동작 방식에 대한 이해와 라이프 사이클 입니다.</p>

</body>
</html>

<%
	// 소멸 단계 확인 (jspDestory)
	if(application.getAttribute("initialized")!= null){
		application.removeAttribute("initialized");
		application.removeAttribute("initializedTime");
		out.println("JSP 객체가(서블릿) 소멸 되었습니다. <br>");
	}
	
%>



