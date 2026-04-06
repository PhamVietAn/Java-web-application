<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<html>
<head>
  <title>Kết quả tìm kiếm sự kiện</title>
  <%-- Ghi chú nội bộ: Không dùng HTML comment cho note kỹ thuật --%>
</head>
<body>

<h1>
  Kết quả tìm kiếm cho:
  <c:out value="${keyword}" escapeXml="true" />
</h1>

<p>Tìm thấy ${empty events ? 0 : fn:length(events)} sự kiện</p>

<c:if test="${empty events}">
  <p>Không tìm thấy sự kiện nào phù hợp.</p>
</c:if>

<c:if test="${not empty events}">
  <table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
      <th>STT</th>
      <th>Tên sự kiện</th>
      <th>Ngày tổ chức</th>
      <th>Giá vé</th>
      <th>Vé còn lại</th>
      <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="event" items="${events}" varStatus="status">
      <tr>
        <td>${status.count}</td>

        <td>
          <c:out value="${event.name}" escapeXml="true" />
        </td>

        <td>${event.eventDate}</td>

        <td>
          <c:choose>
            <c:when test="${event.price == 0}">
              <span>MIỄN PHÍ</span>
            </c:when>
            <c:otherwise>
              <fmt:formatNumber value="${event.price}" pattern="#,##0" />
            </c:otherwise>
          </c:choose>
        </td>

        <td>
          <c:choose>
            <c:when test="${event.remainingTickets == 0}">
              <span style="color:red;">HẾT VÉ</span>
            </c:when>
            <c:when test="${event.remainingTickets < 10}">
                            <span style="color:orange;">
                                Sắp hết (còn ${event.remainingTickets} vé)
                            </span>
            </c:when>
            <c:otherwise>
              <span style="color:green;">${event.remainingTickets}</span>
            </c:otherwise>
          </c:choose>
        </td>

        <td>
          <c:choose>
            <c:when test="${event.remainingTickets == 0}">
              <span style="color:gray;">Đặt vé</span>
            </c:when>
            <c:otherwise>
              <a href="<c:url value='/events/${event.id}/book' />">Đặt vé</a>
            </c:otherwise>
          </c:choose>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</c:if>

<hr>

<c:if test="${not empty events}">
  <p>
    Tên sự kiện đầu tiên:
    <c:out value="${fn:toUpperCase(events[0].name)}" escapeXml="true" />
  </p>
</c:if>

<p>Số ký tự của từ khóa tìm kiếm: ${fn:length(keyword)} ký tự</p>

</body>
</html>