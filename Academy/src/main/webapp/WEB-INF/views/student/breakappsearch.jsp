<%@page import="com.tenco.model.student.StudentDTO"%>
<%@page import="com.tenco.model.student.breakappDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ include file="../main_head.jsp" %>

<% StudentDTO studentDTO = (StudentDTO)request.getSession().getAttribute("studentDTO"); %>
<% breakappDTO breakappDTO = (breakappDTO)request.getAttribute("breakappDTO"); %>

<h1>휴학 신청 목록 입니다.</h1>
<div>
<table border="1">

<th>신청일자</th>
<td> <%= breakappDTO.getApp_date()%></td>

<th>구분</th>
<td> <%= breakappDTO.getType()%></td>

<th>시작학기</th>
<td> <%= breakappDTO.getFrom_semester()%></td>


<th>종료학기</th>
<td> <%= breakappDTO.getTo_semester()%></td>


<th>처리상태</th>
<td> <%= breakappDTO.getStatus() %></td>
</div>

<%@ include file="../main_footer.jsp"%>