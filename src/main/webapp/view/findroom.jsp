<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/8/2022
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<h5 class="text">
    Customer
</h5>
<table class="table table-striped">
    <tr>
        <th>#</th>
        <th>Customer name</th>
        <th>Customer age</th>
        <th>Customer phone</th>
        <th>Customer id</th>
    </tr>
    <tr>
        <td>
            <p>
                ${requestScope["customer"].id_customer}
            </p>
        </td>
        <td>
            <p>
                ${requestScope["customer"].name}
            </p>
        </td>
        <td>
            <p>
                ${requestScope["customer"].age}
            </p>
        </td>
        <td>
            <p>
                ${requestScope["customer"].phone}
            </p>
        </td>
        <td>
            <p>
                ${requestScope["customer"].cmtnd}
            </p>
        </td>
    </tr>
</table>
<h5 class="text">
    Room list
</h5>
<table class="table table-striped">
    <tr>
        <th>#</th>
        <th>Room number</th>
        <th>Beds</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${list}" var="r" varStatus="loop">
        <tr>
            <td>
                <a href="/home?action=checkinorder&id_customer=${requestScope["customer"].id_customer}&id_room=${r.id_room}">
                        ${r.id_room}
                </a>
            </td>
            <td>
                <a href="/home?action=checkinorder&id_customer=${requestScope["customer"].id_customer}&id_room=${r.id_room}">
                        ${r.name}
                </a>
            </td>
            <td><p>${r.beds}</p></td>
            <td><p>${r.price}</p></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
