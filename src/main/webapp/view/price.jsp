<%@ page import="model.Role" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Problem" %>
<%@ page import="dao.ProblemDAOImplement" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Role role = (Role) request.getSession().getAttribute("role");%>
<%List<Problem> problems = new ProblemDAOImplement().getAll();%>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="text"/>
<html lang="param.locale">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Adaptive</title>
    <style>
        <%@include file='/view/font-awesome-4.7.0/css/font-awesome.min.css'%>
        <%@include file='/view/css/normalize.css'%>
        <%@include file='/view/css/repair_service.css'%>
        <%@include file='/view/css/responsive.css'%>
    </style>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet"
          type="text/css">
</head>

<body id="page-top">
<nav class="nav_bar">
    <div class="container">
        <input type="checkbox" id="menu">
        <div class="nav_wrap">
            <a class="nav_left nav_item" href="<c:url value='/' />"><fmt:message key="title"/></a>
            <label for="menu"><i class="fas fa-bars"></i>
                <fmt:message key="menu"/>
            </label>
            <ul class="nav_right">
                <%if (role == Role.CLIENT) {%>
                <li><a href="<c:url value='/account/orders'/>" class="nav_item"><fmt:message key="orders"/></a></li>
                <li><a href="<c:url value='/account/add_order'/>" class="nav_item"><fmt:message key="add_order"/></a>
                </li>
                <li><a href="<c:url value='/account/add_feedback'/>" class="nav_item"><fmt:message
                        key="add_feedback"/></a></li>
                <li><a href="<c:url value='/account/edit_profile'/>" class="nav_item"><fmt:message
                        key="edit_profile"/></a></li>
                <li><a href="<c:url value='/contact' />" class="nav_item"><fmt:message key="contact"/></a></li>
                <li><a href="<c:url value='/price' />" class="nav_item"><fmt:message key="price"/></a></li>
                <li><a href="<c:url value='/logout'/>" class="nav_item"><fmt:message key="logout"/></a></li>
                <%} else {%>
                <li><a href="<c:url value='/account/login' />" class="nav_item"><fmt:message key="authorization"/></a>
                </li>
                <li><a href="<c:url value='/account/office' />" class="nav_item"><fmt:message key="office"/></a></li>
                <li><a href="<c:url value='/registration' />" class="nav_item"><fmt:message key="registration"/></a>
                </li>
                <li><a href="<c:url value='/contact' />" class="nav_item"><fmt:message key="contact"/></a></li>
                <li><a href="<c:url value='/price' />" class="nav_item"><fmt:message key="price"/></a></li>
                <%}%>

            </ul>
        </div>
    </div>
</nav>

<header class="promo">
    <div class="container">
    </div>
</header>
<section class="main_white">
    <div id=" order_table" class="item2">
        <table class="list" id="employeeList">
            <thead>
            <tr>
                <th><fmt:message key="id"/></th>
                <th><fmt:message key="solving"/></th>
                <th><fmt:message key="price"/></th>
            </tr>
            </thead>
            <% for (int i = 0; i < problems.size(); i++) {%>
            <% Problem problem = problems.get(i);%>
            <tr>
                <td><%=problem.getId()%>
                </td>
                <td><%=problem.getProblem()%>
                </td>
                <td><%=problem.getPrice()%>
                </td>
            </tr>
            <%}%>
        </table>
    </div>
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