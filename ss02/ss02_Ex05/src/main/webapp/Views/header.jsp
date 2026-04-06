<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div style="padding:10px; background:#f2f2f2; margin-bottom:20px;">
    <a href="<c:url value='/employees' />">Danh sách nhân viên</a>

    <c:if test="${sessionScope.role == 'hr_manager'}">
        | <span>Menu quản lý</span>
    </c:if>

    <span style="float:right;">
        Xin chào,
        <c:out value="${sessionScope.loggedUser}" />
        | <a href="<c:url value='/logout' />">Đăng xuất</a>
    </span>
</div>