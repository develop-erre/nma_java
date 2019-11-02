<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesion = request.getSession();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="fonts/css/all.min.css">
        <script lenguage="javascript" src="js/validar.js"></script>
        <title>Capacitación</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script lenguage="javascript" src="js/jquery-3.4.1.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

        <script>
            $(function () {
                $("#datepicker").datepicker({minDate: 0, maxDate: 30});
            });
        </script>
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
            <h3>Solicitar Asesoria</h3>
            <form action="solicitarAsesoria" name="formSolicitarAsesoria" method="POST" onsubmit="return validarReporteAccidente();">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputTipoAsesoria4">Tipo de asesoria</label>
                        <select name="selectTipoAsesoria" id="inputTipoAsesoria4" class="form-control" required="">
                            <option value="0">SELECCIONE</option>
                            <option value="1">SEGURIDAD LABORAL</option>
                            <option value="2">GESTIÓN DOCUMENTAL</option>
                            <option value="3">DIAGNÓSTICO DE PELIGROS Y RIESGOS EN SU ORGANIZACIÓN</option>
                            <option value="4">PROCEDIMIENTOS FRENTE A TODO TIPO DE ACCIDENTES, INCLUYENDO GRAVES Y FATALES</option>
                            <option value="5">SEGURIDAD EN VIALIDAD</option>
                            <option value="6">DIAGNÓSTICO, RECOMENDACIÓN, USO Y RECAMBIO DE ELEMENTOS DE PROTECCIÓN PERSONAL (EPP)</option>
                            <option value="7">DIAGNOSTICO E IMPLEMENTACIÓN DE SEÑALÉTICA DE SEGURIDAD Y LETREROS DE ADVERTENCIA</option>
                            <option value="8">EMERGENCIA Y EVACUACIÓN</option>
                        </select>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputSucursal4">Lugar del accidente</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-map-marker-alt"></i></span>
                            <select id="inputSucursal4" class="form-control" name="selectSucursalId">
                                <option value="0">SELECCIONE</option>
                                <c:forEach items="${listaSucursal}" var="variable">
                                    <option value="${variable.id_sucursal}">${variable.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <input  name="idEmpresa" type="hidden" value="<%= sesion.getAttribute("id_empresa")%>">
                <button type="submit" class="btn btn-primary">Solicitar Asesoria</button>
            </form>
            <c:out value="${mensaje}" />
        </div>

        <script src="js/jquery-3.4.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script lenguage="javascript" src="js/validar.js"></script>
    </body>
</html>
