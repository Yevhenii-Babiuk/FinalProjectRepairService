<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Order" %>
<%@ page import="dao.OrderDAOImplement" %>
<%@ page import="model.Role" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Order> orders = new OrderDAOImplement().getOrderByClient((Integer) request.getSession().getAttribute("id"));%>
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
            obj.orderId = form.orderId.value;
            obj.text = form.feedback.value;
            obj.rate = form.rate.value;
            var jsonObject = JSON.stringify(obj);

            var xhr = new XMLHttpRequest();
            xhr.open('POST', "/add_feedback", true);
            xhr.setRequestHeader("Content-Type", 'application/x-www-form-urlencoded');
            xhr.send(jsonObject);
        }
    </script>
    <style>
        <%@include file='/view/font-awesome-4.7.0/css/font-awesome.min.css'%>
        <%@include file='/view/css/normalize.css'%>
        <%@include file='/view/css/lab10.css'%>
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

<section class="contact" id="contact">
    <div class="container">

        <form name="user" class="contact_form" onsubmit="event.preventDefault();submitForm(this);">
            <select required name="orderId">
                <%for (int i = 0; i < orders.size(); i++) {%>
                <%Order order = orders.get(i);%>
                <option value="<%=order.getId()%>"><%=order.getId()%>
                </option>
                <%}%>
            </select>
            <input name="rate" type="number" required max="5" min="0" placeholder="<fmt:message key="rate"/>">
            <textarea required placeholder="<fmt:message key="feedback"/>" name="feedback"></textarea>
            <input name="submit" id="button" class="btn_send" type="submit" value="<fmt:message key="send"/>">
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