<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width"/>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="fonts/css/all.min.css">
        <link rel="stylesheet" href="css/style/signin.css" >
        <link href="css/style/cover.css" rel="stylesheet">
        <title>Previriesgos Web</title>
        <script>

            window.onload = function () {
                document.getElementById("btnGoogle").onmouseover = function () {
                    document.localName();
                };
            };


        </script> 

    </head>

    <body class="text-center">

        <div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
            <header class="masthead mb-auto">
                <div class="inner">
                    <h3 class="masthead-brand">PREVIRIESGOS</h3>
                    <nav class="nav nav-masthead justify-content-center">
                        <a class="nav-link active" href="index.jsp">Home</a>
                        <a class="nav-link active" href="#contact">Contacto</a>
                        <a class="nav-link active" href="#ubicacion">Ubicación</a>
                        <a class="nav-link active" href="login.jsp"><i class="fas fa-sign-in-alt"></i> Login</a>
                    </nav>
                </div>
            </header>

            <br>
            <br>

            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="imagen/01.jpg" alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="imagen/02.jpg" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="imagen/03.jpg" alt="Third slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>

            <br>
            <!-- Contact Section -->
            <section id="contact" >
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 mx-auto">
                            <h1>Contacto </h1>
                            <br>
                            <p class="lead">Si requieres ayuda o presentas algun problema con el servicio, no dudes en contactanos.
                                <br>
                                Correo: 
                                <a href="#">previriesgosduoc@gmail.com</a><br>
                                Mesas de ayuda:
                                <a href="#">+562 2 2625 1234</a><br>
                                <br><br>
                                No olvides visitarnos en:
                            </p>			 
                            <ul class="list-inline banner-social-buttons">
                                <li class="list-inline-item">
                                    <a href="#" class="btn btn-primary">
                                        <i class="fab fa-twitter"></i>
                                        <span class="network-name">Twitter</span>
                                    </a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="#" class="btn btn-danger" id="btnGoogle" >
                                        <i class="fab fa-google"></i>
                                        <span class="network-name">Google+</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </section>
            <br>
            <section id="ubicacion" >
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 mx-auto">
                            <h1>Ubicación </h1>
                        </div>
                    </div>
                </div>
            </section>
            <br>
            <div 
                id="wrapper-9cd199b9cc5410cd3b1ad21cab2e54d3">
                <div 
                    id="map-9cd199b9cc5410cd3b1ad21cab2e54d3">
                </div>
            </div> 
            <!-- Contact Section -->
            <section id="ubicacion" >
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 mx-auto">
                            Providencia, 727 - Santiago - Chile</li>
                            <br>
                            <p class="mt-5 mb-3 text-muted">NMA &copy; 2018</p>
                        </div>
                    </div>
                </div>
        </div>

        <script>(function () {
                var setting = {"height": 500, "width": 1000, "zoom": 17, "queryString": "Providencia 727, Providencia, Chile", "place_id": "ChIJpUh2RYbFYpYRYXDVufAByeE", "satellite": false, "centerCoord": [-33.43289856048422, -70.62547230000001], "cid": "0xe1c901f0b9d57061", "id": "map-9cd199b9cc5410cd3b1ad21cab2e54d3", "embed_id": "42040"};
                var d = document;
                var s = d.createElement('script');
                s.src = 'https://1map.com/js/script-for-user.js?embed_id=42040';
                s.async = true;
                s.onload = function (e) {
                    window.OneMap.initMap(setting)
                };
                var to = d.getElementsByTagName('script')[0];
                to.parentNode.insertBefore(s, to);
            })();</script>

    </div>




    <script src="js/jquery-3.3.1.slim.min.js" ></script>
    <script src="js/popper.min.js" ></script>
    <script src="js/bootstrap.min.js" ></script>
</body>
</html>