<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesion = request.getSession();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="Css/Css.css">
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
        <h1>Hello CAPACITACION!</h1>

        <% String rs = String.valueOf(sesion.getAttribute("id_rol"));%>
        <c:set var="id_rol" value="<%=rs%>" />

        <c:choose>
            <c:when test="${id_rol == 1}">

            </c:when>    
            <c:otherwise>
                <%response.sendRedirect("http://localhost:8080/nma/home.jsp");%>
            </c:otherwise>
        </c:choose>

        <form action="capacitacion" name="formCrearCapacitacion" method="POST">
            <br>
            <h4>Fecha Capacitacion</h4>
            <input type="text" id="datepicker" class="input-text" placeholder="Ingrece Fecha" name = "txtFechaCap"  required="">

            <h4>Hora</h4>
            <input type="number" class="input-text" name = "txtHoraCap" placeholder="Ingresa hora" required=""  min="0" max="23">

            <h4>minutos</h4>
            <input type="number" class="input-text" name = "txtMinutosCap" placeholder="Ingresa minuto"  required=""  min="0" max="59">

            <h4>Números Asistentes</h4>
            <input type="number" class="input-text" name = "txtNumerosCap" placeholder="Ingresa Capacidad de asistentes"  required=""  min="0" max="30">

            <h4>Tipo Capacitación</h4>
            <select name="selectTipoCapacitacion" class="input-text" required="">
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

            <h4>Seleccione Profesional  para la capacitación</h4>
                <select name="selectProfesionalId" class="input-text" required="">
                    <option  value="4">PROFE 4</option>
                    <option  value="5">PROFE 5</option>
                    <option  value="6">PROFE 6</option>
            </select>
            
            <h4>Seleccione lugar para la capacitación</h4>
                <select name="selectSucursalId" class="input-text" required="">
                    <option  value="3">SUC 3</option>
                    <option  value="5">SUC 5</option>
                    <option  value="6">SUC 6</option>
                    
            </select>

            <input type = "submit" class="input-login"  value = "CREAR CAPACITACIÓN">
            <br>
            <c:out value="${mensaje}"></c:out>
            <br>
        </form>


    </body>
</html>
