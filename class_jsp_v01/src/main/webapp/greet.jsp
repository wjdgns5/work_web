<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- JSP 페이지의 설정을 정의하는 JSP 지시자  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>인사말을 완성 하였습니다.</h1>
	
	<%
		// 자바 실행 코드
		// request 객체에서 값 추출하기
		
		String name = request.getParameter("name");
		
		if(name == null || name.trim().isEmpty()){
			out.println("<p> 앗! 당신에 이름을 먼저 입력해주세요 </p>");
		} else {
			out.println("<p> 반가워," +name +"! 나의 JSP Site 잘 왔어 환영~~" +"</p>");
		}
	%>
	
	<!-- 다시 이전페이지로 또는 (특정 페이지로 이동)처리를 만들고 싶다면  -->
	<a href="greet_from_page.html">Back</a>
	
</body>
</html>