<%@ page import="dao.UserDAOImplement" %>
<%@ page import="model.Role" %>
<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Problem" %>
<%@ page import="dao.ProblemDAOImplement" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            obj.brand = form.brand.value;
            obj.model = form.model.value;
            obj.imei = form.imei.value;
            obj.comment = form.comment.value;
            obj.solving = form.solving.value;
            obj.clientLogin = form.clientLogin.value;
            obj.status = form.status.value;
            obj.masterSurname = form.masterSurname.value;
            obj.managerSurname = form.managerSurname.value;
            obj.endDate = new Date(form.endDate.value).getTime();
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
        <%UserDAOImplement userDao = new UserDAOImplement();%>
        <form name="user" class="forms_form" onsubmit="event.preventDefault();submitForm(this);">
            <input type="text" required placeholder="<fmt:message key="brand"/>" name="brand">
            <input type="text" required placeholder="<fmt:message key="model"/>" name="model">
            <input type="text" required placeholder="IMEI" name="imei">
            <input type="text" required placeholder="<fmt:message key="comment"/>" name="comment">
            <select name="solving" required id="solving">
                <%ProblemDAOImplement problemDao = new ProblemDAOImplement();%>
                <%List<Problem> problemList = problemDao.getAll();%>
                <% for (int i = 0; i < problemList.size(); i++) {%>
                <option><%=problemList.get(i).getProblem()%>
                </option>
                <%}%>
            </select>
            <input type="text" required placeholder="<fmt:message key="login"/>" name="clientLogin" id="clientLogin">
            <select name="status" required id="status">
                <option value="created"><fmt:message key="created"/></option>
                <option value="accepted"><fmt:message key="accepted"/></option>
                <option value="done"><fmt:message key="done"/></option>
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
            <input type="date" placeholder="<fmt:message key="end_date"/>" name="endDate">
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