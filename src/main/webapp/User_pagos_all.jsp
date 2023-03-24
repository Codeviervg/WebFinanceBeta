<%-- 
    Document   : User_gasto_registro
    Created on : May 25, 2022, 9:36:35 AM
    Author     : Henrry
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pagos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/inicio.css" rel="stylesheet" type="text/css"/>
        <script src="js/inicio.js" ></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        
        <script src="js/validar_ruc.js" type="text/javascript"></script>      
        <!-- <script src="js/Combobox_Procedencia.js" type="text/javascript"></script>
        <script src="js/Combobox_Proveedores.js" type="text/javascript"></script>
        <script src="js/Combobox_TipoGasto.js" type="text/javascript"></script>    
        <script src="js/Combobox_Proyecto.js" type="text/javascript"></script>-->        
        <script src="js/cargar_combobox_all.js" type="text/javascript"></script>
        <!-- alerta style -->
        <script src="js/sweetalert2.min.js" type="text/javascript"></script>
        <script src="js/sweetalert2.js" type="text/javascript"></script>
        <script src="js/sweetalert2.all.min.js" type="text/javascript"></script>
        <script src="js/sweetalert2.all.js" type="text/javascript"></script>
        <link href="css/sweetalert2.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/sweetalert2.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="img/logo.png">
        
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet" type="text/css" />
        
        <link href="css/tabla_resposive.css" rel="stylesheet" type="text/css"/>
        <script src="js/ajax_eliminar_anular_gasto.js" type="text/javascript"></script>
    </head>
    <body id="body-pd">
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
            <jsp:include page="header/menu.html"></jsp:include>             
        </nav>
        <%
            if (session.getAttribute("id_user") == null) {
                response.sendRedirect("Iniciar-sesion.jsp");
            }
        %>
        <!--Container Main start-->  
        <div class="container mt-5 pt-5">
            <br/>
            <div>
                <h4>Gastos de Vision Geograficaaa</h4>                
                <div  id="mainBody">                    
                    <div  id="container">                                            

                        <form action="action">
                            <br/>
                            <h5>Tus gastos registrados</h5>
                            <label>Buscar: </label>
                            <input id="searchTerm" type="text" onkeyup="doSearch()" />
                            <br>
                            <br>
                            <div id="div1" style="max-height:  600px;">                                            
                                <table class="width200" id="datos" width="100%">
                                    <thead >                                                                                       
                                        <tr>
                                            <th ><strong>ID</strong></th>
                                            <th ><strong>ESTADO</strong></th>
                                            <th ><strong>PROVEEDOR</strong></th>  
                                            <th ><strong>USUARIO</strong></th>                               		 
                                            <th ><strong>TIPO</strong></th>
                                            <th ><strong>PROCEDENCIA</strong></th>
                                            <th ><strong>COMENTARIO</strong></th>                                                                      		 
                                            <th ><strong>TIPO</strong></th>
                                            <th ><strong>REGISTRO</strong></th>
                                            <th ><strong>FECHA DE GASTO</strong></th>                                                                        		                                                                                                                         
                                            <th ><strong>IVA</strong></th>
                                            <th ><strong>VALOR IVA</strong></th> 
                                            <th ><strong>VALOR TOTAL</strong></th> 
                                            <td colspan=1><strong>ACCIONES</strong></td>	
                                        </tr>
                                    </thead>
                                    <tbody >
                                        <c:forEach var="Objeto" items="${lista}">
                                            <tr>
                                                <td  style="text-align: justify;" ><c:out value="${Objeto.id_gasto}"/></td>
                                                <td  style="text-align: justify;" ><c:out value="${Objeto.estado}"/></td>
                                                <td style="text-align: justify; "><c:out value="${Objeto.proveedor}"/></td>
                                                <td style="text-align: justify;"><c:out value="${Objeto.usuario_registro}"/></td>                                                                                
                                                <td style="text-align: justify; "><c:out value="${Objeto.tipo_gasto}"/></td>     
                                                <td  style="text-align: justify;" ><c:out value="${Objeto.procedencia}"/></td>
                                                <td style="text-align: justify; "><c:out value="${Objeto.comentario}"/></td>

                                                <td style="text-align: justify; "><c:out value="${Objeto.tipo_pago}"/></td> 
                                                <td  style="text-align: justify;" ><c:out value="${Objeto.fecha__registro}"/></td>
                                                <td style="text-align: justify; "><c:out value="${Objeto.fecha__pago}"/></td>
                                                <td style="text-align: justify; "><c:out value="${Objeto.iva}"/></td>
                                                <td style="text-align: justify;"><c:out value="${Objeto.valor_iva}"/></td>                                                                                

                                                <td style="text-align: justify;"><c:out value="${Objeto.valor}"/></td> 
                                                <td><input   type="button" id="button_cambiar" name="button_cambiar" class="u-btn u-btn-submit u-button-style" onclick = "AnularGasto(${Objeto.id_gasto})"  value="Anular gasto"/></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table> 
                                <br/>
                                <br/>
                                <br/>
                            </div>    
                        </form> 
                    </div>
                </div>
            </div>
        </div>
        <!--Container Main end-->
    </body>
</html>
