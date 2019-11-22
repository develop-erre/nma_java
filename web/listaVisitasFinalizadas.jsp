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
        <title>Lista de Visitas finalizadas</title>
    </head>
    <body>

        <% String rs = String.valueOf(sesion.getAttribute("id_rol"));%>
        <% String nombreSucursal = String.valueOf(sesion.getAttribute("nombreSucursal"));%>
        <c:set var="id_rol" value="<%=rs%>" />

        <c:choose>
            <c:when test="${id_rol == 3}">

            </c:when>    
            <c:otherwise>
                <%response.sendRedirect("http://localhost:8080/nma/home.jsp");%>
            </c:otherwise>
        </c:choose>
        <jsp:include page="menuCliente.jsp"/>

        <br>
        <div class="container-fluid">
            <h3>Visitas finalizadas - <%=nombreSucursal%></h3>
            <br>
            <table class="table table-sm table-responsive-md table-striped">
                <thead class="thead-light">
                    <tr>
                        <th>Nombre Profesional</th>
                        <th>Tipo Visita</th>
                        <th>Fecha Visita</th>
                        <th>Hora Visita</th>
                        <th>Reporte</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaGetAllVisita}" var="getallvisita">
                        <tr>
                            <td>${getallvisita.nombre_apellido}</td>
                            <td>${getallvisita.tipo_visita}</td>
                            <td>${getallvisita.fecha_act}</td>
                            <td>${getallvisita.hora_act}</td>
                            <td>
                                <form action="pdfVisita" method="POST" target="_blank">
                                    <input type="hidden" name="txtNombreSucursal" value="${getallvisita.nombre_sucursal}" />
                                     <input type="hidden" name="txtNombrecalle" value="${getallvisita.nombre_calle}" />
                                    <input type="hidden" name="txtNumero" value="${getallvisita.numero}" />
                                    <input type="hidden" name="txtComuna" value="${getallvisita.nombre_comuna}" />
                                    <input type="hidden" name="txtRegion" value="${getallvisita.nombre_region}" />
                                    <input type="hidden" name="txtTipoVisita" value="${getallvisita.tipo_visita}" />
                                    <input type="hidden" name="txtNombreProf" value="${getallvisita.nombre_apellido}" />
                                    <input type="hidden" name="txtFecha" value="${getallvisita.fecha_act}" />
                                    <input type="hidden" name="txtHora" value="${getallvisita.hora_act}" />
                                    
                                    <input type="hidden" name="txtContratos" value="${getallvisita.contratos}" />
                                    <input type="hidden" name="txtDocumentos" value="${getallvisita.documentacion}" />
                                    <input type="hidden" name="txtFiniquitos" value="${getallvisita.finiquitos}" />
                                    <input type="hidden" name="txtComentariosDocumentos" value="${getallvisita.comentarios_documentacion}" />
                                    
                                    <input type="hidden" name="txtInstalacion" value="${getallvisita.instalacion}" />
                                    <input type="hidden" name="txtBanios" value="${getallvisita.banios}" />
                                    <input type="hidden" name="txtComedores" value="${getallvisita.comedores}" />
                                    <input type="hidden" name="txtComentariosFaena" value="${getallvisita.comentarios_faena}" />
                                    
                                    <input type="hidden" name="txtSeguridad" value="${getallvisita.seguridad}" />
                                    <input type="hidden" name="txtPeligros" value="${getallvisita.peligros}" />
                                    <input type="hidden" name="txtComentariosSeguridad" value="${getallvisita.comentarios_seguridad}" />
                                    <input type="hidden" name="txtComentariosPropuesta" value="${getallvisita.comentarios_propuesta}" />
                                    
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
