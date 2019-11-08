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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
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
@WebServlet(name = "actualizarUsuarioServlets", urlPatterns = {"/actualizar"})
public class actualizarUsuarioServlets extends HttpServlet {

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
            out.println("<title>Servlet actualizarUsuarioServlets</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet actualizarUsuarioServlets at " + request.getContextPath() + "</h1>");
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
        String nombre = request.getParameter("txtNombre");
        String apellidos = request.getParameter("txtApellidos");
        String run = request.getParameter("txtRun");
        String fechaNac = request.getParameter("txtFechaNac");
        String email = request.getParameter("txtEmail");
        String telefono = request.getParameter("txtTelefono");
        String direccion = request.getParameter("txtDireccion") + " #" + request.getParameter("txtNumero");
        int comunaId = Integer.parseInt(request.getParameter("selectComunaId"));
        int idUsuario = Integer.parseInt(request.getParameter("txtIdUsuario"));
        

        try {
            
            UsuarioDAOImpl usDAO = new UsuarioDAOImpl();

            Usuario us = new Usuario();
            us.setNombre(nombre.toUpperCase());
            us.setApellidos(apellidos.toUpperCase());
            us.setRut(run);
            us.setDireccion(direccion.toUpperCase());
            us.setFecha_nac(castDate(fechaNac));
            us.setEmail(email.toUpperCase());
            us.setTelefono(telefono);
            us.setId_comuna_us_fk(comunaId);
            us.setId_usuario(idUsuario);
            
            usDAO.actualizar(us);

            
            //SE INSERTA EN BASE DE DATOS
           // profDAO.agregar(prof);

            request.getRequestDispatcher("home.jsp").forward(request, response);

        }catch (SQLException ex) {
            Logger.getLogger(loginServlets.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(actualizarUsuarioServlets.class.getName()).log(Level.SEVERE, null, ex);
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

    public java.util.Date castDate(String date) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date fech = (java.util.Date) simpleDateFormat.parse(date);

        return fech;
    }
    
}
