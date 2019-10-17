<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesion = request.getSession(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Home!</h1>
        
        <h3>rut <%= sesion.getAttribute("run") %> </h3><br>
        <h3>Nombre <%= sesion.getAttribute("nombre") %> </h3><br>
        <h3>id usuario  <%= sesion.getAttribute("id_usuario") %> </h3><br>
        <h3>id rol <%= sesion.getAttribute("id_rol") %> </h3><br>
        <h3>id empresa <%= sesion.getAttribute("id_empresa") %> </h3><br>
        <h3>estado <%= sesion.getAttribute("estado") %> </h3><br>
        
        
        <h3>Pass <%= sesion.getId() %> </h3><br>
        
        <form action="listarProfesional" method="post">
                <br>
                    <input type = "submit" class="input-login"  value = "VER PROFESIONALES">
            </form>
        
         <form action="listaEmpresa" method="post">
                <br>
                    <input type = "submit" class="input-login"  value = "VER EMPRESAS">
            </form>
       
                <br>
               <a href="http://localhost:8080/nma/crearprofesional.jsp">crear profesional</a>
               <br>
               
               <a href="crearusuarioempresa">crear usuario empresa</a>
               <br>
               <a href="http://localhost:8080/nma/crearempresa.jsp">crear empresa</a>
               <br>
               <a href="http://localhost:8080/nma/reportaraccidente.jsp">reportar Accidente empresa</a>
               
               <a href="login">Cerrar Sesion</a>
           
    </body>
</html>
