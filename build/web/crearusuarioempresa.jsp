<%@page import="java.sql.ResultSet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="Css/Css.css">
        <title>NMA</title>
    </head>
    <body>

        <form action="crearusuarioempresa" method="post">
            <br>
            <h4>nombre</h4>
            <input type="text" class="input-text" name = "txtNombre" placeholder="Ingresa Run" value = "" required="" minlength="3">
            <h4>apellidos</h4> 
            <input type="text" class="input-text"  name = "txtApellidos" placeholder="Ingresa Password" value = "" required="" minlength="3">
            <br>
            <h4>rut</h4>
            <input type="text" class="input-text" name = "txtRun" placeholder="Ingresa Run" value = "" required="" minlength="3">
            <h4>password</h4> 
            <input type="password" class="input-text"  name = "txtPass" placeholder="Ingresa Password" value = "" required="" minlength="3">
            <br>
            <h4>direccion</h4>
            <input type="text" class="input-text" name = "txtDireccion" placeholder="Ingresa Run" value = "" required="" minlength="3">
            <h4>fecha de nacimiento</h4> 
            <input type="date" class="input-text"  name = "txtFechaNac" placeholder="Ingresa Password" value = "" required="" minlength="3">
            <br>
            <h4>email</h4> 
            <input type="email" class="input-text"  name = "txtEmail" placeholder="Ingresa Password" value = "" required="" minlength="3">
            <br>
            <h4>telefono</h4>
            <input type="number" class="input-text" name = "txtTelefono" placeholder="Ingresa Run" value = "" required="" minlength="3">
            <br>
            <h4>ID comuna</h4>
            <input type="number" class="input-text" name = "txtIdComuna" placeholder="Ingresa Run" value = "" required="" minlength="3">

            <h4>Seleccione Empresa</h4>
            <select name="selectEmpresaId" class="input-text" required="">
                <option  value="0">SELECCIONE</option>
                <c:forEach items="${listaEmp}" var="empresa">
                    <option value="${empresa.id_empresa}">${empresa.nombre}</option>
                </c:forEach>
            </select>
            <br>
            <br>
            <input type = "submit" class="input-login"  value = "Crear Profesional">
            <br>
            <br>
        </form>

    </body>
</html>