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
        <title>Proveedores</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/inicio.css" rel="stylesheet" type="text/css"/>
        <script src="js/inicio.js" ></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <link href="css/Tablas.css" rel="stylesheet" type="text/css"/>
        <script src="js/ajax_eliminar_proveedor.js" type="text/javascript"></script>
        <script src="js/ajax_registro_proveedor.js" type="text/javascript"></script>
        <script src="js/validar_ruc.js" type="text/javascript"></script>
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
        <link href="css/tabla_resposive_proveedores.css" rel="stylesheet" type="text/css"/>
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
        <div class="container mt-5 pt-5">
            <br/>
            <br/>       
            <div >
                <h4>Proveedores</h4>                
                <div id="mainBody">                    
                    <div  id="container">                        
                        <form  enctype="multipart/form-data" method="POST"  name="form" style="padding: 10px;">                            
                            <div >                                
                                <h5>Nuevo proveedor</h5>                                
                                <div class="form-row px-3">                                    
                                    <div id="contenedor" class="col">
                                        <label >Username</label>
                                        <input style="width:400px" disabled value="<%= session.getAttribute("nom_user")%>" required id="username" name="username" class="form-control">                                        
                                    </div>
                                    <div id="contenedor0" class="col">
                                        <label style="width:400px" >Ruc del proveedor</label>                                    
                                        <input required style="width:400px" type="text" id="n_ruc" name="n_ruc"   class="form-control">                                        
                                    </div>                             
                                    <div id="contenedor" class="col">
                                        <label >Nombre del proveedor</label>
                                        <span>*</span>
                                        <input required id="nombre_proveedor" name="nombre_proveedor" style="width:400px" type="text" class="form-control">                                        
                                    </div>
                                    <div class="col">
                                        <label>Descripcion</label>
                                        <span>*</span>
                                        <textarea required id="descripcion_proveedor" name="descripcion_proveedor" style="width:400px" type="text" class="form-control"></textarea>                                        
                                    </div> 
                                    <br/>
                                    <div class="u-align-left u-form-group u-form-submit">
                                        <input style="width:200px"  type="button" id="button_validar" name="button_validar"  class="u-btn u-btn-submit u-button-style" onclick = "validar()"  value="Validar ruc"/>                                    
                                    </div>
                                    <div class="u-align-left u-form-group u-form-submit">
                                        <input style="width:200px" type="button" id="button_sin_ruc" name="button_sin_ruc"   class="u-btn u-btn-submit u-button-style" onclick = "registrar_sin_ruc()" value="Registrar sin ruc"/>
                                    </div>
                                    <div class="u-align-left u-form-group u-form-submit">
                                        <input disabled style="width:200px"  type="button" id="button_cambiar" name="button_cambiar" class="u-btn u-btn-submit u-button-style" onclick = "cambiar_ruc()"  value="Cambiar RUC"/>
                                    </div>                                
                                    <div class="u-align-left u-form-group u-form-submit">
                                        <input disabled  style="width:200px" type="button" id="button_registrar" name="button_registrar"  class="u-btn u-btn-submit u-button-style" value="Guardar proveedor"/>
                                    </div>
                                    <div id="cargando">                                    
                                    </div>
                                </div> 
                            </div>                                                                                                          
                        </form>
                        <br/>
                        <form action="action">
                            <br/>
                            <h5>Todos los proveedores</h5>
                            <label>Buscar: </label>
                            <input id="searchTerm" type="text" onkeyup="doSearch()" />
                            <br>
                            <br>
                            <div id="div1" style="max-height:  600px;">                            
                                <table class="width200" id="datos"  width="100%">
                                    <thead >                                                                                       
                                        <tr>
                                            <th ><strong>ID</strong></th>
                                            <th ><strong>RUC</strong></th>  
                                            <th ><strong>NOMBRE</strong></th>                               		 
                                            <th ><strong>DESCRIPCION</strong></th>
                                            <td colspan=1><strong>ACCIONES</strong></td>	
                                        </tr>
                                    </thead>
                                    <tbody >
                                        <c:forEach var="Objeto" items="${lista}">
                                            <tr>
                                                <td  style="text-align: justify;" ><c:out value="${Objeto.id_proveedor}"/></td>
                                                <td style="text-align: justify; "><c:out value="${Objeto.ruc}"/></td>
                                                <td style="text-align: justify;"><c:out value="${Objeto.nombre}"/></td>                                                                                
                                                <td style="text-align: justify; "><c:out value="${Objeto.descripcion}"/></td>                                                                                                                                                               
                                                <td><input   type="button" id="button_cambiar" name="button_cambiar"  onclick = "BorrarCliente(${Objeto.id_proveedor})"  value="Eliminar proveedor"/></td>
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
        <!--Container Main start-->            


        <!--Container Main end-->
    </body>
</html>
