<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ include file="../main_head.jsp" %>
 

 <div class="studentEvaluation-inner">
 	
 	<div style="flex-grow: 1; ">
 	<table border="1">
 		<tr>
 			<td>전체 강의 조회</td>
		</tr>
 		<tr>
 			<td>내 강의 조회</td>
		</tr>
		<tr>
 			<td>내 강의 평가</td>
		</tr>
 	</table>
 	</div>
<div style="flex-grow: 1"></div>

<div style="flex-grow: 1">
	<h2>강의평가 수강과목 조회</h2>
	<form action="${pageContext.request.contextPath}/user/readmysubject" method="GET">
		<select id="year" name="year">
			<option value="2014">2014</option>
			<option value="2015">2015</option>
			<option value="2016">2016</option>
			<option value="2017">2017</option>
			<option value="2018">2018</option>
			<option value="2019">2019</option>
			<option value="2020">2020</option>
			<option value="2021">2021</option>
			<option value="2022">2022</option>
			<option value="2023">2023</option>
			<option value="2024">2024</option>
		</select> 
		<select id="semester" name="semester">
			<option value="1">1학기</option>
			<option value="2">2학기</option>
		</select>
		<input type="text"id="studentId" name="studentId" placeholder="학번을 입력하시오.">
		<button type="submit">조회</button>
	</form>
	<br>
	<br>
	<a href="${pageContext.request.contextPath}/views/home.jsp">홈으로 돌아가기</a>
</div>

</div><!-- flex row 끝지점 -->

<%@ include file="../main_footer.jsp"%>