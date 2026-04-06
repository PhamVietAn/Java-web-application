<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
  <title>Đăng nhập</title>
</head>
<body>
<h2>Đăng nhập hệ thống</h2>

<c:if test="${not empty errorMessage}">
  <p style="color:red;">${errorMessage}</p>
</c:if>

<form action="${pageContext.request.contextPath}/login" method="post">
  <div>
    <label>Tài khoản:</label>
    <input type="text" name="username">
  </div>
  <div>
    <label>Mật khẩu:</label>
    <input type="password" name="password">
  </div>
  <div>
    <button type="submit">Đăng nhập</button>
  </div>
</form>
</body>
</html>