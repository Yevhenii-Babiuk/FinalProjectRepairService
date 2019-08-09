<%@ page import="model.Order" %>
<%@ page import="dto.OrderDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%ArrayList orders = (ArrayList) request.getAttribute("orders");%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Adaptive</title>
    <style>
        <%@include file='/view/font-awesome-4.7.0/css/font-awesome.min.css'%>
        <%@include file='/view/css/normalize.css'%>
        <%@include file='/view/css/lab10.css'%>
        <%@include file='/view/css/responsive.css'%>
    </style>
    <script>
        <%@include file='/view/script/script.js'%>
    </script>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet"
          type="text/css">
</head>

<body id="page-top">
<nav class="nav_bar">
    <div class="container">
        <input type="checkbox" id="menu">
        <div class="nav_wrap">
            <a class="nav_left nav_item" href="#page-top">Repair service</a>
            <label for="menu"><i class="fas fa-bars"></i>
                Menu
            </label>
            <ul class="nav_right">
                <li><a href="<c:url value='/user/login' />" class="nav_item">Authorization</a></li>
                <li><a href="<c:url value='/user/account' />" class="nav_item">user`s office</a></li>
                <li><a href="<c:url value='/registration' />" class="nav_item">Registration</a></li>
                <li><a href="contact.jsp" class="nav_item">Contact</a></li>
                <li><a href="price.jsp" class="nav_item">Price</a></li>
            </ul>
        </div>
    </div>
</nav>
<header class="promo">
    <div class="container">
    </div>
</header>
<section class="portfolio">
    <div class="container grid-container">
        <div id="form" class="item1">
            <form name="order" class="order_form" onsubmit="event.preventDefault();onFormSubmit();">
                <input type="text" required placeholder="Master surname" name="masterSurname" id="masterSurname">
                <input type="text" required placeholder="Manager surname" name="managerSurname" id="managerSurname">
                <input type="text" required placeholder="Solving" name="solving" id="solving">
                <select name="status" required id="status">
                    <option value="created">CREATED</option>
                    <option value="accepted">ACCEPTED</option>
                    <option value="done">DONE</option>
                </select>
                <input type="date" placeholder="End date" name="endDate" id="endDate">
                <input name="submit" id="button" class="btn_send" type="submit" value="Enter">
        </div>
        <div id="table" class="item2">
            <table class="list" id="employeeList">
                <thead>
                <tr>
                    <th>Order id</th>
                    <th>Client Name</th>
                    <th>Client Surname</th>
                    <th>Master Surname</th>
                    <th>Manager Surname</th>
                    <th>Device</th>
                    <th>Problem</th>
                    <th>Solving</th>
                    <th>Price</th>
                    <th>Start Date</th>
                    <th>Status</th>
                    <th>End Date</th>
                    <th>Feedback</th>
                    <th></th>
                </tr>
                </thead>
                <% for (int i = 0; i < orders.size(); i++) {%>
                <%OrderDTO order = (OrderDTO) orders.get(i);%>
                <tr>
                    <td><%=order.getOrder().getId()%>
                    </td>
                    <td><%=order.getClientName()%>
                    </td>
                    <td><%=order.getClientSurname()%>
                    </td>
                    <td><%=order.getMasterSurname()%>
                    </td>
                    <td><%=order.getManagerSurname()%>
                    </td>
                    <td><%=order.getDevice()%>
                    </td>
                    <td><%=order.getProblem()%>
                    </td>
                    <td></td>
                    <td><%=order.getPrice()%>
                    </td>
                    <td><%=order.getOrder().getStart_date()%>
                    </td>
                    <td><%=order.getOrder().getStatus().getStatusToString()%>
                    </td>
                    <td><%=order.getOrder().getEnd_date()%>
                    </td>
                    <td><%=order.getFeedback()%>
                    </td>
                    <td>
                        <button onclick="onEdit(this)">Edit</button>
                    </td>
                </tr>
                <% }%>
            </table>
        </div>
    </div>
</section>

<div class="copyright">
    <div class="container">
        <p>Copyright © Your Website 2019</p>
    </div>
</div>
</body>
</html>