<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesion = request.getSession();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="fonts/css/all.min.css">
        <title>Añadir Sucursal</title>
        <script lenguage="javascript" src="js/validar.js"></script>
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

        <% String idEmpresa = (String) request.getParameter("id_emp");%>
        <% String nombreEmpresa = request.getParameter("nom_emp");%>

        <br>
        <div class="container-fluid">
            <h3>Añadir Sucursal <%= nombreEmpresa%></h3>  <%= idEmpresa%>
            <form action="crearSucursal" name="formProgramarVisita" method="POST" onsubmit="return validarSelectOption();">
                <br>
                <div class="form-row">
                    <div class="form-group col-md-5">
                        <label for="txtNombreSucursalJs4">Nombre Sucursal</label>
                        <input type="text" class="form-control" id="txtNombreSucursalJs" name="txtNombreSucursal" placeholder="Ingrece nombre sucursal" required="">
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label for="inputAddress">Dirección</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-map-marker-alt"></i></span>
                            <input type="text" class="form-control" id="inputDireccion4" name = "txtDireccion" placeholder="Ingrece Dirección" required="">
                        </div>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="inputAddress">Número</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-home"></i></span>
                            <input type="number" class="form-control" id="inputNumero4" name = "txtNumero" placeholder="Ingrece número" required="" min="1" max="99999">
                        </div>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-5">
                        <label for="inputRegion4">Región - Comuna</label>
                        <select name="selectComunaId" id="inputRegion4" class="form-control" required="">
                            <option value="0">SELECCIONE</option>
                            <c:forEach items="${listaReg}" var="comuna">
                                <option value="${comuna.id_comuna}">${comuna.nombre_comuna}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <input type="hidden" name="idEmpresa" value="<%= idEmpresa%>" />
                <input type = "submit" class="btn btn-primary"  value = "Añadir Sucursal">
                <br>
            </form>
        </div>

        <script lenguage="javascript" src="js/validar.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
