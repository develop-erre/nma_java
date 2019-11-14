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
        <title>Lista de Visitas Asignadas</title>
    </head>
    
        <% String rs = String.valueOf(sesion.getAttribute("id_rol"));%>
        <c:set var="id_rol" value="<%=rs%>" />

        <c:choose>
            <c:when test="${id_rol == 2}">

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
            <h3>Lista de Visitas Asignadas</h3>
            <br>
            <table class="table table-sm table-responsive-md table-striped">
                <thead class="thead-light">
                    <tr>
                        <th>Nombre Sucursal</th>
                        <th>Tipo Visita</th>
                        <th>Fecha Visita</th>
                        <th>Hora Visita</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaActividadGetAll}" var="actividadGetAll">
                        <tr>
                            <td>${actividadGetAll.nombre_sucursal}</td>
                            <td>${actividadGetAll.tipo_visita}</td>
                            <td>${actividadGetAll.fecha_act}</td>
                            <td>${actividadGetAll.hora_act}</td>
                            <td>
                                <form action="ejecutarVisita" method="POST">
                                    <input type="hidden" name="txtIdActividad" value="${actividadGetAll.id_actividad}" />
                                    <input type="hidden" name="txtIdAVisita" value="${actividadGetAll.id_visita}" />
                                    <input type="hidden" name="txtTipoVisita" value="${actividadGetAll.tipo_visita}" />
                                    <input type="hidden" name="txtNombreSucursal" value="${actividadGetAll.nombre_sucursal}" />
                                    <button type="submit" class="btn btn-info"><i class="far fa-calendar-check"></i> Ejecutar</button>
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
    
</html>
