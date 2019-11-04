
function validarSelectOption() {

    var selectTipo = document.getElementById("selectTipoVisitaJs").value;
    var selectPro = document.getElementById("selectProfVisitaJs").value;
    var selectHora = document.getElementById("selectHoraJS").value;

    if (selectHora == 0) {
        alert("Debe seleccionar hora de visita");
        return false;
    }

    if (selectTipo == 0) {
        alert(" debe seleccionar el tipo de visita");
        return false;
    }

    if (selectPro == 0) {
        alert("Debe seleccionar un Profesional");
        return false;
    }

}

function validarSolicitarAsesoria() {

    var selectTipo = document.getElementById("inputTipoAsesoria4").value;
    var selectSucursal = document.getElementById("inputSucursal4").value;

    if (selectTipo == 0) {
        alert("Debe seleccionar tipo asesoria");
        return false;
    }

    if (selectSucursal == 0) {
        alert(" debe seleccionar sucursal");
        return false;
    }

}

function validarAsignarAsesoria() {

    var hora = document.getElementById("selectHoraJS").value;
    var pro = document.getElementById("selectProfAseJs").value;

    if (hora == 0) {
        alert("Debe seleccionar Hora");
        return false;
    }

    if (pro == 0) {
        alert(" Debe seleccionar Profesional");
        return false;
    }

}

function validarProgramarCapacitacion() {

    var selectTipoCapacitacion = document.getElementById("selectTipoCapacitacionJs").value;
    var selectPro = document.getElementById("selectProfcapacitacionJs").value;
    var selectHora = document.getElementById("selectHoraJS").value;

    if (selectHora == 0) {
        alert("Debe seleccionar hora de Capacitación");
        return false;
    }

    if (selectTipoCapacitacion == 0) {
        alert(" debe seleccionar el tipo de capacitación");
        return false;
    }

    if (selectPro == 0) {
        alert("Debe seleccionar un Profesional");
        return false;
    }

}

function validarCrearProfesional() {

    var selectRegion = document.getElementById("inputComuna4").value;

    if (selectRegion == 0) {
        alert("Debe seleccionar Comuna");
        return false;
    }

}

function validarCrearEmpresa() {

    var selectRubro = document.getElementById("selectRubro4").value;
    var selectRegion = document.getElementById("selectComunaId4").value;

    expresion = /\w+@\w+\.+[a-z]/;

    if (selectRubro == 0) {
        alert("Debe seleccionar Rubro");
        return false;
    }
    if (selectRegion == 0) {
        alert("Debe seleccionar Comuna");
        return false;
    }
}

function validarCrearUsuarioEmpresa() {

    var selectRegion = document.getElementById("inputRegion4").value;
    var selectEmpresa = document.getElementById("empresaIdSelect").value;

    if (selectRegion == 0) {
        alert("Debe seleccionar Comuna");
        return false;
    }
    
    if (selectEmpresa == 0) {
        alert("Debe seleccionar Empresa");
        return false;
    }
    
}

function confirmarDelete() {

    var respuesta = confirm("Estas seguro que deseas eliminar el usuario?");

    if (respuesta === true) {
        return true;
    } else {
        return false;
    }
}

function validarReporteAccidente() {

    var hora, minuto, tipoAccidente, sucursal;
    hora = document.getElementById("inputHora4").value;
    minuto = document.getElementById("inputMinuto4").value;
    tipoAccidente = document.getElementById("inputTipoAccidente4").value;
    sucursal = document.getElementById("inputSucursal4").value;


    if (hora == 0) {
        alert("Debe seleccionar hora de reporte");
        return false;
    }

    if (minuto == 0) {
        alert("Debe seleccionar minutos de accidente");
        return false;
    }

    if (tipoAccidente == 0) {
        alert("Debe seleccionar Tipo de accidente");
        return false;
    }

    if (sucursal == 0) {
        alert("Debe seleccionar Sucursal");
        return false;
    }

}

