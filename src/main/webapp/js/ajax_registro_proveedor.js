/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

$(document).ready(function () {
    $('#button_registrar').click(function (event) {             
      $('#cargando').html('<div class="loading"><img src="gif/loader.gif" alt="loading" /><br/>Un momento, por favor...</div>');        
        var n_rucVar = $('#n_ruc').val();
        var nombre_proveedorVar = $('#nombre_proveedor').val();
        var descripcion_proveedorVar = $('#descripcion_proveedor').val();
        // Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
        $.post('Servlet_Proveedor_Nuevo', {
            n_ruc: n_rucVar,
            nombre_proveedor: nombre_proveedorVar,
            descripcion_proveedor: descripcion_proveedorVar
        }, function (responseText) {
            $('#datos').html(responseText);
            $('#cargando').html('<div class="loading"><br/>Termino de cargar...</div>');        
        });                     
    });
});


