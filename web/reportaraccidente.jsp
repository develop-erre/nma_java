<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesion = request.getSession();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="fonts/css/all.min.css">
        <script lenguage="javascript" src="js/validarReporte.js"></script>
        <meta name="viewport" content="width=device-width"/>
        <title>Reportar Accidente</title>
        <link rel="stylesheet" href="js/base/jquery-ui.css">
        <link rel="stylesheet" href="js/base/style.css">
        <script src="js/jquery-1.12.4.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker({
                    minDate: -5,
                    maxDate: 0,
                    changeMonth: true,
                    changeYear: true,
                    dateFormat: "yy-mm-dd"}).val();
            });
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
            <h3>Reportar Accidente </h3>
            <form action="reportarAccidente" name="formReport" method="post" onsubmit="return validarReporteAccidente();">
                <div class="form-row">
                    <div class="form-group col-md-2">
                        <label for="inputFechaNac4">Fecha Accidente</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
                            <input type="text" class="form-control" id="datepicker" name="txtFecha" placeholder="Ingrece fecha" required="">
                        </div>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="inputHora4">Hora</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-clock"></i></span>
                            <select name="txtHora" id="inputHora4" class="form-control" required="">
                                <option value="0">SELECCIONE</option>
                                <option value="08">08:00 AM</option>
                                <option value="09">09:00 AM</option>
                                <option value="10">10:00 AM</option>
                                <option value="11">11:00 AM</option>
                                <option value="12">12:00 PM</option>
                                <option value="13">13:00 PM</option>
                                <option value="14">14:00 PM</option>
                                <option value="15">15:00 PM</option>
                                <option value="16">16:00 PM</option>
                                <option value="17">17:00 PM</option>
                                <option value="18">18:00 PM</option>
                                <option value="19">19:00 PM</option>
                                <option value="20">20:00 PM</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="inputMinuto4">Minutos</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="far fa-clock"></i></span>
                            <select name="txtMinutos" id="inputMinuto4" class="form-control" required="">
                                <option value="SELECCIONE">SELECCIONE</option>
                                <option value="00">00:00</option>
                                <option value="05">05:00</option>
                                <option value="10">10:00</option>
                                <option value="15">15:00</option>
                                <option value="20">20:00</option>
                                <option value="25">25:00</option>
                                <option value="30">30:00</option>
                                <option value="35">35:00</option>
                                <option value="40">40:00</option>
                                <option value="45">45:00</option>
                                <option value="50">50:00</option>
                                <option value="55">55:00</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputTipoAccidente4">Tipo de accidente</label>
                        <select name="selectTipoAccidente" id="inputTipoAccidente4" class="form-control" required="">
                            <option value="0">SELECCIONE</option>
                            <option  value="1">CAÍDAS AL MISMO NIVEL</option>
                            <option  value="2">CAÍDAS DE ALTURA</option>
                            <option  value="3">CONTACTOS ELÉCTRICOS</option>
                            <option  value="4">CORTES Y PINCHAZOS</option>
                            <option  value="5">GOLPES CON ESTANTERÍAS O ARMARIOS</option>
                            <option  value="6">INCENDIOS</option>
                            <option  value="7">FATIGA POSTURAL</option>
                            <option  value="8">OTROS ACCIDENTES</option>
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
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputValor4">Comentario accidente</label>
                        <div class="input-group-prepend">
                            <textarea class="form-control" name="textareaDescripcion" rows="3" cols="100" placeholder="Escriba Aqui ..." required="" minlength="10" maxlength="99" ></textarea>
                        </div>
                    </div>
                </div>
                <input  name="idSucursal" type="hidden" value="<%= sesion.getAttribute("id_empresa")%>">
                <button type="submit" class="btn btn-primary">Reportar Accidente</button>
            </form>
        </div>

        <script lenguage="javascript" src="js/validarReporte.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>