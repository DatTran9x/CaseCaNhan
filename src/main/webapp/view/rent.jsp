<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/7/2022
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Rent room</title>
</head>
<body>
<h1>Rent room</h1>
<h5>
    <button>
        <a href="/home">Back to homepage</a>
    </button>
</h5>
<form action="/home?action=rent&id=${requestScope["room"].id_room}" method="post">
    <table>
        <tr>
            <th>#</th>
            <th>Room number</th>
            <th>Beds</th>
            <th>Price</th>
        </tr>
        <tr>
            <td>${requestScope["room"].id_room}</td>
            <td>${requestScope["room"].name}</td>
            <td>${requestScope["room"].beds}</td>
            <td>${requestScope["room"].price}</td>
        </tr>
        <tr>
            <th>Customer name</th>
            <th>Customer age</th>
            <th>Customer phone number</th>
            <th>Customer ID card</th>
            <th>Date start</th>
            <th>Date end</th>
        </tr>
    </table>
    <table>
        <tr>
            <th>
                <input type="text" name="name">
            </th>
            <th>
                <input type="text" name="age">
            </th>
            <th>
                <input type="text" name="phone">
            </th>
            <th>
                <input type="text" name="cmtnd">
            </th>
            <th>
                <input type="date" name="date_start" value="2021-01-01">
            </th>
            <th>
                <input type="date" name="date_end" value="2021-01-01">
            </th>
        </tr>
    </table>
    <input type="submit" value="Rent">
</form>
</body>
</html>
