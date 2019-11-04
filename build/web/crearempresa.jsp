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
        <script lenguage="javascript" src="js/validar.js"></script>
        <title>Crear Empresa</title>
        <link rel="stylesheet" href="js/base/jquery-ui.css">
        <link rel="stylesheet" href="js/base/style.css">
        <script src="js/jquery-1.12.4.js"></script>
        <script src="js/jquery-ui.js"></script>
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
            <h3>Crear Empresa </h3>
            <form action="crearEmpresa" method="POST" onsubmit="return validarCrearEmpresa();">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="inputNombreEmp4">Nombre Empresa</label>
                        <input type="text" class="form-control" id="inputNombreEmp4" name="txtNombre" placeholder="Ingrece Nombre de la empresa" required="" maxlength="44">
                    </div>
                    <div class="form-group col-md-2">
                        <label for="inputRutEmp4">Rut Empresa</label>
                        <input type="text" class="form-control" id="inputRutEmp4" name = "txtRut" placeholder="Ingrece rut empresa" required="">
                    </div>
                    <div class="form-group col-md-2">
                        <label for="inputTelefono4">Teléfono</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-phone-alt"></i></span>
                            <input type="number" class="form-control" id="inputTelefono4" name = "txtTelefono" placeholder="Ej: 226655889 " required="" min="11111" max="99999999999">
                        </div>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="inputSitioWeb4">Sitio Web *(opcional)</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-globe"></i></span>
                            <input type="text" class="form-control" id="inputSitioWeb4" name = "txtSitioWeb" placeholder="Ingrece sitio web ">
                        </div>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-12">
                        <label for="inputRubro4">Rubro</label>
                        <select name="selectRubro" id="selectRubro4" class="form-control" required="">
                            <option value="0">SELECCIONE</option>
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
                    </div>
                </div>

                <h3>Casa matriz</h3>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="inputDireccionEmp4">Dirección</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-map-marker-alt"></i></span>
                            <input type="text" class="form-control" id="inputDireccionEmp4" name = "txtDireccion" placeholder="Ingrece Dirección" required="">
                        </div>

                    </div>
                    <div class="form-group col-md-2">
                        <label for="inputNumeroEmp4">Número</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-home"></i></span>
                            <input type="number" class="form-control" id="inputNumeroEmp4" name = "txtNumero" placeholder="Ingrece número" min="1" max="99999" required="">
                        </div>

                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputCity">Región - Comuna</label>
                        <select name="selectComunaId" id="selectComunaId4" class="form-control" required="">
                            <option value="0">SELECCIONE</option>
                            <c:forEach items="${listaReg}" var="comuna">
                                <option value="${comuna.id_comuna}">${comuna.nombre_comuna}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <h3>Contrato</h3>
                <div class="form-row">
                    <div class="form-group col-md-2">
                        <label for="inputValor4">Valor</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-dollar-sign"></i></span>
                            <input type="number" class="form-control" id="inputValor4" name = "txtValor" placeholder="Ingrece valor" min="10000" max="100000000" required=""> 
                        </div>
                    </div>
                    <div class="form-group col-md-10">
                        <label for="inputValor4">Descripción contrato</label>
                        <div class="form-group">
                            <textarea class="form-control" id="exampleFormControlTextarea1" placeholder="Escriba Aqui ..." name="textareaDescripcion" rows="3" required="" maxlength="99"></textarea>
                        </div>
                    </div>
                    <div class="form-group col-md-8">
                        <button type="submit" class="btn btn-primary">Crear Empresa</button>
                    </div>
                </div>
            </form>
        </div>


        <script lenguage="javascript" src="js/validar.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>