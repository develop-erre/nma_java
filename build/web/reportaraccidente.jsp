<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesion = request.getSession();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="Css/Css.css">
        <title>Reportar Accidente</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script lenguage="javascript" src="js/jquery-3.4.1.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker({minDate: -10,maxDate:0});
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

        <!-- Errores -->
        <c:forEach items="${errores}" var="error">
            <div class="alert alert-danger">
                ${error.value}
            </div>

        </c:forEach>

        <form action="reportarAccidente" name="formReport" method="post">
            <br>
            <h4>Fecha Accidente</h4>
            <input type="text" id="datepicker" class="input-text" placeholder="Ingrece Fecha" name = "txtFecha"  required="">

            <h4>Hora</h4>
            <input type="number" class="input-text" name = "txtHora" placeholder="Ingresa hora" required=""  min="0" max="23">

            <h4>minutos</h4>
            <input type="number" class="input-text" name = "txtMinutos" placeholder="Ingresa minuto"  required=""  min="0" max="59">

            <h4>Tipo Accidente</h4>
            <c:out value="${mensajeTipo}"></c:out>
            <select name="selectTipoAccidente" class="input-text" required="">
                <option  value="0">SELECCIONE</option>
                <option  value="1">CAÍDAS AL MISMO NIVEL</option>
                <option  value="2">CAÍDAS DE ALTURA</option>
                <option  value="3">CONTACTOS ELÉCTRICOS</option>
                <option  value="4">CORTES Y PINCHAZOS</option>
                <option  value="5">GOLPES CON ESTANTERÍAS O ARMARIOS</option>
                <option  value="6">INCENDIOS</option>
                <option  value="7">FATIGA POSTURAL</option>
                <option  value="8">OTROS ACCIDENTES</option>
            </select>



            <h4>Seleccione Lugar</h4>
            <c:out value="${mensajeLugar}"></c:out>
            <select name="selectSucursalId" class="input-text" required="">
                <option  value="0">SELECCIONE</option>
                <c:forEach items="${listaSucursal}" var="variable">
                    <option value="${variable.id_sucursal}">${variable.nombre}</option>
                </c:forEach>
            </select>

            <h4>Comentario</h4>
            <textarea name="textareaDescripcion" rows="10" cols="80" placeholder="Escriba Aqui ..." required="" maxlength="99" ></textarea>
            <input  name="idEmpresa" type="hidden" value="<%= sesion.getAttribute("id_empresa")%>">

            <input type = "submit" class="input-login"  value = "REPORTAR ACCIDENTE">
            <br>
            <c:out value="${mensaje}"></c:out>
            <br>
        </form>

    </body>
</html>