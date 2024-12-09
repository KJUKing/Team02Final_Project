<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
                    <td>${notice.noticeDate}</td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="4">등록된 공지사항이 없습니다.</td>
            </tr>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>

<!-- 권한 글쓰기 버튼 -->
<%--<c:if test="${sessionScope.user.role == 'admin'}">--%>
<%--    <div class="text-right mt-3">--%>
<%--        <c:url value="/${companyId}/notice/new" var="writeUrl" />--%>
<%--        <a href="${writeUrl}" class="btn btn-primary">글쓰기</a>--%>
<%--    </div>--%>
<%--</c:if>--%>

<!-- 글쓰기 버튼 테스트용 -->
<div class="text-right mt-3">
    <c:url value="/${companyId}/notice/new" var="writeUrl" />
    <a href="${writeUrl}" class="btn btn-primary">글쓰기</a>
</div>


<!-- 페이지네이션 -->
<div class="paging-area">
    ${pagingHTML}
</div>
