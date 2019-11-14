<%@ page pageEncoding="UTF-8" %>
<!-- MENU -->

<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Profesional</a>
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
                    Acciones
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="listarVisitasAsignadas">Visitas Asignadas</a>
                    <a class="dropdown-item" href="listaAsesoriasAsignadas">Asesorias Asignadas</a>
                    <a class="dropdown-item" href="listaCapacitacionAsignada">Capacitaciones Asignadas</a>
                </div>
            </li> 
        </ul>
        <form class="form-inline my-2 my-lg-0" action="login" method="GET">
            <button class="btn btn-success my-2 my-sm-0" type="submit" value="" > <i class="fas fa-sign-out-alt"></i> Salir</button>
        </form>
    </div>
</nav>