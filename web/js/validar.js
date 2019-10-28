
//alert("hola mundo");

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

    if (selectRubro == 0) {
        alert("Debe seleccionar Rubro");
        return false;
    }

    if (numeroDir > 5) {
        alert("Campo numero direccion Debe ser maximo 5 caracteres y ser numero");
        return  false;
    }
    
    
    function confirmarDelete() {
        
        var respuesta = confirm("Estas seguro que deseas eliminar el usuario?");
        
        if (respuesta === true) {
            return true;
        }else{
            return false;
        }
    }

}