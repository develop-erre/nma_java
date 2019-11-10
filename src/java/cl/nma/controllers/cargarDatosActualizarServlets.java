/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.controllers;

import cl.nma.dao.RegionComunaDAOImpl;
import cl.nma.dao.UsuarioDAOImpl;
import cl.nma.dominio.RegionComuna;
import cl.nma.dominio.UsuarioLista;
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
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@WebServlet(name = "cargarDatosActualizarServlets", urlPatterns = {"/cargarDatosActualizar"})
public class cargarDatosActualizarServlets extends HttpServlet {

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
            out.println("<title>Servlet cargarDatosActualizarServlets</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cargarDatosActualizarServlets at " + request.getContextPath() + "</h1>");
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

        int idrol = Integer.parseInt(request.getParameter("id_rol"));
        
        
        System.out.println("rol : " + idrol);

        List<RegionComuna> listaComuna = new ArrayList();

        RegionComunaDAOImpl rcDAO;
        try {
            rcDAO = new RegionComunaDAOImpl();
            listaComuna = rcDAO.listar();

            request.setAttribute("listaReg", listaComuna);

        } catch (SQLException ex) {
            Logger.getLogger(cargarDatosActualizarServlets.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (idrol == 2) {

            int idProfesional = Integer.parseInt(request.getParameter("id_prof_actualizar"));

            try {

                UsuarioDAOImpl usDAO = new UsuarioDAOImpl();
                UsuarioLista us = usDAO.traeUsuarioPorId(idProfesional);

                request.setAttribute("getId_usuario", us.getId_usuario());
                request.setAttribute("getNombre", us.getNombre());
                request.setAttribute("getApellidos", us.getApellidos());
                request.setAttribute("getRut", us.getRut());
                request.setAttribute("getFecha_nacimiento", us.getFecha_nacimiento());
                request.setAttribute("getEmail", us.getEmail());
                request.setAttribute("getTelefono", us.getTelefono());
                request.setAttribute("getNombre_calle", us.getNombre_calle());
                request.setAttribute("getNumero", us.getNumero());
                request.setAttribute("getDepto", us.getDepto());
                request.setAttribute("getComuna", us.getComuna());
                request.setAttribute("getRegion", us.getRegion());
                request.setAttribute("getId_rol_fk", us.getId_rol_fk());
                request.setAttribute("getId_empresa_fk", us.getId_empresa_fk());
                request.setAttribute("getId_direccion_fk", us.getId_direccion_fk());

                request.getRequestDispatcher("actualizarprofesional.jsp").forward(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(listProfesionalServlets.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

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
