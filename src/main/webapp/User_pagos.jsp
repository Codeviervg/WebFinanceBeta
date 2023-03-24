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
        <title>Registro gasto</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/inicio.css" rel="stylesheet" type="text/css"/>
        <script src="js/inicio.js" ></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <link href="css/Tablas.css" rel="stylesheet" type="text/css"/>
        <script src="js/validar_ruc.js" type="text/javascript"></script>
        <script src="js/ajax_registro_proveedor.js" type="text/javascript"></script>
        <script src="js/ajax_eliminar_proveedor.js" type="text/javascript"></script>        
        <!-- <script src="js/Combobox_Procedencia.js" type="text/javascript"></script>
        <script src="js/Combobox_Proveedores.js" type="text/javascript"></script>
        <script src="js/Combobox_TipoGasto.js" type="text/javascript"></script>    
        <script src="js/Combobox_Proyecto.js" type="text/javascript"></script>-->   
        <!-- alerta style -->
        <script src="js/sweetalert2.min.js" type="text/javascript"></script>
        <script src="js/sweetalert2.js" type="text/javascript"></script>
        <script src="js/sweetalert2.all.min.js" type="text/javascript"></script>
        <script src="js/sweetalert2.all.js" type="text/javascript"></script>
        <link href="css/sweetalert2.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/sweetalert2.css" rel="stylesheet" type="text/css"/>
        <script src="js/ajax_eliminar_proveedor.js" type="text/javascript"></script>
        
        <link rel="icon" href="img/logo.png">
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet" type="text/css" />
        <link href="css/tabla_resposive_registro_gastos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body id="body-pd">
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
            <jsp:include page="header/menu.html"></jsp:include>             
        </nav>
        <div class="container mt-5 pt-5">  
            <br/>
            <br/>
            <div >
                    <h4>Gastos de Vision Geografica</h4>                
                    <div class="container-fluid" id="mainBody">                    
                        <div class="row" id="container">                                            
                            <br/>
                            <div  >
                                <div class="signIn">
                                    <h4>Ingrese los datos del gasto</h4>
                                </div>
                                <div class="w-100">
                                <c:choose>
                                    <c:when test="${message=='1'}">                
                                        <script >
                                            Swal.fire({
                                                position: 'top-end',
                                                icon: 'success',
                                                title: 'Se registro correctamente',
                                                showConfirmButton: false,
                                                timer: 1500
                                            })
                                        </script>
                                        <br />
                                    </c:when>    
                                    <c:otherwise>    
                                        <c:choose>
                                            <c:when test="${message=='2'}">                
                                                <script >
                                                    Swal.fire({
                                                        icon: 'error',
                                                        title: 'Oops...',
                                                        text: 'Hubo problemas, no se pudo registrar el proveedor!'
                                                    })
                                                </script>
                                                <br />
                                            </c:when>    
                                            <c:otherwise>    
                                            </c:otherwise>
                                        </c:choose> 
                                    </c:otherwise>
                                </c:choose>  
                                <form action="Servlet_Pago_Nuevo" method="post" enctype="multipart/form-data" >
                                    <div class="subContainer">

                                        <div class="form-row px-3">
                                            <div id="contenedor" class="col">
                                                <div id="cargando_tipo_gasto">                                    
                                                </div> 
                                                <label >Tipo de gasto</label>
                                                <span>*</span>
                                                <select title="tipo" data-live-search="true" style="width:400px" required class="form-control" id="select_tipo_gasto" name="select_tipo_gasto" >  
                                                    <c:forEach var="Objeto" items="${listaGastos_tipos}">
                                                        <option value="${Objeto.id_tipo_gasto}">${Objeto.nombre}</option>
                                                    </c:forEach>
                                                </select>                                              
                                            </div>

                                            <div class="col">
                                                <div id="cargando_procedencia">                                    
                                                </div>
                                                <label>Procedencia del gasto</label>
                                                <span>*</span>                                                    
                                                <select title="procedencia" style="width:400px" required class="form-control" id="select_procedencia" name="select_procedencia" >  
                                                    <c:forEach var="Objeto" items="${listaProcedencias}">
                                                        <option value="${Objeto.id_procedencia}">${Objeto.nombre}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="col">
                                                <div id="cargando_proveedores">                                    
                                                </div>
                                                <label for="lastName">Proveedor</label>
                                                <span>*</span>
                                                <select title="Proveedor" data-live-search="true" style="width:400px" required class="form-control" id="select_proveedores" name="select_proveedores" >  
                                                    <c:forEach var="Objeto" items="${listaProveedores}">
                                                        <option value="${Objeto.id_proveedor}">${Objeto.nombre}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="col">
                                                <div id="cargando_proyecto">                                    
                                                </div>
                                                <label for="lastName">Proyecto</label>
                                                <span>*</span>
                                                <select title="proyecto" data-live-search="true" style="width:400px" required class="form-control" id="select_proyecto" name="select_proyecto" >  
                                                    <c:forEach var="Objeto" items="${listaProyectos}">
                                                        <option value="${Objeto.id_proyecto}">${Objeto.nombre_proyecto}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="col">
                                                <label for="lastName">Tipo pago</label>
                                                <span>*</span>
                                                <select required style="width:400px" id="select_tipo_pago" name="select_tipo_pago" class="form-control">
                                                    <option value="Efectivo">Efectivo</option>
                                                    <option value="Transferenica">Transferenica</option>
                                                </select>
                                            </div>
                                            <div class="col">
                                                <label for="lastName">Fecha del pago</label>
                                                <span>*</span>
                                                <input required style="width:400px" id="fecha_pago" name="fecha_pago" type="date" class="form-control" id="exampleFormControlFile1">
                                            </div>
                                            <div class="col">
                                                <label for="lastName">Personas involucradas (por defecto se registra al usuario logeado)</label>
                                                <c:forEach var="Objeto" items="${listaUser}">
                                                    <c:choose>
                                                        <c:when test="${userID==Objeto.id_user}"> 
                                                            <div class="form-check">
                                                                <input checked disabled name="checks1[]" class="form-check-input" type="checkbox" value="${Objeto.id_user}" id="CheckUser">
                                                                <label  class="form-check-label" for="flexCheckDefault">
                                                                    ${Objeto.nombre_completo} (${Objeto.tipo_user})
                                                                </label>
                                                            </div>
                                                        </c:when>    
                                                        <c:otherwise>   
                                                            <div class="form-check">
                                                                <input  name="checks1[]" class="form-check-input" type="checkbox" value="${Objeto.id_user}" id="CheckUser">
                                                                <label  class="form-check-label" for="flexCheckDefault">
                                                                    ${Objeto.nombre_completo} (${Objeto.tipo_user})
                                                                </label>
                                                            </div>
                                                        </c:otherwise>
                                                    </c:choose> 
                                                </c:forEach>
                                            </div>
                                            <div class="col">
                                                <label for="lastName">Equipos utilizados</label>
                                                <c:forEach var="Objeto" items="${listaEquipo}">
                                                    <div class="form-check">
                                                        <input name="checks2[]" class="form-check-input" type="checkbox" value="${Objeto.id_equipo}" id="CheckEquipo">
                                                        <label   class="form-check-label" for="flexCheckDefault">
                                                            ${Objeto.nombre}
                                                        </label>
                                                    </div>                                                
                                                </c:forEach>                                                                                        
                                            </div>
                                            <div class="col">
                                                <label for="lastName">Detalles</label>                                                
                                                <textarea required id="detalle_gastos" name="detalle_gastos"  style="width:400px" class="form-control"></textarea>
                                            </div>
                                            <div class="col">
                                                <label for="lastName">Pago de IVA</label>
                                                <span>*</span>
                                                <select required style="width:400px" id="select_ivasn" name="select_ivasn" class="form-control">
                                                    <option value="Si">Si</option>
                                                    <option value="No">No</option>
                                                </select>
                                            </div>                                        
                                            <div class="col">
                                                <label for="lastName">Valor total cancelado</label>
                                                <input required id="valor_total" step="0.01" name="valor_total" style="width:400px"  min="0" type="number" class="form-control">
                                            </div>
                                            <div class="col">
                                                <label for="lastName">Respaldo</label>
                                                <input style="width:400px" name="file" type="file" class="form-control" id="file">
                                            </div>                                                                                                
                                            <br/>                                                                                        
                                            <div class="u-align-left u-form-group u-form-submit">
                                                <input   style="width:200px" type="submit"  class="u-btn u-btn-submit u-button-style" value="Guardar pago"/>
                                            </div>
                                            <div id="cargando">                                    
                                            </div>                          
                                        </div>                                                                                
                                    </div>
                                    <br/>
                                </form>
                            </div>
                        </div>
                        <c:choose>
                            <c:when test="${cantPagos>0}"> 
                                <form action="action">
                                    <br/>
                                    <h5>Tus gastos registrados hoy</h5>
                                    <label>Buscar: </label>
                                    <input id="searchTerm" type="text" onkeyup="doSearch()" />
                                    <br>
                                    <br>
                                    <div id="div1" style="max-height:  600px;">                            
                                        <table class="width200" id="datos" width="100%">
                                            <thead >                                                                                       
                                                <tr>
                                                    <th ><strong>ID</strong></th>
                                                    <th ><strong>PROVEEDOR</strong></th>  
                                                    <th ><strong>USUARIO</strong></th>                               		 
                                                    <th ><strong>TIPO</strong></th>
                                                    <th ><strong>PROCEDENCIA</strong></th>
                                                    <th ><strong>COMENTARIO</strong></th>                                                                      		 
                                                    <th ><strong>TIPO</strong></th>
                                                    <th ><strong>REGISTRO</strong></th>
                                                    <th ><strong>GASTO</strong></th>                                                                        		                                                                                                                         
                                                    <th ><strong>IVA</strong></th>
                                                    <th ><strong>TOTAL</strong></th> 
                                                    <th ><strong>RESPALDO</strong></th> 	
                                                </tr>
                                            </thead>
                                            <tbody >
                                                <c:forEach var="Objeto" items="${lista}">
                                                    <tr>
                                                        <td  style="text-align: justify;" ><c:out value="${Objeto.id_gasto}"/></td>
                                                        <td style="text-align: justify; "><c:out value="${Objeto.proveedor}"/></td>
                                                        <td style="text-align: justify;"><c:out value="${Objeto.usuario_registro}"/></td>                                                                                
                                                        <td style="text-align: justify; "><c:out value="${Objeto.tipo_gasto}"/></td>     
                                                        <td  style="text-align: justify;" ><c:out value="${Objeto.procedencia}"/></td>
                                                        <td style="text-align: justify; "><c:out value="${Objeto.comentario}"/></td>

                                                        <td style="text-align: justify; "><c:out value="${Objeto.tipo_pago}"/></td> 
                                                        <td  style="text-align: justify;" ><c:out value="${Objeto.fecha__registro}"/></td>
                                                        <td style="text-align: justify; "><c:out value="${Objeto.fecha__pago}"/></td>
                                                        <td style="text-align: justify; "><c:out value="${Objeto.iva}"/></td>                                                                               

                                                        <td style="text-align: justify;"><c:out value="${Objeto.valor}"/></td>  
                                                        <td style="text-align: justify;"><c:out value="${Objeto.img_respaldo}"/></td>  
                                                       
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table> 
                                        <br/>
                                        <br/>
                                        <br/>
                                    </div>    
                                </form> 
                            </c:when>    
                            <c:otherwise>   
                                <h5>No tiene registro de gastos hoy</h5>
                            </c:otherwise>
                        </c:choose> 

                        <br/>
                        <br/>      <br/>
                        <br/>

                    </div>
                </div>
            </div>
        </div>

        <!--Container Main end-->
    </body>
</html>
