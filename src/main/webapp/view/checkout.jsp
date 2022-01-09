<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/8/2022
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check in form</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<diu>
    <h5>
        <button class="btn btn-light">
            <a href="/home">Back to homepage</a>
        </button>
    </h5>
</diu>
<div>
    <form>
        <form action="/home?action=search" method="post">
            <input type="text" name="find">
            <input type="submit" value="Search customer" class="btn">
        </form>
    </form>
</div>
<div>
    <table class="table table-striped">
        <tr>
            <th>#</th>
            <th>Customer name</th>
            <th>Customer age</th>
            <th>Customer phone</th>
            <th>Customer id</th>
        </tr>
        <c:forEach items="${list}" var="c">
            <tr>
                <td>
                    <a href="/home?action=getcheckout&id=${c.id_customer}">
                            ${c.id_customer}
                    </a>
                </td>
                <td>
                    <a href="/home?action=getcheckout&id=${c.id_customer}">
                            ${c.name}
                    </a>
                </td>
                <td>${c.age}</td>
                <td>${c.phone}</td>
                <td>${c.cmtnd}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
