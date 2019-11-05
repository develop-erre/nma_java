/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.controllers;

import cl.nma.dao.ActividadDAOImpl;
import cl.nma.dao.AsesoriaDAOImpl;
import cl.nma.dominio.Actividad;
import cl.nma.dominio.Asesoria;
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
@WebServlet(name = "finalizarAsesoriaServlets", urlPatterns = {"/finalizarAsesoria"})
public class finalizarAsesoriaServlets extends HttpServlet {

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
            out.println("<title>Servlet finalizarAsesoriaServlets</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet finalizarAsesoriaServlets at " + request.getContextPath() + "</h1>");
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

        int idAct = Integer.parseInt(request.getParameter("idACT"));
        int idAse = Integer.parseInt(request.getParameter("idASE"));
        String detectado =  request.getParameter("textareaProblemasDetectados");
        String propuesta =  request.getParameter("textareaSolucionPropuesta");
        
        try {
            AsesoriaDAOImpl asDAO = new AsesoriaDAOImpl();
            Asesoria as = new Asesoria();
            as.setId_asesoria(idAse);
            as.setComentarios_detectados(detectado);
            as.setComentarios_propuesta(propuesta);
            //SE ACTUALIZA DATOS EN ASESORIA FINALIZANDO EL PROCESO
            asDAO.finalizarAsesoria(as);
            
            ActividadDAOImpl actDAO = new ActividadDAOImpl();
            Actividad act = new Actividad();
            act.setId_actividad(idAct);
            //SE ACTUALIZA DATOS EN ACTIVIDAD FINALIZANDO EL ESTADO EN 1
            actDAO.finalizarActividad(act);
            
            request.getRequestDispatcher("home.jsp").forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(finalizarAsesoriaServlets.class.getName()).log(Level.SEVERE, null, ex);
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
