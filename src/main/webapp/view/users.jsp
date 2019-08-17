<%@ page import="model.Role" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="dao.UserDAOImplement" %>
<%@ page import="dao.EmployeeDAOImplement" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
            <a class="nav_left nav_item" href="<c:url value='/' />">Repair service</a>
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
                <input type="text" required placeholder="Name" name="name" id="name">
                <input type="text" required placeholder="Surname" name="surname" id="surname">
                <input type="text" required placeholder="Phone" pattern="+[0-9]{11,12}" name="phone" id="phone">
                <input type="text" required placeholder="Address" name="address" id="address">
                <input type="text" readonly required placeholder="Login" name="login" id="login">
                <select name="role" required id="role">
                    <option value="client">Client</option>
                    <option value="master">Master</option>
                    <option value="manager">Manager</option>
                    <option value="admin">Admin</option>
                </select>
                <input name="submit" id="button" class="btn_send" type="submit" value="Save">
            </form>
        </div>
        <div id="table" class="item2">
            <table class="list" id="employeeList">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Login</th>
                    <th>Address</th>
                    <th>Phone</th>
                    <th>Role</th>
                    <th>Start Date</th>
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
                            new EmployeeDAOImplement().getEntityByKey(user.getId()).getStartDate();
                        }
                    %>
                    </td>
                    <td>
                        <button onclick="onEdit(this)">Edit</button>
                    </td>
                </tr>
                <%}%>
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