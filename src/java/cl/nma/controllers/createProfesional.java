/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.controllers;

import cl.nma.dao.DireccionDAOImpl;
import cl.nma.dao.RegionComunaDAOImpl;
import cl.nma.dao.UsuarioDAOImpl;
import cl.nma.dominio.Direccion;
import cl.nma.dominio.RegionComuna;
import cl.nma.dominio.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Richard Foncea
 */
@WebServlet(name = "createProfesionalServlets", urlPatterns = {"/crearProfesional"})
public class createProfesional extends HttpServlet {

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
            out.println("<title>Servlet createProfesional</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet createProfesional at " + request.getContextPath() + "</h1>");
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

        List<RegionComuna> listaComuna = new ArrayList();
        try {

            RegionComunaDAOImpl rcDAO = new RegionComunaDAOImpl();
            listaComuna = rcDAO.listar();

        } catch (SQLException ex) {
            Logger.getLogger(createProfesional.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("listaReg", listaComuna);
        request.getRequestDispatcher("crearprofesional.jsp").forward(request, response);

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
        String nombre_calle = request.getParameter("txtDireccion");
        String numero = request.getParameter("txtNumero");
        String depto = request.getParameter("txtDepto");
        String fechaNac = request.getParameter("txtFechaNac");
        String email = request.getParameter("txtEmail");
        String telefono = request.getParameter("txtTelefono");
        int estado = 0;
        int comunaId = Integer.parseInt(request.getParameter("selectComunaId"));

        try {
            DireccionDAOImpl dicDAO = new DireccionDAOImpl();

            Direccion dir = new Direccion();
            dir.setNombre_calle(nombre_calle.toUpperCase());
            dir.setNumero(numero);
            dir.setDepto(depto);
            dir.setId_comuna_fk(comunaId);

            int idDireccion = dicDAO.agregar(dir);

            UsuarioDAOImpl profDAO = new UsuarioDAOImpl();

            Usuario user = new Usuario();
            user.setNombre(nombre.toUpperCase());
            user.setApellidos(apellidos.toUpperCase());
            user.setRut(run);
            user.setId_direccion_fk(idDireccion);
            user.setFecha_nac(castDate(fechaNac));
            user.setEmail(email.toUpperCase());
            user.setTelefono(telefono);
            user.setEstado(estado);
            user.setId_rol_fk(2);
            //METODO CREAR CRONTRASEÑA ENTRE NOMBRE, APELLIDO Y FECHA DE NACIMIENTO
            String pass = user.createPassword(fechaNac);

            //SE CODIFICA CONTRASEÑA 
            String originalInput = pass;
            String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());

            // SE DECODIFICA
            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
            String decodedString = new String(decodedBytes);
            System.out.println("Credenciales ");
            System.out.println("rut :   " + run);
            System.out.println("contraseña  :  " + decodedString);

            user.setPassword(encodedString);

            //SE INSERTA EN BASE DE DATOS
            

            int idProf = profDAO.agregarProfesional(user);

            if (idProf > 0) {

                Properties props = new Properties();
                props.setProperty("mail.smtp.host", "smtp.gmail.com");
                props.setProperty("mail.smtp.starttls.enable", "true");
                props.setProperty("mail.smtp.port", "587");
                props.setProperty("mail.smtp.auth", "true");

                Session ses = Session.getDefaultInstance(props);

                String correoRemitente = "previriesgosduoc@gmail.com";
                String passRemitente = "previriesgosduoc12345";
                String CorreoReceptor = email;
                String asunto = "Envío de Credenciales";
                String mensaje = "-------------------------------------------------------------------\n"
                        + "                       PREVIRIESGOS   SPA                          \n"
                        + "-------------------------------------------------------------------\n"
                        + "Don: " + nombre.toUpperCase() + " " + apellidos.toUpperCase() + " , ha sido registrado en nuestra plataforma como Profesional\n"
                        + "Sus credenciales son:\n"
                        + "RUN :  " + run + "\n"
                        + "CONTRASEÑA :  " + pass;

                MimeMessage message = new MimeMessage(ses);
                message.setFrom(new InternetAddress(correoRemitente));

                message.addRecipient(Message.RecipientType.TO, new InternetAddress(CorreoReceptor));
                message.setSubject(asunto);
                message.setText(mensaje);

                Transport t = ses.getTransport("smtp");
                t.connect(correoRemitente, passRemitente);
                t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
                t.close();

                System.out.println("Correo electronico enviado");

            }
            request.getRequestDispatcher("home.jsp").forward(request, response);

        } catch (SQLException | ParseException | MessagingException ex) {
            Logger.getLogger(createProfesional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
