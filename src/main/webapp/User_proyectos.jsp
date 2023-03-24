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
        <title>Proyectos</title>
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


        <script src="js/ajax_registro_proyecto.js" type="text/javascript"></script>
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

        <link href="css/tabla_resposive_proyectos.css" rel="stylesheet" type="text/css"/>
        <script src="js/ajax_eliminar_proyecto.js" type="text/javascript"></script>
        
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
            <br/>
            <div >
                <h4>Proyecto</h4>                
                <div class="container-fluid" id="mainBody">                    
                    <div class="row" id="container">                        
                        <form  enctype="multipart/form-data" method="POST"  name="form" style="padding: 10px;">                            
                            <div class="subContainer">                                
                                <h5>Nuevo proyecto</h5>                                
                                <div class="form-row px-3">                                    
                                    <div id="contenedor" class="col">
                                        <label >Username</label>
                                        <input style="width:400px" disabled value="<%= session.getAttribute("nom_user")%>" required id="username" name="username" class="form-control">                                        
                                    </div>                                                           
                                    <div id="contenedor" class="col">
                                        <label >Nombre del proyecto</label>
                                        <span>*</span>
                                        <input required id="nombre_proyecto" name="nombre_proyecto" style="width:400px" type="text" class="form-control">                                        
                                    </div>
                                    <div class="col">
                                        <label>Descripcion</label>
                                        <span>*</span>
                                        <textarea required id="descripcion_proyecto" name="descripcion_proyecto" style="width:400px" type="text" class="form-control"></textarea>                                        
                                    </div> 

                                    <div class="col">
                                        <label for="lastName">Fecha de inicio de proyecto</label>
                                        <span>*</span>
                                        <input required style="width:400px" id="fecha_proyecto" name="fecha_proyecto" type="date" class="form-control" id="exampleFormControlFile1">
                                    </div>     
                                    <br/>
                                    <div class="u-align-left u-form-group u-form-submit">
                                        <input  style="width:200px" type="button" id="button_registrar_proyecto" name="button_registrar_proyecto"  class="u-btn u-btn-submit u-button-style" value="Guardar proyecto"/>
                                    </div>
                                    <div id="cargando">                                    
                                    </div>
                                </div> 
                            </div>                                                                                                          
                        </form>
                        <br/>
                        <form action="action">
                            <br/>
                            <h5>Todos los proyecto</h5>
                            <label>Buscar: </label>
                            <input id="searchTerm" type="text" onkeyup="doSearch()" />
                            <br>
                            <br>
                            <div id="div1" style="max-height:  600px;">                            
                                <table class="width200" id="datos"  width="100%">
                                    <thead >                                                                                       
                                        <tr>
                                            <th ><strong>ID</strong></th>
                                            <th ><strong>NOMBRE</strong></th>  
                                            <th ><strong>DESCRIPCION</strong></th>                               		 
                                            <th ><strong>USUARIO</strong></th>
                                            <th ><strong>CREACION</strong></th>
                                            <th ><strong>INICIO</strong></th>
                                            <th ><strong>ESTADO</strong></th>
                                            <td colspan=1><strong>ACCIONES</strong></td>	
                                        </tr>
                                    </thead>
                                    <tbody >
                                        <c:forEach var="Objeto" items="${listaProyectos}">
                                            <tr>
                                                <td  style="text-align: justify;" ><c:out value="${Objeto.id_proyecto}"/></td>
                                                <td style="text-align: justify; "><c:out value="${Objeto.nombre_proyecto}"/></td>
                                                <td style="text-align: justify;"><c:out value="${Objeto.descripcion}"/></td>                                                                                
                                                <td style="text-align: justify; "><c:out value="${Objeto.name_user}"/></td>     
                                                <td  style="text-align: justify;" ><c:out value="${Objeto.fecha_creacion}"/></td>
                                                <td style="text-align: justify; "><c:out value="${Objeto.fecha_inicio}"/></td>                                                                                
                                                <td style="text-align: justify; "><c:out value="${Objeto.estado}"/></td> 
                                                <td><input   type="button" id="button_cambiar" name="button_cambiar" class="u-btn u-btn-submit u-button-style" onclick = "BorrarProyecto(${Objeto.id_proyecto})"  value="Eliminar proyecto"/></td>
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
