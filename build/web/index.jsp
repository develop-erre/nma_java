<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="fonts/css/all.min.css">
        <link rel="stylesheet" href="css/style/signin.css" >
        <link href="css/style/cover.css" rel="stylesheet">
        <title>NMA App</title>
        
    </head>

    <body class="text-center">

        <div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
            <header class="masthead mb-auto">
                <div class="inner">
                    <h3 class="masthead-brand">PREVIRIESGOS</h3>
                    <nav class="nav nav-masthead justify-content-center">
                        <a class="nav-link active" href="index.jsp">Home</a>
                        <a class="nav-link active" href="#contact">Contacto</a>
                        <a class="nav-link active" href="login.jsp"><i class="fas fa-sign-in-alt"></i> Login</a>
                    </nav>
                </div>
            </header>

            <main role="main" class="inner cover">
                <h1 class="cover-heading">Cover your page.</h1>
                <p class="lead">Cover is a one-page template for building simple and beautiful home pages. Download, edit the text, and add your own fullscreen background photo to make it your own.</p>
                <p class="lead">
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-info btn-block ">
                        Leer más
                    </button>
                </p>
            </main>

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
                                <a href="#">Contacto@Previriesgos.cl</a><br>
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
                                    <a href="#" class="btn btn-danger">
                                        <i class="fab fa-google"></i>
                                        <span class="network-name">Google+</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </section>

            <p class="mt-5 mb-3 text-muted">NMA &copy; 2018</p>

        </div>
        
        <script src="js/jquery-3.3.1.slim.min.js" ></script>
        <script src="js/popper.min.js" ></script>
        <script src="js/bootstrap.min.js" ></script>
    </body>
</html>