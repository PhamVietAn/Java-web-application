<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <title>StudentHub - Chi tiết sinh viên</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container py-4">
    <h1 class="h3 mb-3">Chi tiết sinh viên</h1>

    <c:if test="${not empty message}">
        <div class="alert alert-info" role="alert">${message}</div>
    </c:if>

    <c:if test="${not empty student}">
        <div class="card mb-3">
            <div class="card-body">
                <div class="row mb-2">
                    <div class="col-sm-4 font-weight-bold">ID:</div>
                    <div class="col-sm-8">${student.id}</div>
                </div>
                <div class="row mb-2">
                    <div class="col-sm-4 font-weight-bold">Mã SV:</div>
                    <div class="col-sm-8">${student.studentCode}</div>
                </div>
                <div class="row mb-2">
                    <div class="col-sm-4 font-weight-bold">Họ tên:</div>
                    <div class="col-sm-8">${student.fullName}</div>
                </div>
                <div class="row mb-2">
                    <div class="col-sm-4 font-weight-bold">Khoa:</div>
                    <div class="col-sm-8">${student.faculty}</div>
                </div>
                <div class="row mb-2">
                    <div class="col-sm-4 font-weight-bold">Năm nhập học:</div>
                    <div class="col-sm-8">${student.enrollmentYear}</div>
                </div>
                <div class="row mb-2">
                    <div class="col-sm-4 font-weight-bold">GPA:</div>
                    <div class="col-sm-8">${student.gpa}</div>
                </div>
                <div class="row">
                    <div class="col-sm-4 font-weight-bold">Trạng thái:</div>
                    <div class="col-sm-8">${student.status.displayName}</div>
                </div>
            </div>
        </div>
    </c:if>

    <a class="btn btn-outline-secondary" href="<c:url value='/students'/>">Quay lại danh sách</a>
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

