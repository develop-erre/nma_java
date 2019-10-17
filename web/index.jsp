<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="Css/Css.css">
        <title>NMA</title>
    </head>
    <body>
        <div class="boxLogin">
            <form action="login" method="post">
                <br>
                <h4>Run</h4>
                    <input type="text" class="input-text" name = "txtRun" placeholder="Ingresa Run" value = "" required="" minlength="3">
                    <h4>Password</h4> 
                    <input type="password" class="input-text"  name = "txtPass" placeholder="Ingresa Password" value = "" required="" minlength="3">
                    <br>
                    <br>
                    <br>
                    <input type = "submit" class="input-login"  value = "Login">
                <br>
                <c:out value="${error1}"></c:out>
                <c:out value="${error2}"></c:out>
                <br>
                <br>
            </form>
        </div>
    </body>
</html>