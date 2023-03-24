/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


var init = function () {
    $('#cargando_tipo_gasto').html('<div class="loading"><img src="gif/loader.gif" alt="loading" /><br/>Actualizando tipos de gastos...</div>');
    //Obtenemos la lista json de ProductCode
    $.getJSON("Servlet_Combobox_TipoGasto", {}, function (data, textStatus, jqXHR) {
        //preparamos el combo con la lista obtenida den data
        $("#select_tipo_gasto").empty(); //limpiamos el contenido
        $.each(data, function (index, item) {//recorremos la lista
            $("<option/>") //creamos un objeto option...
                    .attr("value", item.id_tipo_gasto) //.. con el valor
                    .text(item.nombre) //.. el texto a mostrar
                    .appendTo("#select_tipo_gasto"); //.. y lo agregamos al combo
        });
        $('#cargando_tipo_gasto').html(''); 
    });
        
    
    
};

$(document).ready(init);
