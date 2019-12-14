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
        <script lenguage="javascript" src="js/validar.js"></script>
        <title>Solicitar Asesoria</title>
        <link rel="stylesheet" href="js/base/jquery-ui.css">
        <link rel="stylesheet" href="js/base/style.css">
        <script src="js/jquery-1.12.4.js"></script>
        <script src="js/jquery-ui.js"></script>

        <script>
            $(function () {
                $("#datepicker").datepicker({minDate: 0, maxDate: 30});
            });
        </script>
        <script>
            function validarAsesoria() {

                var selectTipo = document.getElementById("inputTipoAsesoria4").value;

                if (selectTipo == 0) {
                    alert("Debe seleccionar tipo asesoria");
                    return false;
                }

            }
            
             function solicitarAsesoria() {

                var respuesta = confirm("Estas seguro que deseas solicitar la asesoria?");

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
        <% String nombreSucursal = String.valueOf(sesion.getAttribute("nombreSucursal"));%>
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
            <form action="solicitarAsesoria" name="formSolicitarAsesoria" method="POST" onsubmit="return validarAsesoria();">
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
                        <label for="inputFechaNac4">Lugar de Accidente</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-map-marker-alt"></i></span>
                            <input type="text" class="form-control" disabled="" value="<%=nombreSucursal%>">
                        </div>
                    </div>
                </div>

                <input  name="idSucursal" type="hidden" value="<%= sesion.getAttribute("id_empresa")%>">
                <button type="submit" class="btn btn-primary" onclick="return solicitarAsesoria()">Solicitar Asesoria</button>
            </form>
        </div>

        <script lenguage="javascript" src="js/validar.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
