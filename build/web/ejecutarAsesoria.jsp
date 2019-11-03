<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesion = request.getSession();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="fonts/css/all.min.css">
        <title>Ejecutar Asesoria</title>
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

        <% String idAsesoria = request.getParameter("txtIdAsesoria"); %>
        <% String idActividad = request.getParameter("txtIdActividad"); %>
        <% String tipoAsesoria = request.getParameter("txtTipoAsesoria"); %>
        <% String nombreSucursal = request.getParameter("txtNombreSucursal");%>


        <br>
        <div class="container-fluid">
            <h3>Ejecutar Asesoria </h3><br>
            <form action="finalizarAsesoria" name="formEjecutar" method="POST" onsubmit="return validarReporteAccidente();">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="inputFechaNac4"><i class="fas fa-map-marker-alt"></i> <strong>Lugar: </strong><%= nombreSucursal%></label>
                    </div>
                    <div class="form-group col-md-4">
                        <label > <strong>Tipo de Asesoria: </strong></label>
                        <label > <%= tipoAsesoria%></label>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-8">
                        <label for="inputValor4">Problemas detectados</label>
                        <div class="input-group-prepend">
                            <textarea class="form-control" name="textareaProblemasDetectados" rows="3" cols="100" placeholder="Escriba Aqui ..." required="" minlength="10" maxlength="490" ></textarea>
                        </div>
                    </div>
                </div>


                <div class="form-row">
                    <div class="form-group col-md-8">
                        <label for="inputValor4">Solucion Propuesta</label>
                        <div class="input-group-prepend">
                            <textarea class="form-control" name="textareaSolucionPropuesta" rows="3" cols="100" placeholder="Escriba Aqui ..." required="" minlength="10" maxlength="490" ></textarea>
                        </div>
                    </div>
                </div>
                <input  name="idACT" type="hidden" value="<%=idActividad%>">
                <input  name="idASE" type="hidden" value="<%=idAsesoria%>">
                <button type="submit" class="btn btn-danger">Finalizar Asesoria</button>
            </form>
            <c:out value="${mensaje}" />
        </div>

        
        <script src="js/jquery-3.4.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>