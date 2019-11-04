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
        <title>Lista de Asesorias finalizadas</title>
    </head>
    <body>

        <% String rs = String.valueOf(sesion.getAttribute("id_rol"));%>
        <c:set var="id_rol" value="<%=rs%>" />

        <c:choose>
            <c:when test="${id_rol == 3}">

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
            <h3>Lista de Asesorias finalizadas</h3>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Id Actividad</th>
                        <th>Id Asesoria</th>
                        <th>Fecha Asesoria</th>
                        <th>Hora Asesoria</th>
                        <th>Nombre Sucursal</th>
                        <th>Tipo Asesoria</th>
                        <th>Reporte</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaGetAllAsesoria}" var="getallasesoria">
                        <tr>
                            <td>${getallasesoria.id_actividad}</td>
                            <td>${getallasesoria.id_asesoria}</td>
                            <td>${getallasesoria.fecha_act}</td>
                            <td>${getallasesoria.hora_act}</td>
                            <td>${getallasesoria.nombre_sucursal}</td>
                            <td>${getallasesoria.tipo_asesoria}</td>
                            <td>
                                <form action="pdfAsesoria" method="POST" target="_blank">
                                    <input type="hidden" name="txtNombreProf" value="${getallasesoria.nombre_apellido}" />
                                    <input type="hidden" name="txtFecha" value="${getallasesoria.fecha_act}" />
                                    <input type="hidden" name="txtHora" value="${getallasesoria.hora_act}" />
                                    <input type="hidden" name="txtNombreSucursal" value="${getallasesoria.nombre_sucursal}" />
                                    <input type="hidden" name="txtDescProblem" value="${getallasesoria.comentarios_detectados}" />
                                    <input type="hidden" name="txtDescPropuesta" value="${getallasesoria.comentarios_propuesta}" />
                                    
                                    <input type="hidden" name="txtIdAsesoria" value="${getallasesoria.id_asesoria}" />
                                    <input type="hidden" name="txtIdActividad" value="${getallasesoria.id_actividad}" />
                                    <input type="hidden" name="txtTipoAsesoria" value="${getallasesoria.tipo_asesoria}" />
                                    <input type="hidden" name="txtNombreSucursal" value="${getallasesoria.nombre_sucursal}" />
                                    <button type="submit" class="btn btn-danger"><i class="fas fa-file-download"></i> Download</button>
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