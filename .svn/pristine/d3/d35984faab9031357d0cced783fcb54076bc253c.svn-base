<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- 시설 이미지 -->
    <div class="facility-image">
        <img src="${room.roomImg}" alt="${room.roomName}" style="width:100%; height:auto;">
    </div>

    <!-- 시설 정보 -->
    <table class="facility-info">
        <tr>
            <td>호수:</td>
            <td>${room.roomHosu}</td>
        </tr>
        <tr>
            <td>이름:</td>
            <td>${room.roomName}</td>
        </tr>
        <tr>
            <td>번호:</td>
            <td>${room.roomNum}</td>
        </tr>
        <tr>
            <td>상세정보:</td>
            <td>${room.roomDetail}</td>
        </tr>
        <tr>
            <td>사용 가능 여부:</td>
            <td>
                <c:choose>
                    <c:when test="${room.roomYn == 'Y'}">사용 가능</c:when>
                    <c:otherwise>사용 불가</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </table>

    <!-- 회차 선택 -->
    <div class="time-selection">
        <button>09:00 - 10:00</button>
        <button>10:00 - 11:00</button>
        <!-- 필요한 시간 버튼 추가 -->
    </div>