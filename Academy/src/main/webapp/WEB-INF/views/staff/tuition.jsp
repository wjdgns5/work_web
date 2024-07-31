<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

 <%@ include file="../main_head.jsp" %>
 <table >
    <tr>
        <th>학번</th>
        <th>이름</th>
        <th>년도</th>
        <th>학기</th>
        <th>학부</th>
        <th>등록금</th>
        <th>장학금</th>
        <th>장학제도</th>
        <th>납부여부</th>
    </tr>
    
    <c:forEach var="DTO" items="${tuiList}">
    <tr>
        <td>${DTO.id}</td>
        <td>${DTO.studentName}</td>
        <td>${DTO.tuiYear}</td>
        <td>${DTO.semester}</td>
        <td>${DTO.collName}</td>
        <td>${DTO.amount}</td>
        <td>${DTO.schMount}</td>
        <td>${DTO.schName}</td>
        <c:choose>
	        <c:when test="${DTO.status eq 1}">
	        	<td>O</td>
	        </c:when>
	        <c:otherwise>
	        	<td>X</td>
	        	<td><button onclick="#">납부하기</button></td>
	        </c:otherwise>
        </c:choose>
    </tr>
     </c:forEach>

</table>
 
 
 <%@ include file="../main_footer.jsp"%>