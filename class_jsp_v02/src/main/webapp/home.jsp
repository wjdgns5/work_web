<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  만약에 폴더에 있는데 뒤로 나가고 싶다 ../  사용 -->
    <%@ include file="header.jsp" %>
    <%@ page import="java.util.Date" %>
    
    <h1>JSP 지시자 예제</h1>
    
    <%-- <%=  %> 는 System.print 이다. --%>
    <p>현재 시간 <%= new Date() %> </p>
    
    <%@ include file="footer.jsp" %>
    
    