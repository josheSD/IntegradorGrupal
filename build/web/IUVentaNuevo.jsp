<%-- 
    Document   : IUAdmin
    Created on : 28/11/2021, 10:47:09 AM
    Author     : josec
--%>

<%@page import="vista.VentaPresentador"%>
<%@page import="vista.PedidoPresentador"%>
<%@page import="vista.ProductoPresentador"%>
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
            <% VentaPresentador ventPre = (VentaPresentador) session.getAttribute("ventPre"); %>
            <% ProductoPresentador prodPre = (ProductoPresentador) session.getAttribute("prodPre"); %>
            <% PedidoPresentador pediPre = (PedidoPresentador) session.getAttribute("pediPre"); %>
            <%! String totalPedido = String.valueOf(0.00); %>
            
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
                <main class="l-dashboard boleta overflow-auto venta">

                    <form method="post" action="VentaControl">
                        
                        <div class="container-fluid">
                            <div class="row mx-1">
                                <div class="col-12 mt-3">
                                    <h4>
                                       <% String tipoAccion = ventPre.getTipoAccion(); %>
                                       <%= tipoAccion %> Venta 
                                    </h4>
                                </div>

                                <div class="col-12 mt-3">

                                    <div class="card bg-yellow">
                                        <div class="card-body py-3">

                                            <div class="row">
                                                <div class="col-md-12 d-flex align-items-center justify-content-end">
                                                    <section>
                                                        <p class="d-inline-block mb-0 text-center"><b>NRO. SERIE</b></p>
                                                        <div class="card bg-white px-3 px-md-5">
                                                            <div class="card-body py-1">
                                                                <p class="mb-0 text-center"><b>00000006</b></p>
                                                            </div>
                                                        </div>
                                                    </section>
                                                </div>
                                            </div>

                                            <!-- ################     FORMULARIO BOLETA DE VENTA   ################# -->
                                            <% Object[] ventaForm = ventPre.getVenta(); %>
                                            <input type="hidden" name="idUsuarioForm" value="<%= usuario[0] %>" />
                                            <input type="hidden" name="idTipoUsuarioForm" value="<%= usuario[3] %>" />
                                            
                                            <input type="hidden" name="idVenta" value="<%= ventaForm[0] %>" />
                                            

                                            <div class="row mt-3">

                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label class="formGroupExampleInput">Señor(a)</label>
                                                        <input name="seniorForm" type="text" class="form-control" value="<%= ventaForm[3] %>">
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label class="formGroupExampleInput">Documento de identidad</label>
                                                        <input name="documentoIdentidadForm" type="text" class="form-control" value="<%= ventaForm[4] %>">
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label class="formGroupExampleInput">Dirección</label>
                                                        <input name="direccionForm" type="text" class="form-control" value="<%= ventaForm[5] %>">
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label class="formGroupExampleInput">Fecha de emisión</label>
                                                        <input name="fechaEmisionForm" type="text" class="form-control" value="<%= ventaForm[8] %>">
                                                    </div>
                                                </div>

                                            </div>

                                            <% if(!tipoAccion.equals("Ver")) { %>        
                                                <div class="row mt-3">

                                                    <div class="col-xl-8 offset-xl-2">

                                                        <div class="card bg-blue">
                                                            <% Object[] productoPed = pediPre.getProductoPedido(); %>
                                                            <div class="card-body pb-2">
                                                                <div class="row">
                                                                    <div class="col-12">
                                                                        <% if(productoPed[0].toString().isEmpty()){ %>
                                                                                <h5 class="mb-3">Ingresar Producto</h5>
                                                                        <% }else{ %>
                                                                                <h5 class="mb-3">Actualizar Producto</h5>
                                                                        <% } %>
                                                                    </div>
                                                                </div>
                                                                <div class="row pl-md-4">

                                                                    <input id="productoFormActualizar" type="hidden" class="form-control" data-idproductoform="<%= productoPed[0] %>">

                                                                    <div class="col-md-3">
                                                                        <div class="form-group">
                                                                          <label>Seleccionar Producto</label>
                                                                          <select class="form-control" id="selectProducto" name="IdProductoForm" >
                                                                            <% for(int i=1;i<prodPre.getListaProducto().size();i++){ %>
                                                                            <% Object[] producto = (Object[])prodPre.getListaProducto().get(i); %>
                                                                            <option value="<%= producto[0] %>" data-idproducto="<%= producto[0] %>" data-preciounitario="<%= producto[2] %>" data-product="<%= producto[1] %>" > <%= producto[1] %> </option>
                                                                            <% } %>
                                                                          </select>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-3">
                                                                        <div class="form-group">
                                                                            <label class="formGroupExampleInput">Precio Unitario</label>
                                                                            <input id="precio" name="precioForm" value="<%= productoPed[2] %>" type="text" disabled class="form-control">
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-3">
                                                                        <div class="form-group">
                                                                            <label class="formGroupExampleInput">Cantidad</label>
                                                                            <input id="cantidad" name="CantidadForm" value="<%= productoPed[4] %>" type="text" class="form-control">
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-2 d-flex align-items-center">
                                                                        <% if(productoPed[0].toString().isEmpty()){ %>
                                                                            <button class="btn btn-primary w-100 mt-3" name="acc" value="AgregarProducto">
                                                                                Insertar
                                                                            </button>
                                                                        <% }else{ %>
                                                                            <button class="btn btn-primary w-100 mt-3 ml-3" name="acc" value="ActualizarProducto">
                                                                                Actualizar
                                                                            </button>
                                                                        <% } %>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                    </div>

                                                </div>
                                            <% } %>      

                                            <div class="row mt-3">
                                                <div class="col-12">

                                                    <div class="table-responsive">
                                                        <table class="table table-bordered bg-white">
                                                            <thead>
                                                              <tr>
                                                                <% if(!tipoAccion.equals("Ver")) { %>
                                                                    <th scope="col">Acciones</th>
                                                                <% } %>
                                                                <th scope="col">Producto</th>
                                                                <th scope="col">Precio Unitario</th>
                                                                <th scope="col">Cantidad</th>
                                                                <th scope="col">Importe</th>
                                                              </tr>
                                                            </thead>
                                                            <tbody>
                                                                
                                                                <% for(int i=0;i<pediPre.getListaPedido().size();i++){ %>
                                                                <% Object[] productoPedido = (Object[])pediPre.getListaPedido().get(i); %>
                                                                <% totalPedido = productoPedido[6].toString(); %>
                                                                    <tr>
                                                                      <% if(!tipoAccion.equals("Ver")) { %>  
                                                                        <td>
                                                                              <form method="post" action="VentaControl">
                                                                                  <input type="hidden" name="IdProducto" value="<%= productoPedido[0] %>" />
                                                                                  <input type="hidden" name="Nombre" value="<%= productoPedido[1] %>" />
                                                                                  <input type="hidden" name="PrecioUnitario" value="<%= productoPedido[2] %>" />
                                                                                  <input type="hidden" name="Cantidad" value="<%= productoPedido[3] %>" />
                                                                                  <input type="hidden" name="Cant" value="<%= productoPedido[4] %>" />
                                                                                  <input type="hidden" name="Importe" value="<%= productoPedido[5] %>" />
                                                                                  <input type="hidden" name="Total" value="<%= productoPedido[6] %>" />
                                                                                  <input type="hidden" name="Indice" value="<%= i %>" />

                                                                                  <button class="btn btn-success" id="modificarProducto" type="submit" name="acc" value="ModificarProducto">
                                                                                      <i class="fas fa-pencil-alt fa-xs"></i>
                                                                                  </button>
                                                                                  <button class="btn btn-danger" type="submit" name="acc" value="EliminarProducto">
                                                                                      <i class="fas fa-trash fa-xs"></i>
                                                                                  </button>
                                                                              </form>
                                                                        </td>
                                                                      <% } %>
                                                                      <td><%= productoPedido[1] %></td>
                                                                      <td class="text-right">S/. <%= productoPedido[2] %></td>
                                                                      <td class="text-right"><%= productoPedido[4] %></td>
                                                                      <td class="text-right">S/. <%= productoPedido[5] %></td>
                                                                    </tr>
                                                                <% } %>
                                                                
                                                                <tr>
                                                                  <% if(!tipoAccion.equals("Ver")) { %>
                                                                    <td></td>
                                                                  <% } %>
                                                                  <td></td>
                                                                  <td></td>
                                                                  <td class="text-right"><b>Total a Pagar</b></td>
                                                                  <td class="text-right">
                                                                      S/. <%= totalPedido %>
                                                                  </td>
                                                                </tr>
                                                                
                                                            </tbody>
                                                        </table>
                                                    </div>

                                                </div>
                                            </div>

                                        </div>
                                    </div>

                                </div>
                                                                  
                                <% if(!tipoAccion.equals("Ver")) { %>
                                    <div class="col-12">  
                                        <div class="d-inline-block">
                                            <button type="submit" class="btn btn-primary mr-1 mt-4 mb-4" name="acc" value="GrabarVenta">
                                               <i class="fas fa-save d-inline-block mr-2"></i>
                                               <% String tipoAccion2 = ventPre.getTipoAccion(); %>
                                               <%= tipoAccion2 %> Venta
                                            </button>   
                                            <button type="submit" class="btn btn-danger ml-2" name="acc" value="Lista">
                                                Cancel
                                            </button>
                                        </div>
                                    </div>
                                <% } %>
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
