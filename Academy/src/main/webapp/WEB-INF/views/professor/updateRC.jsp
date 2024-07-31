<%@page import="com.tenco.model.professor.RestClassDTO"%>
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
<title>휴강일정 수정하기</title>
</head>
<body>
    <h2>휴강일정 수정하기</h2>
    <%
	RestClassDTO rc = (RestClassDTO)request.getAttribute("rc");
	%>
    <form action="${pageContext.request.contextPath}/professor/inputUpdateRC" method="GET">

        <label for="restDay">휴강 일정 및 사유:</label>
        <textarea id="restDay" name="restDay" rows="4" cols="50" required><%=rc.getRestDay()%></textarea><br><br>

        <label for="supplement">보강 계획:</label>
        <textarea id="supplement" name="supplement" rows="4" cols="50" required><%=rc.getSupplement()%></textarea><br><br>
        
		<input type="hidden" id="id" name="id" value="<%=request.getParameter("id")%>">
        <button type="submit">입력</button>
    </form>
</body>
</html>