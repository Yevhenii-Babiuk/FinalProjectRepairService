<%@ page import="dto.OrderDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Role" %>
<%@ page import="model.User" %>
<%@ page import="dao.UserDAOImplement" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.ProblemDAOImplement" %>
<%@ page import="model.Problem" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="text"/>
<html lang="param.locale">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><fmt:message key="title"/></title>
    <style>
        <%@include file='/view/font-awesome-4.7.0/css/font-awesome.min.css'%>
        <%@include file='/view/css/normalize.css'%>
        <%@include file='/view/css/repair_service.css'%>
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

    </div>
</nav>

<header class="promo">
    <div class="container">
    </div>
</header>

<section class="main_white">
    <header class="main_white" id="portfolio">
        <div class="container">
            <h1 class="header_title"><fmt:message key="exist"/></h1>
        </div>
    </header>
</section>

<div class="copyright">
    <div class="container">
        <a href="?locale=en">en</a>
        <a href="?locale=ru">ru</a>
        <a href="?locale=ua">ua</a>
    </div>
</div>
</body>
</html>
