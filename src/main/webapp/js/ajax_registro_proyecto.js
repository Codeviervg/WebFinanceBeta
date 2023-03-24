/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

$(document).ready(function () {
    $('#button_registrar_proyecto').click(function (event) {             
      $('#cargando').html('<div class="loading"><img src="gif/loader.gif" alt="loading" /><br/>Un momento, por favor...</div>');        
        var nombre_proyecto = $('#nombre_proyecto').val();
        var descripcion_proyecto = $('#descripcion_proyecto').val();
        var fecha_proyecto = $('#fecha_proyecto').val();
        // Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
        $.post('Servlet_Proyecto_Nuevo', {
            nombre_proyecto: nombre_proyecto,
            descripcion_proyecto: descripcion_proyecto,
            fecha_proyecto: fecha_proyecto
        }, function (responseText) {
            $('#datos').html(responseText);
            $('#cargando').html('<div class="loading"><br/>Termino de cargar...</div>');        
        });                     
    });
});


