/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */



function validar() {
    var number = document.getElementById('n_ruc').value;
    var ruc_number = document.getElementById('n_ruc');
    var button_cambiar = document.getElementById('button_cambiar');
    var button_validar = document.getElementById('button_validar');
    var button_registrar = document.getElementById('button_registrar');

    var dto = number.length;
    var valor;
    var acu = 0;
    if (number == "0000000000000") {
        alert('Se ha ingresado el RUC por defecto, utilizado para los proveedores sin RUC\n');
        ruc_number.disabled = true;
        button_cambiar.disabled = false;
        button_validar.disabled = true;
        button_registrar.disabled = false;
    } else {

        if (number == "") {
            alert('No has ingresado ningún dato, porfavor ingresar los datos correspondientes.');
        } else {
            if (number.length < 14) {
                for (var i = 0; i < dto; i++) {
                    valor = number.substring(i, i + 1);
                    if (valor == 0 || valor == 1 || valor == 2 || valor == 3 || valor == 4 || valor == 5 || valor == 6 || valor == 7 || valor == 8 || valor == 9) {
                        acu = acu + 1;
                    }
                }
                if (acu == dto) {
                    while (number.substring(10, 13) != 001) {
                        alert('Los tres últimos dígitos no tienen el código del RUC 001.');
                        return;
                    }
                    while (number.substring(0, 2) > 24) {
                        alert('Los dos primeros dígitos no pueden ser mayores a 24.');
                        return;
                    }
                    var porcion1 = number.substring(2, 3);
                    if (porcion1 < 6) {
                        alert('El tercer dígito es menor a 6, por lo \ntanto el usuario es una persona natural.\n');
                        ruc_number.disabled = true;
                        button_cambiar.disabled = false;
                        button_validar.disabled = true;
                        button_registrar.disabled = false;
                    } else {
                        if (porcion1 == 6) {
                            alert('El tercer dígito es igual a 6, por lo \ntanto el usuario es una entidad pública.\n');
                            ruc_number.disabled = true;
                            button_cambiar.disabled = false;
                            button_validar.disabled = true;
                            button_registrar.disabled = false;
                        } else {
                            if (porcion1 == 9) {
                                alert('El tercer dígito es igual a 9, por lo \ntanto el usuario es una sociedad privada.\n');
                                ruc_number.disabled = true;
                                button_cambiar.disabled = false;
                                button_validar.disabled = true;
                                button_registrar.disabled = false;
                            }
                        }
                    }
                } else {
                    alert("ERROR: Por favor no ingrese texto");
                }
            } else {
                alert('La dimension del RUC no es la correcta\n');
            }
        }

    }
}


function registrar_sin_ruc() {
    var ruc_number = document.getElementById('n_ruc');
    var button_cambiar = document.getElementById('button_cambiar');
    var button_validar = document.getElementById('button_validar');
    var button_registrar = document.getElementById('button_registrar');
    ruc_number.value = "0000000000000";
    ruc_number.disabled = true;
    button_cambiar.disabled = false;
    button_validar.disabled = true;
    button_registrar.disabled = false;

}

function cambiar_ruc() {
    var number = document.getElementById('n_ruc').value;
    var ruc_number = document.getElementById('n_ruc');
    var button_cambiar = document.getElementById('button_cambiar');
    var button_validar = document.getElementById('button_validar');
    var button_registrar = document.getElementById('button_registrar');

    ruc_number.disabled = false;
    button_cambiar.disabled = false;
    button_validar.disabled = false;
    button_registrar.disabled = true;

}


    

