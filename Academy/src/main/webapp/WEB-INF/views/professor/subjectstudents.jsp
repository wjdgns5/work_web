<%@page
	import="jakarta.security.auth.message.callback.PrivateKeyCallback.SubjectKeyIDRequest"%>
<%@page import="com.tenco.model.student.StudentIdNameDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학점 입력하기</title>
</head>
<body>
	<h2>학점 입력하기</h2>
	<%
	List<StudentIdNameDTO> studentList = (List<StudentIdNameDTO>) request.getAttribute("studentList");
	if (studentList != null) {
	%>
	<form action="${pageContext.request.contextPath}/professor/input-grade"
		method="GET">
		<table border="1">
			<tr>
				<th>순번</th>
				<th>학번</th>
				<th>성명</th>
				<th>중간고사 성적</th>
				<th>기말고사 성적</th>
				<th>환산 점수</th>
				<th>비고</th>
			</tr>
			<%
			int i;
			for (i = 0; i < studentList.size(); i++) {
			%>
			<tr>
				<td><%=i + 1%></td>
				<td><%=studentList.get(i).getId()%></td>
				<td><%=studentList.get(i).getName()%></td>
				<td><input type="text" name="midExamScore<%=i+1%>" size="10"
					style="width: 20vh" value="90"></td>
				<td><input type="text" name="finalExamScore<%=i+1%>" size="10"
					style="width: 20vh" value="80"></td>
				<td><input type="text" name="grade<%=i+1%>" size="10"
					style="width: 20vh" value="4.0"></td>
				<td><input type="hidden" name="studentId<%=i+1%>"
					value="<%=studentList.get(i).getId()%>"></td>
			</tr>
			<%
			}
			%>
		</table>
		<input type="hidden" name="studentSize" value="<%=i%>"> <input
			type="hidden" name="subjectId"
			value="<%=request.getAttribute("subjectId")%>">
		<button type="submit">학점 입력</button>
	</form>
	<%
	} else {
	%>
	<p>해당 강의에 수강중인 학생이 없습니다.</p>
	<%
	}
	%>
</body>
</html>