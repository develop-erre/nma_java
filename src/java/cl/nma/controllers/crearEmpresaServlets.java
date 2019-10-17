/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.controllers;

import cl.nma.dao.ContratoDAOImpl;
import cl.nma.dao.EmpresaDAOImpl;
import cl.nma.dao.ProfesionalDAOImpl;
import cl.nma.dao.SucursalDAOImpl;
import cl.nma.dominio.Contrato;
import cl.nma.dominio.Empresa;
import cl.nma.dominio.Profesional;
import cl.nma.dominio.Sucursal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
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
@WebServlet(name = "crearEmpresaServlets", urlPatterns = {"/crearEmpresa"})
public class crearEmpresaServlets extends HttpServlet {

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
            out.println("<title>Servlet crearEmpresaServlets</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet crearEmpresaServlets at " + request.getContextPath() + "</h1>");
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
        
        //EMPRESA
        String nombre = request.getParameter("txtNombre").toUpperCase();
        String rut = request.getParameter("txtRut");
        String sitioWeb = request.getParameter("txtSitioWeb").toUpperCase();
        String telefono = request.getParameter("txtTelefono");
        int estado = 0;
        int rubroId = Integer.parseInt(request.getParameter("selectRubro"));
        
        //SUCURSAL
        String nombreSuc = "";
        String numeroDir = request.getParameter("txtNumero");
        String direccion = request.getParameter("txtDireccion").toUpperCase()+" #"+numeroDir;
        int comunaId = Integer.parseInt(request.getParameter("selectComuna"));
        
        //CONTRATO
        int valorContrato = Integer.parseInt(request.getParameter("txtValor"));
        String descripcion = request.getParameter("textareaDescripcion");
        

        try {
            //SE CREA EMPRESA
            EmpresaDAOImpl emDAO = new EmpresaDAOImpl();

            Empresa em = new Empresa();
            em.setNombre(nombre);
            em.setRut(rut);
            em.setSitio_web(sitioWeb);
            em.setTelefono(telefono);
            em.setEstado(estado);
            em.setId_rubro_fk(rubroId);
            nombreSuc = em.nombreSucursal(em.getNombre());
           
            //SE GUARDA ID EMPRESA EN VARIABLE 
            int IdEmpresa ;
            IdEmpresa = emDAO.agregar(em);

            //SE CREA SUCURSAL
            SucursalDAOImpl sucDAO = new SucursalDAOImpl();
            Sucursal suc = new Sucursal();
            suc.setNombre(nombreSuc);
            suc.setDireccion(direccion);
            suc.setId_empresa_fk(IdEmpresa);
            suc.setId_comuna_suc_fk(comunaId);
            
            sucDAO.agregar(suc);
            
            //SE CREA CONTRATO
            ContratoDAOImpl conDAO = new ContratoDAOImpl();
            Contrato con = new Contrato();
            con.setValor(valorContrato);
            con.setDescripcion(descripcion);
            con.setId_empresa_fk(IdEmpresa);
            
            conDAO.agregar(con);
            
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/home_1.jsp");
            rd.include(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(loginServlets.class.getName()).log(Level.SEVERE, null, ex);
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
