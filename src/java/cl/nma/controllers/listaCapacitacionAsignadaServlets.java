/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.controllers;

import cl.nma.dao.ActividadDAOImpl;
import cl.nma.dominio.ActividadCapacitacionGettAll;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Richard Foncea
 */
@WebServlet(name = "listaCapacitacionAsignadaServlets", urlPatterns = {"/listaCapacitacionAsignada"})
public class listaCapacitacionAsignadaServlets extends HttpServlet {

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
            out.println("<title>Servlet listaCapacitacionAsignadaServlets</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet listaCapacitacionAsignadaServlets at " + request.getContextPath() + "</h1>");
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
        
        HttpSession sesion = (HttpSession) request.getSession();
        System.out.println(sesion.getAttribute("nombre"));
        String idUsuario = String.valueOf(sesion.getAttribute("id_usuario")) ;
        System.out.println(idUsuario);
        int idUsu = Integer.parseInt(idUsuario);
        
        List<ActividadCapacitacionGettAll> lista = new ArrayList();
        try {
            ActividadDAOImpl acDAO = new ActividadDAOImpl();
            lista = acDAO.listarCapacitacionGetAll(idUsu);

        } catch (SQLException ex) {
            Logger.getLogger(listaEmpresaListServlets.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("listaGetAllCapacitacion", lista);
        request.getRequestDispatcher("listaCapacitacionAsignada.jsp").forward(request, response);
        
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
        
         HttpSession sesion = (HttpSession) request.getSession();
        System.out.println(sesion.getAttribute("nombre"));
        String idUsuario = String.valueOf(sesion.getAttribute("id_usuario")) ;
        System.out.println(idUsuario);
        int idUsu = Integer.parseInt(idUsuario);
        
        List<ActividadCapacitacionGettAll> lista = new ArrayList();
        try {
            ActividadDAOImpl acDAO = new ActividadDAOImpl();
            lista = acDAO.listarCapacitacionGetAll(idUsu);

        } catch (SQLException ex) {
            Logger.getLogger(listaEmpresaListServlets.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("listaGetAllCapacitacion", lista);
        request.getRequestDispatcher("listaCapacitacionAsignada.jsp").forward(request, response);
        
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
