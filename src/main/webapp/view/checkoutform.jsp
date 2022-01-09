<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/8/2022
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Check Out</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<h1 class="text">Check Out</h1>
<h5>
    <button class="btn btn-light">
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
    Room
</h5>
<table class="table table-striped">
    <tr>
        <th>#</th>
        <th>Room number</th>
        <th>Beds</th>
        <th>Price</th>
    </tr>
    <tr>
        <th>
            <p>
                ${requestScope["room"].id_room}
            </p>
        </th>
        <th>
            <p>
                ${requestScope["room"].name}
            </p>
        </th>
        <th>
            <p>
                ${requestScope["room"].beds}
            </p>
        </th>
        <th>
            <p>
                ${requestScope["room"].price}
            </p>
        </th>
    </tr>
</table>
<table class="table table-striped">
    <tr>
        <th>
            Date start
        </th>
        <th>
            Date end
        </th>
        <th>
            Money
        </th>
    </tr>
    <tr>
        <td>
            ${requestScope["order"].date_start}
        </td>
        <td>
            ${requestScope["order"].date_end}
        </td>
        <td>
            ${requestScope["order"].money}
        </td>
    </tr>
</table>
<table class="table table-striped">
    <tr>
        <th>
            <button class="btn btn-light">
                <a href="/home?action=payment&id=${requestScope["order"].id_orders}">Check out</a>
            </button>
            </th>
    </tr>
</table>
</body>
</html>
