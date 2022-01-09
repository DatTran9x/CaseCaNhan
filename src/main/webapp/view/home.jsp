<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/7/2022
  Time: 11:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Homepage</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<h1>Homepage</h1>
<form action="/home?action=search" method="post">
    <input type="text" name="find" class="form-control">
    <input type="submit" value="Search customer" class="btn btn-primary" >
</form>
<h6>
    <button class="btn btn-light">
        <a href="/home?action=checkin"> Check in </a>
    </button>
</h6>
<h6>
    <button class="btn btn-light">
        <a href="/home?action=checkout"> Check out </a>
    </button>
</h6>
<p>Message: ${message}</p>
<c:remove var="message" scope="session" />
<table class="table table-striped">
    <tr>
        <th>#</th>
        <th>Room number</th>
        <th>Beds</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${list}" var="r" varStatus="loop">
        <tr>
        <td><a href="/home?action=rent&id=${r.id_room}">${r.id_room}</a></td>
        <td><a href="/home?action=rent&id=${r.id_room}">${r.name}</a></td>
        <td><p>${r.beds}</p></td>
        <td><p>${r.price}</p></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
