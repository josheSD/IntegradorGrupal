/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Detalle;
import negocio.Producto;
import negocio.Venta;
import servicio.DetalleServicio;
import servicio.DetalleServicioImp;
import servicio.PedidoServicio;
import servicio.PedidoServicioImp;
import servicio.ProductoServicio;
import servicio.ProductoServicioImp;
import servicio.VentaServicio;
import servicio.VentaServicioImp;

/**
 *
 * @author josec
 */
@WebServlet(name = "VentaControl", urlPatterns = {"/VentaControl"})
public class VentaControl extends HttpServlet {
    
    private VentaServicio ventSer;
    private VentaPresentador ventPre;
    
    private ProductoServicio prodSer;
    private ProductoPresentador prodPre;
    
    private PedidoServicio pediSer;
    private PedidoPresentador pediPre;
    
    private DetalleServicio detaSer;

    public VentaControl(){
        this.ventSer = new VentaServicioImp();
        this.ventPre = new VentaPresentador();
        
        this.prodSer = new ProductoServicioImp();
        this.prodPre = new ProductoPresentador();
        
        this.pediSer = new PedidoServicioImp();
        this.pediPre = new PedidoPresentador();
        
        this.detaSer = new DetalleServicioImp();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String IdVenta = request.getParameter("idVenta");
        String acc = request.getParameter("acc");
        
        // VENTA
        if(acc.equals("Lista")){
            this.lista(request, response);
        }
        
        if(acc.equals("AgregarVenta")){
            this.agregarVenta(request,response);
        }
        
        if(acc.equals("ModificarVenta")){
            this.modificarVenta(request,response);
        }
        
        // CRUD VENTA
        if(acc.equals("GrabarVenta")){
            if(IdVenta == null || IdVenta.isEmpty()){
                this.grabarVenta(request, response);
            }else{
                this.actualizarVenta(request, response);
            }
        }
        
        if(acc.equals("EliminarVenta")){
            this.eliminarVenta(request,response);
        }
        
        // PRODUCTO
        if(acc.equals("AgregarProducto")){
            this.agregarProducto(request,response);
        }
        
        if(acc.equals("EliminarProducto")){
            this.eliminarProducto(request,response);
        }
        
        if(acc.equals("ModificarProducto")){
            this.modificarProducto(request,response);
        }
        
        if(acc.equals("ActualizarProducto")){
            this.actualizarProducto(request, response);
        }
        
    }
    
    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ventPre.setMsg("");
        Object[] ventaPedido = {"","","","","","","","","",""};
        ventPre.setVenta(ventaPedido);
            
        ventPre.setListaVenta(ventSer.lista());
        request.getSession().setAttribute("ventPre", ventPre);
        
        response.sendRedirect("IUVenta.jsp");
        
    }
    
    private void agregarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            Object[] venta = {"","","","","","","","","",""};
            ventPre.setVenta(venta);
            
            ventPre.setMsg("");
            ventPre.setTipoAccion("Crear");
            prodPre.setListaProducto(prodSer.lista());        
            pediPre.setListaPedido(pediSer.vaciarCesta());

            request.getSession().setAttribute("prodPre", prodPre);
            request.getSession().setAttribute("ventPre", ventPre);
            request.getSession().setAttribute("pediPre", pediPre);
            response.sendRedirect("IUVentaNuevo.jsp");
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }
    
    
    private void modificarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            
            // Tabla información
            String IdVenta = request.getParameter("IdVenta");
            String Serie = request.getParameter("Serie");
            String Estado = request.getParameter("Estado");
            String Senior = request.getParameter("Senior");
            String Dni = request.getParameter("Dni");
            String Direccion = request.getParameter("Direccion");
            String Telefono = request.getParameter("Telefono");
            String Total = request.getParameter("Total");
            String FechaRegistro = request.getParameter("FechaRegistro");
            String FechaActualizacion = request.getParameter("FechaActualizacion");
            String IdUsuario = request.getParameter("IdUsuario");
            
            Object[] ventaActualizar = {"","","","","","","","","","",""};
                     ventaActualizar[0] = IdVenta;
                     ventaActualizar[1] = Serie;
                     ventaActualizar[2] = Estado;
                     ventaActualizar[3] = Senior;
                     ventaActualizar[4] = Dni;
                     ventaActualizar[5] = Direccion;
                     ventaActualizar[6] = Telefono;
                     ventaActualizar[7] = Total;
                     ventaActualizar[8] = FechaRegistro;
                     ventaActualizar[9] = FechaActualizacion;
                     ventaActualizar[10] = IdUsuario;
            ventPre.setMsg("");
            ventPre.setTipoAccion("Actualizar");
            ventPre.setVenta(ventaActualizar);
            
            prodPre.setListaProducto(prodSer.lista());        
            pediPre.setListaPedido(pediSer.vaciarCesta());

            List detalleDB = detaSer.buscar(Integer.parseInt(IdVenta));

            for(int i=1;i<detalleDB.size();i++){
                Object[] detalle = (Object[])detalleDB.get(i);
                int CantidadForm = Integer.parseInt(detalle[7].toString());
                Producto productoDB = new Producto();
                         productoDB.setIdProducto(Integer.parseInt(detalle[0].toString()));
                         productoDB.setNombre(detalle[1].toString());
                         productoDB.setPrecioUnitario(Double.parseDouble(detalle[2].toString()));
                         productoDB.setCantidadInicial(Integer.parseInt(detalle[3].toString()));
                pediPre.setListaPedido(pediSer.agregarProducto(productoDB,CantidadForm));
            }

            request.getSession().setAttribute("prodPre", prodPre);
            request.getSession().setAttribute("ventPre", ventPre);
            request.getSession().setAttribute("pediPre", pediPre);
            response.sendRedirect("IUVentaNuevo.jsp");
            
        }catch(Exception err){
            System.out.println(err);
        }
        
    }
    
    private void agregarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            
            int IdProductoForm = Integer.parseInt(request.getParameter("IdProductoForm"));
            int CantidadForm = Integer.parseInt(request.getParameter("CantidadForm"));
                Producto productoDB = prodSer.buscar(IdProductoForm);
                pediPre.setListaPedido(pediSer.agregarProducto(productoDB, CantidadForm));
            
            //Venta
            String idVenta = request.getParameter("idVenta");
            String seniorForm = request.getParameter("seniorForm");
            int documentoIdentidadForm = Integer.parseInt(request.getParameter("documentoIdentidadForm"));
            String direccionForm = request.getParameter("direccionForm");
            String fechaEmisionForm = request.getParameter("fechaEmisionForm");
            
            // Usuario
            int idUsuarioForm = Integer.parseInt(request.getParameter("idUsuarioForm"));
            
            Object[] ventaForm =  {"","","","","","","","","","",""};
                     ventaForm[0] = idVenta;
                     ventaForm[1] = "0001";
                     ventaForm[2] = 1;
                     ventaForm[3] = seniorForm;
                     ventaForm[4] = documentoIdentidadForm;
                     ventaForm[5] = direccionForm;
                     ventaForm[6] = "986548754";
                     ventaForm[7] = 0.00;
                     ventaForm[8] = fechaEmisionForm;
                     ventaForm[9] = "";
                     ventaForm[10] = idUsuarioForm;
                        
            ventPre.setVenta(ventaForm);
                    
            request.getSession().setAttribute("pediPre", pediPre);
            response.sendRedirect("IUVentaNuevo.jsp");
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }
    
    private void actualizarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            Object[] productoPedidoSelected = pediPre.getProductoPedido();
            // Producto
            int IdProducto = Integer.parseInt(productoPedidoSelected[0].toString());
            String Nombre = productoPedidoSelected[1].toString();
            double PrecioUnitario = Double.parseDouble(productoPedidoSelected[2].toString());
            int Cantidad = Integer.parseInt(productoPedidoSelected[3].toString());
            
            // Informacion adicional
            int Cant = Integer.parseInt(productoPedidoSelected[4].toString());
            double Importe = Double.parseDouble(productoPedidoSelected[5].toString());
            double Total = Double.parseDouble(productoPedidoSelected[6].toString());
            int Indice = Integer.parseInt(productoPedidoSelected[7].toString());
            
            // Formulario
            int CantidadForm = Integer.parseInt(request.getParameter("CantidadForm"));
            int IdProductoForm = Integer.parseInt(request.getParameter("IdProductoForm"));
            Producto productoDB = prodSer.buscar(IdProductoForm);
            
                     
            pediPre.setListaPedido(pediSer.actualizarProducto(productoDB, CantidadForm, Indice));
            
            
            Object[] productoPed = {"","","","","","","",""};
            pediPre.setProductoPedido(productoPed);
            
            request.getSession().setAttribute("pediPre", pediPre);
            response.sendRedirect("IUVentaNuevo.jsp");
        }catch(Exception err){
            System.out.println(err);
        }
        
    }
    
    private void grabarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        try{
            // Venta
            String seniorForm = request.getParameter("seniorForm");
            String documentoIdentidadForm = request.getParameter("documentoIdentidadForm");
            String direccionForm = request.getParameter("direccionForm");
            String fechaEmisionForm = request.getParameter("fechaEmisionForm");
            
            // Usuario
            int idUsuarioForm = Integer.parseInt(request.getParameter("idUsuarioForm"));
            
            Double boletaVentaTotal = 0.0;
            for(int i=0;i<pediPre.getListaPedido().size();i++){
                Object[] productoPedido = (Object[])pediPre.getListaPedido().get(i);
                boletaVentaTotal += Double.parseDouble(productoPedido[5].toString());
            }
            
            Venta ventaForm = new Venta();
                ventaForm.setSerie("0001");
                ventaForm.setTelefono("986548754");
                ventaForm.setSenior(seniorForm);
                ventaForm.setDni(documentoIdentidadForm);
                ventaForm.setDireccion(direccionForm);
                ventaForm.setFechaRegistro(fechaEmisionForm);

                ventaForm.setEstado(1);
                ventaForm.setTotal(boletaVentaTotal);
                ventaForm.setIdUsuario(idUsuarioForm);
            
            Object[] ventaDB = ventSer.grabar(ventaForm);
                        
            ventPre.setListaVenta(ventSer.lista());
            
            for(int i=0;i<pediPre.getListaPedido().size();i++){
                Object[] productoPedido = (Object[])pediPre.getListaPedido().get(i);
                Detalle detalle = new Detalle();
                                    detalle.setImporte(Double.parseDouble(productoPedido[5].toString()));
                                    detalle.setCantidad(Integer.parseInt(productoPedido[4].toString()));
                                    detalle.setFechaRegistro(fechaEmisionForm);
                                    detalle.setIdVenta(Integer.parseInt(ventaDB[0].toString()));
                                    detalle.setIdProducto(Integer.parseInt(productoPedido[0].toString()));
                detaSer.grabar(detalle);
            }
            
            ventPre.setMsg("Venta grabado con éxito");
            
            request.getSession().setAttribute("ventPre", ventPre);
            response.sendRedirect("IUVenta.jsp");
        }catch(Exception err){
            System.out.println(err);
        }

        
    }
    
    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            int IdProducto = Integer.parseInt(request.getParameter("IdProducto"));
            pediPre.setListaPedido(pediSer.quitarProducto(IdProducto));
            
            request.getSession().setAttribute("pediPre", pediPre);
            response.sendRedirect("IUVentaNuevo.jsp");
        }catch(Exception err){
            System.out.println(err);
        }
        
    }
    
    
    private void modificarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            // Producto
            int IdProducto = Integer.parseInt(request.getParameter("IdProducto"));
            String Nombre = request.getParameter("Nombre");
            double PrecioUnitario = Double.parseDouble(request.getParameter("PrecioUnitario"));
            int Cantidad = Integer.parseInt(request.getParameter("Cantidad"));
            // Informacion adicional
            int Cant = Integer.parseInt(request.getParameter("Cant"));
            double Importe = Double.parseDouble(request.getParameter("Importe"));
            double Total = Double.parseDouble(request.getParameter("Total"));
            int Indice = Integer.parseInt(request.getParameter("Indice"));
            
            Object[] productoPedido = {"","","","","","","",""};
                     productoPedido[0] = IdProducto;
                     productoPedido[1] = Nombre;
                     productoPedido[2] = PrecioUnitario;
                     productoPedido[3] = Cantidad;
                     productoPedido[4] = Cant;
                     productoPedido[5] = Importe;
                     productoPedido[6] = Total;
                     productoPedido[7] = Indice;
                     
            pediPre.setProductoPedido(productoPedido);
            
            request.getSession().setAttribute("pediPre", pediPre);
            response.sendRedirect("IUVentaNuevo.jsp");
        }catch(Exception err){
            System.out.println(err);
        }
        
    }
    
    
    private void actualizarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            
            int IdVenta = Integer.parseInt(request.getParameter("idVenta"));
                detaSer.eliminar(IdVenta);
            
            // Boleta de Venta
            String seniorForm = request.getParameter("seniorForm");
            String documentoIdentidadForm = request.getParameter("documentoIdentidadForm");
            String direccionForm = request.getParameter("direccionForm");
            
            SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/dd");
            String fechaActualizacion = format.format(new Date());
            
            // Usuario
            int idUsuarioForm = Integer.parseInt(request.getParameter("idUsuarioForm"));
            
            Double boletaVentaTotal = 0.0;
            for(int i=0;i<pediPre.getListaPedido().size();i++){
                Object[] productoPedido = (Object[])pediPre.getListaPedido().get(i);
                boletaVentaTotal += Double.parseDouble(productoPedido[5].toString());
            }
            
            Venta vent = new Venta();
                vent.setSenior(seniorForm);
                vent.setDni(documentoIdentidadForm);
                vent.setDireccion(direccionForm);
                vent.setFechaActualizacion(fechaActualizacion);
                vent.setSerie("0001");
                vent.setTelefono("986548754");
                vent.setEstado(1);
                vent.setTotal(boletaVentaTotal);
                vent.setIdUsuario(idUsuarioForm);
                               
            String mensajeRespuesta = ventSer.actualizar(vent, IdVenta);
            ventPre.setMsg(mensajeRespuesta);
            ventPre.setListaVenta(ventSer.lista());
            
            for(int i=0;i<pediPre.getListaPedido().size();i++){
                Object[] productoPedido = (Object[])pediPre.getListaPedido().get(i);
                Detalle detalle = new Detalle();
                        detalle.setImporte(Double.parseDouble(productoPedido[5].toString()));
                        detalle.setCantidad(Integer.parseInt(productoPedido[4].toString()));
                        detalle.setIdVenta(IdVenta);
                        detalle.setFechaRegistro(fechaActualizacion);
                        detalle.setIdProducto(Integer.parseInt(productoPedido[0].toString()));
                detaSer.grabar(detalle);
            }
        
            ventPre.setListaVenta(ventSer.lista());
            
            request.getSession().setAttribute("ventPre", ventPre);
            response.sendRedirect("IUVenta.jsp");
            
        }catch(Exception err){
            System.out.println(err);
        }
        
    }
    
    
    private void eliminarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            
            int IdVenta = Integer.parseInt(request.getParameter("IdVenta"));
            
            String respuestaBoletaVenta = detaSer.eliminar(IdVenta);
            ventSer.eliminar(IdVenta);
            ventPre.setMsg(respuestaBoletaVenta);
            ventPre.setListaVenta(ventSer.lista());
            
            request.getSession().setAttribute("ventPre", ventPre);
            response.sendRedirect("IUVenta.jsp");
        }catch(Exception err){
            System.out.println(err);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
