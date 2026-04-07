<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <title>StudentHub - Bảng điều khiển</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container py-4">
    <h1 class="h3 mb-4">Dashboard tổng quan</h1>

    <div class="row">
        <div class="col-lg-6 mb-3">
            <div class="card h-100">
                <div class="card-header">Thống kê chung</div>
                <div class="card-body">
                    <p><strong>Tổng số sinh viên:</strong> ${stats.totalStudents}</p>
                    <p class="mb-0"><strong>GPA trung bình:</strong>
                        <fmt:formatNumber value="${stats.averageGpa}" minFractionDigits="2" maxFractionDigits="2"/>
                    </p>
                </div>
            </div>
        </div>

        <div class="col-lg-6 mb-3">
            <div class="card h-100">
                <div class="card-header">Tỷ lệ theo trạng thái</div>
                <ul class="list-group list-group-flush">
                    <c:forEach items="${stats.statusPercentages}" var="entry">
                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            <span>${entry.key}</span>
                            <span class="badge badge-primary badge-pill">
                                <fmt:formatNumber value="${entry.value}" minFractionDigits="1" maxFractionDigits="1"/>%
                            </span>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>

    <div class="card mb-3">
        <div class="card-header">Thủ khoa nhóm</div>
        <div class="card-body">
            <c:if test="${not empty stats.topStudent}">
                <p class="mb-0">${stats.topStudent.fullName} (${stats.topStudent.studentCode}) - GPA: ${stats.topStudent.gpa}</p>
            </c:if>
            <c:if test="${empty stats.topStudent}">
                <p class="mb-0 text-muted">Chưa có dữ liệu.</p>
            </c:if>
        </div>
    </div>

    <a class="btn btn-outline-secondary" href="<c:url value='/students'/>">Quay lại danh sách sinh viên</a>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>

