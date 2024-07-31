<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		out.println("ResultSet.jsp 파일 입니다.");
	%>
	
	<h1> 사용자 목록</h1>
	<table border="1">사용자 목록
		<thead>
			<tr>
				<th>ID</th>
				<th>이름</th>
				<th>이메일</th>
			</tr>
		</thead>
		
		<tbody>
			<%
				List<Map<String, String>> userList
					= (List<Map<String, String>>)request.getAttribute("userList");
				
				if(userList != null) {
					
					for(Map<String, String> userMap : userList){ %>
						
						<tr>
							<td> <%= userMap.get("id") %></td>
							<td> <%= userMap.get("name") %> </td>
							<td> <%= userMap.get("email") %></td>
						</tr>
						
				<% }
					
				} else { %>
					<p>등록된 사용자가 없네요.</p>
			<%
				}	
			%>		
		</tbody>
	</table>
	
</body>
</html>