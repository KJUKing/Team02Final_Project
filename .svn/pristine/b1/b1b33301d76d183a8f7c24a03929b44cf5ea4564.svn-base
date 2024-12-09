<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card container">
	<div class="table-responsive">
		<button type="button" class="btn btn-primary">목록</button>
		<table class="table">
			<tr>
				<th>문의게시판 번호</th>
				<td>${question.quNo}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${question.questionId}</td>
			</tr>
			<tr>
				<th>문의 제목</th>
				<td>${question.quTitle}</td>
			</tr>
			<tr>
				<th>파일</th>
				<td>
					<c:choose>
						<c:when test="${not empty question.atchFile }">
							<c:forEach items="${question.atchFile.fileDetails }" var="fd" varStatus="vs">
								<c:url value='/${companyId}/question/${question.quNo}/atch/${fd.atchFileId }/${fd.fileSn }' var="downUrl"/>
								<a href="${downUrl }">${fd.orignlFileNm }(${fd.fileFancysize })</a>
								${not vs.last ? '|' : ''}
							</c:forEach>
						</c:when>
						<c:otherwise>
							파일이 등록되지 않았습니다.
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th>문의게시판 내용</th>
				<td>${question.quContent}</td>
			</tr>
			<tr>
				<th>작성날짜</th>
				<td>${question.quDate}</td>
			</tr>
			<c:choose>
				<c:when test="${question.quYn eq 'Y' }">
					<tr>
						<th>운영자(답변작성자)</th>
						<td>${question.answerId}</td>
					</tr>
					<tr>
						<th>답변날짜</th>
						<td>${question.answDate}</td>
					</tr>
					<tr>
						<th>답변 내용</th>
						<td>${question.answContent}</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<th>운영자 답변</th>
						<td>아직 답변이 등록되지 않았습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="2">
					<button type="button" class="btn btn-primary" id="editBtn"
					 data-src-path="${pageContext.request.contextPath}/${companyId}/question/${question.quNo }/edit">수정</button>
					<button type="button" class="btn btn-secondary" id="delBtn"
					data-del-path="${pageContext.request.contextPath}/${companyId}/question/${question.quNo}">삭제</button>
				</td>
			</tr>
		</table>
	</div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/app/question/questionDetail.js"></script>