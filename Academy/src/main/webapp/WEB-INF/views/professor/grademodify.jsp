<%@page import="com.tenco.model.professor.StudentGradeDTO"%>
<%@page
	import="jakarta.security.auth.message.callback.PrivateKeyCallback.SubjectKeyIDRequest"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학점 수정하기</title>
</head>
<body>
	<h2>학점 수정하기</h2>
	<%
	List<StudentGradeDTO> gradeList = (List<StudentGradeDTO>) request.getAttribute("gradeList");
	if (gradeList != null) {
	%>
	<form action="${pageContext.request.contextPath}/professor/update-grade"
		method="GET">
		<table border="1">
			<tr>
				<th>순번</th>
				<th>학번</th>
				<th>성명</th>
				<th>강의코드</th>
				<th>강의명</th>
				<th>중간고사 성적</th>
				<th>기말고사 성적</th>
				<th>환산 점수</th>
				<th>비고</th>
			</tr>
			<%		
			
			int i;
			for (i = 0; i < gradeList.size(); i++) {
			%>
			<tr>
				<td><%=i + 1%></td>
				<td><%=gradeList.get(i).getStudentId()%></td>
				<td><%=gradeList.get(i).getStudentName()%></td>
				<td><%=gradeList.get(i).getSubjectId()%></td>
				<td><%=gradeList.get(i).getSubjectName()%></td>
				<td><input type="text" name="midExamScore<%=i+1%>" size="10"
					style="width: 20vh" value="<%=gradeList.get(i).getMidExam()%>"></td>
				<td><input type="text" name="finalExamScore<%=i+1%>" size="10"
					style="width: 20vh" value="<%=gradeList.get(i).getFinalExam()%>"></td>
				<td><input type="text" name="grade<%=i+1%>" size="10"
					style="width: 20vh" value="<%=gradeList.get(i).getConvertedMark()%>"></td>
				<td><input type="hidden" name="studentId<%=i+1%>"
					value="<%=gradeList.get(i).getStudentId()%>"></td>
			</tr>
			<%
			}
			%>
		</table>
		<input type="hidden" name="studentSize" value="<%=i%>"> <input
			type="hidden" name="subjectId"
			value="<%=request.getAttribute("subjectId")%>">
		<button type="submit">학점 수정</button>
	</form>
	<%
	} else {
	%>
	<p>수정할 학점 정보가 없습니다.</p> <a href="home.jsp">홈 화면으로 돌아가기</a>
	<%
	}
	%>
</body>
</html>