<%@page import="org.apache.jasper.tagplugins.jstl.core.Remove"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  세션과 관련된 메소드들을 확인 및 활용하고 세션을 무효화 시키는 기능을 만들어 보세요  -->
	
	<h2>세션 삭제</h2>
	
	<%
	try {
		
		session.removeAttribute("username");
		session.removeAttribute("age");
		
		// 세션에서 사용자 이름과 나이를 가져옵니다.
 		 String username = (String) session.getAttribute("username");
        Integer age = (Integer) session.getAttribute("age");
        
        request.getSession().invalidate();
        
        // 사용자 이름이 null이 아닌 경우
        
        if (username != null) {
            // 세션 무효화
           
            out.print(username);
            out.print(age);
            
            // 사용자 이름과 나이를 출력합니다.
            out.println("<p>안녕 " + username + "</p>");
            out.println("<p>나이는 " + age + "이네요!</p>");
        } else {
            // 세션이 설정되지 않은 경우
            out.println("<p>세션이 설정되지 않았습니다.</p>");
        }
    } catch (Exception e) {
        // 예외가 발생하면 setSession.jsp로 리다이렉트합니다.
        response.sendRedirect("test_form.jsp");
    }
		
	%>

</body>
</html>