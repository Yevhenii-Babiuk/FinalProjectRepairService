<%@ page import="model.Role" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="dao.UserDAOImplement" %>
<%@ page import="dao.EmployeeDAOImplement" %>
<%@ page import="model.Employee" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Role role = (Role) request.getSession().getAttribute("role");%>
<%EmployeeDAOImplement employeeDao = new EmployeeDAOImplement();%>

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
        <%@include file='/view/script/userScript.js'%>
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
                <li><a href="<c:url value='/account/orders'/>" class="nav_item"><fmt:message key="orders"/></a></li>
                <li><a href="<c:url value='/account/employee_add_order'/>" class="nav_item"><fmt:message key="add_order"/></a></li>
                <li><a href="<c:url value='/account/users'/>" class="nav_item"><fmt:message key="users"/></a></li>
                <li><a href="<c:url value='/account/add_user'/>" class="nav_item"><fmt:message key="add_user"/></a></li>
                <li><a href="<c:url value='/account/edit_profile'/>" class="nav_item"><fmt:message key="edit_profile"/></a></li>
                <li><a href="<c:url value='/logout'/>" class="nav_item"><fmt:message key="logout"/></a></li>
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
                <input type="text" required placeholder="<fmt:message key="name"/>" name="name" id="name">
                <input type="text" required placeholder="<fmt:message key="surname"/>" name="surname" id="surname">
                <input type="text" required placeholder="<fmt:message key="phone"/>" pattern="+[0-9]{11,12}" name="phone" id="phone">
                <input type="text" required placeholder="<fmt:message key="address"/>" name="address" id="address">
                <input type="text" readonly required placeholder="<fmt:message key="login"/>" name="login" id="login">
                <select name="role" required id="role">
                    <option value="client"><fmt:message key="client"/></option>
                    <option value="master"><fmt:message key="master"/></option>
                    <option value="manager"><fmt:message key="manager"/></option>
                    <option value="admin"><fmt:message key="admin"/></option>
                </select>
                <input name="submit" id="button" class="btn_send" type="submit" value="<fmt:message key="save"/>">
            </form>
        </div>
        <div id="table" class="item2">
            <table class="list" id="employeeList">
                <thead>
                <tr>
                    <th>UserId</th>
                    <th><fmt:message key="name"/></th>
                    <th><fmt:message key="surname"/></th>
                    <th><fmt:message key="login"/></th>
                    <th><fmt:message key="address"/></th>
                    <th><fmt:message key="phone"/></th>
                    <th><fmt:message key="role"/></th>
                    <th><fmt:message key="start_date"/></th>
                    <th></th>
                </tr>
                </thead>
                <%List<User> users = new UserDAOImplement().getAll();%>
                <% for (int i = 0; i < users.size(); i++) {%>
                <%User user = users.get(i);%>
                <tr>
                    <td><%=user.getId()%>
                    </td>
                    <td><%=user.getName()%>
                    </td>
                    <td><%=user.getSurname()%>
                    </td>
                    <td><%=user.getLogin()%>
                    </td>
                    <td><%=user.getAddress()%>
                    </td>
                    <td><%=user.getPhone()%>
                    </td>
                    <td><%=user.getRole()%>
                    </td>
                    <td><%
                        if (user.getRole() != Role.CLIENT) {
                            Employee employee = employeeDao.getEntityByKey(user.getId());%>
                            <%=employee.getStartDate()%>
                        <%}%>
                    </td>
                    <td>
                        <button onclick="onEdit(this)"><fmt:message key="edit"/></button>
                    </td>
                </tr>
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