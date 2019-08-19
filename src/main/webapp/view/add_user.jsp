<%@ page import="model.Role" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Role role = (Role) request.getSession().getAttribute("role");%>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="text"/>
<html lang="param.locale">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><fmt:message key="title"/></title>
    <script type="text/javascript">
        function submitForm(form) {
            var obj = {};
            obj.name = form.name.value.trim();
            obj.surname = form.surname.value.trim();
            obj.phone = form.phone.value.trim();
            obj.address = form.address.value.trim();
            obj.login = form.login.value.trim();
            obj.password = form.password.value;
            obj.role= form.role.value;
            var jsonObject = JSON.stringify(obj);

            var xhr = new XMLHttpRequest();
            xhr.open('POST', "/newUser", true);
            xhr.setRequestHeader("Content-Type", 'application/x-www-form-urlencoded');
            xhr.send(jsonObject);
            xhr.onload = function () {
                location.replace(xhr.responseText);
            }
        }
    </script>
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
                <%}%>
                <%if (role == Role.MASTER) {%>
                <li><a href="<c:url value='/account/orders'/>" class="nav_item"><fmt:message key="orders"/></a></li>
                <li><a href="<c:url value='/account/edit_profile'/>" class="nav_item"><fmt:message
                        key="edit_profile"/></a></li>
                <li><a href="<c:url value='/logout'/>" class="nav_item"><fmt:message key="logout"/></a></li>
                <%}%>
                <%if (role == Role.MANAGER) {%>
                <li><a href="<c:url value='/account/orders'/>" class="nav_item"><fmt:message key="orders"/></a></li>
                <li><a href="<c:url value='/account/employee_add_order'/>" class="nav_item"><fmt:message
                        key="add_order"/></a></li>
                <li><a href="<c:url value='/account/add_user'/>" class="nav_item"><fmt:message key="add_user"/></a></li>
                <li><a href="<c:url value='/account/edit_profile'/>" class="nav_item"><fmt:message
                        key="edit_profile"/></a></li>
                <li><a href="<c:url value='/logout'/>" class="nav_item"><fmt:message key="logout"/></a></li>
                <%}%>
                <%if (role == Role.ADMIN) {%>
                <li><a href="<c:url value='/account/orders'/>" class="nav_item"><fmt:message key="orders"/></a></li>
                <li><a href="<c:url value='/account/employee_add_order'/>" class="nav_item"><fmt:message
                        key="add_order"/></a></li>
                <li><a href="<c:url value='/account/users'/>" class="nav_item"><fmt:message key="users"/></a></li>
                <li><a href="<c:url value='/account/add_user'/>" class="nav_item"><fmt:message key="add_user"/></a></li>
                <li><a href="<c:url value='/account/edit_profile'/>" class="nav_item"><fmt:message
                        key="edit_profile"/></a></li>
                <li><a href="<c:url value='/logout'/>" class="nav_item"><fmt:message key="logout"/></a></li>
                <%}%>
            </ul>
        </div>
    </div>
</nav>

<section class="forms" id="contact">
    <div class="container">
        <form name="user" class="forms_form" onsubmit="event.preventDefault();submitForm(this);">
            <input type="text" required placeholder="<fmt:message key="name"/>" name="name">
            <input type="text" required placeholder="<fmt:message key="surname"/>" name="surname">
            <input type="text" required placeholder="<fmt:message key="phone"/>" pattern="+[0-9]{11,12}" name="phone">
            <select name="role" required id="role" >
                <option value="client"><fmt:message key="client"/></option>
                <option value="master"><fmt:message key="master"/></option>
                <option value="manager"><fmt:message key="manager"/></option>
                <option value="admin"><fmt:message key="admin"/></option>
            </select>
            <input type="text" required placeholder="<fmt:message key="address"/>" name="address">
            <input type="email" required placeholder="<fmt:message key="login"/>" name="login">
            <input type="password" required placeholder="<fmt:message key="password"/>" name="password">
            <input name="submit" id="button" class="btn_send" type="submit" value="<fmt:message key="registration"/>">
        </form>
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
