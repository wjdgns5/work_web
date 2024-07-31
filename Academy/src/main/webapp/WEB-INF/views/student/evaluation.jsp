<%@page import="com.tenco.model.temp.EvaluationQuestionDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" >
<title>Insert title here</title>
</head>
<body>
	<h2> 강의 평가 설문 </h2>
	<%
	EvaluationQuestionDTO questions = (EvaluationQuestionDTO)request.getAttribute("questions");
	if (questions != null) {
	%>
    <label>본 평가는 본 학교의 강의 환경 개선에 활용됩니다. <br> 진지한 답변 작성 부탁드립니다. <br> (1). 매우 그렇지 않다. (2). 약간 그렇지 않다. (3). 보통이다. (4). 약간 그렇다. (5). 매우 그렇다 </label>
	
	<h4>강의명 : <%=request.getAttribute("subjectName")%></h4>
	<form action="${pageContext.request.contextPath}/student/uploadAnswer" method="post">
    <table border="1">
        <tr>
        	<th rowspan="2">평가 요소</th>
        	<th rowspan="2">번호</th>
            <th rowspan="2">평가 내용</th>
            <th colspan="5">만족도 평가(배점)</th>
        </tr>

        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td>5</td>
        </tr>
        
        <tr>
        	<td rowspan="2">강의 준비</td>
        	<td>1</td>
        	<td><%=questions.getQuestion1()%></td>
        	<td><input type="radio" id="que1-1" name="que1" value="1"></td>
        	<td><input type="radio" id="que1-2" name="que1" value="2"></td>
        	<td><input type="radio" id="que1-3" name="que1" value="3"></td>
        	<td><input type="radio" id="que1-4" name="que1" value="4"></td>
        	<td><input type="radio" id="que1-5" name="que1" value="5"></td>
        </tr>
        
        <tr>
        	<td>2</td>
        	<td><%=questions.getQuestion2()%></td>
        	<td><input type="radio" id="que2-1" name="que2" value="1"></td>
        	<td><input type="radio" id="que2-2" name="que2" value="2"></td>
        	<td><input type="radio" id="que2-3" name="que2" value="3"></td>
        	<td><input type="radio" id="que2-4" name="que2" value="4"></td>
        	<td><input type="radio" id="que2-5" name="que2" value="5"></td>
        </tr>
        
        <tr>
        	<td rowspan="2">강의 내용</td>
        	<td>3</td>
        	<td><%=questions.getQuestion3()%></td>
        	<td><input type="radio" id="que3-1" name="que3" value="1"></td>
        	<td><input type="radio" id="que3-2" name="que3" value="2"></td>
        	<td><input type="radio" id="que3-3" name="que3" value="3"></td>
        	<td><input type="radio" id="que3-4" name="que3" value="4"></td>
        	<td><input type="radio" id="que3-5" name="que3" value="5"></td>
        </tr>
        
        <tr>
        	<td>4</td>
        	<td><%=questions.getQuestion4()%></td>
        	<td><input type="radio" id="que4-1" name="que4" value="1"></td>
        	<td><input type="radio" id="que4-2" name="que4" value="2"></td>
        	<td><input type="radio" id="que4-3" name="que4" value="3"></td>
        	<td><input type="radio" id="que4-4" name="que4" value="4"></td>
        	<td><input type="radio" id="que4-5" name="que4" value="5"></td>
        </tr>
		
		<tr>
        	<td rowspan="3">강의 태도</td>
        	<td>5</td>
        	<td><%=questions.getQuestion5()%></td>
        	<td><input type="radio" id="que5-1" name="que5" value="1"></td>
        	<td><input type="radio" id="que5-2" name="que5" value="2"></td>
        	<td><input type="radio" id="que5-3" name="que5" value="3"></td>
        	<td><input type="radio" id="que5-4" name="que5" value="4"></td>
        	<td><input type="radio" id="que5-5" name="que5" value="5"></td>
        </tr>
        
        <tr>
        	<td>6</td>
        	<td><%=questions.getQuestion6()%></td>
        	<td><input type="radio" id="que6-1" name="que6" value="1"></td>
        	<td><input type="radio" id="que6-2" name="que6" value="2"></td>
        	<td><input type="radio" id="que6-3" name="que6" value="3"></td>
        	<td><input type="radio" id="que6-4" name="que6" value="4"></td>
        	<td><input type="radio" id="que6-5" name="que6" value="5"></td>
        </tr>
        
        <tr>
        	<td>7</td>
        	<td><%=questions.getQuestion7()%></td>
        	<td><input type="radio" id="que7-1" name="que7" value="1"></td>
        	<td><input type="radio" id="que7-2" name="que7" value="2"></td>
        	<td><input type="radio" id="que7-3" name="que7" value="3"></td>
        	<td><input type="radio" id="que7-4" name="que7" value="4"></td>
        	<td><input type="radio" id="que7-5" name="que7" value="5"></td>
        </tr>
        
        <tr>
        	<td rowspan="3">학습 평가</td>
        	<td>8</td>
        	<td><%=questions.getQuestion8()%></td>
        	<td><input type="radio" id="que8-1" name="que8" value="1"></td>
        	<td><input type="radio" id="que8-2" name="que8" value="2"></td>
        	<td><input type="radio" id="que8-3" name="que8" value="3"></td>
        	<td><input type="radio" id="que8-4" name="que8" value="4"></td>
        	<td><input type="radio" id="que8-5" name="que8" value="5"></td>
        </tr>
        
        <tr>
        	<td>9</td>
        	<td><%=questions.getQuestion9()%></td>
        	<td><input type="radio" id="que9-1" name="que9" value="1"></td>
        	<td><input type="radio" id="que9-2" name="que9" value="2"></td>
        	<td><input type="radio" id="que9-3" name="que9" value="3"></td>
        	<td><input type="radio" id="que9-4" name="que9" value="4"></td>
        	<td><input type="radio" id="que9-5" name="que9" value="5"></td>
        </tr>
        
        <tr>
        	<td>10</td>
        	<td><%=questions.getQuestion10()%></td>
        	<td><input type="radio" id="que10-1" name="que10" value="1"></td>
        	<td><input type="radio" id="que10-2" name="que10" value="2"></td>
        	<td><input type="radio" id="que10-3" name="que10" value="3"></td>
        	<td><input type="radio" id="que10-4" name="que10" value="4"></td>
        	<td><input type="radio" id="que10-5" name="que10" value="5"></td>
        </tr>
        

    </table>
    <%}%>
  
    <input type="hidden" name="subjectId"
	value="<%=request.getAttribute("subjectId")%>">
    
    <p>건의사항 - 강의에 대한 건의사항이 있다면 자유롭게 써 주세요</p>
    <textarea name="Content" rows="10" cols="100">
    </textarea>
    <br> <br>
    <button type="submit">제출하기</button>
    <a href="${pageContext.request.contextPath}/WEB-INF/views/Home.jsp">홈 화면으로 돌아가기</a>
    
    </form>
</body>
</html>