<%-- 
    Document   : Iniciar-sesion
    Created on : Jun 2, 2022, 4:12:15 PM
    Author     : Henrry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visión Geográfica</title>
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/style_login.css">
        <link rel="icon" href="img/logo.png">
    </head>
    <body>
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">
                        <h2 class="heading-section">Visión Geográfica</h2>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-7 col-lg-5">
                        <div class="login-wrap p-4 p-md-5">
                            <div class="icon d-flex align-items-center justify-content-center">
                                <span class="fa fa-user-o"></span>
                            </div>
                            <h3 class="text-center mb-4">Ingrese sus credenciales</h3>
                            <form action="Logear" method="POST" class="login-form">
                                <div class="form-group">
                                    <input name="usuario" type="text" class="form-control rounded-left"  placeholder="Usuario" required>
                                </div>
                                <div class="form-group d-flex">
                                    <input name="clave" type="password" class="form-control rounded-left"  placeholder="Clave" required>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="form-control btn btn-primary rounded submit px-3">Ingresar</button>
                                </div>
                                <div class="form-group d-md-flex">
                                    <div class="w-50">
                                        <label class="checkbox-wrap checkbox-primary">Recordar credenciales
                                            <input type="checkbox" checked>
                                            <span class="checkmark"></span>
                                        </label>
                                    </div>
                                    <div class="w-50 text-md-right">
                                        <a href="#">Recuperar clave</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="js/login/bootstrap.min.js" ></script>
        <script src="js/login/jquery.min.js" ></script>
        <script src="js/login/main.js" ></script>
        <script src="js/login/popper.js" ></script>
    </body>
</html>
