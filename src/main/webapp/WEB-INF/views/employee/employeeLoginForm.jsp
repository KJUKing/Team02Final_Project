<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Work2gether Login</title>
<%@include file="employeePreScript.jsp" %>
</head>

<body id="login-body" data-contextPath="${pageContext.request.contextPath}">
	<%@include file="employeeMessageSwal.jsp" %>
	<div class="main-div">
		<div class="logo">
			<img id="logoImg" alt="logo" src="${pageContext.request.contextPath}/resources/sneat-1.0.0/assets/img/layouts/logo.png" />
		</div>
		<form method="post">
			<div class="form-group">
				<div class="input-area">
					<input type="text" placeholder="이메일을 입력해주세요." name="accountMail" />
					<input type="password" placeholder="비밀번호를 입력해주세요." name="accountPass" />
				</div>
				<div class="button-area">
					<button type="submit">LOGIN</button>
				</div>
			</div>
		</form>
		<div class="links">
			<a href="javascript:void(0);" onclick="openFindPassModal();">비밀번호 찾기</a>
			 | 
			<a href="javascript:void(0);" onclick="openJoinModal();">회원가입</a>
		</div>
	</div>

	<!-- 비밀번호 확인 모달 -->
	<div class="modal fade" id="passFindModal" tabindex="-1" aria-labelledby="joinModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="joinModalLabel">비밀번호 찾기</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<form id="find-modal-form" method="get">
					<div class="modal-body">
						<input type="text" name="empName" placeholder="이름을 입력해주세요." class="form-control" />
						<input type="text" name="empMail" placeholder="이메일을 입력해주세요." class="form-control" />
						<input type="text" name="empPhone" placeholder="핸드폰 번호를 입력해주세요." class="form-control" />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">닫기</button>
						<button type="submit" class="btn btn-primary">확인</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- 회원가입모달 -->
	<div class="modal fade" id="joinModal" tabindex="-1" aria-labelledby="joinModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="joinModalLabel">회원가입 이메일 확인</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<form id="join-modal-form" method="get">
					<div class="modal-body">
						<input type="text" name="accountMail" placeholder="이메일을 입력해주세요." class="form-control" />
						<input type="password" name="accountPass" placeholder="비밀번호를 입력해주세요." class="form-control" />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">닫기</button>
						<button type="submit" class="btn btn-primary">확인</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/employee/employeeLoginForm.js"></script>

</body>
</html>
