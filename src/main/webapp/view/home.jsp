<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Products</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
  <button class="btn btn-success"><a href="/?action=create">Create</a></button>
  <form action="" method="get">
    <div class="input-group">
      <input name="search" type="search" class="form-control rounded" placeholder="Search" aria-label="Search"
             aria-describedby="search-addon" />
      <input name="action" value="search" hidden/>
      <button type="submit" class="btn btn-outline-primary">search</button>
    </div>
  </form>
  <table class="table table-striped">
    <thead>
    <tr>
      <th>#</th>
      <th>Name</th>
      <th>Price</th>
      <th>Quantity</th>
      <th>Color</th>
      <th>Description</th>
      <th>Category</th>
      <th>Action</th>
    </tr>
    </thead>
    <c:forEach var="t" items="${products}" varStatus="loop">
      <tbody>
      <tr>
        <td>${loop.count}</td>
        <td>${t.nameProduct}</td>
        <td>${t.price}</td>
        <td>${t.quantity}</td>
        <td>${t.color}</td>
        <td>${t.description}</td>
        <td>${t.nameCategory}</td>
        <td><a href="/?action=edit&id=${t.idProduct}" class="btn btn-warning">Edit</a></td>
        <td><a href="/?action=delete&id=${t.idProduct}" class="btn btn-danger">Delete</a></td>
      </tr>
      </tbody>
    </c:forEach>
  </table>
</div>

</body>
</html>

