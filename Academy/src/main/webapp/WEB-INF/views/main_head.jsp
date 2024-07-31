<%@page import="com.tenco.model.user.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="../resource/style.css" rel="stylesheet" type="text/css">

</head>
<body>
	<header>
				
			
			<% UserDTO userDTO= (UserDTO) request.getSession().getAttribute("verifiedUser");%>
			
			<p></p>
			 <!-- <P><%=userDTO.getName() %> </P> -->
			<a href="${pageContext.request.contextPath}/user/home"> <img alt="로고" src="../resource/favicon.ico"> </a>
			<!-- permissionLevel (학생, 교수, 직원)에 따라 홈페이지의 헤더 부분의 카테고리의 내용이 달라진다. -->
				
			<c:if test="${verifiedUser.permissionLevel == 1}"> 
				<!-- 학생 카테고리 6-->
				<h2> <a href="${pageContext.request.contextPath}/user/home">홈@</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/user/myInfo">My</a> </h2>
<<<<<<< HEAD

				<h2> <a href="${pageContext.request.contextPath}/test/subjectList">수업</a> </h2>

				<h2> <a href="${pageContext.request.contextPath}/student/subjectList">수강신청</a> </h2>

				<h2> <a href="${pageContext.request.contextPath}/@@@@/Semester">학사정보</a> </h2>
			</c:if>
			
			<c:if test="${verifiedUser.permissionLevel == 2}">
				<!-- 교수 카테고리   -->
				<h2> <a href="${pageContext.request.contextPath}/professor/123123"></a> </h2>

				<h2> <a href="${pageContext.request.contextPath}/professor/goinputpage">수업</a> </h2>

				<h2> <a href="${pageContext.request.contextPath}/professor/clickERMenu">강의 평가 조회</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/professor/goinputpage">학생 성적 관리</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/professor/restclassmanagement">휴/보강 관리</a> </h2>

=======
				<h2> <a href="${pageContext.request.contextPath}/test/subjectList">수업</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/student/subjectList">수강신청</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/student/restClassList">휴/보강 조회</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/@@@@/Semester">성적</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/@@@@/Semester">학사정보</a> </h2>
			</c:if>
			
			
			<c:if test="${verifiedUser.permissionLevel == 2}">
				<!-- 교수 카테고리   -->
				<h2> <a href="${pageContext.request.contextPath}/professor/123123"></a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/professor/goinputpage">수업</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/professor/clickERMenu">강의 평가 조회</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/professor/goinputpage">학생 성적 관리</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/professor/restclassmanagement">휴/보강 관리</a> </h2>
>>>>>>> 89716ad88387574891788f81d6fc41b1af9d99a5
			</c:if>
			
			<c:if test="${verifiedUser.permissionLevel == 3}">
				<!-- 관리직 카테고리   5-->
				<h2> <a href="${pageContext.request.contextPath}/user/home">홈@</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/test/My">My</a> </h2>
			    <div class="dropdown">
			        <button class="dropbtn">관리</button>
			        <div class="dropdown-content">
			            <a href="${pageContext.request.contextPath}/staff/tuition">등록금</a>
			            <a href="${pageContext.request.contextPath}/staff/scholarship">장학금</a>
						<a href="${pageContext.request.contextPath}/staff/subjectList">학사관리</a> 
			        </div>
			    </div>
			    <div class="dropdown">
			        <button class="dropbtn">등록</button>
			        <div class="dropdown-content">
			            <a href="${pageContext.request.contextPath}/staff/registPro">교수</a>
			            <a href="${pageContext.request.contextPath}/staff/registStaff">직원</a>
			            <a href="${pageContext.request.contextPath}/staff/registStu">학생</a>
			        </div>
			    </div>
				<h2> <a href="${pageContext.request.contextPath}/test/notice">학사정보</a> </h2>
			</c:if>
			
			
			<c:if test="@@">
				<!-- 혹시 위에서 없어지면 여기서 가져오면 된다.(백업용) -->
			<h2> <a href="${pageContext.request.contextPath}/test/home">홈@</a> </h2>
			<h2> <a href="${pageContext.request.contextPath}/test/My">My@</a> </h2>
			<h2> <a href="${pageContext.request.contextPath}/test/subjectList">수강신청@</a> </h2>
			<h2> <a href="${pageContext.request.contextPath}/test/Semester">성적@</a> </h2>
			<h2> <a href="${pageContext.request.contextPath}/test/notice">학사정보@</a> </h2>
			</c:if>
			
			<nav>
				<ul>
					<li> <%=userDTO.getId()%> <%=userDTO.getName()%> </li>
					<!--  TODO- 로그아웃 userController에 get 영역에 만들어야 한다. -->
					<li> <a href="${pageContext.request.contextPath}/user/logout">로그아웃</a> </li>
				</ul>
			</nav>
		
	</header>
	