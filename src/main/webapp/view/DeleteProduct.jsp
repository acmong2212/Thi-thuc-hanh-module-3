<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Delete Product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        body {
            margin-left: 45%;
        }
        .margin {
            margin-top: 10px;
        }
    </style>
</head>
<body>
<form action="/delete" method="post" class="margin">
    <input value="${idDelete}" name="id" hidden/>
    <h1>Ban chac chua ?</h1>
    <button type="submit" class="btn btn-danger">Yes</button>
    <button type="button" class="btn btn-dark"><a href="/">No</a></button>
</form>
</body>
</html>
