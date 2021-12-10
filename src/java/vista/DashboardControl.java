/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.DashboardServicio;
import servicio.DashboardServicioImp;

/**
 *
 * @author josec
 */
@WebServlet(name = "DashboardControl", urlPatterns = {"/DashboardControl"})
public class DashboardControl extends HttpServlet {

    private DashboardServicio dashSer;
    private DashboardPresentador dashPre;
    
    public DashboardControl(){
        this.dashSer = new DashboardServicioImp();
        this.dashPre = new DashboardPresentador();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acc = request.getParameter("acc");
        
        if(acc.equals("Lista")){
            this.lista(request, response);
        }
        
    }
    
    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        dashPre.setListaVentaMayor(dashSer.ventaMayor());
        dashPre.setListaVentaMenor(dashSer.ventaMenor());
        dashPre.setListaVentaAnual(dashSer.ventaAnual());
        dashPre.setListaVentaMensualActual(dashSer.ventaMensualActual());
        dashPre.setListaVentaPorAnio(dashSer.ventaPorAnio());
        dashPre.setListaVentaUltimoTrimestre(dashSer.ventaUltimoTrimestre());

        request.getSession().setAttribute("dashPre", dashPre);
        response.sendRedirect("IUAdmin.jsp");
        
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
