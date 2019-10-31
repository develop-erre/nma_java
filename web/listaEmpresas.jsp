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
        <script lenguage="javascript">
            function confirmarDeleteEmpresa() {

                var respuesta = confirm("Estas seguro que deseas Deshabilitar la Empresa?");

                if (respuesta === true) {
                    return true;
                } else {
                    return false;

                }
            }
        </script>
        <title>Lista de Empresas</title>
        
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
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Rut</th>
                    <th>Casa Matriz</th>
                    <th>Dirección</th>
                    <th>Sucursal</th>
                    <th>Ver</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaEmp}" var="empresa">
                    <tr>
                        <td>${empresa.id_empresa}</td>
                        <td>${empresa.nombre}</td>
                        <td>${empresa.rut}</td>
                        <td>${empresa.nombre_suc}</td>
                        <td>${empresa.direccion}</td>
                         <td>
                            <form action="listasucursal" method="POST">
                                <input type="submit" value="Añadir Sucursal" class="btn btn-success" name="btnSucursal" />
                                <input type="hidden" name="id_emp" value="${empresa.id_empresa}" />
                            </form>
                        </td>
                        <td>
                            <form action="listasucursal" method="POST">
                                <input type="submit" value="Sucursal" class="btn btn-primary" name="btnSucursal" />
                                <input type="hidden" name="id_emp" value="${empresa.id_empresa}" />
                            </form>
                        </td>
                        
                        <td>
                            <form action="eliminarEmpresa" method="POST" onclick="return confirmarDeleteEmpresa();">
                                <input type="submit" value="Deshabilitar" class="btn btn-danger" name="btnSucursal" />
                                <input type="hidden" name="id_emp" value="${empresa.id_empresa}" />
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
