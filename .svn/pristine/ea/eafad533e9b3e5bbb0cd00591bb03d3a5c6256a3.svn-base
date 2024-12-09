<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<form:form id="updateForm" method="post" enctype="multipart/form-data" modelAttribute="targetNotice">
    <table>
        <tr>
            <th>공지 번호</th>
            <td><form:input type="text" path="noticeNo" cssClass="form-control" readonly="true" />
                <form:errors path="noticeNo" cssClass="text-danger" /></td>
        </tr>
        <tr>
            <th>공지 제목</th>
            <td><form:input type="text" path="noticeName" required="required" cssClass="form-control" />
                <form:errors path="noticeName" cssClass="text-danger" /></td>
        </tr>
        <tr>
            <th>기존 파일</th>
            <td>
                <c:forEach items="${targetNotice.atchFile.fileDetails}" var="fd" varStatus="vs">
                    <span>
                        ${fd.orignlFileNm} [${fd.fileFancysize}]
                        <a data-atch-file-id="${fd.atchFileId}" data-file-sn="${fd.fileSn}" class="btn btn-danger" href="javascript:;">
                            삭제
                        </a>
                        ${not vs.last ? '|' : ''}
                    </span>
                </c:forEach>
            </td>
        </tr>
        <tr>
            <th>새 파일 업로드</th>
            <td>
                <input type="file" name="uploadFiles" multiple class="form-control" />
            </td>
        </tr>
        <tr>
            <th>공지 내용</th>
            <td>
                <form:textarea path="noticeContent" class="tinymce-editor" />
                <form:errors path="noticeContent" cssClass="text-danger" />
            </td>
        </tr>
        <tr>
            <th>중요 여부</th>
            <td>
                <form:input type="text" path="noticeImportant" cssClass="form-control" />
                <form:errors path="noticeImportant" cssClass="text-danger" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="수정" class="btn btn-primary" />
<%--                <input type="button" value="삭제" class="btn btn-danger" id="delBtn" />--%>
            </td>
        </tr>
    </table>
</form:form>

<!-- 삭제 폼 -->
<form action="<c:url value='/notice/${targetNotice.noticeNo}' />" method="post" id="deleteForm">
    <input type="hidden" name="_method" required value="delete" />
</form>

<script>
    const contextPath = "${pageContext.request.contextPath}";
    const companyId = "${companyId}";
    const noticeNo = "${targetNotice.noticeNo}";
</script>


<!-- JavaScript 파일 연결 -->
<script src="${pageContext.request.contextPath}/resources/js/app/notice/noticeEdit.js"></script>
