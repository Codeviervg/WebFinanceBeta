/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function BorrarCliente(codigoidProveedor)
{
    var resul = confirm('¿Este seguro de eliminar al proveedor?');
    if (resul)
    {
        $.post('Servlet_Proveedor_Eliminar', {
            idProveedor: codigoidProveedor
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