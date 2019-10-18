/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.controllers;

import cl.nma.dao.ReporteAccidenteDAOImpl;
import cl.nma.dominio.ReporteAccidente;
import cl.nma.util.ValidarParametros;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
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
@WebServlet(name = "reportarAccidenteServlets", urlPatterns = {"/reportarAccidente"})
public class reportarAccidenteServlets extends HttpServlet {

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
            out.println("<title>Servlet reportarAccidenteServlets</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet reportarAccidenteServlets at " + request.getContextPath() + "</h1>");
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
        
        HttpSession sesion = (HttpSession) request.getSession();
        String id = String.valueOf(sesion.getAttribute("id_empresa")) ;
        int idEmpresa = Integer.parseInt(id);

        String hr = request.getParameter("txtHora");
        String min = request.getParameter("txtMinutos");
        String hora = hr + ":" + min + ":00";
        String horaMin = hr + ":" + min;
        String fecha = request.getParameter("txtFecha");

        String dateString = fecha+" " + hora;
        String comentario = request.getParameter("textareaDescripcion");
        int idSucursal = Integer.parseInt(request.getParameter("selectSucursalId"));
        int idTipoAccidente = Integer.parseInt(request.getParameter("selectTipoAccidente"));

//        HashMap<String, Object> errores = new HashMap<>();
//        if (!ValidarParametros.validarSeleccione(idSucursal)) {
//            errores.put("sucursal", "Seleccione Sucursal");
//        }
//        
//        if (!ValidarParametros.validarSeleccione(idTipoAccidente)) {
//            errores.put("tipo", "Seleccione Tipo Accidente");
//        }
//        
//        if (!errores.isEmpty()) {
//            request.setAttribute("errores", errores);
//            request.getRequestDispatcher("listasucursal").forward(request, response);
//            return;
//        }
        
        
        
        try {
            //SE CREA REPORTE ACCIDENTE
            ReporteAccidenteDAOImpl raDAO = new ReporteAccidenteDAOImpl();
            System.out.println(dateString);
            ReporteAccidente ra = new ReporteAccidente();
            //ate f = ra.castDate(dateString);
            ra.setHora(horaMin);
            ra.setComentario(comentario);
            ra.setId_sucursal_fk(idSucursal);
            ra.setId_tipo_accidente_fk(idTipoAccidente);
            ra.setFecha((java.util.Date) castDate(dateString));

            raDAO.agregar(ra);
            
            request.getRequestDispatcher("/home_1.jsp").forward(request, response);

        } catch (ParseException | SQLException ex) {
            Logger.getLogger(reportarAccidenteServlets.class.getName()).log(Level.SEVERE, null, ex);
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
    
     public Date castDate(String date) throws ParseException{
        
        SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        Date fech = (Date) simpleDateFormat.parse(date);
       
        return fech;
    }

}
