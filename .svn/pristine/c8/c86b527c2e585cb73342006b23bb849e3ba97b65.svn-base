<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

<form:form method="post" enctype="multipart/form-data" modelAttribute="room">
    <table class="table table-bordered">
        <tr>
            <th>시설 번호:</th>
            <td>
                <form:input path="roomId" class="form-control" required="true" />
                <form:errors cssClass="text-danger" path="roomId"/>
            </td>
        </tr>
        <tr>
			<th>시설 호수:</th>
			<td>
				<form:input path="roomHosu" class="form-control" />
				<form:errors path="roomHosu" cssClass="text-danger" />
			</td>
		</tr>
        <tr>
            <th>시설 이름:</th>
            <td>
                <form:input path="roomName" cssClass="form-control" required="true"/>
                <form:errors cssClass="text-danger" path="roomName"/>
            </td>
        </tr>
        <tr>
            <th>수용 인원:</th>
            <td>
                <form:input path="roomNum" type="number" cssClass="form-control" />
                <form:errors cssClass="text-danger" path="roomNum"/>
            </td>
        </tr>
        <tr>
            <th>시설 이미지:</th>
            <td>
                <input type="file" name="roomImage" class="form-control" accept="image/*" />
                <form:errors path="roomImage" cssClass="text-danger" />
            </td>
        </tr>
        <tr>
            <th>시설 세부사항:</th>
            <td>
                <form:input path="roomDetail" cssClass="form-control" />
                <form:errors cssClass="text-danger" path="roomDetail"/>
            </td>
        </tr>
        <tr>
            <th>시설 사용 가능 여부:</th>
            <td>
                <form:input path="roomYn" cssClass="form-control" />
                <form:errors cssClass="text-danger" path="roomYn"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">전송</button>
                <button type="reset">취소</button>
            </td>
        </tr>
    </table>
</form:form>
