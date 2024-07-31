<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

 <%@ include file="../main_head.jsp" %>
 <table>
    <tr>
        <th>학번</th>
        <th>이름</th>
        <th>구분</th>
        <th>년도</th>
        <th>학기</th>
        <th>금액</th>
    </tr>

	<c:forEach var="DTO" items="${studentScholarDTO}">
    <tr>
        <td>${DTO.studentId}</td>
        <td>${DTO.studentName}</td>
        <td>${DTO.schYear}</td>
        <td>${DTO.semester}</td>
        <td>${DTO.schTypeName}</td>
        <td>${DTO.amount}</td>
    </tr>
	</c:forEach>

</table>
 
 
 <%@ include file="../main_footer.jsp"%>