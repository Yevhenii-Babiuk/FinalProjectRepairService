<%@ page import="dao.UserDAOImplement" %>
<%@ page import="model.Role" %>
<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Problem" %>
<%@ page import="dao.ProblemDAOImplement" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="text"/>
<html lang="param.locale">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Adaptive</title>
    <script type="text/javascript">
        function submitForm(form) {
            var obj = {};
            obj.brand = form.brand.value;
            obj.model = form.model.value;
            obj.imei = form.imei.value;
            obj.comment = form.comment.value;
            obj.solving = form.solving.value;
            obj.clientLogin = form.clientLogin.value;
            obj.status = form.status.value;
            obj.masterSurname = form.masterSurname.value;
            obj.managerSurname = form.managerSurname.value;
            obj.endDate = form.endDate.value;
            var jsonObject = JSON.stringify(obj);

            var xhr = new XMLHttpRequest();
            xhr.open('POST', "/account/orders", true);
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
            <a class="nav_left nav_item" href="<c:url value='/' />">Repair service</a>
            <label for="menu"><i class="fas fa-bars"></i>
                Menu
            </label>
            <ul class="nav_right">
                <li><a href="<c:url value='/account/orders'/>" class="nav_item">Orders</a></li>
                <li><a href="<c:url value='/account/add_order'/>" class="nav_item">Add orders</a></li>
                <li><a href="<c:url value='/account/users'/>" class="nav_item">Users</a></li>
                <li><a href="<c:url value='/account/employee_add_user'/>" class="nav_item">Add user</a></li>
                <li><a href="<c:url value='/account/edit_profile'/>" class="nav_item">Edit profile</a></li>
                <li><a href="<c:url value='/logout'/>" class="nav_item">Log out</a></li>
            </ul>
        </div>
    </div>
</nav>

<section class="contact" id="contact">
    <div class="container">
        <h2 class="h2_title">Contact me</h2>

        <div class="divider_custom">
            <div class="divider_custom-line line-dark"></div>
            <div class="divider_custom-content">
                <i class="fas fa-star"></i>
            </div>
            <div class="divider_custom-line line-dark"></div>
        </div>
        <%UserDAOImplement userDao = new UserDAOImplement();%>
        <form name="user" class="contact_form" onsubmit="event.preventDefault();submitForm(this);">
            <input type="text" required placeholder="Brand" name="brand">
            <input type="text" required placeholder="Model" name="model">
            <input type="text" required placeholder="IMEI" name="imei">
            <input type="text" required placeholder="Comment" name="comment">
            <select name="solving" required id="solving">
                <%ProblemDAOImplement problemDao = new ProblemDAOImplement();%>
                <%List<Problem> problemList = problemDao.getAll();%>
                <% for (int i = 0; i < problemList.size(); i++) {%>
                <option><%=problemList.get(i).getProblem()%>
                </option>
                <%}%>
            </select>
            <input type="text" required placeholder="User Login" name="clientLogin" id="clientLogin">
            <select name="status" required id="status">
                <option value="created">CREATED</option>
                <option value="accepted">ACCEPTED</option>
                <option value="done">DONE</option>
            </select>
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
            <input type="date" placeholder="End date" name="endDate">
            <input name="submit" id="button" class="btn_send" type="submit" value="Send order">
        </form>
    </div>
</section>


<div class="copyright">
    <div class="container">
        <p>Copyright © Your Website 2019</p>
    </div>
</div>
</body>
</html>