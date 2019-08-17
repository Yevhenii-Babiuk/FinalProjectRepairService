<%@ page import="model.User" %>
<%@ page import="dao.UserDAOImplement" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%String login =  request.getSession().getAttribute("login").toString();%>

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
            obj.name = form.name.value;
            obj.surname = form.surname.value;
            obj.phone = form.phone.value;
            obj.address = form.address.value;
            obj.login = form.login.value;
            obj.password = form.password.value;
            obj.role= null;
            var jsonObject = JSON.stringify(obj);

            var xhr = new XMLHttpRequest();
            xhr.open('POST', "/account/edit", true);
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
                <li><a href="<c:url value='/account/login' />" class="nav_item">Authorization</a></li>
                <li><a href="<c:url value='/account/office' />" class="nav_item">user`s office</a></li>
                <li><a href="<c:url value='/registration' />" class="nav_item">Registration</a></li>
                <li><a href="<c:url value='/contact' />" class="nav_item">Contact</a></li>
                <li><a href="<c:url value='/price' />" class="nav_item">Price</a></li>
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
        <%User user = new UserDAOImplement().getEntityByLogin(login);%>
        <form name="user" class="contact_form" onsubmit="event.preventDefault();submitForm(this);">
            <input type="text" required placeholder="Name" name="name" value="<%user.getName();%>">
            <input type="text" required placeholder="Surname" name="surname" value="<%user.getSurname();%>">
            <input type="text" required placeholder="Phone" pattern="+[0-9]{11,12}" name="phone" value="<%user.getPhone();%>">
            <input type="text" required placeholder="Address" name="address" value="<%user.getAddress();%>">
            <input type="text" readonly required placeholder="Login" name="login" value="<%user.getLogin();%>">
            <input type="password" required placeholder="Password" name="password" value="<%user.getPassword();%>">
            <input name="submit" id="button" class="btn_send" type="submit" value="Save">
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