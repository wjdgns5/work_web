
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <%@ include file="main_head.jsp" %>
 
 <p>학번: ${verifiedUser.id}</p>
 <c:if test="${verifiedUser.permissionLevel == 1}">
 	<p>학생</p>
 </c:if>
 
 <c:if test="${verifiedUser.permissionLevel == 2}">
 	<p>교수</p>
 </c:if>
 
 <c:if test="${verifiedUser.permissionLevel == 3}">
 	<p>관리직</p>
 </c:if>
 


<a href="${pageContext.request.contextPath}/user/logout">로그아웃 logout</a>
<a href="${pageContext.request.contextPath}/user/My">마이페이지</a>




<%@ include file="main_footer.jsp"%>