<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="fonts/css/all.min.css">
        <link rel="stylesheet" href="css/style/signin.css" >
        <meta name="viewport" content="width=device-width"/>
        <title>Capacitación</title>
        <script lenguage="javascript" src="js/jquery-3.4.1.min.js"></script>
    </head>
    <body class="text-center">
        <form class="form-signin" action="login" method="POST">
            <img class="mb-4" src="imagen/icon-login.png" alt="" width="85" height="85">
            <h1 class="h3 mb-3 font-weight-normal">Favor, registrarse</h1>
            <label for="inputEmail" class="sr-only">Run</label>
            <input type="text" id="inputEmail" class="form-control" name="txtRun" placeholder="Ingresar Run" required autofocus>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" class="form-control" name="txtPass" placeholder="Password" required>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Registrarse</button>

            <c:out value="${error1}"></c:out>
            <c:out value="${error2}"></c:out>
            <br>
            <a href="index.jsp">Volver</a>
            <p class="mt-5 mb-3 text-muted">NMA &copy; 2018</p>
        </form>

        <script src="js/jquery-3.3.1.slim.min.js" ></script>
        <script src="js/popper.min.js" ></script>
        <script src="js/bootstrap.min.js" ></script>
    </body>
</html>
