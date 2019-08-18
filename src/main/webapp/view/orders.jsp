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
<%ArrayList orders = (ArrayList) request.getAttribute("orders");%>
<%int id = (Integer) request.getSession().getAttribute("id");%>
<%Role role = (Role) request.getSession().getAttribute("role");%>

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

<header class="promo">
    <div class="container">
    </div>
</header>
<section class="portfolio">
    <div class="container grid-container">
        <%if (role != Role.CLIENT) {%>
        <%UserDAOImplement userDao = new UserDAOImplement();%>
        <div id="form" class="item1">
            <form name="order" class="order_form" onsubmit="event.preventDefault();onFormSubmit();">
                <input type="hidden" name="orderId" id="orderId">
                <select name="masterSurname" required id="masterSurname">
                    <%List<User> masterList = userDao.getEntityByRole(Role.MASTER);%>
                    <% for (int i = 0; i < masterList.size(); i++) {%>
                    <option><%=masterList.get(i).getSurname()%>
                    </option>
                    <%}%>
                </select>
                <select name="managerSurname" required id="managerSurname">
                    <%List<User> managerList = userDao.getEntityByRole(Role.MANAGER);%>
                    <% for (int i = 0; i < managerList.size(); i++) {%>
                    <option><%=managerList.get(i).getSurname()%>
                    </option>
                    <%}%>
                </select>
                <select name="solving" required id="solving">
                    <%ProblemDAOImplement problemDao = new ProblemDAOImplement();%>
                    <%List<Problem> problemList = problemDao.getAll();%>
                    <% for (int i = 0; i < problemList.size(); i++) {%>
                    <option><%=problemList.get(i).getProblem()%>
                    </option>
                    <%}%>
                </select>
                <select name="status" required id="status">
                    <option value="created"><fmt:message key="created"/></option>
                    <option value="accepted"><fmt:message key="accepted"/></option>
                    <option value="done"><fmt:message key="done"/></option>
                </select>
                <input type="date" placeholder="<fmt:message key="end_date"/>" name="endDate" id="endDate">
                <input name="submit" id="button" class="btn_send" type="submit" value="<fmt:message key="save"/>">
            </form>
        </div>
        <%}%>
        <div id="order_table"  class="item2">
            <table class="list" id="employeeList">
                <thead>
                <tr>
                    <th><fmt:message key="orderId"/></th>
                    <th><fmt:message key="client_name"/></th>
                    <th><fmt:message key="client_surname"/></th>
                    <th><fmt:message key="master_surname"/></th>
                    <th><fmt:message key="manager_surname"/></th>
                    <th><fmt:message key="device"/></th>
                    <th><fmt:message key="comment"/></th>
                    <th><fmt:message key="solving"/></th>
                    <th><fmt:message key="price"/></th>
                    <th><fmt:message key="start_date"/></th>
                    <th><fmt:message key="status"/></th>
                    <th><fmt:message key="end_date"/></th>
                    <th><fmt:message key="feedback"/></th>
                    <%if (role != Role.CLIENT) {%>
                    <th></th>
                    <%}%>
                </tr>
                </thead>
                <% for (int i = 0; i < orders.size(); i++) {%>
                <% OrderDTO order = (OrderDTO) orders.get(i);%>
                <%
                    if (role.equals(Role.CLIENT) &&
                            order.getOrder().getClient() != id) {
                        continue;
                    }
                    if (role.equals(Role.MANAGER) &&(
                            order.getManagerSurname()!=null) && order.getOrder().getManager() != id) {
                        continue;
                    }
                    if (role.equals(Role.MASTER) &&
                            order.getOrder().getMaster() != id) {
                        continue;
                    } else {
                %>
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
                    <td><%=order.getOrder().getComment()%>
                    </td>
                    <td><%=order.getProblem()%>
                    </td>
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
                    <%if (role != Role.CLIENT) {%>
                    <td>
                        <button onclick="onEdit(this)"><fmt:message key="edit"/></button>
                    </td>
                    <%}%>
                </tr>
                <%}%>
                <%}%>
            </table>
        </div>
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