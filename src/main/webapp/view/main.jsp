<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
    <link href="https://fonts.googleapis.com/css?family=Montserrat:700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
</head>

<body id="page-top">
    <nav class="nav_bar">
        <div class="container">
            <input type="checkbox" id="menu">
            <div class="nav_wrap">
                <a class="nav_left nav_item" href="#page-top">Repair service</a>
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
            <h1 class="header_title">Наші клієнти — наші партнери</h1>

            <p class="header_text">
                Люди приносять нам не просто техніку, а своїх помічників в роботі та побуті. Ми це розуміємо, тому до замовлень ставимося відповідально. І цінуємо, коли клієнти до нас повертаються. Постійні клієнти – найприємніший комплімент для сервісного центру. Постійні клієнти – це результат партнерських відносин: сумлінно виконуючи свою роботу, ми заробляємо довіру клієнтів, і Ви повертаєтеся до нас знову.

                Ми поряд та готові допомогти
                Думаючи про своїх клієнтів і співробітників, керівництво мережі сервісних центрів «TotalService» подбало, щоб всі майстерні були легкодоступні. Ніколи ремонт ноутбуків в Києві не був так близько. І ніколи не було так легко нести хлібопічку до сервісного центру.

                Ми цінуємо довіру до нашого сервісного центру, тому ми пропонуємо Якість, даємо Гарантію і працюємо на Результат. Вибір СЦ «TotalService» – хороший вибір!</p>
        </div>
    </header>


    <div class="copyright">
        <div class="container">
            <p>Copyright © Your Website 2019</p>
        </div>
    </div>
</body>
</html>