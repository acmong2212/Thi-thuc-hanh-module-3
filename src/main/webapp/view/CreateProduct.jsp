<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Create Product</title>
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
<form action="/create" method="post">
    <h1>Add new Student</h1>
    <div class="margin">
        <div>Name</div>
        <div><input name="addName" type="text" placeholder="Enter name"/></div>
    </div>
    <div class="margin">
        <div>Price</div>
        <div><input name="addPrice" type="text" placeholder="Enter price"/></div>
    </div>
    <div class="margin">
        <div>Quantity</div>
        <div><input name="addQuantity" type="number" placeholder="Enter quantity"/></div>
    </div>
    <div class="margin">
        <div>Color</div>
        <div><input name="addColor" type="text" placeholder="Enter color"/></div>
    </div>
    <div class="margin">
        <div>Description</div>
        <div><input name="addDescription" type="text" placeholder="Enter description"/></div>
    </div>
    <div class="margin">Category
        <div><select name="addCategory">
            <c:forEach var="t" items="${listCategory}">
                <option value="${t.idCategory}">${t.nameCategory}</option>
            </c:forEach>
        </select>
        </div>
    </div>
    <button type="submit" class="btn btn-primary margin">Create</button>
    <a type="submit" href="/" class="btn btn-secondary margin">Back</a>
</form>
</body>
</html>
