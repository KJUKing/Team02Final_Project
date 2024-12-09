<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="card container">
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<td colspan="4">
						<div class="search-area" data-pg-target="#searchform" data-pg-name="fnPaging">
							<form:select path="condition.searchType">
								<form:option value="" label="전체"/>
								<form:option value="title" label="제목"/>
								<form:option value="writer" label="작성자"/>
							</form:select>
							<form:input path="condition.searchWord"/>
							<button class="search-btn">검색</button>
						</div>
					</td>
					<td>
						<button type="button" class="btn btn-primary me-2" id="questionWrite" data-lc-add="${pageContext.request.contextPath}/${companyId}/question/new">
						  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
							  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
							  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
							</svg> 문의 작성
						</button>
					</td>
				</tr>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>답변여부</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty QuestionList}">
					<c:forEach items="${QuestionList }" var="question">
						<tr>
						<td>${question.rnum}</td>
							<td>
								<a href='<c:url value="/${companyId}/question/${question.quNo}"/>'>${question.quTitle }</a>
							</td>
							<td>${question.questionId }</td>
							<td>${question.quDate }</td>
							<c:choose>
								<c:when test="${question.quYn eq 'Y' }">
									<td><span class="badge bg-label-success me-1">답변완료</span></td>
								</c:when>
								<c:otherwise>
									 <td><span class="badge bg-label-warning me-1">답변대기중</span></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
				<tr>
					<td colspan="5">
						<div class="paging-area">
							${pagingHTML }
						</div>
					</td>
				</tr>
		</table>
		<form:form id="searchform" method="get" modelAttribute="condition">
			<form:input path="searchType"/>
			<form:input path="searchWord"/>
			<input type="hidden" name="page"/>
		</form:form>
	</div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/app/utils/paging.js"></script>
