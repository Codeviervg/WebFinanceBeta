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
        <title>Procedencias de gastos</title>
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
        <link rel="icon" href="img/logo.png">

        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet" type="text/css" />
        <link href="css/tabla_resposive_procedencia.css" rel="stylesheet" type="text/css"/>
    </head>
    <body id="body-pd">


        <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
            <jsp:include page="header/menu.html"></jsp:include>                         
        </nav>
        <div class="container mt-5 pt-5">
            <br/>
            <br/>
            <div >
                <h4>Origenes/procedencias de pago</h4>
                <div  id="mainBody">
                    <div class="row" id="container">
                        <br/>
                        <form action="action">
                            <br/>
                            <h5>Todos las procedencias de gastos</h5>
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
                                        </tr>
                                    </thead>
                                    <tbody >
                                        <c:forEach var="Objeto" items="${lista}">
                                            <tr>
                                                <td  style="text-align: justify;" ><c:out value="${Objeto.id_procedencia}"/></td>
                                                <td style="text-align: justify;"><c:out value="${Objeto.nombre}"/></td>                                    
                                                <td style="text-align: justify; "><c:out value="${Objeto.descripcion}"/></td>          
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table> 
                            </div>    
                        </form> 
                    </div>
                </div>
            </div>
            
        </div>

        <!--Container Main end-->
    </body>
</html>
