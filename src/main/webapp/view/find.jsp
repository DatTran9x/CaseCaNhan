<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/7/2022
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Find room</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<h1 class="text">Room</h1>
<h5>
    <button class="btn">
        <a href="/home">Back to homepage</a>
    </button>
</h5>
<h3 class="text">Using room</h3>
<table class="table table-striped">
    <tr>
        <th>#</th>
        <th>Room number</th>
        <th>Beds</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${usingRoom}" var="r" varStatus="loop">
        <tr>
            <td><p>${r.id_room}</p></td>
            <td><p>${r.name}</p></td>
            <td><p>${r.beds}</p></td>
            <td><p>${r.price}</p></td>
        </tr>
    </c:forEach>
</table>
<h3 class="text">Used room</h3>
<table class="table table-striped">
    <tr>
        <th>#</th>
        <th>Room number</th>
        <th>Beds</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${usedRoom}" var="r" varStatus="loop">
        <tr>
            <td><p>${r.id_room}</p></td>
            <td><p>${r.name}</p></td>
            <td><p>${r.beds}</p></td>
            <td><p>${r.price}</p></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
