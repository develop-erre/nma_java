package cl.nma.controllers;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javafx.scene.text.TextAlignment;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "reporteAsesoriaServlets", urlPatterns = {"/pdfAsesoria"})
public class reporteAsesoriaServlets extends HttpServlet {

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
        response.setContentType("application/pdf");

        OutputStream out = response.getOutputStream();
        try {
            try {

                String nombreProfesional = request.getParameter("txtNombreProf");
                String fecha_act = request.getParameter("txtFecha");
                String hora_act = request.getParameter("txtHora");
                String lugar = request.getParameter("txtNombreSucursal");
                String tipoAsesoria = request.getParameter("txtTipoAsesoria");
                String descProblema = request.getParameter("txtDescProblem");
                String descPropuesta = request.getParameter("txtDescPropuesta");

                Document documento = new Document();
                PdfWriter.getInstance(documento, out);
                // abrir documento
                documento.open();

                Image imagen = Image.getInstance("http://18.223.187.212/imagen/icono-reporte-asesoria.png");
                imagen.setAlignment(Element.ALIGN_LEFT);
                imagen.scaleToFit(50, 50);
                documento.add(imagen);

                Paragraph par1 = new Paragraph();
                Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLACK);
                par1.add(new Phrase("Reporte Asesoria", fontTitulo));
                par1.setAlignment(Element.ALIGN_CENTER);
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase(Chunk.NEWLINE));
                documento.add(par1);

                //LUGAR
                Paragraph lugaraSE = new Paragraph();
                Font fontLugar = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
                lugaraSE.add(new Phrase("LUGAR : " + lugar, fontLugar));
                lugaraSE.setAlignment(Element.ALIGN_LEFT);
                lugaraSE.add(new Phrase(Chunk.NEWLINE));
                documento.add(lugaraSE);

                //TIPO ASESORIA
                Paragraph tipoAse = new Paragraph();
                Font fontTipo = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL, BaseColor.BLACK);
                tipoAse.add(new Phrase("TIPO ASESORIA: " + tipoAsesoria, fontTipo));
                tipoAse.setAlignment(Element.ALIGN_LEFT);
                tipoAse.add(new Phrase(Chunk.NEWLINE));
                tipoAse.add(new Phrase(Chunk.NEWLINE));
                tipoAse.add(new Phrase(Chunk.NEWLINE));
                documento.add(tipoAse);

                //NOMBRE PROFESIONAL
                Paragraph nomeProfesional = new Paragraph();
                Font fontName = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                nomeProfesional.add(new Phrase("Nombre Profesional: " + nombreProfesional, fontName));
                nomeProfesional.setAlignment(Element.ALIGN_LEFT);
                nomeProfesional.add(new Phrase(Chunk.NEWLINE));
                documento.add(nomeProfesional);

                //FECHA
                Paragraph fecha = new Paragraph();
                Font fontFecha = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                fecha.add(new Phrase("Fecha Asesoria: " + fecha_act, fontFecha));
                fecha.setAlignment(Element.ALIGN_LEFT);
                fecha.add(new Phrase(Chunk.NEWLINE));
                documento.add(fecha);
                
                //HORA
                Paragraph hora = new Paragraph();
                Font fonthora = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                hora.add(new Phrase("Hora Asesoria: " + hora_act, fonthora));
                hora.setAlignment(Element.ALIGN_LEFT);
                hora.add(new Phrase(Chunk.NEWLINE));
                hora.add(new Phrase(Chunk.NEWLINE));
                documento.add(hora);

                //PROBLEMAS DETECTADOS
                Paragraph problemasdetectados = new Paragraph();
                Font fontDescripcion = new Font(Font.FontFamily.HELVETICA, 10, Font.UNDERLINE, BaseColor.BLACK);
                problemasdetectados.add(new Phrase("Problemas Detectados:", fontDescripcion));
                problemasdetectados.setAlignment(Element.ALIGN_JUSTIFIED);
                problemasdetectados.add(new Phrase(Chunk.NEWLINE));
                problemasdetectados.add(new Phrase(Chunk.NEWLINE));
                documento.add(problemasdetectados);
                
                Paragraph descripcionProblemas = new Paragraph();
                Font fontDescripcionPro = new Font(Font.FontFamily.COURIER, 10, Font.NORMAL, BaseColor.BLACK);
                descripcionProblemas.add(new Phrase(descProblema, fontDescripcionPro));
                descripcionProblemas.setAlignment(Element.ALIGN_JUSTIFIED);
                descripcionProblemas.add(new Phrase(Chunk.NEWLINE));
                descripcionProblemas.add(new Phrase(Chunk.NEWLINE));
                descripcionProblemas.add(new Phrase(Chunk.NEWLINE));
                documento.add(descripcionProblemas);
                
                //SOLUCION PROPUESTA
                Paragraph propuesta = new Paragraph();
                Font fontPropuesta = new Font(Font.FontFamily.HELVETICA, 10, Font.UNDERLINE, BaseColor.BLACK);
                propuesta.add(new Phrase("Solución Propuesta:", fontPropuesta));
                propuesta.setAlignment(Element.ALIGN_JUSTIFIED);
                propuesta.add(new Phrase(Chunk.NEWLINE));
                propuesta.add(new Phrase(Chunk.NEWLINE));
                documento.add(propuesta);
                
                Paragraph descripcionPropuesta = new Paragraph();
                Font fontdescripcionPropuesta = new Font(Font.FontFamily.COURIER, 10, Font.NORMAL, BaseColor.BLACK);
                descripcionPropuesta.add(new Phrase(descPropuesta, fontdescripcionPropuesta));
                descripcionPropuesta.setAlignment(Element.ALIGN_JUSTIFIED);
                descripcionPropuesta.add(new Phrase(Chunk.NEWLINE));
                documento.add(descripcionPropuesta);
                
                documento.close();

            } catch (Exception e) {
                e.getMessage();
            }
        } finally {
            out.close();
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
