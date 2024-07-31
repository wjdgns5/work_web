<%@page import="com.tenco.model.subject.SubjectDTO"%>
<%@page import="java.util.List"%>
<%@page
    import="jakarta.security.auth.message.callback.PrivateKeyCallback.SubjectKeyIDRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>휴강일정 입력하기</title>
</head>
<body>
    <h2>휴강일정 입력하기</h2>
    <%
	List<SubjectDTO> subjectList = (List<SubjectDTO>) request.getAttribute("subjectList");
	if (subjectList != null) {
	%>
    <form action="${pageContext.request.contextPath}/professor/inputRestClass" method="GET">
        <input type="hidden" name="professorId" value="<%=request.getParameter("professorId")%>"> 
        <input type="hidden" name="year" value="<%=request.getParameter("year")%>"> 
        <input type="hidden" name="semester" value="<%=request.getParameter("semester")%>"> 

        <label for="subjectId">과목 선택</label>
		<select id="selectSub" name="selectSub">
		<%System.out.println(subjectList.toString()); %>
        <% int i=0;
        for (i = 0; i < subjectList.size(); i++) {%>
			<option value="<%=i%>">과목코드 : <%=subjectList.get(i).getId()%>, 강의명 : <%=subjectList.get(i).getName()%></option>
        <%}%>
		</select>        
		

        <label for="restDay">휴강 일정 및 사유:</label>
        <textarea id="restDay" name="restDay" rows="4" cols="50" required></textarea><br><br>

        <label for="supplement">보강 계획:</label>
        <textarea id="supplement" name="supplement" rows="4" cols="50" required></textarea><br><br>

        <button type="submit">입력</button>
    </form>
	<%}else{ %>
	<p>이번 학기에 개설하신 강좌가 없습니다.</p>
	<%} %>
</body>
</html>