/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.controllers;

import cl.nma.dao.UsuarioDAO;
import cl.nma.dao.UsuarioDAOImpl;
import cl.nma.dominio.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "loginServlets", urlPatterns = {"/login"})
public class loginServlets extends HttpServlet {

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
            out.println("<title>Servlet loginServlets</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginServlets at " + request.getContextPath() + "</h1>");
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
        HttpSession sesion = request.getSession();
        sesion.invalidate();
        response.sendRedirect("index.jsp");
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

        String run = request.getParameter("txtRun");
        String pass = request.getParameter("txtPass");

        try {
            UsuarioDAOImpl usuarioVerificarDAO = new UsuarioDAOImpl();
            UsuarioDAOImpl usuarioObtenerDAO = new UsuarioDAOImpl();
//            List<Usuario> usuarios = new ArrayList<>();
//            usuarios = usuarioDAO.listarUsuario();
            boolean verificar = usuarioVerificarDAO.verificarUserSession(run, pass);

            if (verificar) {

                Usuario usuario = usuarioObtenerDAO.obtenerUsuario(run, pass);

                if (usuario.getEstado() == 0) {

                    HttpSession session = request.getSession();
                    session.setAttribute("run", usuario.getRut());
                    // session.setAttribute("pass", us.getPassword());
                    session.setAttribute("nombre", usuario.getNombre());
                    session.setAttribute("id_usuario", usuario.getId_usuario());
                    session.setAttribute("id_rol", usuario.getId_rol_fk());
                    session.setAttribute("id_empresa", usuario.getId_empresa_fk());
                    session.setAttribute("estado", usuario.getEstado());
                    //System.out.println("Conexion correcta");
                    request.getRequestDispatcher("/home.jsp").forward(request, response);
                    
                } else {
                    String error2 = "Usuario bloqueado - contactar con Administrador";
                    request.setAttribute("error2", error2);
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            } else {
                String error1 = "Usuario y/o contraseña inválida";
                request.setAttribute("error1", error1);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(loginServlets.class.getName()).log(Level.SEVERE, null, ex);
        }
        // response.sendRedirect("index.jsp");
        //  System.out.println("No se pudo");

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
