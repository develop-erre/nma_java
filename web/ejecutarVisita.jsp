<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesion = request.getSession();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width"/>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="fonts/css/all.min.css">
        <title>Ejecutar Visita</title>
    </head>
    <body>

        <% String rs = String.valueOf(sesion.getAttribute("id_rol"));%>
        <c:set var="id_rol" value="<%=rs%>" />

        <c:choose>
            <c:when test="${id_rol == 2}">

            </c:when>    
            <c:otherwise>
                <%response.sendRedirect("http://localhost:8080/nma/home.jsp");%>
            </c:otherwise>
        </c:choose>

        <jsp:include page="menuProfesional.jsp"/>

       
        <% String idActividad = request.getParameter("txtIdActividad"); %>
         <% String idVisita = request.getParameter("txtIdAVisita"); %>
        <% String tipoVisita = request.getParameter("txtTipoVisita"); %>
        <% String nombreSucursal = request.getParameter("txtNombreSucursal");%>


        <br>
        <div class="container-fluid">
            <h3>Ejecutar Visita </h3><br>
            <form action="finalizarVisita" name="formEjecutarVisita" method="POST";">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label><i class="fas fa-map-marker-alt"></i> <strong>Lugar: </strong><%= nombreSucursal%></label>
                    </div>
                    <div class="form-group col-md-4">
                        <label> <strong>Tipo de Visita: </strong><%= tipoVisita%></label>
                    </div>
                </div>


                <!--  SECCION DOCUMENTACION-->

                <label><strong><i class="far fa-folder-open"></i> Sección Documentos - (Chequear solo si cumple la norma)</strong></label>
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <div class="form-group">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="1" id="defaultCheck1" name="checkContratos">
                                <label class="form-check-label" for="defaultCheck1">
                                    Contratos al día
                                </label>
                            </div>
                        </div>

                    </div>
                    <div class="form-group col-md-3">
                        <div class="form-group">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="1" id="defaultCheck2" name="checkDocumentos">
                                <label class="form-check-label" for="defaultCheck2">
                                    Documnetación al día
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group col-md-3">
                        <div class="form-group">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="1" id="defaultCheck3" name="checkFiniquitos" >
                                <label class="form-check-label" for="defaultCheck3">
                                    Finiquitos al día
                                </label>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-9">
                        <label><i class="fas fa-edit"></i> Comentarios revición Documentación</label>
                        <div class="input-group-prepend">
                            <textarea class="form-control" name="textareaComentariosDocumentos" rows="3" cols="100" placeholder="Escriba Aqui ..." required="" minlength="10" maxlength="490" ></textarea>
                        </div>
                    </div>
                </div>

                <hr>
                <!--  SECCION INSTALACION DE FAENAS-->

                <label><strong><i class="fas fa-check"></i> Sección Instalación de Faenas - (Chequear solo si cumple la norma)</strong></label>
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <div class="form-group">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                                <label class="form-check-label" for="defaultCheck1">
                                    Contratos al día
                                </label>
                            </div>
                        </div>

                    </div>
                    <div class="form-group col-md-3">
                        <div class="form-group">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                                <label class="form-check-label" for="defaultCheck1">
                                    Documnetación al día
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group col-md-3">
                        <div class="form-group">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                                <label class="form-check-label" for="defaultCheck1">
                                    Finiquitos al día
                                </label>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="form-row">
                    <div class="form-group col-md-9">
                        <label for="inputValor4"><i class="fas fa-edit"></i> Comentarios revición Instalaciones</label>
                        <div class="input-group-prepend">
                            <textarea class="form-control" name="textareaSolucionPropuesta" rows="3" cols="100" placeholder="Escriba Aqui ..." required="" minlength="10" maxlength="490" ></textarea>
                        </div>
                    </div>
                </div>

                <hr>
                <!--  SECCION SEGURIDAD-->

                <label><strong><i class="fas fa-user-shield"></i> Sección Seguridad  - (Chequear solo si cumple la norma)</strong></label>
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <div class="form-group">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                                <label class="form-check-label" for="defaultCheck1">
                                    Zonas seguras establecidas
                                </label>
                            </div>
                        </div>

                    </div>
                    <div class="form-group col-md-3">
                        <div class="form-group">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                                <label class="form-check-label" for="defaultCheck1">
                                    Se observan peligros
                                </label>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-9">
                        <label for="inputValor4"><i class="fas fa-edit"></i> Comentarios revición seguridad</label>
                        <div class="input-group-prepend">
                            <textarea class="form-control" name="textareaSolucionPropuesta" rows="3" cols="100" placeholder="Escriba Aqui ..." required="" minlength="10" maxlength="490" ></textarea>
                        </div>
                    </div>
                </div>



                <hr>
                <!--  SECCION PROPUESTA-->

                <div class="form-row">
                    <div class="form-group col-md-9">
                        <h4>Propuesta</h4>
                        <br>
                        <label for="inputValor4"><i class="fas fa-edit"></i> Propuesta de la visita</label>
                        <div class="input-group-prepend">
                            <textarea class="form-control" name="textareaSolucionPropuesta" rows="3" cols="100" placeholder="Escriba Aqui ..." required="" minlength="10" maxlength="490" ></textarea>
                        </div>
                    </div>
                </div>

                <input  name="idACT" type="hidden" value="<%=idActividad%>">
                <input  name="idASE" type="hidden" value="<%=idVisita%>">
                <button type="submit" class="btn btn-danger">Finalizar Visita</button>
                <br>
                <br>
            </form>
        </div>
    </div>


    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>