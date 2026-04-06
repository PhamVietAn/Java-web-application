<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<head>
  <title>Danh sách đơn hàng</title>
</head>
<body>

<h2>Xin chào, ${sessionScope.loggedUser}! Vai trò: ${sessionScope.role}</h2>

<table border="1" cellpadding="8" cellspacing="0">
  <tr>
    <th>STT</th>
    <th>Mã đơn</th>
    <th>Tên sản phẩm</th>
    <th>Tổng tiền</th>
    <th>Ngày đặt</th>
  </tr>

  <c:forEach var="order" items="${requestScope.orderList}" varStatus="loop">
    <tr>
      <td>${loop.index + 1}</td>
      <td>${order.orderCode}</td>
      <td>${order.productName}</td>
      <td>
        <fmt:formatNumber value="${order.totalAmount}" type="number" groupingUsed="true" /> VNĐ
      </td>
      <td>
        <fmt:formatDate value="${order.orderDate}" pattern="dd/MM/yyyy" />
      </td>
    </tr>
  </c:forEach>
</table>

<p>
  Tổng lượt xem đơn hàng toàn hệ thống:
  ${applicationScope.totalViewCount.get()}
</p>

<p>
  <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
</p>

</body>
</html>