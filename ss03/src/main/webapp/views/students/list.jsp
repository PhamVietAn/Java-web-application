<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <title>StudentHub - Danh sách sinh viên</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container py-4">
    <div class="d-flex flex-column flex-md-row justify-content-between align-items-md-center mb-3">
        <h1 class="h3 mb-3 mb-md-0">StudentHub - Danh sách sinh viên</h1>
        <div>
            <a class="btn btn-outline-primary btn-sm mr-2" href="<c:url value='/students'><c:param name='sortBy' value='name'/><c:param name='search' value='${search}'/><c:param name='faculty' value='${faculty}'/></c:url>">Sắp xếp tên (A-Z)</a>
            <a class="btn btn-outline-primary btn-sm mr-2" href="<c:url value='/students'><c:param name='sortBy' value='gpa'/><c:param name='search' value='${search}'/><c:param name='faculty' value='${faculty}'/></c:url>">Sắp xếp GPA</a>
            <a class="btn btn-primary btn-sm" href="<c:url value='/dashboard'/>">Xem dashboard</a>
        </div>
    </div>

    <div class="card mb-3">
        <div class="card-body">
            <form method="get" action="<c:url value='/students'/>" class="form-row align-items-end">
                <div class="form-group col-md-5">
                    <label for="search">Tìm theo tên/mã SV</label>
                    <input id="search" type="text" name="search" value="${search}" class="form-control" />
                </div>
                <div class="form-group col-md-4">
                    <label for="faculty">Khoa</label>
                    <input id="faculty" type="text" name="faculty" value="${faculty}" placeholder="CNTT" class="form-control" />
                </div>
                <div class="form-group col-md-3">
                    <button type="submit" class="btn btn-success btn-block">Lọc</button>
                </div>
            </form>
        </div>
    </div>

    <p class="text-muted">Tìm thấy ${resultCount} sinh viên phù hợp</p>

    <div class="table-responsive">
        <table class="table table-striped table-hover">
            <thead class="thead-light">
            <tr>
                <th>STT</th>
                <th>Mã SV</th>
                <th>Họ tên</th>
                <th>Khoa</th>
                <th>Năm nhập học</th>
                <th>GPA</th>
                <th>Trạng thái</th>
                <th>Chi tiết</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${students}" var="student" varStatus="loop">
                <tr>
                    <td>${loop.count}</td>
                    <td>${student.studentCode}</td>
                    <td>${student.fullName}</td>
                    <td>${student.faculty}</td>
                    <td>${student.enrollmentYear}</td>
                    <td>${student.gpa}</td>
                    <td>
                        <c:choose>
                            <c:when test="${student.status.cssClass eq 'status-active'}">
                                <span class="badge badge-success">${student.status.displayName}</span>
                            </c:when>
                            <c:when test="${student.status.cssClass eq 'status-paused'}">
                                <span class="badge badge-warning">${student.status.displayName}</span>
                            </c:when>
                            <c:otherwise>
                                <span class="badge badge-info">${student.status.displayName}</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <a class="btn btn-sm btn-outline-secondary" href="<c:url value='/students/detail'><c:param name='id' value='${student.id}'/></c:url>">Xem</a>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${empty students}">
                <tr>
                    <td colspan="8" class="text-center text-muted">Không có dữ liệu sinh viên.</td>
                </tr>
            </c:if>
            </tbody>
        </table>
    </div>
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

