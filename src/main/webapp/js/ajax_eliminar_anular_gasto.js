/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function AnularGasto(codigoGasto)
{
    var resul = confirm('¿Este seguro de anular el gasto?');
    if (resul)
    {
        $.post('Servlet_Gasto_Anular', {
            idGasto: codigoGasto
        }, function (responseText) {
            $('#datos').html(responseText);
            $('#cargando').html('<div class="loading"><br/>Termino de cargar...</div>');
        });
    }
}