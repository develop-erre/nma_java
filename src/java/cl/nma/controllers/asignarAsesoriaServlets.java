/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.controllers;

import cl.nma.dao.ActividadDAOImpl;
import cl.nma.dao.AsesoriaDAOImpl;
import cl.nma.dao.CapacitacionDAOImpl;
import cl.nma.dominio.Actividad;
import cl.nma.dominio.Capacitacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "asignarAsesoriaServlets", urlPatterns = {"/asignarAsesoria"})
public class asignarAsesoriaServlets extends HttpServlet {

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
            out.println("<title>Servlet asignarAsesoriaServlets</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet asignarAsesoriaServlets at " + request.getContextPath() + "</h1>");
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
        
        String fecha = request.getParameter("txtFechaAs");
        String hora = request.getParameter("selectHora");
        int idProfesionaCap = Integer.parseInt(request.getParameter("selectProfesionalId"));
        int idActividad = Integer.parseInt(request.getParameter("txtIdActividad"));
        int idAsesoria = Integer.parseInt(request.getParameter("txtIdAsesoria"));
        
        try {
            //SE CREA ACTIVIDAD CREAR CAPACITACION
            ActividadDAOImpl actDAO = new ActividadDAOImpl();
            Actividad act = new Actividad();
            //SE SETEA VALOR DE JSP
            act.setFecha_act(castDate(fecha));
            act.setHora_act(hora);
            act.setId_usuario_fk(idProfesionaCap);
            act.setId_actividad(idActividad);
            
            actDAO.asignarAsesoria(act);
            
            //MODIFICAR ESTADO DE LA ASESORIA A ASIGNADO        
            AsesoriaDAOImpl asDAO = new AsesoriaDAOImpl();
            asDAO.EstadoAsesoriaAsignado(idAsesoria);
            
            request.getRequestDispatcher("listaSolicitudAsesorias").forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(reportarAccidenteServlets.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(asignarAsesoriaServlets.class.getName()).log(Level.SEVERE, null, ex);
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

    public Date castDate(String date) throws ParseException {
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        Date fech = (Date) simpleDateFormat.parse(date);
        
        return fech;
    }
}
