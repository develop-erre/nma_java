
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

function validarProgramarCapacitacion() {

    var selectTipoCapacitacion = document.getElementById("selectTipoCapacitacionJs").value;
    var selectPro = document.getElementById("selectProfcapacitacionJs").value;
    var selectHora = document.getElementById("selectHoraJS").value;
    var numeroAsistentes = document.getElementById("numeroAsisJS");

    if (selectHora == 0) {
        alert("Debe seleccionar hora de Capacitación");
        return false;
    }

    if (numeroAsistentes > 40) {
        alert("Asistentes deben ser mayor a 0 y hasta 40 personas");
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

function validarCrearEmpresa() {

    var selectRubro, phone, expresion, numeroDir;
    phone = document.getElementById("telefonoJs").value;
    selectRubro = document.getElementById("selectRubroJs").value;
    numeroDir = document.getElementById("numeroDireccionJs").value;


    expresion = /\w+@\w+\.+[a-z]/;

    if (phone.length > 9) {
        alert("telefono debe tener máximo 9 caracteres");
        return false;
    }

    if (isNaN(phone)) {
        alert("telefono debe ser un Número ");
        return false;
    }

    if (selectRubro === 0) {
        alert("Debe seleccionar Rubro");
        return false;
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

}