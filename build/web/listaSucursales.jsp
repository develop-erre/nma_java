<%@page import="java.sql.ResultSet"%>
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
        <link rel="stylesheet" href="fonts/css/all.min.css">
        <title>Lista de Sucursales</title>
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

        <% String nameEmpresa = (String)request.getAttribute("nombreEmpresa"); %>
        
        <br>
        <div class="container-fluid">
            <h3>Sucursales <%=nameEmpresa%></h3>
            <br>
            <table class="table table-sm table-responsive-md table-striped">
                <thead class="thead-light">
                    <tr>
                        <th>Nombre Sucursal</th>
                        <th>Direccion</th>
                        <th>Crear</th>
                        <th>visita</th>
                        <th>Capacitación</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaSucursal}" var="sucursales">
                        <tr>
                            <td>${sucursales.nombre_sucursal}</td>
                            <td>${sucursales.direccion_sucural}</td>
                            <td>
                                <form action="cargarRegionCrearUsuarioEmpresa" method="POST">
                                    <button type="submit" class="btn btn-success" ><i class="fas fa-user-plus"></i> Crear Usuario</button>
                                    <input type="hidden" name="txtIdSucursal" value="${sucursales.id_sucursal}" />
                                    <input type="hidden" name="nombre_sucursal" value="${sucursales.nombre_sucursal}" />
                                </form>
                            </td>
                            <td>
                                <form action="programarVisita" method="POST">
                                    <input type="submit" value="Programar Visita" class="btn btn-primary" />
                                    <input type="hidden" name="txtIdSucursal" value="${sucursales.id_sucursal}" />
                                </form>
                            </td>
                            <td>
                                <form action="cargarCapacitacion" method="POST">
                                    <input type="submit" value="Crear Capacitación" class="btn btn-primary"/>
                                    <input type="hidden" name="txtIdSucursal" value="${sucursales.id_sucursal}" />
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <script src="js/jquery-3.4.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
