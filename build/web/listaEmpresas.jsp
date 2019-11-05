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
            <h3>Lista de Empresas</h3>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre Empresa</th>
                        <th>Rut</th>
                        <th>Casa Matriz</th>
                        <th>Dirección</th>
                        <th>Ver</th>
                        <th>Añadir</th>
                        <th>Ver</th>
                        <th>Deshabilitar</th>
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
                                
                                <form action="listaReportesAccidentes" method="POST">
                                    <input type="submit" value="Accidentes" class="btn btn-warning" name="btnAnadirSucursal" />
                                    <input type="hidden" name="id_emp" value="${empresa.id_empresa}" />
                                    <input type="hidden" name="nom_emp" value="${empresa.nombre}" />
                                </form>
                            </td>
                            <td>
                                
                                <form action="cargarAnadirSucursal" method="POST">
                                    <button type="submit"  class="btn btn-success" name="btnAnadirSucursal">Sucursal</button>
                                    <input type="hidden" name="id_emp" value="${empresa.id_empresa}" />
                                    <input type="hidden" name="nom_emp" value="${empresa.nombre}" />
                                </form>
                            </td>
                            <td>
                                <form action="listasucursal" method="POST">
                                    <input type="submit" value="Sucursal" class="btn btn-primary" name="btnSucursal" />
                                    <input type="hidden" name="id_emp" value="${empresa.id_empresa}" />
                                    <input type="hidden" name="nom_emp" value="${empresa.nombre}" />
                                </form>
                            </td>

                            <td class="text-center">
                                <form action="eliminarEmpresa" method="POST" onclick="return confirmarDeleteEmpresa();">
                                    <button type="submit" class="btn btn-danger" name="btnDeshabilitar" ><i class="fas fa-trash-alt"></i></button>
                                    <input type="hidden" name="id_emp" value="${empresa.id_empresa}" />
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
