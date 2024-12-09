<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<form:form method="post" action="${pageContext.request.contextPath}/${companyId}/notice/new" enctype="multipart/form-data" modelAttribute="newNotice">


    <table>
        <tr>
            <th>공지 제목</th>
            <td>
                <form:input type="text" path="noticeName" cssClass="form-control"/>
                <form:errors path="noticeName" cssClass="text-danger" />
            </td>
        </tr>
        <tr>
            <th>공지 내용</th>
            <td>
                <form:textarea path="noticeContent" cssClass="form-control" id="noticeContent"/>
                <form:errors path="noticeContent" cssClass="text-danger" />
<%--                <script>--%>
<%--                    document.addEventListener("DOMContentLoaded", () => {--%>
<%--                        tinymce.init({--%>
<%--                            selector: '#noticeContent',--%>
<%--                            plugins: 'image',--%>
<%--                            toolbar: 'image',--%>
<%--                            images_upload_url: '${pageContext.request.contextPath}/notice/upload'--%>
<%--                        });--%>
<%--                    });--%>
<%--                </script>--%>
            </td>
        </tr>
        <tr>
            <th>첨부 파일</th>
            <td>
                <input type="file" name="uploadFiles" multiple class="form-control"/>
            </td>
        </tr>
        <tr>
            <th>중요공지 여부(Y/N)</th>
            <td>
                <form:input type="text" path="noticeImportant" cssClass="form-control"/>
                <form:errors path="noticeImportant" cssClass="text-danger"/>
            </td>
        </tr>
        <!-- 작성자 사원번호(empId)는 세션이나 다른 로직으로 셋팅될 수도 있음 -->
        <tr>
            <td colspan="2">
                <input type="submit" value="전송" class="btn btn-primary"/>
            </td>
        </tr>
    </table>
</form:form>
