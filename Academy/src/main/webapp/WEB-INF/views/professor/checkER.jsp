<%@page import="com.tenco.model.professor.EvaluationResultDTO"%>
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
<title>강의 평가 결과창</title>
</head>
<body>
    <h2>강의 평가 결과창</h2>
    <%
	List<EvaluationResultDTO> erList = (List<EvaluationResultDTO>) request.getAttribute("erList");
	if (erList != null) {
	%>
        <% int i;
        float sumAvgScore = 0;
        for (i = 0; i < erList.size(); i++) {%>
        <label>평점 : <%=erList.get(i).getAvgScore()%></label> <br><br>
		<label>학생측 건의 사항</label>
        <textarea rows="4" cols="50" ><%=erList.get(i).getImprovements()%></textarea><br><br>
        <%sumAvgScore = sumAvgScore + erList.get(i).getAvgScore();
        }%>
        
        <label>토탈 평균 점수 : <%=sumAvgScore/(float)erList.size()%></label>
        
		
		

	<%}else{ %>
	<p>조회된 강의평가 결과가 없습니다.</p>
	<%} %>
	
	<a href="home.jsp">홈으로 돌아가기.</a>
</body>
</html>