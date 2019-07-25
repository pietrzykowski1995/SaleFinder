<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Sale Finder</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700|Work+Sans:300,400,700" rel="stylesheet">
    <link rel="stylesheet" href="../../resources/fonts/icomoon/style.css">

    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/magnific-popup.css">
    <link rel="stylesheet" href="../../resources/css/jquery-ui.css">
    <link rel="stylesheet" href="../../resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="../../resources/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="../../resources/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="../../resources/css/animate.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mediaelement@4.2.7/build/mediaelementplayer.min.css">


    <link rel="stylesheet" href="../../resources/fonts/flaticon/font/flaticon.css">

    <link rel="stylesheet" href="../../resources/css/aos.css">

    <link rel="stylesheet" href="../../resources/css/style.css">

</head>
<body>

<%@ include file="header.jsp" %>

<div class="unit-5 overlay" style="background-image: url('images/hero_1.jpg');">
    <div class="container text-center">
        <h2 class="mb-0">Lista kategorii</h2>
        <%--        <p class="mb-0 unit-6"><a href="index.html">Home</a> <span class="sep">></span> <span>Dodaj promocje</span></p>--%>
    </div>
</div>
<br/>

<div class="site-section">
    <div class="container">
        <div class="row">
            <div class="col-md-6 mx-auto text-center mb-5 section-heading">
            </div>
        </div>
        <div class="row">
            <c:forEach items="${categories}" var="category">
                <div class="col-sm-6 col-md-4 col-lg-3 mb-3" data-aos="fade-up" data-aos-delay="100">
                    <a href="/category/${category.id}" class="h-100 feature-item">
                        <span class="d-block icon flaticon-calculator mb-3 text-primary"></span>
                        <h2>${category.name}</h2>
                        <span class="counting">${category.productQuantity}</span>
                    </a>
                </div>
            </c:forEach>
            <div class="col-md-12 text-center mt-5" data-aos="fade-up" data-aos-delay="100">
                <h3 class="h5 text-black mb-3">Brakuje kategorii?</h3>
                <a href="create-category" class="btn btn-primary rounded py-3 px-5"><span class="icon-plus-circle"></span> Dodaj ją!</a>
            </div>
        </div>

    </div>
</div>

<br/>

<%@ include file="footer.jsp" %>

</body>
</html>
