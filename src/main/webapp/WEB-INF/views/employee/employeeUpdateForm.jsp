<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
#password-guide{
	font-size: 12px;
	margin-top: 2px;
	margin-bottom: 2px;
}

.join-main-div{
	background-color: white;
	border-radius: 8px;
	padding : 20px;
}

#google-oauth-area{
	margin-bottom: 10px;
}

.col-md-2{
/* 	padding-top : 13px; */
/* 	padding-bottom : 13px; */
}

.col-md-10{
	padding-top : 13px;
	padding-bottom : 13px;
}
</style>
</head>
<body>
	<div class="join-main-div">
	<h4>개인정보수정</h4>
		<div id="google-oauth-area">
			<c:if test="${empty sessionScope.myOAuth}">
				<a class="google-oauth-a" href="${pageContext.request.contextPath}/google-oauth">
					<img id="googleImg" alt="google-logo" src="${pageContext.request.contextPath}/resources/images/google-logo.png" />
					<span id="googleInfo">구글 계정 인증하기</span>
				</a>
				<p id="google-oauth-introduction">사내 관리자를 통해 등록한 이메일 계정을 사용해주세요. 다른 계정 사용시 오류가 발생할 수 있습니다.</p>
			</c:if>
			<c:if test="${not empty sessionScope.myOAuth}">
				<img id="googleImg" alt="google-logo" src="${pageContext.request.contextPath}/resources/images/google-logo.png" />
				<span id="googleInfo"> 구글 계정 인증완료 </span>
			</c:if>
		</div>

		<form:form id="joinForm" method="post" modelAttribute="myEmp" enctype="multipart/form-data">
			<table>
				<tr>
					<td>이메일</td>
					<td>
						<form:input path="empMail" class="form-control" disabled="true"/>
						<form:errors path="empMail" cssClass="text-danger"/>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<form:input type="password" path="empPass" class="form-control"/>
						<form:errors path="empPass" cssClass="text-danger"/>
					</td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td>
						<input type="password" id="empPasscheck" class="form-control"/>
						<p id="password-guide">　</p>
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
						<form:input path="empName" class="form-control" disabled="true"/>
						<form:errors path="empName" cssClass="text-danger"/>
					</td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td>
						<form:input path="empBirth" class="form-control"/>
						<form:errors path="empBirth" cssClass="text-danger"/>
					</td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<div class="form-check form-check-inline">
						<form:radiobutton path="empGender" value="남"
							class="form-check-input" id="empGenderMale" />
						<label class="form-check-label" for="empGenderMale">남</label>
					</div>
					<div class="form-check form-check-inline">
						<form:radiobutton path="empGender" value="여"
							class="form-check-input" id="empGenderFemale" />
						<label class="form-check-label" for="empGenderFemale">여</label>
					</div>
					<form:errors path="empGender" cssClass="text-danger" />
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<form:input path="empAddr1" id="roadAddress" class="form-control" onclick="getAddrForm()" readonly="true" placeholder="클릭하면 주소 검색창이 열립니다." title="클릭하면 주소 검색창이 열립니다."/>
						<form:errors path="empAddr1" cssClass="text-danger"/>
						<span id="guide" style="color: #999; display: none"></span>
					</td>
				</tr>
				<tr>
					<td>상세주소</td>
					<td>
						<form:input path="empAddr2" id="extraAddress" class="form-control"/>
						<form:errors path="empAddr2" cssClass="text-danger"/>
					</td>
				</tr>
				<tr>
					<td>핸드폰번호</td>
					<td>
						<form:input path="empPhone" class="form-control"/>
						<form:errors path="empPhone" cssClass="text-danger"/>
					</td>
				</tr>
				<tr>
					<td>프로필 이미지</td>
					<td>
						<input type="file" name="empImage" class="form-control" accept="image/*"/>
						<form:errors path="empImage" cssClass="text-danger"/>
					</td>
				</tr>
				<tr>
					<td>도장이미지</td>
					<td>
						<input type="file" name="empSignimage" class="form-control" accept="image/*"/>
						<form:errors path="empSignimage" cssClass="text-danger"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit" class="btn btn-primary">수정</button>
			    		<button type="reset" class="btn btn-warning">취소</button>
					</td>
				</tr>
			</table>

		</form:form>
		
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/employee/employeeJoinForm.js"></script>

	</div>
</body>
</html>