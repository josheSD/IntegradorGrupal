/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Usuario;
import servicio.DashboardServicio;
import servicio.DashboardServicioImp;
import servicio.TipoUsuarioServicio;
import servicio.TipoUsuarioServicioImp;
import servicio.UsuarioServicio;
import servicio.UsuarioServicioImp;

/**
 *
 * @author josec
 */
@WebServlet(name = "UsuarioControl", urlPatterns = {"/UsuarioControl"})
public class UsuarioControl extends HttpServlet {

    private UsuarioServicio usuSer;
    private UsuarioPresentador usuPre;
    private TipoUsuarioServicio tipUsuSer;

    private DashboardServicio dashSer;
    private DashboardPresentador dashPre;
    
    public UsuarioControl(){
        this.usuSer = new UsuarioServicioImp();
        this.usuPre = new UsuarioPresentador();
        
        this.tipUsuSer = new TipoUsuarioServicioImp();
        
        this.dashSer = new DashboardServicioImp();
        this.dashPre = new DashboardPresentador();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String IdUsuario = request.getParameter("IdUsuario");
        String acc = request.getParameter("acc");
        
        if(acc.equals("Lista")){
            this.lista(request, response);
        }
        
        if(acc.equals("AgregarUsuario")){
            this.agregarUsuario(request,response);
        }
        
        if(acc.equals("GrabarUsuario")){
            if(IdUsuario.equals("")){
                this.grabarUsuario(request,response);
            }else{
                this.actualizarUsuario(request,response);
            }
        }
        
        if(acc.equals("ModificarUsuario")){
            this.modificarUsuario(request,response);
        }
        
        if(acc.equals("EliminarUsuario")){
            this.eliminarUsuario(request,response);
        }
        
        if(acc.equals("Iniciar Sesion")){
            this.iniciarSesion(request, response);
        }
        
    }
    
    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        usuPre.setMsg("");
        usuPre.setListaUsuario(usuSer.lista());
        request.getSession().setAttribute("usuPre", usuPre);
        response.sendRedirect("IUUsuario.jsp");
        
    }
    
    private void agregarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        usuPre.setTipoAccion("Crear");
        
        Object[] usuObject = {"","","","","",""};
        usuPre.setUsuario(usuObject);
        
        usuPre.setListaTipoUsuario(tipUsuSer.lista());
                
        request.getSession().setAttribute("usuPre", usuPre);
        response.sendRedirect("IUUsuarioNuevo.jsp");
        
    }
    
    private void grabarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            String usuario = request.getParameter("usuario");
            String contrasenia = request.getParameter("contrasenia");
            int idTipoUsuario = Integer.parseInt(request.getParameter("idTipoUsuario"));
            
            SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/dd");
            String fechaRegistro = format.format(new Date());
            
            Usuario usu = new Usuario(usuario,contrasenia,fechaRegistro,idTipoUsuario);
            String msgGrabar = usuSer.grabar(usu);
            usuPre.setMsg(msgGrabar);

            usuPre.setListaUsuario(usuSer.lista());

            request.getSession().setAttribute("usuPre", usuPre);
            response.sendRedirect("IUUsuario.jsp");
        }catch(Exception ex){
            usuPre.setMsg(ex.getMessage());
        }
        
    }
    
    private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        try{
           
            int idUsuario = Integer.parseInt(request.getParameter("IdUsuario"));
            String usuario = request.getParameter("usuario");
            String contrasenia = request.getParameter("contrasenia");
            int idTipoUsuario = Integer.parseInt(request.getParameter("idTipoUsuario"));
            
            SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/dd");
            String fechaActualizacion = format.format(new Date());
            
            Usuario usu = new Usuario(idUsuario,usuario,contrasenia,fechaActualizacion,idTipoUsuario);
            String msgGrabar = usuSer.actualizar(usu);
            usuPre.setMsg(msgGrabar);
            
            Object[] usuarioObject = {"","","","","","",""};
            usuPre.setUsuario(usuarioObject);
            
            usuPre.setListaUsuario(usuSer.lista());
            
            request.getSession().setAttribute("usuPre", usuPre);
            response.sendRedirect("IUUsuario.jsp");
            
        }catch(Exception ex){
            usuPre.setMsg(ex.getMessage());
        }
        
    }
    
    private void modificarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        try{
            
            int IdUsuario = Integer.parseInt(request.getParameter("IdUsuario"));
            String Usuario = request.getParameter("Usuario");
            String Contrasenia = request.getParameter("Contrasenia");
            String FechaRegistro = request.getParameter("FechaRegistro");
            String FechaActualizacion = request.getParameter("FechaActualizacion");
            int IdTipoUsuario = Integer.parseInt(request.getParameter("IdTipoUsuario"));
            String TipoUsuario = request.getParameter("TipoUsuario");
            
            Object[] usuario = {IdUsuario,Usuario,Contrasenia,FechaRegistro,FechaActualizacion,IdTipoUsuario,TipoUsuario};
            
            usuPre.setUsuario(usuario);
            usuPre.setTipoAccion("Actualización");
            
            usuPre.setListaTipoUsuario(tipUsuSer.lista());
        
            request.getSession().setAttribute("usuPre", usuPre);
            response.sendRedirect("IUUsuarioNuevo.jsp");
            
        }catch(Exception ex){
            usuPre.setMsg(ex.getMessage());
        }
        
        
    }
    
    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
        try{
            
            int IdUsuario = Integer.parseInt(request.getParameter("IdUsuario"));

            String msgEliminar = usuSer.eliminar(IdUsuario);
            usuPre.setMsg(msgEliminar);
            
            usuPre.setListaUsuario(usuSer.lista());

            request.getSession().setAttribute("usuPre", usuPre);
            response.sendRedirect("IUUsuario.jsp");
            
        }catch(Exception ex){
            usuPre.setMsg(ex.getMessage());
        }
    
    }

    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usu = request.getParameter("usu");
        String pas = request.getParameter("pas");

        Object[]usuario = usuSer.iniciarSesion(usu, pas);

        if(usuario != null){
            usuPre.setMsg("");
            usuPre.setUsuario(usuario);
            usuPre.setMenu(usuSer.menu(Integer.parseInt(usuario[5].toString())));
            
            dashPre.setListaVentaMayor(dashSer.ventaMayor());
            dashPre.setListaVentaMenor(dashSer.ventaMenor());
            dashPre.setListaVentaAnual(dashSer.ventaAnual());
            dashPre.setListaVentaMensualActual(dashSer.ventaMensualActual());
            dashPre.setListaVentaPorAnio(dashSer.ventaPorAnio());
            dashPre.setListaVentaUltimoTrimestre(dashSer.ventaUltimoTrimestre());

            request.getSession().setAttribute("dashPre", dashPre);
            request.getSession().setAttribute("usuPre", usuPre);
            response.sendRedirect("IUAdmin.jsp");
        }else{
            usuPre.setMsg("Usuario no encontrado");
            request.getSession().setAttribute("usuPre", usuPre);
            response.sendRedirect("IULogin.jsp");
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
