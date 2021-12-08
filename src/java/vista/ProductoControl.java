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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Producto;
import servicio.ProductoServicio;
import servicio.ProductoServicioImp;

/**
 *
 * @author josec
 */
@WebServlet(name = "ProductoControl", urlPatterns = {"/ProductoControl"})
public class ProductoControl extends HttpServlet {

    private ProductoServicio proSer;
    private ProductoPresentador proPre;

    public ProductoControl(){
        this.proSer = new ProductoServicioImp();
        this.proPre = new ProductoPresentador();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String IdProducto = request.getParameter("IdProducto");
        String acc = request.getParameter("acc");
        
        if(acc.equals("Lista")){
            this.lista(request, response);
        }
        
        if(acc.equals("AgregarProducto")){
            this.agregarProducto(request,response);
        }
        
        if(acc.equals("GrabarProducto")){
            if(IdProducto.equals("")){
                this.grabarProducto(request,response);
            }else{
                this.actualizarProducto(request,response);
            }
        }
        
        if(acc.equals("ModificarProducto")){
            this.modificarProducto(request, response);
        }
        
        if(acc.equals("EliminarProducto")){
            this.eliminarProducto(request,response);
        }
        
    }
    
    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Object[] productoObject = {"","","","","","",""};
        proPre.setProducto(productoObject);
        
        proPre.setMsg("");
        proPre.setListaProducto(proSer.lista());
        request.getSession().setAttribute("proPre", proPre);
        response.sendRedirect("IUProducto.jsp");
        
    }
    
    private void agregarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        proPre.setTipoAccion("Crear");
        
        Object[] proObject = {"","","","","","",""};
        proPre.setProducto(proObject);
                
        request.getSession().setAttribute("proPre", proPre);
        response.sendRedirect("IUProductoNuevo.jsp");
        
    }
    
    private void grabarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        try{
            
            String producto = request.getParameter("producto");
            double precio = Double.parseDouble(request.getParameter("precio"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            
            SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/dd");
            String fechaRegistro = format.format(new Date());
            
            Producto prod = new Producto(producto,precio,cantidad,0,fechaRegistro);
            String msgGrabar = proSer.grabar(prod);
            proPre.setMsg(msgGrabar);

            proPre.setListaProducto(proSer.lista());

            request.getSession().setAttribute("proPre", proPre);
            response.sendRedirect("IUProducto.jsp");
                    
        }catch(Exception ex){
            proPre.setMsg(ex.getMessage());
        }
        
    }
    
    private void actualizarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        try{
           
            int idProducto = Integer.parseInt(request.getParameter("IdProducto"));
            String producto = request.getParameter("producto");
            double precio = Double.parseDouble(request.getParameter("precio"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            
            SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/dd");
            String fechaActualizacion = format.format(new Date());
            
            Producto prod = new Producto(idProducto,producto,precio,cantidad,0,fechaActualizacion);
            String msgActualizacion = proSer.actualizar(prod);
            proPre.setMsg(msgActualizacion);

            proPre.setListaProducto(proSer.lista());

            request.getSession().setAttribute("proPre", proPre);
            response.sendRedirect("IUProducto.jsp");
            
        }catch(Exception ex){
            proPre.setMsg(ex.getMessage());
        }
    
    }
    
    private void modificarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        try{
            
            int IdProducto = Integer.parseInt(request.getParameter("IdProducto"));
            String Producto = request.getParameter("Producto");
            Double PrecioUnitario = Double.parseDouble(request.getParameter("PrecioUnitario"));
            int CantidadInicial = Integer.parseInt(request.getParameter("CantidadInicial"));
            int CantidadFinal = Integer.parseInt(request.getParameter("CantidadFinal"));
            String FechaRegistro = request.getParameter("FechaRegistro");
            String FechaActualizacion = request.getParameter("FechaActualizacion");
            
            Object[] producto = {IdProducto,Producto,PrecioUnitario,CantidadInicial,CantidadFinal,FechaRegistro,FechaActualizacion};
            
            proPre.setProducto(producto);
            proPre.setTipoAccion("Actualización");
            
            proPre.setListaProducto(proSer.lista());
        
            request.getSession().setAttribute("proPre", proPre);
            response.sendRedirect("IUProductoNuevo.jsp");
            
        }catch(Exception ex){
            proPre.setMsg(ex.getMessage());
        }
        
        
    }
    
    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        try{
            
            int IdProducto = Integer.parseInt(request.getParameter("IdProducto"));

            String msgEliminar = proSer.eliminar(IdProducto);
            proPre.setMsg(msgEliminar);
            
            proPre.setListaProducto(proSer.lista());

            request.getSession().setAttribute("proPre", proPre);
            response.sendRedirect("IUProducto.jsp");
            
        }catch(Exception ex){
            proPre.setMsg(ex.getMessage());
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
