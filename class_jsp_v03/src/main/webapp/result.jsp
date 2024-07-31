<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		// 자바 실행 코드
		// request 객체에서 값 추출하기
	
		String cm = request.getParameter("cm");
	
		
		
		if(cm != null ){
		int a = Integer.parseInt(cm);
			out.println("변환결과 ");
			out.println("<br>");
			String format = String.format("%.3f", a / (2.54));
			out.println(format);
			out.println("<br>");
			out.println(a / (2.54));
			out.println("<br>");
			out.println( (int)(a / (2.54)) );
			
			DecimalFormat decimalFormat = new DecimalFormat("###,###");
			String formatResult =  decimalFormat.format(a / (2.54));
			out.println(formatResult);
		} else {
			out.println("<p> 다시 해보기</p>");
		}
	%>
	
	<!-- 다시 이전페이지로 또는 (특정 페이지로 이동)처리를 만들고 싶다면  -->
	<a href="form_page.jsp">Back</a>

</body>
</html>