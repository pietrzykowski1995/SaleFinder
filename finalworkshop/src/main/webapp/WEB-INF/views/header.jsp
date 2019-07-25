<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="UTF-8">

<div class="site-wrap">

    <div class="site-mobile-menu">
        <div class="site-mobile-menu-header">
            <div class="site-mobile-menu-close mt-3">
                <span class="icon-close2 js-menu-toggle"></span>
            </div>
        </div>
        <div class="site-mobile-menu-body"></div>
    </div> <!-- .site-mobile-menu -->


    <div class="site-navbar-wrap js-site-navbar bg-white">

        <div class="container">
            <div class="site-navbar bg-light">
                <div class="py-1">
                    <div class="row align-items-center">
                        <div class="col-2">
                            <h2 class="mb-0 site-logo"><a href="/">Sale<strong class="font-weight-bold">Finder</strong> </a></h2>
                        </div>
                        <div class="col-10">
                            <nav class="site-navigation text-right" role="navigation">
                                <div class="container">
                                    <div class="d-inline-block d-lg-none ml-md-0 mr-auto py-3"><a href="#" class="site-menu-toggle js-menu-toggle text-black"><span class="icon-menu h3"></span></a></div>

                                    <ul class="site-menu js-clone-nav d-none d-lg-block">
                                        <li><a href="mega-sales">MEGA Promocje</a></li>
                                        <li class="has-children">
                                            <a href="category.html">Statystyki</a>
                                            <ul class="dropdown arrow-top">
                                                <li><a href="/categories">Kategorie</a></li>
                                                <li><a href="#">Użytkownicy</a></li>
                                                <li><a href="#">Sklepy</a></li>
                                      <%--          <li class="has-children">
                                                    <a href="#">More Links</a>
                                                    <ul class="dropdown">
                                                        <li><a href="#">Browse Candidates</a></li>
                                                        <li><a href="#">Post a Job</a></li>
                                                        <li><a href="#">Employeer Profile</a></li>
                                                    </ul>
                                                </li>--%>

                                            </ul>
                                        </li>
                                        <li><a href="../../../../../Downloads/jobfinder/contact.html">Kontakt</a></li>
                                        <li><a href="/new-post"><span class="bg-primary text-white py-3 px-4 rounded"><span class="icon-plus mr-3"></span>Dodaj nową promocje</span></a></li>
                                    </ul>
                                </div>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div style="height: 113px;">

    </div>
</div>