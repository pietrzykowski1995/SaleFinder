<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
        <h2 class="mb-0">Edycja</h2>
        <%--        <p class="mb-0 unit-6"><a href="index.html">Home</a> <span class="sep">></span> <span>Dodaj promocje</span></p>--%>
    </div>
</div>


<div class="site-section bg-light">
    <div class="container">
        <div class="row">

            <div class="col-md-12 col-lg-8 mb-5">


                <form action="/add-city/${id}" method="post" class="p-5 bg-white">


                    <div class="row form-group mb-4">
                        <div class="col-md-12"><h3>Dodaj miasto</h3></div>
                        <div class="col-md-12 mb-3 mb-md-0">
                            <input type="text" name="cityName" class="form-control"/>
                        </div>
                    </div>

                    <div class="row form-group">
                        <div class="col-md-12">
                            <input type="submit" value="Dodaj" class="btn btn-primary  py-2 px-5">
                        </div>
                    </div>
                </form>

                <c:forEach items="${cities}" var="city">
                    <div class="col-sm-6 col-md-4 col-lg-3 mb-3" data-aos="fade-up" data-aos-delay="100">
                        <a href="/category/${city.name}" class="h-100 feature-item">
                            <span class="d-block icon flaticon mb-3 text-primary"></span>
                            <h2>${city.name}</h2>
                            <span class="counting">${city.id}</span>
                        </a>
                    </div>
                </c:forEach>

            </div>
        </div>
    </div>
</div>


</div>
</div>

<%@ include file="footer.jsp" %>
