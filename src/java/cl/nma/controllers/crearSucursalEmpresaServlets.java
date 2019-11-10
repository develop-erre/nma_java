/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.controllers;

import cl.nma.dao.DireccionDAOImpl;
import cl.nma.dao.SucursalDAOImpl;
import cl.nma.dominio.Direccion;
import cl.nma.dominio.Sucursal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Richard Foncea
 */
@WebServlet(name = "crearSucursalEmpresaServlets", urlPatterns = {"/crearSucursal"})
public class crearSucursalEmpresaServlets extends HttpServlet {

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
            out.println("<title>Servlet crearSucursalEmpresaServlets</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet crearSucursalEmpresaServlets at " + request.getContextPath() + "</h1>");
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
        
        String nombre_calle = request.getParameter("txtDireccion");
        String numero = request.getParameter("txtNumero");
        int idComuna = Integer.parseInt(request.getParameter("selectComunaId"));
        
        String nombreSucursal = request.getParameter("txtNombreSucursal");
        int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
        
        try {
            
            //SE AGREGA DIRECCION
            DireccionDAOImpl dicDAO = new DireccionDAOImpl();
            Direccion dir = new Direccion();
            dir.setNombre_calle(nombre_calle.toUpperCase());
            dir.setNumero(numero);
            dir.setId_comuna_fk(idComuna);

            int idDireccion = dicDAO.agregar(dir);
            
            //SE AGREGA SUCURSAL 
            SucursalDAOImpl sucDAO = new SucursalDAOImpl();
            Sucursal suc = new Sucursal();
            suc.setNombre(nombreSucursal.toUpperCase());
            suc.setId_direccion_suc_fk(idDireccion);
            suc.setId_empresa_fk(idEmpresa);
            
            sucDAO.agregarSucursal(suc);
            
            request.getRequestDispatcher("listaEmpresa").forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(crearSucursalEmpresaServlets.class.getName()).log(Level.SEVERE, null, ex);
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
