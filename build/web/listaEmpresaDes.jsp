<%@page import="java.sql.ResultSet"%>
<%@page import="java.lang.String"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesion = request.getSession();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="fonts/css/all.min.css">
        <meta name="viewport" content="width=device-width"/>
        <script lenguage="javascript">
            function confirmarHabilitar() {

                var respuesta = confirm("Estas seguro que deseas habilitar el usuario?");

                if (respuesta === true) {
                    return true;
                } else {
                    return false;

                }
            }
        </script>
        <title>Lista de Empresas Deshabilitadas</title>
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

        <br>
        <div class="container-fluid">
            <h3>Empresas Deshabilitadas</h3>
            <br>
            <table class="table table-sm table-responsive-md table-striped">
                <thead class="thead-light">
                    <tr>
                        <th>Nombre</th>
                        <th>Rut</th>
                        <th>Correo</th>
                        <th>Telefono</th>
                        <th>Habilitar</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaEmpeDes}" var="empresa">
                        <tr>
                            <td>${empresa.nombre_empresa}</td>
                            <td>${empresa.rut}</td>
                            <td>${empresa.nombre_sucursal}</td>
                            <td>${empresa.nombre_calle} #${empresa.numero} - ${empresa.comuna} - ${empresa.region}</td>
                            <td>
                                <form action="habilitarEmpresa" method="POST" onclick="return confirmarHabilitar();">
                                    <input type="submit" class="btn btn-success" value="Habilitar" />
                                    <input type="hidden" name="id_empresa_des" value="${empresa.id_empresa}" />
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <script src="js/jquery-3.4.1.min.js"></script>
            <script src="js/popper.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
    </body>
</html>
