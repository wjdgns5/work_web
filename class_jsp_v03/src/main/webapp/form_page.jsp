<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	
	<%@ include file="header.jsp" %>
	
	<form action="result.jsp" method="POST">
		<label for="cm"></label>
		<input type="text" id="cm" name="cm" required="required">
		<button type="submit">서버로 제출</button>
	</form>
	
	<%@ include file="footer.jsp" %>
