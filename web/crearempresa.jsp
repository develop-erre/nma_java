<%@page import="java.lang.String"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesion = request.getSession();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="Css/Css.css">
        <script lenguage="javascript" src="js/validar.js"></script>
        <title>Crear Empresa</title>
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

        <h2>Crear Empresa </h2>

        <form action="crearEmpresa" method="post" onsubmit="return validarCrearEmpresa();">
            <br>
            <h4>Nombre Empresa</h4>
            <input type="text" class="input-text" name = "txtNombre" placeholder="Ingresa Nombre Empesa" value = "" required="" minlength="3" maxlength="44">

            <h4>Rut</h4>
            <input type="text" class="input-text" name = "txtRut" placeholder="Ingresa Rut Empresa" value = "" required="" minlength="3" maxlength="19">

            <h4>Sitio Web </h4>
            <input type="text" class="input-text" name = "txtSitioWeb" placeholder="Ingresa Sitio WEB" value = "" required="" minlength="3" maxlength="44">

            <h4>telefono</h4>
            <input type="number" class="input-text" id="telefonoJs" name="txtTelefono" placeholder="Ingresa Telefono" value = "" required="" minlength="3" maxlength="10">

            <h4>Rubro de la Empresa</h4>
            <select name="selectRubro" id="selectRubroJs" class="input-text" required="">
                <option value="0">Seleccione</option>
                <option value="1">AGRICULTURA, GANADERÍA, CAZA Y SILVICULTURA</option>
                <option value="2">PESCA</option>
                <option value="3">EXPLOTACIÓN DE MINAS Y CANTERAS</option>
                <option value="4">INDUSTRIAS MANUFACTURERAS NO METÁLICAS</option>
                <option value="5">INDUSTRIAS MANUFACTURERAS METÁLICAS</option>
                <option value="6">SUMINISTRO DE ELECTRICIDAD, GAS Y AGUA</option>
                <option value="7">CONSTRUCCIÓN</option>
                <option value="8">COMERCIO AL POR MAYOR Y MENOR, REP. VEH. AUTOMOTORES / ENSERES DOMÉSTICOS</option>
                <option value="9">HOTELES Y RESTAURANTES</option>
                <option value="10">TRANSPORTE, ALMACENAMIENTO Y COMUNICACIONES</option>
                <option value="11">AGRICULTURA, GANADERÍA, CAZA Y SILVICULTURA</option>
                <option value="12">ACTIVIDADES INMOBILIARIAS, EMPRESARIALES Y DE ALQUILER</option>
                <option value="13">ADM. PÚBLICA Y DEFENSA, PLANES DE SEG. SOCIAL AFILIACIÓN OBLIGATORIA</option>
                <option value="14">ENSEÑANZA</option>
                <option value="15">SERVICIOS SOCIALES Y DE SALUD</option>
                <option value="16">AGRICULTURA, OTRAS ACTIVIDADES DE SERVICIOS COMUNITARIAS, SOCIALES Y PERSONALES</option>
                <option value="17">CONSEJO DE ADMINISTRACIÓN DE EDIFICIOS Y CONDOMINIOS</option>
                <option value="18">ORGANIZACIONES Y ÓRGANOS EXTRATERRITORIALES</option>
                <option value="19">SIN INFORMACIÓN</option>
                <option value="20">TOTAL GENERAL</option>

            </select>
            <br>
            <hr>
            <h2>Sucursal Empresa</h2>

            <h4>Direccion</h4>
            <input type="text" class="input-text"  name = "txtDireccion" placeholder="Ingresa direccion de la Empesa" value = "" required="" minlength="3" max="44">
            <input type="number" class="input-text"  id="numeroDireccionJs" name = "txtNumero" placeholder="Ingresa numero" value = "" required="">
            <h4>Region</h4>
            <select name="selectRegion" class="input-text" required="">

                <option value="0">SELECCIONE</option>
                <option value="1">ARICA Y PARINACOTA</option>
                <option value="2">TARAPACÁ</option>
                <option value="3">ANTOFAGASTA</option>
                <option value="4">ATACAMA</option>
                <option value="5">COQUIMBO</option>
                <option value="6">VALPARAÍSO</option>
                <option value="7">LIBERTADOR B. O'HIGGINS</option>
                <option value="8">MAULE</option>
                <option value="9">BÍOBÍO</option>
                <option value="10">LA ARAUCANÍA</option>
                <option value="11">LOS RÍOS</option>
                <option value="12">LOS LAGOS</option>
                <option value="13">AISÉN DEL GRAL. C. IBÁÑEZ DEL CAMPO</option>
                <option value="14">MAGALLANES Y DE LA ANTÁRTICA CHILENA</option>
                <option value="15">REGIÓN METROPOLITANA</option>
            </select>

            <br>

            <h4>Region</h4>
            <select name="selectComuna" class="input-text" required="">

                <option value="0">SELECCIONE</option>
                <option value="1">ARICA Y PARINACOTA</option>
                <option value="2">TARAPACÁ</option>
                <option value="3">ANTOFAGASTA</option>
            </select>
            
            <br>
            <hr>
            <h2>Contrato</h2>

            <h4>Valor Contrato</h4>
            <br>
            <input type="number" class="input-text" name = "txtValor" placeholder="Ingresa valor"  required="">
            <br>
            <h4>Descripcion contrato</h4>
            <textarea name="textareaDescripcion" rows="10" cols="80" placeholder="Escriba Aqui ..." required="" maxlength="99" ></textarea>

            <input type = "submit" class="input-login"  value = "CREAR RUBRO">
            <br>
            <br>
        </form>

    </body>
</html>