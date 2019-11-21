package cl.nma.controllers;

import cl.nma.dao.ActividadDAOImpl;
import cl.nma.dao.VisitaDAOImpl;
import cl.nma.dominio.Visita;
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

@WebServlet(name = "finalizarVisitaProfesionalServlets", urlPatterns = {"/finalizarVisita"})
public class finalizarVisitaProfesionalServlets extends HttpServlet {

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
            out.println("<title>Servlet finalizarVisitaProfesionalServlets</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet finalizarVisitaProfesionalServlets at " + request.getContextPath() + "</h1>");
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

        int idActividad = Integer.parseInt(request.getParameter("idAct"));
        int idVisita = Integer.parseInt(request.getParameter("idVis"));

        //SECCION DOCUMENTOS
        String  chContratos = request.getParameter("checkContratos");
        if (chContratos == null) {
            chContratos="0";
        }
        String chDocumentos = request.getParameter("checkDocumentos");
        if (chDocumentos == null) {
            chDocumentos="0";
        }
        String chFiniquitos = request.getParameter("checkFiniquitos");
        if (chFiniquitos == null) {
            chFiniquitos="0";
        }
        String areaComentariosDocumentos = request.getParameter("textareaComentariosDocumentos");
        
        //SECCION INSTALACIONES
        String chInstalaciones = request.getParameter("checkInstalaciones");
        if (chInstalaciones == null) {
            chInstalaciones="0";
        }
        String chBanios = request.getParameter("checkBanios");
        if (chBanios == null) {
            chBanios="0";
        }
        String chComedores = request.getParameter("checkComedores");
        if (chComedores == null) {
            chComedores="0";
        }
        String areaComentariosInstalacion = request.getParameter("textareaComentariosInstalacion");
        
        //SECCION SEGURIDAD
        String checkZonas = request.getParameter("checkZonas");
        if (checkZonas == null) {
            checkZonas="0";
        }
        String checkPeligros = request.getParameter("checkPeligros");
        if (checkPeligros == null) {
            checkPeligros="0";
        }
        String textareaComentariosSeguridad = request.getParameter("textareaComentariosSeguridad");
        String textareaSolucionPropuesta = request.getParameter("textareaSolucionPropuesta");
        
        try {
            VisitaDAOImpl visDAO = new VisitaDAOImpl();
            Visita vis = new Visita();
            vis.setId_visita(idVisita);
            //SECCION DOCUMENTACION
            vis.setContratos(Integer.parseInt(chContratos));
            vis.setDocumentacion(Integer.parseInt(chDocumentos));
            vis.setFiniquitos(Integer.parseInt(chFiniquitos));
            vis.setComentarios_documentacion(areaComentariosDocumentos);
            //SECCION INSTALACIONES
            vis.setInstalacion(Integer.parseInt(chInstalaciones));
            vis.setBanios(Integer.parseInt(chBanios));
            vis.setComedores(Integer.parseInt(chComedores));
            vis.setComentarios_faena(areaComentariosInstalacion);
            //SECCION SEGURIDAD
            vis.setSeguridad(Integer.parseInt(checkZonas));
            vis.setPeligros(Integer.parseInt(checkPeligros));
            vis.setComentarios_seguridad(textareaComentariosSeguridad);
            vis.setComentarios_propuesta(textareaSolucionPropuesta);
            
            visDAO.actualizar(vis);
            
            ActividadDAOImpl actDAO = new ActividadDAOImpl();
            actDAO.finalizarActividad(idActividad);
            
            request.getRequestDispatcher("/home.jsp").forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(finalizarVisitaProfesionalServlets.class.getName()).log(Level.SEVERE, null, ex);
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
