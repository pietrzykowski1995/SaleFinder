<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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


<div class="site-blocks-cover overlay"
     style="background-image: url('../../../../../Downloads/jobfinder/images/hero_1.jpg');" data-aos="fade"
     data-stellar-background-ratio="0.5">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-12" data-aos="fade">
                <h1>Znajdź promocje</h1>
                <form action="search" method="post">
                    <div class="row mb-3">
                        <div class="col-md-9">
                            <div class="row">
                                <div class="col-md-6 mb-3 mb-md-0">
                                    <input type="text" name="productName" class="mr-3 form-control border-0 px-4"
                                                placeholder="produkt"/>
                                </div>
                                <div class="col-md-6 mb-3 mb-md-0">
                                    <div class="input-wrap">
                                        <span class="icon icon-room"></span>
                                        <input type="text" name="cityName"
                                               class="form-control form-control-block search-input  border-0 px-4"
                                               id="autocomplete" placeholder="miasto lub województwo"
                                               onFocus="geolocate()">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <input type="submit" class="btn btn-search btn-primary btn-block" value="Wyszukaj">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<div class="site-section">
    <div class="container">
        <div class="row">
            <div class="col-md-6 mx-auto text-center mb-5 section-heading">
                <h2 class="mb-5">Najpopularniejsze kategorie</h2>
            </div>
        </div>
        <div class="row">
            <c:forEach items="${categories}" var="category" end="11">
                <div class="col-sm-6 col-md-4 col-lg-3 mb-3" data-aos="fade-up" data-aos-delay="100">
                    <a href="/category/${category.id}" class="h-100 feature-item">
                        <span class="d-block icon flaticon-calculator mb-3 text-primary"></span>
                        <h2>${category.name}</h2>
                        <span class="counting">${category.productQuantity}</span>
                    </a>
                </div>
            </c:forEach>
            <%--<div class="col-sm-6 col-md-4 col-lg-3 mb-3" data-aos="fade-up" data-aos-delay="200">
              <a href="#" class="h-100 feature-item">
                <span class="d-block icon flaticon-wrench mb-3 text-primary"></span>
                <h2>Automotive Jobs</h2>
                <span class="counting">192</span>
              </a>
            </div>
            <div class="col-sm-6 col-md-4 col-lg-3 mb-3" data-aos="fade-up" data-aos-delay="300">
              <a href="#" class="h-100 feature-item">
                <span class="d-block icon flaticon-worker mb-3 text-primary"></span>
                <h2>Construction / Facilities</h2>
                <span class="counting">1,021</span>
              </a>
            </div>
            <div class="col-sm-6 col-md-4 col-lg-3 mb-3" data-aos="fade-up" data-aos-delay="400">
              <a href="#" class="h-100 feature-item">
                <span class="d-block icon flaticon-telecommunications mb-3 text-primary"></span>
                <h2>Telecommunications</h2>
                <span class="counting">1,219</span>
              </a>
            </div>
            <div class="col-sm-6 col-md-4 col-lg-3 mb-3" data-aos="fade-up" data-aos-delay="500">
              <a href="#" class="h-100 feature-item">
                <span class="d-block icon flaticon-stethoscope mb-3 text-primary"></span>
                <h2>Healthcare</h2>
                <span class="counting">482</span>
              </a>
            </div>
            <div class="col-sm-6 col-md-4 col-lg-3 mb-3" data-aos="fade-up" data-aos-delay="600">
              <a href="#" class="h-100 feature-item">
                <span class="d-block icon flaticon-computer-graphic mb-3 text-primary"></span>
                <h2>Design, Art &amp; Multimedia</h2>
                <span class="counting">5,409</span>
              </a>
            </div>
            <div class="col-sm-6 col-md-4 col-lg-3 mb-3" data-aos="fade-up" data-aos-delay="700">
              <a href="#" class="h-100 feature-item">
                <span class="d-block icon flaticon-trolley mb-3 text-primary"></span>
                <h2>Transportation &amp; Logistics</h2>
                <span class="counting">291</span>
              </a>
            </div>
            <div class="col-sm-6 col-md-4 col-lg-3 mb-3" data-aos="fade-up" data-aos-delay="800">
              <a href="#" class="h-100 feature-item">
                <span class="d-block icon flaticon-restaurant mb-3 text-primary"></span>
                <h2>Restaurant / Food Service</h2>
                <span class="counting">329</span>
              </a>
            </div>--%>
        </div>

    </div>
</div>


<div class="site-section bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-12 mb-5 mb-md-0" data-aos="fade-up" data-aos-delay="100">
                <div class="col-md-6 mx-auto text-center mb-5 section-heading">
                    <h2 class="mb-5">Ostatnie promocje</h2>
                </div>
                <div class="rounded border jobs-wrap">

                    <c:forEach items="${top10Products}" var="product">
                        <a href="../../../../../Downloads/jobfinder/job-single.html"
                           class="job-item d-block d-md-flex align-items-center  border-bottom fulltime">
                            <div class="company-logo blank-logo text-center text-md-left pl-3">
                                <img src="../../resources/images/company_logo_blank.png" alt="Image" class="img-fluid mx-auto">
                            </div>
                            <div class="job-details h-100">
                                <div class="p-3 align-self-center">
                                    <h3>${product.name}</h3>
                                    <div class="d-block d-lg-flex">
                                        <div class="mr-3"><span class="icon-suitcase mr-1"></span>${product.category.name}</div>
                                        <div class="mr-3"><span class="icon-room mr-1"></span>${product.shop.name}</div>
                                        <div><span class="icon-money mr-1"></span>Cena przed obniżką: ${product.priceBeforeSale} zł</div>
                                    </div>
                                </div>
                            </div>
                            <div class="job-category align-self-center">
                                <div class="p-3">
                                    <span class="text-info p-2 rounded border border-info">${product.price} zł</span>
                                </div>
                            </div>
                        </a>
                    </c:forEach>
                </div>


            </div>
           <%-- <div class="col-md-4 block-16" data-aos="fade-up" data-aos-delay="200">
                <div class="d-flex mb-0">
                    <h2 class="mb-5 h3 mb-0">Nadchodzące promocje</h2>
                    <div class="ml-auto mt-1"><a href="#" class="owl-custom-prev">Prev</a> / <a href="#"
                                                                                                class="owl-custom-next">Next</a>
                    </div>
                </div>

                <div class="nonloop-block-16 owl-carousel">

                    <div class="border rounded p-4 bg-white">
                        <h2 class="h5">Restaurant Crew</h2>
                        <p><span class="border border-warning rounded p-1 px-2 text-warning">Freelance</span></p>
                        <p>
                            <span class="d-block"><span class="icon-suitcase"></span> Resto Bar</span>
                            <span class="d-block"><span class="icon-room"></span> Florida</span>
                            <span class="d-block"><span class="icon-money mr-1"></span> $55000 &mdash; 70000</span>
                        </p>
                    </div>

                    <div class="border rounded p-4 bg-white">
                        <h2 class="h5">Javascript Fullstack Developer</h2>
                        <p><span class="border border-warning rounded p-1 px-2 text-warning">Freelance</span></p>
                        <p>
                            <span class="d-block"><span class="icon-suitcase"></span> Resto Bar</span>
                            <span class="d-block"><span class="icon-room"></span> Florida</span>
                            <span class="d-block"><span class="icon-money mr-1"></span> $55000 &mdash; 70000</span>
                        </p>
                        <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ducimus accusamus
                            necessitatibus praesentium voluptate natus excepturi rerum, autem. Magnam laboriosam, quam
                            sapiente laudantium iure sit ea! Tenetur, quasi, praesentium. Architecto, eum.</p>
                    </div>

                    <div class="border rounded p-4 bg-white">
                        <h2 class="h5">Assistant Brooker, Real Estate</h2>
                        <p><span class="border border-warning rounded p-1 px-2 text-warning">Freelance</span></p>
                        <p>
                            <span class="d-block"><span class="icon-suitcase"></span> Resto Bar</span>
                            <span class="d-block"><span class="icon-room"></span> Florida</span>
                            <span class="d-block"><span class="icon-money mr-1"></span> $55000 &mdash; 70000</span>
                        </p>
                        <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Delectus esse, quam
                            consectetur ipsum quibusdam ullam ab nesciunt, doloribus voluptatum neque iure perspiciatis
                            vel vero illo consequatur facilis, fuga nobis corporis.</p>
                    </div>

                    <div class="border rounded p-4 bg-white">
                        <h2 class="h5">Telecommunication Manager</h2>
                        <p><span class="border border-warning rounded p-1 px-2 text-warning">Freelance</span></p>
                        <p>
                            <span class="d-block"><span class="icon-suitcase"></span> Resto Bar</span>
                            <span class="d-block"><span class="icon-room"></span> Florida</span>
                            <span class="d-block"><span class="icon-money mr-1"></span> $55000 &mdash; 70000</span>
                        </p>
                        <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid at ipsum
                            commodi hic, cum esse asperiores libero molestiae, perferendis consectetur assumenda iusto,
                            dolorem nemo maiores magnam illo laborum sit, dicta.</p>
                    </div>

                </div>

            </div>--%>
        </div>
    </div>
</div>

<!--<div class="site-section" data-aos="fade">
  <div class="container">
    <div class="row align-items-center">
      <div class="col-md-6 mb-5 mb-md-0">

          <div class="img-border">
            <a href="https://vimeo.com/28959265" class="popup-vimeo image-play">
              <span class="icon-wrap">
                <span class="icon icon-play"></span>
              </span>
              <img src="../../../../../Downloads/jobfinder/images/hero_2.jpg" alt="Image" class="img-fluid rounded">
            </a>
          </div>

      </div>
      <div class="col-md-5 ml-auto">
        <div class="text-left mb-5 section-heading">
          <h2>Testimonies</h2>
        </div>

        <p class="mb-4 h5 font-italic lineheight1-5">&ldquo;Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eaque, nisi Lorem ipsum dolor sit amet, consectetur adipisicing elit. Odit nobis magni eaque velit eum, id rem eveniet dolor possimus voluptas..&rdquo;</p>
        <p>&mdash; <strong class="text-black font-weight-bold">John Holmes</strong>, Marketing Strategist</p>
        <p><a href="https://vimeo.com/28959265" class="popup-vimeo text-uppercase">Watch Video <span class="icon-arrow-right small"></span></a></p>
      </div>
    </div>
  </div>
</div>-->


<!--    <div class="site-blocks-cover overlay inner-page" style="background-image: url('../../../../../Downloads/jobfinder/images/hero_1.jpg');" data-aos="fade" data-stellar-background-ratio="0.5">
      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-6 text-center" data-aos="fade">
            <h1 class="h3 mb-0">Your Dream Job</h1>
            <p class="h3 text-white mb-5">Is Waiting For You</p>
            <p><a href="#" class="btn btn-outline-warning py-3 px-4">Find Jobs</a> <a href="#" class="btn btn-warning py-3 px-4">Apply For A Job</a></p>
            
          </div>
        </div>
      </div>
    </div>-->


<!--<div class="site-section site-block-feature bg-light">
  <div class="container">

    <div class="text-center mb-5 section-heading">
      <h2>Why Choose Us</h2>
    </div>

    <div class="d-block d-md-flex border-bottom">
      <div class="text-center p-4 item border-right" data-aos="fade">
        <span class="flaticon-worker display-3 mb-3 d-block text-primary"></span>
        <h2 class="h4">More Jobs Every Day</h2>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Obcaecati reprehenderit explicabo quos fugit vitae dolorum.</p>
        <p><a href="#">Read More <span class="icon-arrow-right small"></span></a></p>
      </div>
      <div class="text-center p-4 item" data-aos="fade">
        <span class="flaticon-wrench display-3 mb-3 d-block text-primary"></span>
        <h2 class="h4">Creative Jobs</h2>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Obcaecati reprehenderit explicabo quos fugit vitae dolorum.</p>
        <p><a href="#">Read More <span class="icon-arrow-right small"></span></a></p>
      </div>
    </div>
    <div class="d-block d-md-flex">
      <div class="text-center p-4 item border-right" data-aos="fade">
        <span class="flaticon-stethoscope display-3 mb-3 d-block text-primary"></span>
        <h2 class="h4">Healthcare</h2>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Obcaecati reprehenderit explicabo quos fugit vitae dolorum.</p>
        <p><a href="#">Read More <span class="icon-arrow-right small"></span></a></p>
      </div>
      <div class="text-center p-4 item" data-aos="fade">
        <span class="flaticon-calculator display-3 mb-3 d-block text-primary"></span>
        <h2 class="h4">Finance &amp; Accounting</h2>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Obcaecati reprehenderit explicabo quos fugit vitae dolorum.</p>
        <p><a href="#">Read More <span class="icon-arrow-right small"></span></a></p>
      </div>
    </div>
  </div>
</div>-->


<!--    <div class="site-section block-15">
      <div class="container">
        <div class="row">
          <div class="col-md-6 mx-auto text-center mb-5 section-heading">
            <h2>Recent Blog</h2>
          </div>
        </div>


        <div class="nonloop-block-15 owl-carousel">
          

            <div class="media-with-text">
              <div class="img-border-sm mb-4">
                <a href="#" class="image-play">
                  <img src="resources/images/img_1.jpg" alt="" class="img-fluid">
                </a>
              </div>
              <h2 class="heading mb-0 h5"><a href="#">Jobs are made easy</a></h2>
              <span class="mb-3 d-block post-date">January 20, 2018 &bullet; By <a href="#">Josh Holmes</a></span>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio dolores culpa qui aliquam placeat nobis veritatis tempora natus rerum obcaecati.</p>
            </div>
          
            <div class="media-with-text">
              <div class="img-border-sm mb-4">
                <a href="#" class="image-play">
                  <img src="resources/images/img_2.jpg" alt="" class="img-fluid">
                </a>
              </div>
              <h2 class="heading mb-0 h5"><a href="#">Jobs are made easy</a></h2>
              <span class="mb-3 d-block post-date">January 20, 2018 &bullet; By <a href="#">Josh Holmes</a></span>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio dolores culpa qui aliquam placeat nobis veritatis tempora natus rerum obcaecati.</p>
            </div>
          
            <div class="media-with-text">
              <div class="img-border-sm mb-4">
                <a href="#" class="image-play">
                  <img src="resources/images/img_3.jpg" alt="" class="img-fluid">
                </a>
              </div>
              <h2 class="heading mb-0 h5"><a href="#">Jobs are made easy</a></h2>
              <span class="mb-3 d-block post-date">January 20, 2018 &bullet; By <a href="#">Josh Holmes</a></span>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio dolores culpa qui aliquam placeat nobis veritatis tempora natus rerum obcaecati.</p>
            </div>

            <div class="media-with-text">
              <div class="img-border-sm mb-4">
                <a href="#" class="image-play">
                  <img src="resources/images/img_1.jpg" alt="" class="img-fluid">
                </a>
              </div>
              <h2 class="heading mb-0 h5"><a href="#">Jobs are made easy</a></h2>
              <span class="mb-3 d-block post-date">January 20, 2018 &bullet; By <a href="#">Josh Holmes</a></span>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio dolores culpa qui aliquam placeat nobis veritatis tempora natus rerum obcaecati.</p>
            </div>
          
            <div class="media-with-text">
              <div class="img-border-sm mb-4">
                <a href="#" class="image-play">
                  <img src="resources/images/img_2.jpg" alt="" class="img-fluid">
                </a>
              </div>
              <h2 class="heading mb-0 h5"><a href="#">Jobs are made easy</a></h2>
              <span class="mb-3 d-block post-date">January 20, 2018 &bullet; By <a href="#">Josh Holmes</a></span>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio dolores culpa qui aliquam placeat nobis veritatis tempora natus rerum obcaecati.</p>
            </div>
          
            <div class="media-with-text">
              <div class="img-border-sm mb-4">
                <a href="#" class="image-play">
                  <img src="resources/images/img_3.jpg" alt="" class="img-fluid">
                </a>
              </div>
              <h2 class="heading mb-0 h5"><a href="#">Jobs are made easy</a></h2>
              <span class="mb-3 d-block post-date">January 20, 2018 &bullet; By <a href="#">Josh Holmes</a></span>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio dolores culpa qui aliquam placeat nobis veritatis tempora natus rerum obcaecati.</p>
            </div>
            
            <div class="media-with-text">
              <div class="img-border-sm mb-4">
                <a href="#" class="image-play">
                  <img src="resources/images/img_1.jpg" alt="" class="img-fluid">
                </a>
              </div>
              <h2 class="heading mb-0 h5"><a href="#">Jobs are made easy</a></h2>
              <span class="mb-3 d-block post-date">January 20, 2018 &bullet; By <a href="#">Josh Holmes</a></span>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio dolores culpa qui aliquam placeat nobis veritatis tempora natus rerum obcaecati.</p>
            </div>
          
            <div class="media-with-text">
              <div class="img-border-sm mb-4">
                <a href="#" class="image-play">
                  <img src="resources/images/img_2.jpg" alt="" class="img-fluid">
                </a>
              </div>
              <h2 class="heading mb-0 h5"><a href="#">Jobs are made easy</a></h2>
              <span class="mb-3 d-block post-date">January 20, 2018 &bullet; By <a href="#">Josh Holmes</a></span>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio dolores culpa qui aliquam placeat nobis veritatis tempora natus rerum obcaecati.</p>
            </div>
          
            <div class="media-with-text">
              <div class="img-border-sm mb-4">
                <a href="#" class="image-play">
                  <img src="resources/images/img_3.jpg" alt="" class="img-fluid">
                </a>
              </div>
              <h2 class="heading mb-0 h5"><a href="#">Jobs are made easy</a></h2>
              <span class="mb-3 d-block post-date">January 20, 2018 &bullet; By <a href="#">Josh Holmes</a></span>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio dolores culpa qui aliquam placeat nobis veritatis tempora natus rerum obcaecati.</p>
            </div>
        </div>

        <div class="row">
          
        </div>
      </div>
    </div>-->


<%@ include file="footer.jsp" %>