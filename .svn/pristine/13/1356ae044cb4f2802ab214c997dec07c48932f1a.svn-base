<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Work2gether Login</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/employee/employeeLoginForm.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/lib/sweetalert2.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/lib/bootstrap-5.0.2-dist/css/bootstrap.min.css" />
<!-- Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@300;400;500;600;700&display=swap" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/resources/lib/sweetalert2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
</head>

<body data-contextPath="${pageContext.request.contextPath}">
	<c:if test="${not empty message}">
		<script>
			Swal.mixin({
			    toast: true,
			    position: 'top',
			    showConfirmButton: false,
			    timer: 3000,
			    timerProgressBar: true,
			    
			    // 알림 열렸을 때 실행되는 콜백함수
			    // toast 인자로 알림 DOM 요소 접근
			    didOpen: (toast) => {
			    	// 토스트에 마우스를 올렸을 때 타이머 멈추는 이벤트(알림이 안 닫힘)
			        toast.addEventListener('mouseenter', Swal.stopTimer)
			        // 토스트에 마우스 치우면 타이머 진행 이벤트
			        toast.addEventListener('mouseleave', Swal.resumeTimer)
			    }
			}).fire({
			    icon: 'error',
			    title: `${message}`
			})
		</script>
	</c:if>
	<div class="main-div">
		<div class="logo">
			<img id="logoImg" alt="logo"
				src="${pageContext.request.contextPath}/resources/sneat-1.0.0/assets/img/layouts/logo.png" />
		</div>
		<form method="post">
			<div class="form-group">
				<div class="input-area">
					<input type="text" placeholder="이메일을 입력해주세요." name="accountMail" />
					<input type="password" placeholder="비밀번호를 입력해주세요."
						name="accountPass" />
				</div>
				<div class="button-area">
					<button type="submit">LOGIN</button>
				</div>
			</div>
		</form>
		<div class="links">
			<a href="javascript:void(0);" onclick="openFindPassModal();">비밀번호
				찾기</a> | <a href="javascript:void(0);" onclick="openJoinModal();">회원가입</a>
		</div>
	</div>

	<!-- 비밀번호 확인 모달 -->
	<div class="modal fade" id="passFindModal" tabindex="-1"
		aria-labelledby="joinModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="joinModalLabel">비밀번호 찾기</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<form id="find-modal-form" method="get">
					<div class="modal-body">
						<input type="text" name="empName" placeholder="이름을 입력해주세요."
							class="form-control" /> <input type="text" name="empEmail"
							placeholder="이메일을 입력해주세요." class="form-control" /> <input
							type="text" name="empPhone" placeholder="핸드폰 번호를 입력해주세요."
							class="form-control" />
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
	<div class="modal fade" id="joinModal" tabindex="-1"
		aria-labelledby="joinModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="joinModalLabel">회원가입 이메일 확인</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<c:set value="" var="companyId" />
				<form id="join-modal-form" method="get">
					<div class="modal-body">
						<input type="text" name="accountMail" placeholder="이메일을 입력해주세요."
							class="form-control" />
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
	
	<!-- 문자인증모달 -->
	<div class="modal fade" id="smsModal" tabindex="-1"
		aria-labelledby="smsModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="smsModalLabel">문자 인증</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<c:set value="" var="companyId" />
				<div class="modal-body">
					<form id="sms-modal-form" method="get">
							<input type="text" name="accountMail" placeholder="이메일을 입력해주세요." class="form-control" />
							<input type="text" name="empName" placeholder="이름을 입력해주세요." class="form-control" />
							<input type="text" name="empPhone" placeholder="핸드폰 번호를 입력해주세요." class="form-control" />
							
							<button type="submit">문자전송</button>
					</form>
					<form id="sms-modal-form" method="get">
							<input type="text" placeholder="인증번호를 입력해주세요."/>
							<button type="submit">인증번호 확인</button>
					</form>
				</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">닫기</button>
						<button type="submit" class="btn btn-primary">확인</button>
					</div>
<!-- 				</form> -->
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/employeeLoginForm.js"></script>

</body>
</html>
