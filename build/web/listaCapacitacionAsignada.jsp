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
        <title>Capacitación Asignadas</title>
        <script lenguage="javascript">
            function confirmarFinalizar() {

                var respuesta = confirm("Estas seguro que deseas finalizar la capacitación");

                if (respuesta === true) {
                    return true;
                } else {
                    return false;

                }
            }
        </script>
    </head>
    <body>

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
            <h3>Capacitación Asignadas</h3>
            <br>
            <table class="table table-sm table-responsive-md table-striped">
                <thead class="thead-light">
                    <tr>
                        <th>Nombre Sucursal</th>
                        <th>Tipo Asesoria</th>
                        <th>Fecha Asesoria</th>
                        <th>Hora Asesoria</th>
                        <th>Número Asistentes</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaGetAllCapacitacion}" var="getallCapacitacion">
                        <tr>
                            <td>${getallCapacitacion.nombre_sucursal}</td>
                            <td>${getallCapacitacion.descripcion}</td>
                            <td>${getallCapacitacion.fecha_act}</td>
                            <td>${getallCapacitacion.hora_act}</td>
                            <td>${getallCapacitacion.numero_asistente}</td>
                            <td>
                                <form action="finalizarCapacitacion" method="POST" onsubmit="return confirmarFinalizar();">
                                    <input type="hidden" name="txtIdActividad" value="${getallCapacitacion.id_actividad}" />
                                    <input type="submit" value="Finalizar" class="btn btn-danger" />
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
