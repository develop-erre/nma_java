<%@page import="java.lang.String"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesion = request.getSession();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width"/>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style/footer.css">
        <link rel="stylesheet" href="fonts/css/all.min.css">
        <meta name="viewport" content="width=device-width"/>
        <title>Home Principal</title>
    </head>
    <body>
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


        <% String rs = String.valueOf(sesion.getAttribute("id_rol"));%>
        <c:set var="id_rol" value="<%=rs%>" />

        <div class="container-fluid">
            <br>
            <div class="card mb-3">
                <img class="card-img-top" src="imagen/background_index.png" alt="Card image cap">
                <div class="card-body">
                    <c:choose>
                        <c:when test="${id_rol == 1}">
                            <h5 class="card-title">Administrador</h5>
                        </c:when>    
                        <c:when test="${id_rol == 2}">
                            <h5 class="card-title">Profesional</h5>
                        </c:when>  
                        <c:otherwise>
                            <h5 class="card-title">Cliente</h5>
                        </c:otherwise>
                    </c:choose>
                    <h5 class="card-title"><%= sesion.getAttribute("nombre")%> <%= sesion.getAttribute("apellidos")%></h5>
                    <p class="card-text">
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sequi, aperiam, itaque, ducimus, eum exercitationem fuga commodi rem iusto adipisci eos vero quaerat ex suscipit. Excepturi, amet nostrum laboriosam voluptas fugit quae sint ipsum eum. Expedita, laudantium, ut, excepturi reiciendis optio natus esse cupiditate reprehenderit quod voluptatum repudiandae doloremque eius sed aut aliquam odio nesciunt aperiam magnam quis autem consequuntur corporis vel totam perspiciatis iste! Facere, reprehenderit accusamus nesciunt dolorem ut fugiat dicta praesentium molestiae impedit ex. Laudantium, assumenda accusantium veritatis.
                    </p>
                    <p class="card-text"><small class="text-muted"><%= sesion.getAttribute("fechaHoy")%></small></p>
                </div>
            </div>
        </div>

        <footer class="py-4 text-center footer" style="background: #454545">
            <div class="container">
                <h6>Previriesgos &copy; 2019</h6>
            </div>
        </footer>

        <script src="js/jquery-3.4.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
