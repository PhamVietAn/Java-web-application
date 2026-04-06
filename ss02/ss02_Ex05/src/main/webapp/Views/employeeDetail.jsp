<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<head>
    <title>Chi tiết nhân viên</title>
</head>
<body>

<%@ include file="header.jsp" %>

<h2>Chi tiết nhân viên</h2>

<p>Mã NV: <c:out value="${employee.code}" /></p>
<p>Họ tên: <c:out value="${employee.fullName}" /></p>
<p>Phòng ban: <c:out value="${employee.department}" /></p>

<p>
    Lương:
    <c:choose>
        <c:when test="${sessionScope.role == 'hr_manager'}">
            <fmt:formatNumber value="${employee.salary}" pattern="#,##0" /> VNĐ
        </c:when>
        <c:otherwise>
            ***
        </c:otherwise>
    </c:choose>
</p>

<p>
    Ngày vào làm:
    <fmt:formatDate value="${employee.joinDate}" pattern="dd/MM/yyyy" />
</p>

<p>Trạng thái: <c:out value="${employee.status}" /></p>

<p>
    <a href="<c:url value='/employees' />">Quay lại</a>
</p>

<%@ include file="footer.jsp" %>

</body>
</html>