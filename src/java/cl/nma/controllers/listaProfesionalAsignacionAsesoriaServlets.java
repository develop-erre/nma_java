/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.controllers;

import cl.nma.dao.UsuarioDAOImpl;
import cl.nma.dominio.Usuario;
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
 * @author Richard Foncea
 */
@WebServlet(name = "listaProfesionalAsignacionAsesoriaServlets", urlPatterns = {"/listaProfesionalAsignacion"})
public class listaProfesionalAsignacionAsesoriaServlets extends HttpServlet {

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
            out.println("<title>Servlet listaProfesionalAsignacionAsesoriaServlets</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet listaProfesionalAsignacionAsesoriaServlets at " + request.getContextPath() + "</h1>");
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

        String idActividad = request.getParameter("txtIdActividad");
        String idAsesoria = request.getParameter("txtIdAsesoria");
        String tipoAsesoria = request.getParameter("txtTipoAsesoria");
        

        List<Usuario> lista = new ArrayList();
        try {
            UsuarioDAOImpl profDAO = new UsuarioDAOImpl();
            lista = profDAO.listarProfesionalHabilitado();
            
            request.setAttribute("idAct", idActividad);
            request.setAttribute("idAse", idAsesoria);
            request.setAttribute("tipoAs", tipoAsesoria);

            request.setAttribute("listaProfesionalAsesoria", lista);
            request.getRequestDispatcher("asignarAsesoria.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(listaProfesionalAsignacionAsesoriaServlets.class.getName()).log(Level.SEVERE, null, ex);
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
