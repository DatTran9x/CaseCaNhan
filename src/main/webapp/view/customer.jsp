<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/7/2022
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customers</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<h1 class="text">Customer</h1>
<h5>
    <button class="btn">
        <a href="/home">Back to homepage</a>
    </button>
</h5>
<table class="table table-striped">
    <tr>
        <th>Customer name</th>
        <th>Customer age</th>
        <th>Customer phone number</th>
        <th>Customer ID card</th>
    </tr>
    <c:forEach items="${list}" varStatus="loop" var="c">
        <tr>
            <td><a href="/home?action=findRoom&id=${c.id_customer}">${c.name}</a></td>
            <td>${c.age}</td>
            <td>${c.phone}</td>
            <td>${c.cmtnd}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
