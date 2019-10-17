<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesion = request.getSession(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="Css/Css.css">
        <title>Reportar Accidente</title>
    </head>
    <body>

        <form action="reportarAccidente" method="post">
            <br>
            <h4>Fecha Accidente</h4>
            <input type="date" class="input-text" name = "txtFecha" value = "" required="" minlength="3">

            <h4>Hora</h4>
            <input type="number" class="input-text" name = "txtHora" placeholder="Ingresa hora" required=""  min="0" max="23">

            <h4>minutos</h4>
            <input type="number" class="input-text" name = "txtMinutos" placeholder="Ingresa minuto"  required=""  min="0" max="59">

            <h4>Tipo Accidente</h4>
            <select name="selectTipoAccidente" class="input-text" required="">
                <option  value="1">CAÍDAS AL MISMO NIVEL</option>
                <option  value="2">CAÍDAS DE ALTURA</option>
                <option  value="3">CONTACTOS ELÉCTRICOS</option>
                <option  value="4">CORTES Y PINCHAZOS</option>
                <option  value="5">GOLPES CON ESTANTERÍAS O ARMARIOS</option>
                <option  value="6">INCENDIOS</option>
                <option  value="7">FATIGA POSTURAL</option>
                <option  value="8">OTROS ACCIDENTES</option>
            </select>

            <h4>Comentario</h4>
            <textarea name="textareaDescripcion" rows="10" cols="80" placeholder="Escriba Aqui ..." required="" maxlength="99" ></textarea>
            
            <input  name="idEmpresa" type="hidden" value="<%= sesion.getAttribute("id_empresa") %>">

            <input type = "submit" class="input-login"  value = "CREAR RUBRO">
            <br>
            <br>
        </form>

    </body>
</html>