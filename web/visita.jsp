<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesion = request.getSession();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="Css/Css.css">
        <title>Programar Visita</title>
        <script lenguage="javascript" src="js/validar.js"></script>
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
        <h1>Programación de Visita!</h1>

        <% String rs = String.valueOf(sesion.getAttribute("id_rol"));%>
        <c:set var="id_rol" value="<%=rs%>" />

        <c:choose>
            <c:when test="${id_rol == 1}">

            </c:when>    
            <c:otherwise>
                <%response.sendRedirect("http://localhost:8080/nma/home.jsp");%>
            </c:otherwise>
        </c:choose>

        <form action="programarvisita" name="formProgramarVisita" method="POST" onsubmit="return validarSelectOption();">
            <br>
            <h4>Fecha Visita</h4>
            <input type="text" id="datepicker" class="input-text" placeholder="Ingrece Fecha" name = "txtFechaVis"  required="">

            <h4>Seleccione Hora</h4>
            <select name="selectHora" id="selectHoraJS" class="input-text" required="">
                <option value="0">SELECCIONE</option>
                <option value="08:00">09:00</option>
                <option value="10:00">10:00</option>
                <option value="12:00">12:00</option>
                <option value="14:00">14:00</option>
                <option value="16:00">16:00</option>
                <option value="17:00">17:00</option>
            </select>

            <h4>Tipo Vista</h4>
            <select name="selectTipoVisita"  id="selectTipoVisitaJs" class="input-text" required="">
                <option value="0">SELECCIONE</option>
                <option value="1">REVICIÓN DE INSTALACIONES</option>
                <option value="2">REVICIÓN DE DOCUMENTACIÓN</option>
            </select>

            <h4>Seleccione Profesional  para la Visita</h4>
            <select name="selectProfesionalId" id="selectProfVisitaJs" class="input-text" required="">
                <option  value="0">SELECCIONE</option>
                <c:forEach items="${listaProfesional}" var="prof">
                    <option value="${prof.id_usuario}">${prof.nombre}  ${prof.apellidos} </option>
                </c:forEach>}
            </select>
            <br>

            <input type="hidden" name="SucursalId" value="${idSucursal}" />
            <input type = "submit" class="input-login"  value = "PROGRAMAR VISITA">
            <br>
            <c:out value="${mensaje}"></c:out>
            <br>
        </form>


    </body>
</html>
