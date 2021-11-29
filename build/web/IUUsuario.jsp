<%-- 
    Document   : IUAdmin
    Created on : 28/11/2021, 10:47:09 AM
    Author     : josec
--%>

<%@page import="vista.UsuarioPresentador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

                    <div class="container-fluid">
                        <div class="row mx-1">
                            <div class="col-12 mt-3">
                                <h4>
                                   Lista de Usuario 
                                </h4>
                                <form method="post" action="UsuarioControl">
                                    <button class="btn btn-primary my-3" type="submit" name="acc" value="AgregarUsuario">
                                        Agregar
                                    </button>
                                </form>
                            </div>
                            
                            <div class="col-12">
                               <p class="small text-success mb-0">
                                    <%= usuPre.getMsg() %>
                               </p>
                            </div>
                            
                            <div class="col-12 mt-3">
                                <div class="table-responsive">
                                    <table class="table table-bordered my-table">
                                        <thead>
                                          <tr>
                                            <th scope="col">Acciones</th>
                                            <th scope="col">Usuario</th>
                                            <th scope="col">Tipo Usuario</th>
                                            <th scope="col">Fecha Registro</th>
                                            <th scope="col">Fecha Actualizacion</th>
                                          </tr>
                                        </thead>
                                        <tbody>
                                                <% for(int i=1;i<usuPre.getListaUsuario().size();i++){ %>
                                                <% Object[] usuarioLista = (Object[])usuPre.getListaUsuario().get(i); %>
                                                  <tr>
                                                    <td>
                                                        <form method="post" action="UsuarioControl">
                                                            
                                                            <input type="hidden" name="IdUsuario" value="<%= usuarioLista[0] %>" />
                                                            <input type="hidden" name="Usuario" value="<%= usuarioLista[1] %>" />
                                                            <input type="hidden" name="Contrasenia" value="<%= usuarioLista[2] %>" />
                                                            <input type="hidden" name="FechaRegistro" value="<%= usuarioLista[3] %>" />
                                                            <input type="hidden" name="FechaActualizacion" value="<%= usuarioLista[4] %>" />
                                                            <input type="hidden" name="IdTipoUsuario" value="<%= usuarioLista[5] %>" />
                                                            <input type="hidden" name="TipoUsuario" value="<%= usuarioLista[6] %>" />
                                                            
                                                            <button class="btn btn-success" type="submit" name="acc" value="ModificarUsuario">
                                                                <i class="fas fa-pencil-alt fa-xs"></i>
                                                            </button>
                                                            <button class="btn btn-danger" type="submit" name="acc" value="EliminarUsuario">
                                                                <i class="fas fa-trash fa-xs"></i>
                                                            </button>
                                                        </form>
                                                    </td>
                                                    <td><%= usuarioLista[1] %></td>
                                                    <td><%= usuarioLista[6] %></td>
                                                    <td>
                                                        <% if(usuarioLista[3] != null){ %> 
                                                            <%= usuarioLista[3] %>
                                                        <% }%>
                                                    </td>
                                                    <td>
                                                        <% if(usuarioLista[4] != null){ %> 
                                                            <%= usuarioLista[4] %>
                                                        <% }%>
                                                    </td>
                                                  </tr>
                                                <% } %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>

                </main>

            </section>
            <!-- END MAIN -->

        </main>
        
        
        <script type="text/javascript" src="./assets/js/admin.js">
        </script>
    </body>
</html>
