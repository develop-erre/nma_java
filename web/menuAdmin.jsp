<%@ page pageEncoding="UTF-8" %>
<!-- MENU -->

<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Administrador</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="home.jsp">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Crear
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="http://localhost:8080/nma/crearprofesional.jsp">Profesionales</a>
                    <a class="dropdown-item" href="crearusuarioempresa">Empresas</a>
                </div>
            </li> 
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Ver
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="listarProfesional">Profesionales</a>
                    <a class="dropdown-item" href="listaEmpresa">Empresas</a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="login" method="GET">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" value="" > <i class="fas fa-sign-out-alt"></i> </button>
        </form>
    </div>
</nav>