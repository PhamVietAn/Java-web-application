<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>

<h2>Đăng nhập hệ thống nhân sự</h2>

<c:if test="${not empty errorMessage}">
    <p style="color:red;">
        <c:out value="${errorMessage}" />
    </p>
</c:if>

<form action="<c:url value='/login' />" method="post">
    <div>
        <label>Username:</label>
        <input type="text" name="username">
    </div>
    <br>
    <div>
        <label>Password:</label>
        <input type="password" name="password">
    </div>
    <br>
    <button type="submit">Đăng nhập</button>
</form>

</body>
</html>