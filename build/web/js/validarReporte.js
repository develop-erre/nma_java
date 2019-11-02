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

    if (minuto == "SELECCIONE" ) {
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

