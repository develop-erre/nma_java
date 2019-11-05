/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.controllers;

import cl.nma.dao.ActividadDAOImpl;
import cl.nma.dao.VisitaDAOImpl;
import cl.nma.dominio.Actividad;
import cl.nma.dominio.Visita;
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
@WebServlet(name = "programarVisitaServlets", urlPatterns = {"/programarvisita"})
public class programarVisitaServlets extends HttpServlet {

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
            out.println("<title>Servlet programarVisitaServlets</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet programarVisitaServlets at " + request.getContextPath() + "</h1>");
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

        String fecha = request.getParameter("txtFechaVis");
        String horaMin = request.getParameter("selectHora");
        int idProfesionaVis = Integer.parseInt(request.getParameter("selectProfesionalId"));
        int idSucIdCap = Integer.parseInt(request.getParameter("SucursalId"));
        int idTipoVisita = Integer.parseInt(request.getParameter("selectTipoVisita"));

        try {
            //SE CREA ACTIVIDAD CREAR CAPACITACION
            ActividadDAOImpl actDAO = new ActividadDAOImpl();
            Actividad act = new Actividad();
            //SE SETEA VALOR DE JSP
            act.setFecha_act(castDate(fecha));
            act.setHora_act(horaMin);
            act.setEstado_act(0);
            act.setId_usuario_fk(idProfesionaVis);
            act.setId_sucursal_empresa_fk(idSucIdCap);
            act.setId_tipo_actividad_fk(2);

            int idActividad = actDAO.agregar(act);

            //CREAR VISITA
            VisitaDAOImpl visDAO = new VisitaDAOImpl();
            Visita vis = new Visita();
            //SETEAR DATOS 
            vis.setId_tipo_visita_fk(idTipoVisita);
            vis.setId_actividad_fk_v(idActividad);
            visDAO.agregar(vis);

            request.getRequestDispatcher("/listaEmpresa").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(reportarAccidenteServlets.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(programarVisitaServlets.class.getName()).log(Level.SEVERE, null, ex);
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

        String mes = date.substring(0, 2);
        String dia = date.substring(3, 5);
        String anio = date.substring(6, 10);

        String fechaCast = anio + "-" + mes + "-" + dia;
        System.out.println(fechaCast);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date fech = (Date) simpleDateFormat.parse(fechaCast);

        return fech;
    }
}
