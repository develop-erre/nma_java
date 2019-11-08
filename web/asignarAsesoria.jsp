<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesion = request.getSession();%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="fonts/css/all.min.css">
        <script lenguage="javascript" src="js/validar.js"></script>
        <meta name="viewport" content="width=device-width"/>
        <title>Asignar Asesoria</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="js/base/jquery-ui.css">
        <link rel="stylesheet" href="js/base/style.css">
        <script src="js/jquery-1.12.4.js"></script>
        <script src="js/jquery-ui.js"></script>

        <script>
           $(function () {
                $("#datepicker").datepicker({
                    minDate: 0, 
                    maxDate: 30,
                    changeMonth: true,
                    changeYear: true,
                    dateFormat: "yy-mm-dd"}).val();
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

        <% String idAct = (String) request.getAttribute("idAct");%>
        <% String idAse = (String) request.getAttribute("idAse");%>
        <% String tipoAs = (String) request.getAttribute("tipoAs");%>

        <br>
        <div class="container-fluid">
            <h3>Asignar Asesoria</h3>
            <form action="asignarAsesoria" name="formAsignarAs" method="POST" onsubmit="return validarAsignarAsesoria();">
                <br>
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label for="datepicker4">Fecha para la Asesoria</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
                            <input type="text" class="form-control" id="datepicker" name="txtFechaAs" placeholder="Ingrece fecha" required="">
                        </div>
                    </div>

                    <div class="form-group col-md-2">
                        <label for="selectHoraJS4">Hora</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-clock"></i></span>
                            <select name="selectHora" id="selectHoraJS" class="form-control" required="" required="">
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
                </div>
                <div class="form-row">
                    <div class="form-group col-md-5">
                        <label for="inputTipoAs4">Tipo de Asesoria</label>
                        <input type="text" class="form-control" value="<%=tipoAs%>" disabled="">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-5">
                        <label for="selectProfAseJs">Asignar Profesional</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user-plus"></i></span>
                            <select name="selectProfesionalId" id="selectProfAseJs" class="form-control" required="">
                                <option value="0">SELECCIONE</option>
                                <c:forEach items="${listaProfesionalAsesoria}" var="prof">
                                    <option value="${prof.id_usuario}">${prof.nombre}  ${prof.apellidos} </option>
                                </c:forEach>}
                            </select>
                        </div>
                    </div>
                </div>

                <input type="hidden" name="txtIdActividad" value="<%= idAct%>" />
                <input type="hidden" name="txtIdAsesoria" value="<%= idAse%>" />
                <input type = "submit" class="btn btn-primary"  value = "Asignar Asesoria">
                <br>
            </form>



            <script lenguage="javascript" src="js/validar.js"></script>
            <script src="js/bootstrap.min.js"></script>
    </body>
</html>
