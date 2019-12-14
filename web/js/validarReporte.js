function valReportAccidente() {

    var hora = document.getElementById("selectHorareporte").value;
    var minuto = document.getElementById("selectMinutoreporte").value;
    var tipoAccidente = document.getElementById("selectTipoAccidentereporte").value;

    if (hora == "SELECCIONE") {
        alert("Debe seleccionar hora de reporte");
        return false;
    }

    if (minuto == "SELECCIONE" ) {
        alert("Debe seleccionar minutos de accidente");
        return false;
    }

    if (tipoAccidente == "SELECCIONE") {
        alert("Debe seleccionar Tipo de accidente");
        return false;
    }
}