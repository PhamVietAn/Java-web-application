<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<head>
    <title>Danh sách nhân viên</title>
</head>
<body>

<%@ include file="header.jsp" %>

<h2>Danh sách nhân viên</h2>

<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>STT</th>
        <th>Mã NV</th>
        <th>Họ tên</th>
        <th>Phòng ban</th>
        <th>Lương</th>
        <th>Ngày vào làm</th>
        <th>Trạng thái</th>
        <th>Thao tác</th>
    </tr>

    <c:forEach var="emp" items="${employees}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td><c:out value="${emp.code}" /></td>
            <td><c:out value="${emp.fullName}" /></td>
            <td><c:out value="${emp.department}" /></td>
            <td>
                <fmt:formatNumber value="${emp.salary}" pattern="#,##0" /> VNĐ
            </td>
            <td>
                <fmt:formatDate value="${emp.joinDate}" pattern="dd/MM/yyyy" />
            </td>
            <td>
                <c:choose>
                    <c:when test="${emp.status == 'Đang làm'}">
                        <span style="color:green;"><c:out value="${emp.status}" /></span>
                    </c:when>
                    <c:when test="${emp.status == 'Nghỉ phép'}">
                        <span style="color:orange;"><c:out value="${emp.status}" /></span>
                    </c:when>
                    <c:otherwise>
                        <span style="color:blue;"><c:out value="${emp.status}" /></span>
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="<c:url value='/employees/${emp.code}' />">Xem chi tiết</a>
            </td>
        </tr>
    </c:forEach>

    <tr>
        <td colspan="8">
            Tổng lương phòng ban Kỹ thuật:
            <fmt:formatNumber value="${technicalTotalSalary}" pattern="#,##0" /> VNĐ
        </td>
    </tr>
</table>

<%@ include file="footer.jsp" %>

</body>
</html>