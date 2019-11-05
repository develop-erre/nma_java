<%@page import="java.lang.String"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesion = request.getSession();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width"/>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style/footer.css">
        <link rel="stylesheet" href="fonts/css/all.min.css">
        <meta name="viewport" content="width=device-width"/>
        <title>Home Principal</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${id_rol == 1}">
                <jsp:include page="menuAdmin.jsp"/>
            </c:when>    
            <c:when test="${id_rol == 2}">
                <jsp:include page="menuProfesional.jsp"/>
            </c:when>  
            <c:otherwise>
                <jsp:include page="menuCliente.jsp"/>
            </c:otherwise>
        </c:choose>


        <% String rs = String.valueOf(sesion.getAttribute("id_rol"));%>
        <c:set var="id_rol" value="<%=rs%>" />

        <h1>Hello Home!</h1>
        <h1>id rol rescatado </h1>
        <h1><%=rs%></h1>

        <h3>rut <%= sesion.getAttribute("run")%> </h3><br>
        <h3>Nombre <%= sesion.getAttribute("nombre")%> </h3><br>
        <h3>id usuario  <%= sesion.getAttribute("id_usuario")%> </h3><br>
        <h3>id rol <%= sesion.getAttribute("id_rol")%> </h3><br>
        <h3>id empresa <%= sesion.getAttribute("id_empresa")%> </h3><br>
        <h3>estado <%= sesion.getAttribute("estado")%> </h3><br>


        <h5>Pass <%= sesion.getId()%> </h5><br>

        <footer class="py-4 text-center footer" style="background: #454545">
            <div class="container">
                <h6>Previriesgos &copy; 2018</h6>
            </div>
        </footer>

        <script src="js/jquery-3.4.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
