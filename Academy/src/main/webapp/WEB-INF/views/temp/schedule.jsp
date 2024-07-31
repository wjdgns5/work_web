<%@page import="com.tenco.model.user.UserDTO"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tenco.model.temp.EnrollDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시간표</title>
<style type="text/css">
   body {
        display: flex;
        flex-direction: column;
        align-items: center;
        font-family: Arial, sans-serif;
    }
    .front {
        margin-top: 20px;
    }
    .information {
        margin: 20px 0;
    }
    .schedule {
        margin: 20px 0;
    }
    table {
        border-collapse: collapse;
        width: 80%;
    }
    th, td {
        border: 1px solid #f0f0f0;
        padding: 8px;
        text-align: center;
    }
    th {
        background-color: #f2f2f2;
    }
    td.empty {
        background-color: red;
    }
</style>
</head>
<body>
		<% List<EnrollDTO> enrollList=(List<EnrollDTO>) request.getAttribute("enrollList"); %>
		<% UserDTO userDTO=(UserDTO) session.getAttribute("verifiedUser"); %>
	    <h1 class="front">대학 수업 시간표</h1>
	    
	<div class="infomation">
		<p>학번/성명</p>
		<input value="<%=enrollList.get(0).getStudentId() %>">
		<input value="<%=userDTO.getName() %>">
	
	<p>테스트</p>
	</div>
	
	
	

	<div class="schedule">
	    <table style="border: 1px solid #f0f0f0">
	            <tr>
	                <th>시간</th>
	                <th>월요일</th>
	                <th>화요일</th>
	                <th>수요일</th>
	                <th>목요일</th>
	                <th>금요일</th>
	            </tr>
	
	      <%String[] timeSelection  ={"","09:00 - 10:00","10:00 - 11:00","11:00 - 12:00","12:00 - 13:00",
	    		  "13:00 - 14:00","14:00 - 15:00","15:00 - 16:00","16:00 - 17:00","17:00 - 18:00"};%>  
	      
	        <%for(int i =1; i <10;i++){%>
	        	<tr style="border: 1px solid #f0f0f0">
	        		  <td><%=timeSelection[i] %></td>
	    	    <%for(int j =1; j <6;j++){ int a = 0;%>
	    	    	
	    	    	<% for (EnrollDTO enroll : enrollList) { %>
			
							<%if(enroll.getDay() == j && enroll.getPeriod() == i) { a = 1;%>
								<td><%=enroll.getSubjectName() %></td>
							<%}else{%>
								
							<%}%>
						
					<%}%>
					<%if(a == 0){ %><td style="background: red;"></td> <%} %>
					
				<%}%>
			<%}%>
	    
	    </table>
	</div>
</body>
</html>