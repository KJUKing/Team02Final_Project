<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<table class="table table-bordered">
    <thead>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
    </tr>
    </thead>
    <tbody>
    <!-- 공지사항 리스트 데이터 반복 -->
    <c:choose>
        <c:when test="${not empty noticeList}">
            <c:forEach items="${noticeList}" var="notice">
                <tr>
                    <td>${notice.noticeNo}</td>
                    <td>
                        <c:url value="/${companyId}/notice/${notice.noticeNo}" var="detailUrl" />
                        <a href="${detailUrl}" class="notice-link">${notice.noticeName}</a>
                    </td>
                    <td>${notice.empId}</td>
                    <td>
                        <fmt:formatDate value="${notice.noticeDate}" pattern="yyyy-MM-dd" />
                    </td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <!-- 공지사항이 없는 경우 -->
            <tr>
                <td colspan="4">등록된 공지사항이 없습니다.</td>
            </tr>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>

<!-- 검색창 -->
<div class="search-bar">
    <form action="${pageContext.request.contextPath}/${companyId}/notice" method="get" class="form-inline">
        <select name="stype" class="form-control">
            <option value="title" ${param.stype == 'title' ? 'selected' : ''}>제목</option>
            <option value="content" ${param.stype == 'content' ? 'selected' : ''}>내용</option>
            <option value="title_content" ${param.stype == 'title_content' ? 'selected' : ''}>제목+내용</option>
            <option value="writer" ${param.stype == 'writer' ? 'selected' : ''}>작성자</option>
        </select>
        <input type="text" name="sword" value="${param.sword}" placeholder="검색어 입력" class="form-control">
        <button type="submit" class="btn btn-primary">검색</button>
    </form>
</div>

<!-- 공지사항 글쓰기 버튼 (주석 처리) -->

<div class="write-btn">
<a href="${pageContext.request.contextPath}/${companyId}/notice/new" class="btn btn-success">글쓰기</a>
</div>

<!-- 페이지네이션 -->
<div class="paging-area">
    ${pagingHTML}
</div>


