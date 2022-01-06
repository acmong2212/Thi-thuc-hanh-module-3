<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<form action="/edit" method="post">
    <label><input name="id" value="${idEdit}" hidden/></label>
    <table>
        <tr>
            <th><label><input type="text" placeholder="Enter a name" name="editName" value="${editProduct.nameProduct}"/></label></th>
            <th><label><input type="text" placeholder="Enter a price" name="editPrice" value="${editProduct.price}"/></label></th>
            <th><label><input type="text" placeholder="Enter a quantity" name="editQuantity" value="${editProduct.quantity}"/></label></th>
            <th><label><input type="text" placeholder="Enter a color" name="editColor" value="${editProduct.color}"/></label></th>
            <th><label><input type="text" placeholder="Enter a description" name="editDescription" value="${editProduct.description}"/></label></th>
            <th><label><input type="text" placeholder="Enter a idCategory" name="editIdCategory" value="${editProduct.idCategory}"/></label></th>
        </tr>
    </table>
    <button type="submit" class="btn btn-success">Submit</button>
    <a type="submit" href="/" class="btn btn-secondary margin">Back</a>
</form>
</body>
</html>
