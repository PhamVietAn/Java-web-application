<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Trang lỗi</title>
</head>
<body>

<h2>Đã xảy ra lỗi</h2>
<p style="color:red;">
    <c:out value="${errorMessage}" />
</p>

<p>
    <a href="<c:url value='/employees' />">Quay lại danh sách nhân viên</a>
</p>

</body>
</html>