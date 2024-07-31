<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 결과</title>
</head>
<body>
	<h1>구구단 결과</h1>
	<% 
		String sessionId = session.getId();
		out.print("sessionId : " + sessionId);
		
		String numberStr = request.getParameter("number");
		int number = Integer.parseInt(numberStr); // 예외 처리 생략 
		
	%>	
	<h2> <%=number %> 단</h2>
	
	<table border="1">
		<thead>
			<tr>
				<th>계산식</th>
				<th>결과</th>
			</tr>
		</thead>
		<tbody>
			<% for(int i = 1; i <= 9; i++) { %>
			<tr>
				<td><%=number %> x <%= i %> </td>
				<td><%=number * i %></td>
			</tr>				
			<%} %>				
		</tbody>
		<tfoot></tfoot>	
	</table>
</body>
</html>