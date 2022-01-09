<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/7/2022
  Time: 9:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Successful booked</title>
</head>
<body>
<h1>Successful booked</h1>
<h5>
    <button>
        <a href="/home">Back to homepage</a>
    </button>
</h5>
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
    </table>
    <table>
        <tr>
            <th>Customer name</th>
            <th>Customer age</th>
            <th>Customer phone number</th>
            <th>Customer ID card</th>
            <th>Date start</th>
            <th>Date end</th>
            <th>Money</th>
        </tr>
        <tr>
            <td>${requestScope["customer"].name}</td>
            <td>${requestScope["customer"].age}</td>
            <td>${requestScope["customer"].phone}</td>
            <td>${requestScope["customer"].cmtnd}</td>
            <td>${requestScope["customer"].id_customer}</td>
            <td>${requestScope["orders"].date_start}</td>
            <td>${requestScope["orders"].date_end}</td>
            <td>${requestScope["orders"].money}</td>
        </tr>
    </table>
    <button>
        <a href="/home">CONFIRM</a>
    </button>
    <button>
        <a href="/home?action=delete&id=${requestScope["orders"].id_orders}" methods="post">CANCEL</a>
    </button>
</body>
</html>
