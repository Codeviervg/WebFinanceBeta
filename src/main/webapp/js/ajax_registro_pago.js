/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
$(document).ready(function () {
    $('#button_registrar_pago').click(function (event) {
        $('#cargando').html('<div class="loading"><img src="gif/loader.gif" alt="loading" /><br/>Un momento, por favor...</div>');
        var select_tipo_gasto = document.getElementById("select_tipo_gasto").value;
        var select_procedencia = document.getElementById("select_procedencia").value;
        var select_proveedores = document.getElementById("select_proveedores").value;
        var select_tipo_pago = document.getElementById("select_tipo_pago").value;
        var fecha_pago = document.getElementById("fecha_pago").value;
        var fecha_pago = document.getElementById("fecha_pago").value;



        var checkedCheckboxesValues =
                $('input:checkbox[name="checks1"]:checked')
                .map(function () {
                    return $(this).val();
                }).get();
                
        var str = checkedCheckboxesValues.join(',');

        var values = $("input[name='checks1[]']:checked").map(function (index, domElement) {
            return $(domElement).val();
        });

        var vals = $('input:checkbox[name="checks1[]"]:checked').map(function () {
            return this.checked ? this.value : undefined;
        }).get();

        var usuarios = $('[name="checks1[]"]:checked').map(function () {
            return this.value;
        }).get();
        var equipos = $('[name="checks2[]"]:checked').map(function () {
            return this.value;
        }).get();
        var str = usuarios.join(',');
        var detalle_gastos = document.getElementById("detalle_gastos").value;



        var ivasn = $('[name="checks3[]"]:checked').map(function () {
            return this.value;
        }).get();
        var valor_iva = document.getElementById("valor_iva").value;
        var valor_total = document.getElementById("valor_total").value;

        // Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get        
        $.post('Servlet_Pago_Nuevo', {
            select_tipo_gasto: select_tipo_gasto,
            select_procedencia: select_procedencia,
            select_proveedores: select_proveedores,
            select_tipo_pago: select_tipo_pago,
            fecha_pago: fecha_pago,
            usuarios: usuarios,
            equipos: equipos,
            detalle_gastos: detalle_gastos,
            ivasn: ivasn,
            valor_iva: valor_iva,
            valor_total: valor_total,
            checkedCheckboxesValues:checkedCheckboxesValues,
            str: str
        }, function (responseText) {
            $('#respuesta').html(responseText);
            $('#cargando').html('<div class="loading"><br/>Termino de cargar...</div>');
        });
    });
});
