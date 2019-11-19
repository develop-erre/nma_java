/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.controllers;

import cl.nma.dao.EmpresaDAOImpl;
import cl.nma.dao.RegionComunaDAOImpl;
import cl.nma.dominio.EmpresaLista;
import cl.nma.dominio.RegionComuna;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 */
@WebServlet(name = "cargarRegionCrearUsuarioEmpresaServlets", urlPatterns = {"/cargarRegionCrearUsuarioEmpresa"})
public class cargarRegionCrearUsuarioEmpresaServlets extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cargarRegionCrearUsuarioEmpresaServlets</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cargarRegionCrearUsuarioEmpresaServlets at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        request.setCharacterEncoding("UTF-8");

        String idSucursal = request.getParameter("txtIdSucursal");
        String nombre_sucursal = request.getParameter("nombre_sucursal");
        List<RegionComuna> listaComuna = new ArrayList();
        try {

            RegionComunaDAOImpl rcDAO = new RegionComunaDAOImpl();
            listaComuna = rcDAO.listar();

            request.setAttribute("listaReg", listaComuna);
            request.setAttribute("idSucursal", idSucursal);
            request.setAttribute("nombre_sucursal", nombre_sucursal);
            request.getRequestDispatcher("crearusuarioempresa.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(cargarRegionCrearUsuarioEmpresaServlets.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
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
