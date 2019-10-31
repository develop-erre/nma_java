<%@page import="java.lang.String"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesion = request.getSession();%>
<!DOCTYPE html>
<html>
    <head>    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="fonts/css/all.min.css">
        <title>Crear Profesional</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker({maxDate: "-18Y"});
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
            <h3>Crear Profesional </h3>
            <form action="crearProfesional" method="post">
                <br>
                <form>
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="inputNombre4">Nombre</label>
                            <input type="text" class="form-control" id="inputNombre4" name="txtNombre" placeholder="Ingrece Nombre" required="">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="inputApellidos4">Apellidos</label>
                            <input type="text" class="form-control" id="inputApellidos4" name = "txtApellidos" placeholder="Ingrece Apellidos" required="">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="inputRun4">Run</label>
                            <input type="text" class="form-control" id="inputRun4" name = "txtRun" placeholder="Ingrece Run " required="">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <label for="inputPass4">Password</label>
                            <input type="password" class="form-control" id="inputPassword4" name="txtPassword" placeholder="Ingrece password" required="">
                        </div>

                        <div class="form-group col-md-2">
                            <label for="inputFechaNac4">Fecha Nacimiento</label>
                            <input type="text" class="form-control" id="datepicker" name="txtFechaNac" placeholder="Ingrece fecha" required="">
                        </div>

                        <div class="form-group col-md-4">
                            <label for="inputEmail4">E-mail</label>
                            <input type="Email" class="form-control" id="inputEmail4" name = "txtEmail" placeholder="Ingrece E-mail abc12@dominio.com" required="">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="inputRun4">Teléfono</label>
                            <input type="number" class="form-control" id="inputRun4" name = "txtTelefono" placeholder="Ingrece teléfono, solo números " required="">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="inputAddress">Dirección</label>
                            <input type="text" class="form-control" id="inputDireccion4" name = "txtDireccion" placeholder="Ingrece Dirección">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="inputAddress">Número</label>
                            <input type="text" class="form-control" id="inputNumero4" name = "txtNumero" placeholder="Ingrece número">
                        </div>
                        <div class="form-group col-md-3">
                            <label for="inputCity">Región</label>
                            <select name="selectRegion" id="inputRegion4" class="form-control" required="">
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
                        </div>
                        <div class="form-group col-md-3">
                            <label for="inputState">Comuna</label>
                            <select id="inputComuna4" class="form-control" name="txtIdComuna">
                                <option value="0">SELECCIONE</option>
                                <option value="1">ARICA Y PARINACOTA</option>
                                <option value="2">TARAPACÁ</option>
                                <option value="3">ANTOFAGASTA</option>
                            </select>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Crear Profesional</button>
                </form>


                <script src="js/bootstrap.min.js"></script>
                </body>
                </html>