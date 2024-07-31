<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="main_head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="homeMainDiv">

	<div style=" align-items: center;	">
		<img alt="" src="../resource/main_img.png">
	</div>
	
	<div class="homeChildDiv" style="height: 400px">
	
			<div style="flex-grow: 2" class="main-notice">
					<h3><a href="#">공지사항</a></h3>
							<table>
									<c:forEach var="notice" items="${noticeList}">
									<tr>
										<td><a href="#">${notice.category}&nbsp;${notice.title}</a></td>
										<td><fmt:formatDate value="${notice.createdTime}" type="date"/></td>
									</tr>						
	
									</c:forEach>
							</table>
		</div>

		<div style="flex-grow: 2" class="main-schedule">
							<h3><a href="#">학사일정</a></h3>
							<table>
								<c:forEach var="schedule" items="${scheduleList}">
								<tr>
									<td><fmt:formatDate value="${schedule.startDay}" pattern="MM-dd"/>&nbsp;-&nbsp;<fmt:formatDate value="${schedule.endDay}" pattern="MM-dd"/></td>
									<td><a href="#">${schedule.information}</a></td>
								</tr>						
								</c:forEach>
							</table>
		</div>

		<div style="flex-grow: 1">
		
			<!-- 학생  -->
			<c:if test="${verifiedUser.permissionLevel == 1}" >
			<div><p>${verifiedUser.name}님, 환영합니다.</p></div>
			<div><p>이메일: ${studentDTO.email}</p> </div>
			<div><p>소속: ${studentDTO.d_name} </p> </div>
			<div><p>학기: ${studentDTO.grade}</p> </div>
			<div><p>학번: ${studentDTO.u_number}</p></div>
			
			</c:if>
			
			<!--  관리자 -->
			<c:if test="${verifiedUser.permissionLevel == 3}">
			<div><p>${verifiedUser.name}님, 환영합니다.</p></div>
			<div><p>이메일: ${verifiedUser.email}</p> </div>
			<div><p>학번: ${verifiedUser.id}</p></div>
			
			</c:if>
			
			<!-- 교수 -->
			<c:if test="${verifiedUser.permissionLevel == 2}">
			<div><p>${verifiedUser.name}님, 환영합니다.</p></div>
			<div><p>이메일: ${verifiedUser.email}</p> </div>
			<div><p>학번: ${verifiedUser.id}</p></div>
			</c:if>
		
		
			<div>
				<c:if test="${verifiedUser.permissionLevel == 1}">
					<div><button>마이페이지</button></div>
				</c:if>
				<div>
				<a href="${pageContext.request.contextPath}/user/logout"><button>로그아웃</button></a>
				</div>
			</div>
		</div>
		
	
	</div>

</div>

<%@ include file="main_footer.jsp"%>  