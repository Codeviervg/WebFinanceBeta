/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function BorrarProyecto(codigo)
{
    var resul = confirm('¿Este seguro de eliminar el proyecto?');
    if (resul)
    {
        $.post('Servlet_Proyecto_Eliminar', {
            idProyecto: codigo
        }, function (responseText) {
            $('#datos').html(responseText);
            $('#cargando').html('<div class="loading"><br/>Termino de cargar...</div>');
        });
    }
}

function VerImage(url)
{
    $.post('Servlet_ImageView', {
        url: url
    }, function (responseText) {
    });
}