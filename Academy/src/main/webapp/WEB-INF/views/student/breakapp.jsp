<%@page import="com.tenco.model.student.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ include file="../main_head.jsp" %>
 
<h1>휴학 신청 페이지 입니다.</h1>


 
<% StudentDTO student = (StudentDTO)session.getAttribute("studentDTO"); %>

<div>
	<div>
 	
 	<h1>휴학 신청</h1>
 	<form action="${pageContext.request.contextPath}/student/breakPost" method="post">
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
                    <th>소속</th>
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
                
                <tr>
                    <th>기간</th>
                    <td> 
                    <p> 
                    <input type="text" readonly name="year0" value="2023">년
                     <input type="text" readonly name="semester0" value="1">학기
                    부터 <select id="year" name="year">
										 <option value="2023">2023</option>
									     <option value="2024">2024</option>
									     <option value="2025">2025</option>
									     </select> 
									     
					 </p>년도 <select id="semester" name="semester">
										 <option value="1">1</option>
									     <option value="2">2</option>
									     </select> 학기 까지
                    </td>
                    
                    <th>휴학구분</th>
                    <td>
                    
              
                     
                    <select id = "bre" name ="bre">
                    
                    	<option value="일반휴학">일반휴학</option>
                    	<option value="육아휴학">육아휴학</option>
                    	<option value="질병휴학">질병휴학</option>
                    	<option value="창업휴학">창업휴학</option>
                    	<option value="군입대휴학">군입대휴학</option>
                    </select>
                    

                </tr>
                
            </table>
            <button type="submit">신청하기</button>
        <!--   <button type="button" 
            onclick="location.href='/Academy/user/update?id=<%= student.getId()%>'" class="btn btn-dark update--button">수정하기</button>
 		-->  
 	</form>
 	</div>
	
	
</div>


<%@ include file="../main_footer.jsp"%>