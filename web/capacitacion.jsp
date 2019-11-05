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
        <title>Capacitación</title>
        <link rel="stylesheet" href="js/base/jquery-ui.css">
        <link rel="stylesheet" href="js/base/style.css">
        <script src="js/jquery-1.12.4.js"></script>
        <script src="js/jquery-ui.js"></script>

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
            <h3>Programación de Capacitación</h3>
            <form action="capacitacion" name="formCrearCapacitacion" method="POST" onsubmit="return validarProgramarCapacitacion();">
                <br>
                <div class="form-row">
                    <div class="form-group col-md-2">
                        <label for="inputFechaNac4">Fecha Capacitación</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
                            <input type="text" class="form-control" id="datepicker" name="txtFechaCap" placeholder="Ingrece fecha" required="">
                        </div>

                    </div>

                    <div class="form-group col-md-2">
                        <label for="inputNombre4">Hora</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-clock"></i></span>
                            <select name="selectHoraCap" id="selectHoraJS" class="form-control" required="" required="">
                                <option value="0">SELECCIONE</option>
                                <option value="09:00">09:00</option>
                                <option value="10:00">10:00</option>
                                <option value="11:00">11:00</option>
                                <option value="12:00">12:00</option>
                                <option value="14:00">14:00</option>
                                <option value="15:00">15:00</option>
                                <option value="16:00">16:00</option>
                                <option value="17:00">17:00</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="numeroAsisJS4">Número Asistentes</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-users"></i></span>
                            <input type="number" class="form-control" id="numeroAsisJS" name="txtNumerosCap" placeholder="Ingrece Número" required="" min="1" max="40">
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputCity">Tipo de Capacitación</label>
                        <select name="selectTipoCapacitacion" id="selectTipoCapacitacionJs" class="form-control" required="">
                            <option value="0">SELECCIONE</option>
                            <option value="1">ADMINISTRACIÓN DE RIESGOS Y COMPETITIVIDAD</option>
                            <option value="2">APRENDIENDO SOBRE COMITÉS PARITARIOS</option>
                            <option value="3">CÓMO IMPLEMENTAR PROTOCOLO PLANESI EN MI EMPRESA</option>
                            <option value="4">CONOCIENDO LOS RIESGOS LABORALES EN NUESTRO TRABAJO</option>
                            <option value="5">MANEJO DE SUSTANCIAS Y RESIDUOS PELIGROSOS</option>
                            <option value="6">MANEJO MANUAL DE CARGAS</option>
                            <option value="7">MONITORES DE EMERGENCIA</option>
                            <option value="8">MONITORES EN SEGURIDAD Y SALUD OCUPACIONAL PARA EMPRESAS PYME</option>
                            <option value="9">MUTUAL OHSAS 18001</option>
                            <option value="10">ORIENTACIÓN EN PREVENCIÓN DE RIESGOS</option>
                            <option value="11">PREVENCIÓN DE RIESGO EN LA CONDUCCIÓN</option>
                            <option value="12">PROTOCOLO DE VIGILANCIA DE RIESGOS PSICOSOCIALES EN EL TRABAJO</option>
                            <option value="13">TRASTORNOS MUSCULO ESQUELÉTICOS DE EXTREMIDADES SUPERIORES EN EL TRABAJO</option>
                            <option value="14">USO Y MANEJO DE EXTINTORES PORTÁTILES</option>
                        </select>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputCity">Asignar Profesional</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user-plus"></i></span>
                            <select name="selectProfesionalIdCap" id="selectProfcapacitacionJs" class="form-control" required="">
                                <option value="0">SELECCIONE</option>
                                <c:forEach items="${listaProfesional}" var="prof">
                                    <option value="${prof.id_usuario}">${prof.nombre}  ${prof.apellidos} </option>
                                </c:forEach>}
                            </select>
                        </div>
                    </div>
                </div>
                <input type="hidden" name="SucursalId" value="${idSucursal}" />
                <input type = "submit" class="btn btn-primary"  value = "Programar Capacitación">
            </form>

            <script lenguage="javascript" src="js/validar.js"></script>
            <script src="js/bootstrap.min.js"></script>
    </body>
</html>
