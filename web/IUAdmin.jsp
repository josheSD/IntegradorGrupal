<%-- 
    Document   : IUAdmin
    Created on : 28/11/2021, 10:47:09 AM
    Author     : josec
--%>

<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vista.DashboardPresentador"%>
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

        <script src="./assets/js/jquery.bundle.min.js"></script>
        <script src="./assets/js/Chart.bundle.min.js"></script>
        
    </head>
    <body class="theme-dark" id="body">
        <% UsuarioPresentador usuPre = (UsuarioPresentador) session.getAttribute("usuPre"); %>
        <% DashboardPresentador dashPre = (DashboardPresentador) session.getAttribute("dashPre"); %>
        <%! 
            ArrayList<Double> ventaAnioValor = new ArrayList<Double>();
            ArrayList<String> ventaAnioNombre = new ArrayList<String>();
            ArrayList<Double> ventaTrimestreValor = new ArrayList<Double>();
            ArrayList<String> ventaTrimestreNombre = new ArrayList<String>();
        %>

        
        <main class="l-admin" id="admin">
            
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
                <main class="l-dashboard boleta overflow-auto">
                    
                    <section class="l-dashboard__title l-wrapper" style="height:60px !important">
                        <h4> Cuadros Estadísticos</h4>
                    </section>
                    
                    <section class="container-fluid">
                        <div class="row">
                            <div class="col-md-3">
                                
                                <% for(int i=1;i<dashPre.getListaVentaAnual().size();i++){ %>
                                <% Object[] listaVentaAnual = (Object[])dashPre.getListaVentaAnual().get(i); %>
                                    <article class="card mb-3 mt-4  border-0">
                                        <div class="card-body py-5">
                                            <h2 class="mb-0 text-center"><%= listaVentaAnual[1] %></h2>
                                            <span class="d-block mb-0  mt-2 text-center">Venta Anual - <%= listaVentaAnual[0] %></span>
                                        </div>
                                    </article>
                                <% } %>
                                        
                            </div>
                                
                            <div class="col-md-3">
                                
                                <% for(int i=1;i<dashPre.getListaVentaAnual().size();i++){ %>
                                <% Object[] listaVentaMensualActual = (Object[])dashPre.getListaVentaMensualActual().get(i); %>
                                    <article class="card my-3  border-0">
                                        <div class="card-body py-5">
                                            <h2 class="mb-0 text-center"><%= listaVentaMensualActual[1] %></h2>
                                            <span class="d-block mb-0  mt-2 text-center">Venta Mensual Actual - <%= listaVentaMensualActual[0] %></span>
                                        </div>
                                    </article>
                                <% } %>

                            </div>
                                
                            <div class="col-md-3">
                                <% for(int i=1;i<dashPre.getListaVentaMayor().size();i++){ %>
                                <% Object[] listaVentaMayor = (Object[])dashPre.getListaVentaMayor().get(i); %>
                                    <article class="card  my-3  border-0">
                                        <div class="card-body py-5">
                                            <h2 class="mb-0 text-center"><%= listaVentaMayor[1] %></h2>
                                            <span class="d-block mb-0  mt-2 text-center">Máxima Venta - <%= listaVentaMayor[0] %></span>
                                        </div>
                                    </article>
                                <% } %>
                            </div>
                                
                            <div class="col-md-3">
                                <% for(int i=1;i<dashPre.getListaVentaMenor().size();i++){ %>
                                <% Object[] listaVentaMenor = (Object[])dashPre.getListaVentaMenor().get(i); %>
                                    <article class="card my-3 border-0">
                                        <div class="card-body py-5">
                                            <h2 class="mb-0 text-center"><%= listaVentaMenor[1] %></h2>
                                            <span class="d-block mb-0  mt-2 text-center">Mínima Venta - <%= listaVentaMenor[0] %></span>
                                        </div>
                                    </article>
                                <% } %>
                            </div>
                                    
                        </div>
                        <div class="row px-2 px-md-3">
                            <div class="col-md-12">
                                <div class="row">
                                    <div class="col-md-6">
                                        <article class="card border-0 mb-3 mt-3">
                                            <div class="card-body">
                                                
                                                <center>
                                                    <div id="canvas-container" style="width:100%">
                                                        <canvas id="chartPorAnio" width="400" height="280"></canvas>
                                                    </div>
                                                </center>
                                                
                                            </div>
                                        </article>
                                    </div>
                                    <div class="col-md-6">
                                        <article class="card border-0 mb-3 mt-3">
                                            <div class="card-body">
                                                
                                                <center>
                                                    <div id="canvas-container" style="width:100%">
                                                        <canvas id="chartUltimoTrimestre" width="400" height="280"></canvas>
                                                    </div>
                                                </center>
                                                
                                            </div>
                                        </article>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>

                </main>

            </section>
            <!-- END SIDEBAR -->

        </main>
        
        
        <%
            
            for(int i=1;i<dashPre.getListaVentaPorAnio().size();i++){ 
                Object[] listaVentaPorAnio = (Object[])dashPre.getListaVentaPorAnio().get(i); 
                ventaAnioNombre.add(listaVentaPorAnio[1].toString());
                ventaAnioValor.add(Double.parseDouble(listaVentaPorAnio[2].toString())); 
            }
            
            for(int i=1;i<dashPre.getListaVentaUltimoTrimestre().size();i++){ 
                Object[] listaVentaUltimoTrimestre = (Object[])dashPre.getListaVentaUltimoTrimestre().get(i); 
                ventaTrimestreNombre.add(listaVentaUltimoTrimestre[1].toString());
                ventaTrimestreValor.add(Double.parseDouble(listaVentaUltimoTrimestre[2].toString())); 
            }

        %>
                                    
        <script type="text/javascript" src="./assets/js/admin.js">
        </script>
        
        <script type="text/javascript">
                 
            $(document).ready(function(){
                    
                // POR AÑIO
                
                const datosAnio = {
                    labels: ['<%= ventaAnioNombre.get(0) %>','<%= ventaAnioNombre.get(1) %>','<%= ventaAnioNombre.get(2) %>',
                             '<%= ventaAnioNombre.get(3) %>','<%= ventaAnioNombre.get(4) %>','<%= ventaAnioNombre.get(5) %>',
                             '<%= ventaAnioNombre.get(6) %>','<%= ventaAnioNombre.get(7) %>','<%= ventaAnioNombre.get(8) %>',
                             '<%= ventaAnioNombre.get(9) %>','<%= ventaAnioNombre.get(10) %>','<%= ventaAnioNombre.get(11) %>'
                    ],
                    datasets: [{
                      label: 'Venta Anual - 2021',
                      data: <%= ventaAnioValor %>,
                      backgroundColor: [
                        'rgb(190,217,253)',
                        'rgb(255,212,106)',
                        'rgb(127, 203, 143)',
                        'rgb(190,217,253)',
                        'rgb(255,212,106)',
                        'rgb(127, 203, 143)',
                        'rgb(190,217,253)',
                        'rgb(255,212,106)',
                        'rgb(127, 203, 143)',
                        'rgb(190,217,253)',
                        'rgb(255,212,106)',
                        'rgb(127, 203, 143)',
                      ],
                      hoverOffset: 4
                    }]
                  };
                
                var canvas = document.getElementById('chartPorAnio').getContext('2d');
                window.bar = new Chart(canvas,{
                    type: "bar",
                    data: datosAnio,
                    options: {
                      scales: {
                        y: {
                          beginAtZero: true
                        }
                      }
                    }
                });
                
                // TRIMESTRE
                const datosTrimestre = {
                    labels: ['<%= ventaTrimestreNombre.get(0) %>','<%= ventaTrimestreNombre.get(1) %>','<%= ventaTrimestreNombre.get(2) %>'],
                    datasets: [{
                      label: 'Venta Trimestral',
                      data: <%= ventaTrimestreValor %>,
                      backgroundColor: [
                        'rgb(190,217,253)',
                        'rgb(255,212,106)',
                        'rgb(127, 203, 143)',
                      ],
                      hoverOffset: 4
                    }]
                  };
                
                var canvas = document.getElementById('chartUltimoTrimestre').getContext('2d');
                window.bar = new Chart(canvas,{
                    type: "pie",
                    data: datosTrimestre,
                });
                
            });
        </script>
    </body>
</html>
