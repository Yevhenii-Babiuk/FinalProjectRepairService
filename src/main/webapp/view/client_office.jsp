<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="text"/>
<html lang="param.locale">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Client page</title>
    <style>
        <%@include file='/view/font-awesome-4.7.0/css/font-awesome.min.css'%>
        <%@include file='/view/css/normalize.css'%>
        <%@include file='/view/css/lab10.css'%>
        <%@include file='/view/css/responsive.css'%>
    </style>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
</head>

<body id="page-top">
<nav class="nav_bar">
    <div class="container">
        <input type="checkbox" id="menu">
        <div class="nav_wrap">
            <a class="nav_left nav_item" href="<c:url value='/' />">Repair service</a>
            <label for="menu"><i class="fas fa-bars"></i>
                Menu
            </label>
            <ul class="nav_right">
                <li><a href="<c:url value='/account/orders'/>" class="nav_item">Orders</a></li>
                <li><a href="<c:url value='/account/add_order'/>" class="nav_item">Add orders</a></li>
                <li><a href="<c:url value='/account/edit_profile'/>" class="nav_item">Edit profile</a></li>
                <li><a href="<c:url value='/contact' />" class="nav_item">Contact</a></li>
                <li><a href="<c:url value='/price' />" class="nav_item">Price</a></li>
                <li><a href="<c:url value='/logout'/>" class="nav_item">Log out</a></li>
            </ul>
        </div>
    </div>
</nav>

</body>
</html>