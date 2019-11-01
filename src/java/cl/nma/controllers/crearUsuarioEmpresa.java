/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.controllers;

import cl.nma.dao.EmpresaDAOImpl;
import cl.nma.dao.ProfesionalDAOImpl;
import cl.nma.dao.UsuarioDAOImpl;
import cl.nma.dominio.EmpresaLista;
import cl.nma.dominio.Profesional;
import cl.nma.dominio.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

/**
 *
 * @author Richard Foncea
 */
@WebServlet(name = "crearUsuarioEmpresa", urlPatterns = {"/crearusuarioempresa"})
public class crearUsuarioEmpresa extends HttpServlet {

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
            out.println("<title>Servlet crearUsuarioEmpresa</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet crearUsuarioEmpresa at " + request.getContextPath() + "</h1>");
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

        List<EmpresaLista> lista = new ArrayList();
        try {
            EmpresaDAOImpl empDAO = new EmpresaDAOImpl();
            lista = empDAO.listarEmpresaLista();

        } catch (SQLException ex) {
            Logger.getLogger(listaEmpresaListServlets.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("listaEmp", lista);
        request.getRequestDispatcher("crearusuarioempresa.jsp").forward(request, response);
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

        String nombre = request.getParameter("txtNombre");
        String apellidos = request.getParameter("txtApellidos");
        String run = request.getParameter("txtRun");
        String pass = request.getParameter("txtPassword");
        String direccion = request.getParameter("txtDireccion") + " #" + request.getParameter("txtNumero");
        String fechaNac = (request.getParameter("txtFechaNac"));
        String email = request.getParameter("txtEmail");
        String telefono = request.getParameter("txtTelefono");
        int estado = 0;
        int comunaId = Integer.parseInt(request.getParameter("txtIdComuna"));
        //int rolId = Integer.parseInt(request.getParameter("selectRol"));
        int empresaId = Integer.parseInt(request.getParameter("txtIdEmpresa"));

        try {
            UsuarioDAOImpl usuEmpfDAO = new UsuarioDAOImpl();

            Usuario usu = new Usuario();
            usu.setNombre(nombre);
            usu.setApellidos(apellidos);
            usu.setRut(run);
            usu.setPassword(pass);
            usu.setDireccion(direccion);
            usu.setFecha_nac(castDate(fechaNac));
            usu.setEmail(email);
            usu.setTelefono(telefono);
            usu.setEstado(estado);
            usu.setId_comuna_us_fk(comunaId);
            usu.setId_rol_fk(3);
            usu.setId_empresa_fk(empresaId);

            usuEmpfDAO.agregarUsuarioEmpresa(usu);

            request.getRequestDispatcher("home.jsp").forward(request, response);

        } catch (SQLException | ParseException ex) {
            Logger.getLogger(crearUsuarioEmpresa.class.getName()).log(Level.SEVERE, null, ex);
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

        String mes = date.substring(0, 2);
        String dia = date.substring(3, 5);
        String anio = date.substring(6, 10);

        String fechaCast = anio + "-" + mes + "-" + dia;
        System.out.println(fechaCast);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date fech = (java.util.Date) simpleDateFormat.parse(fechaCast);

        return fech;
    }
}
