<%@page import="com.tenco.model.student.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ include file="main_head.jsp" %>
 
 <div class="myInfoMainDiv">
 
 	<div style="flex-direction: row;">
 		
 		<div>
 		<h2>MY</h2>
 		</div>
 

 
 		<div >
 		
 		<div class="sub--menu--mid">
            <table class="sub--menu--table" border="1">
                <tr>
                    <td><a href="/Academy/user/myInfo" class="selected--menu">내 정보 조회</a></td>
                </tr>
                
                <tr>
                    <td><a href="/Academy/student/breakApp">휴학 신청</a></td>
                </tr>
                <tr>
                    <td><a href="/Academy/student/breakSearch">휴학 내역 조회</a></td>
                </tr>
                <tr>
                    <td><a href="/tuition/list">등록금 내역 조회</a></td>
                </tr>
                <tr>
                    <td><a href="/tuition/payment">등록금 납부 고지서</a></td>
                </tr>
            </table>
        </div>
		
        </div>
        
        
 		
 	<% StudentDTO student = (StudentDTO)request.getAttribute("studentDTO"); %>	
 		
 	</div>
 	
 	<!-- ----------------------------------- -->
 	
 	<div>
 	
 	<h1>내 정보 조회</h1>
        <div class="split--div"></div>
            <table border="1" class="input--table" >
            <colgroup>
                <col class="col1">
                <col class="col2">
                <col class="col3">
                <col class="col4">
            </colgroup>
                <tr>
                    <th>학번</th>
                    <td> <%= student.getId() %> </td>
                    <th>소속 student.collegeName</th>
                    <td><%= student.getD_name() %></td>
                </tr>
                <tr>
                    <th>학년</th>
                    <td><%= student.getGrade() %></td>
                    <th>학기</th>
                    <td><%= student.getSemester() %></td>
                </tr>
                <tr>
                    <th>입학일</th>
                    <td><%= student.getEntrance_date() %></td>
                    <th>졸업일(졸업예정일)</th>
                    <!-- 학생 졸업날짜가 null 값이라면 빈 공간을 출력 아니라면 졸업날짜 출력  -->
                    <td><%= student.getGraduation_date() == null ? "" : student.getGraduation_date() %></td>
                </tr>
            </table>
            <table border="1" class="input--table" >
            <colgroup>
                <col class="col1">
                <col class="col2">
                <col class="col3">
                <col class="col4">
            </colgroup>
                <tr>
                    <th>성명</th>
                    <td><%= student.getName() %></td>
                    <th>생년월일</th>
                    <td><%= student.getBirth_date() %></td>
                </tr>
                <tr>
                    <th>성별</th>
                    <td><%= student.getGender() %></td>
                    <th>주소</th>
                    <td><%= student.getAddress() %></td>
                </tr>
                <tr>
                    <th>연락처</th>
                    <td><%= student.getTel() %></td>
                    <th>email</th>
                    <td><%= student.getEmail() %></td>
                </tr>
            </table>
            <input type="button">
            <button type="button" 
            onclick="location.href='/Academy/user/update?id=<%= student.getId()%>'" class="btn btn-dark update--button">수정하기</button>
 	
 	</div>
 	
 	
 </div>

<%@ include file="main_footer.jsp"%>