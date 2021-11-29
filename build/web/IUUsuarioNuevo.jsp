<%-- 
    Document   : IUAdmin
    Created on : 28/11/2021, 10:47:09 AM
    Author     : josec
--%>

<%@page import="vista.UsuarioPresentador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin | Sistema web para llevar el control de ventas de la empresa - COMPSELL S.R.L</title>
        <style>@import"./assets/css/styles.css";</style>
        <style>@import"./assets/css/components/admin.css"</style>
        <link rel="icon" type="image/x-icon" href="./assets/img/logo.png">
        <meta name="theme-color" content="#0078D7">
        <meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'/>
        <script src="https://kit.fontawesome.com/2fb25d77eb.js" crossorigin="anonymous"></script>
        
        <!-- BOOSTSTRAP -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

    </head>
    <body class="theme-dark" id="body">
        
        <main class="l-admin" id="admin">
            <% UsuarioPresentador usuPre = (UsuarioPresentador) session.getAttribute("usuPre"); %>
            
            <!-- START NAVBAR -->
            <section class="l-navbar" id="navbar">
                <article class="l-navbar__icon">

                    <aside class="l-hamburguer" id="l-hamburguer">
                        <div class="hamburger hamburger--slider" id="hamburger">
                            <span class="hamburger__box">
                                <span class="hamburger__inner"></span>
                            </span>
                        </div>
                    </aside>

                    <img src="./assets/img/login/login-name.png">

                </article>
                <article class="l-navbar__main">

                    <p class="mb-0">COMPSELL </p> <span>/</span> <p class="mb-0">Sistema web para llevar el control de ventas</p>
                    

                </article>
                <article class="l-navbar__options">

                    <div class="l-toggle-theme">
                        <div>
                            <input type="checkbox" class="checkbox" id="check-theme" />
                            <label class="label" for="check-theme">
                                <i class="fas fa-moon"></i>
                                <i class="fas fa-sun"></i>
                                <div class="ball"></div>
                            </label>
                        </div>
                    </div>

                </article>
                <article class="l-navbar__hero">
                    <img src="./assets/img/admin/user.png" id="user-photo"> 
                </article>
            </section>

            <section class="l-navbar-profile" id="navbar-profile">

                <article class="l-navbar-profile__name">
                    <p class="mb-0" >Sistema COMPSELL</p>
                </article>

                <article class="l-navbar-profile__logout">
                    <p class="mb-0" id="sign-out">
                        <a href="./IULogin.jsp">Desconectar</a>
                    </p>
                </article>

                <article class="l-navbar-profile__info">

                    <aside class="l-navbar-profile__info-hero">

                        <img src="./assets/img/admin/user.png"> 

                    </aside>

                    <aside class="l-navbar-profile__info-user">
                        <% Object[]usuario = usuPre.getUsuario(); %>
                        <h2 class="mb-0"> <%= usuario[1] %> </h2>
                        <p class="mb-0" > <%= usuario[4] %> </p>
                        <p class="mb-0" > Ver Cuenta </p>
                    </aside>

                </article>

            </section>
            <!-- END NAVBAR -->

            <section class="l-portal" id="portal">

            </section>
            
            <!-- START SIDEBAR -->
            <section class="l-sidebar" id="sidebar">
                <main class="w-sidebar">

                    <article class="w-sidebar__title">
                        <a href="javascript:void(0)">
                            <span>
                                <img src="./assets/img/admin/proyecto.png" /> 
                            </span>
                            <span class="module-parrafo">
                                COMPSELL Sistema
                            </span>
                        </a>
                    </article>

                    <article class="w-sidebar__separator top">
                    </article>

                    <article class="w-sidebar__modules">
                        
                            <% for(int i=1;i<usuPre.getMenu().size();i++){ %>
                            <% Object[] menu = (Object[])usuPre.getMenu().get(i); %>

                                <form method="POST" action="<%= menu[2] %>">
                                    <section class="modules" >

                                        <div class="modules__main">
                                            <input type="hidden" name="IdTipoUsuario" value="<%= usuario[3] %>">
                                            <button class="modules__button" type="submit"  name="acc" value="Lista">
                                                  <span>
                                                       <img src="<%= menu[3] %>" alt="modulo">
                                                  </span>
                                                  <span class="module-parrafo">
                                                       <%= menu[1] %>
                                                  </span>
                                            </button>

                                        </div>
                                    </section>
                                </form>

                            <% } %>


                    </article>

                    <article class="w-sidebar__separator bottom">
                    </article>

                    <article class="w-sidebar__icons">

                        <i class="fa fa-cog first"></i>
                        <span>Project settings</span>
                        <i class="fas fa-angle-double-left second" id="sidebar-bottom-angle"></i>

                    </article>


                </main>
            </section>
            <!-- END SIDEBAR -->
            
            
            <!-- START MAIN -->
            <section class="l-main" id="main">
                <main class="l-dashboard">

                    <form method="post" action="UsuarioControl">
                        
                        <div class="container-fluid">

                            <div class="row mx-1">
                                <div class="col-12 mt-3">
                                    <h4>
                                       <% String tipoAccion = usuPre.getTipoAccion(); %>
                                       <%= tipoAccion %> Usuario 
                                    </h4>
                                </div>
                                <div class="col-md-8 mt-3">
                                        <div class="my-card">

                                                <% Object[]usuarioDB = usuPre.getUsuario(); %>

                                                <input name="IdUsuario" type="hidden" value="<%= usuarioDB[0]%>" />
                                                <input id="IdUsuarioForm" name="IdTipoUsuario" type="hidden" data-idtipousuarioform="<%= usuarioDB[5] %>" class="form-control">

                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <label class="formGroupExampleInput" for="user">Usuario</label>
                                                            <input id="producto" name="usuario" type="text" value="<%= usuarioDB[1] %>" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <label class="formGroupExampleInput" for="user">Contraseña</label>
                                                            <input id="producto" name="contrasenia" type="text" value="<%= usuarioDB[2] %>" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                        <label for="exampleFormControlSelect1">Seleccione el tipo de usuario</label>
                                                        <select class="form-control" name="idTipoUsuario" id="selectTipoUsuario">
                                                          <% for(int i=1;i<usuPre.getListaTipoUsuario().size();i++){ %>
                                                          <% Object[] tipo = (Object[])usuPre.getListaTipoUsuario().get(i); %>
                                                              <option value="<%= tipo[0] %>"> <%= tipo[1] %> </option>
                                                          <% } %>
                                                        </select>
                                                      </div>
                                                    </div>
                                                </div>

                                        </div>
                                    
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-8 d-flex justify-content-end mt-3">
                                    <button type="submit" class="btn btn-primary mr-2" name="acc" value="GrabarUsuario">
                                       <i class="fas fa-save d-inline-block mr-2"></i>
                                       <% String tipoAccion2 = usuPre.getTipoAccion(); %>
                                       <%= tipoAccion2 %> Usuario
                                    </button>
                                </div>
                            </div>
                        </div>
                                
                    </form>

                </main>

            </section>
            <!-- END MAIN -->
            
            

        </main>
        
        
        <script type="text/javascript" src="./assets/js/admin.js"></script>
        <script type="text/javascript" src="./assets/js/venta.js"></script>
        
        
    </body>
</html>
