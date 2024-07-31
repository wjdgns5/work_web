<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <%@ include file="../main_head.jsp" %>

<style>
.split--div {
	margin: 20px 0 20px;
}
.table--container {
	width: 500px;
	border: 1px solid #D2D1D1;
	border-width: 1px 0px;
	margin-top: 50px;
}
.first--tr {
	background-color: #f7f6f6;
	height: 30px;
	font-weight: bolder;
}
table tr, td {
	border: 1px solid #D2D1D1;
	border-width: 1px 0px;
	padding: 5px 15px;
}
.button {
	background-color: #023268;
	border-radius: 5px;
	color: #fff;
	text-decoration: none;
	margin: 5px;
	padding: 3px;
}
input[type="submit"]{
	background-color: #023268;
	border-radius: 5px;
	border: hidden;
	color: #fff;
	text-decoration: none;
	margin: 5px;
	padding: 3px;
}
.button:hover {
	color: #fff;

}
.select--button {
	margin-bottom: 30px;
}

.input--box {
	border: 1px solid #D2D1D1;
	border-radius: 3px;
	height: 35px;
	margin-right: 20px;
	padding: 5px;
}
.form--container {
	margin-top: 30px;
}
.delete {
	font-weight: bold;
}
.button--container {
	margin-left: 200px;
}
</style>

<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start" style="min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>학사관리</h2>
		</div>
		<!-- 메뉴 -->
		<!-- 선택된 메뉴에 class="selected--menu" 추가해주세요 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/user/studentList">학생 명단 조회</a></td>
				</tr>
				<tr>
					<td><a href="/user/professorList">교수 명단 조회</a></td>
				</tr>
				<tr>
					<td><a href="/user/student">학생 등록</a></td>
				</tr>
				<tr>
					<td><a href="/user/professor">교수 등록</a></td>
				</tr>
				<tr>
					<td><a href="/user/staff" class="selected--menu">직원 등록</a></td>
				</tr>
				<tr>
					<td><a href="/tuition/bill">등록금 고지서 발송</a></td>
				</tr>
				<tr>
					<td><a href="/break/list/staff">휴학 처리</a></td>
				</tr>
				<tr>
					<td><a href="/sugang/period">수강 신청 기간 설정</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>학생 등록</h1>
		<div class="split--div"></div>
		<form action="${pageContext.request.contextPath}/staff/registStu" method="post">
			<table class="table--container">
				<tr>
					<td><label for="name">이름</label></td>
					<td><input type="text" name="name" id="name" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="birthDate">생년월일</label></td>
					<td><input type="date" name="birthDate" id="birthDate" class="input--box"></td>
				</tr>
				<tr>
					<td style="padding-top: 7px"><label>성별</label></td>
					<td style="padding-top: 7px"><label for="male">남성</label> 
					<input type="radio" value="남성" name="gender" id="male" checked="checked"> &nbsp;
					<label for="female">여성</label> 
					<input type="radio" value="여성" name="gender" id="female"></td>
				</tr>
				<tr>
					<td><label for="address">주소</label></td>
					<td><input type="text" name="address" id="address" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="tel">전화번호</label></td>
					<td><input type="text" name="tel" id="tel" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="email">이메일</label></td>
					<td><input type="text" name="email" id="email" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="deptId">과 ID</label></td>
					<td><input type="text" name="deptId" id="deptId" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="entranceDate">입학일</label></td>
					<td><input type="text" name="entranceDate" id="entranceDate" class="input--box" value="2024-03-02"></td>
				</tr>
				<tr>
					<td><label for="password">비밀번호</label></td>
					<td><input type="text" name="password" id="password" class="input--box"></td>
					
				</tr>
			</table>
			<div class="button--container">
				<input type="submit" value="입력">
			</div>
		</form>
	</main>
</div>

<%@ include file="../main_footer.jsp"%>