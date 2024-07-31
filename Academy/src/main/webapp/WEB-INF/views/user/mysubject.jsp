<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="org.apache.tomcat.jakartaee.commons.lang3.ArrayUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tenco.model.subject.SubjectDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 강의</title>
</head>
<body>
	<h2>내 강의</h2>
	<%
	List<SubjectDTO> subjectList = (List<SubjectDTO>)request.getAttribute("subjectList");
	if (subjectList != null) {
	%>
	<table border="1">
		<tr>
			<th>과목코드:</th>
			<th>강의명:</th>
			<th>강의실:</th>
			<th>계열/학과:</th>
			<th>강의유형:</th>
			<th>개설 년도:</th>
			<th>학기:</th>
			<th>학점:</th>
			<th>
			<th>
		</tr>
		<%

			for(int i = 0; i< subjectList.size(); i++){
		%>
		<tr>
			<td><%=subjectList.get(i).getId()%></td>
			<td><%=subjectList.get(i).getName()%></td>
			<td><%=subjectList.get(i).getRoomId()%></td>
			<td><%=subjectList.get(i).getDepartmentName()%></td>
			<td><%=subjectList.get(i).getMajorType()%></td>
			<td><%=subjectList.get(i).getYear()%></td>
			<td><%=subjectList.get(i).getSemester()%></td>
			<td><%=subjectList.get(i).getGrades()%></td>
			<td>
				<form
					action="${pageContext.request.contextPath}/professor/input-grade"
					method="GET">
					<input type="hidden" name="subjectId" value="<%=subjectList.get(i).getId()%>">
					<button type="submit">성적 입력</button>
				</form>
			</td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	} else {
	%>
	<p>해당 학기에 개설된 강좌가 없습니다.</p>
	<%
	}
	%>
</body>
</html>