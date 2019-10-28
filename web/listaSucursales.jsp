<%@page import="java.sql.ResultSet"%>
<%@page import="java.lang.String"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesion = request.getSession();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="Css/Css.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Lista de Sucursal</title>
    </head>
    <body>

        <% String rs = String.valueOf(sesion.getAttribute("id_rol"));%>
        <c:set var="id_rol" value="<%=rs%>" />

        <c:choose>
            <c:when test="${id_rol == 1}">

            </c:when>    
            <c:otherwise>
                <%response.sendRedirect("http://localhost:8080/nma/home.jsp");%>
            </c:otherwise>
        </c:choose>

        <h2>Lista de Empresas</h2>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Id Sucursal</th>
                    <th>Nombre Sucursal</th>
                    <th>Direccion</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaSucursal}" var="sucursal">
                    <tr>
                        <td>${sucursal.id_sucursal}</td>
                        <td>${sucursal.nombre}</td>
                        <td>${sucursal.direccion}</td>
                        <td>
                            <form action="programarVisita" method="POST">
                                <input type="submit" value="Programar Visita" />
                                <input type="hidden" name="txtIdSucursal" value="${sucursal.id_sucursal}" />
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
