/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.controllers;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 */
@WebServlet(name = "reporteVisitaServlets", urlPatterns = {"/pdfVisita"})
public class reporteVisitaServlets extends HttpServlet {

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
            out.println("<title>Servlet reporteVisitaServlets</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet reporteVisitaServlets at " + request.getContextPath() + "</h1>");
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
        response.setContentType("application/pdf");

        OutputStream out = response.getOutputStream();
        try {
            try {

                String lugar = request.getParameter("txtNombreSucursal");
                String nombrecalle = request.getParameter("txtNombrecalle");
                String numero = request.getParameter("txtNumero");
                String comuna = request.getParameter("txtComuna");
                String region = request.getParameter("txtRegion");
                String tipoVista = request.getParameter("txtTipoVisita");
                String nombreProfesional = request.getParameter("txtNombreProf");
                String fecha_act = request.getParameter("txtFecha");
                String hora_act = request.getParameter("txtHora");

                //SECCION DOCUMENTOS
                String contratos = request.getParameter("txtContratos");
                if (contratos.equals("0")) {
                    contratos = "Incompletos";
                } else {
                    contratos = "Completos";
                }
                String finiquitos = request.getParameter("txtDocumentos");
                if (finiquitos.equals("0")) {
                    finiquitos = "Incompletos";
                } else {
                    finiquitos = "Completos";
                }
                String documnetos = request.getParameter("txtFiniquitos");
                if (documnetos.equals("0")) {
                    documnetos = "Incompletos";
                } else {
                    documnetos = "Completos";
                }

                String comentariosDocumentos = request.getParameter("txtComentariosDocumentos");

                //SECCION FAENA
                String instalacion = request.getParameter("txtInstalacion");
                if (instalacion.equals("0")) {
                    instalacion = "Incompletos";
                } else {
                    instalacion = "Completos";
                }
                String banios = request.getParameter("txtBanios");
                if (banios.equals("0")) {
                    banios = "Incompletos";
                } else {
                    banios = "Completos";
                }
                String comedores = request.getParameter("txtComedores");
                if (comedores.equals("0")) {
                    comedores = "Incompletos";
                } else {
                    comedores = "Completos";
                }

                String comentariosFaena = request.getParameter("txtComentariosFaena");

                //SECCION SEGURIDAD
                String seguridad = request.getParameter("txtSeguridad");
                if (seguridad.equals("0")) {
                    seguridad = "Incompletos";
                } else {
                    seguridad = "Completos";
                }
                String peligros = request.getParameter("txtPeligros");
                if (peligros.equals("0")) {
                    peligros = "Incompletos";
                } else {
                    peligros = "Completos";
                }
                String comentarios_seguridad = request.getParameter("txtComentariosSeguridad");

                String comentarios_Propuesta = request.getParameter("txtComentariosPropuesta");

                //INICIO DEL DOCUMENTO PDF
                Document documento = new Document();
                PdfWriter.getInstance(documento, out);
                // ABRIR DOCUMENTO
                documento.open();

//                Image imagen = Image.getInstance("http://18.223.187.212/imagen/icono-reporte-asesoria.png");
//                imagen.setAlignment(Element.ALIGN_LEFT);
//                imagen.scaleToFit(50, 50);
//                documento.add(imagen);
                Paragraph par1 = new Paragraph();
                Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLACK);
                par1.add(new Phrase("Reporte Visita", fontTitulo));
                par1.setAlignment(Element.ALIGN_CENTER);
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase(Chunk.NEWLINE));
                documento.add(par1);

                //LUGAR
                Paragraph lugarVis = new Paragraph();
                Font fontLugar = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
                lugarVis.add(new Phrase("LUGAR : " + lugar, fontLugar));
                lugarVis.setAlignment(Element.ALIGN_LEFT);
                lugarVis.add(new Phrase(Chunk.NEWLINE));
                documento.add(lugarVis);

                //DIRECCION
                Paragraph direccion = new Paragraph();
                Font fontDireccion = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.BLACK);
                direccion.add(new Phrase(nombrecalle + " #" + numero, fontDireccion));
                direccion.setAlignment(Element.ALIGN_LEFT);
                direccion.add(new Phrase(Chunk.NEWLINE));
                documento.add(direccion);

                //COMUNA REGION
                Paragraph comunaReg = new Paragraph();
                Font fontcomunaReg = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.BLACK);
                comunaReg.add(new Phrase(comuna + " - " + region, fontcomunaReg));
                comunaReg.setAlignment(Element.ALIGN_LEFT);
                comunaReg.add(new Phrase(Chunk.NEWLINE));
                documento.add(comunaReg);

                //TIPO VISITA
                Paragraph tipoVis = new Paragraph();
                Font fontTipo = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL, BaseColor.BLACK);
                tipoVis.add(new Phrase("TIPO VISITA: " + tipoVista, fontTipo));
                tipoVis.setAlignment(Element.ALIGN_LEFT);
                tipoVis.add(new Phrase(Chunk.NEWLINE));
                tipoVis.add(new Phrase(Chunk.NEWLINE));
                tipoVis.add(new Phrase(Chunk.NEWLINE));
                documento.add(tipoVis);

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

                //SECCION DOCUMENTACION
                Paragraph tituloDocumentacion = new Paragraph();
                Font fontDescripcion = new Font(Font.FontFamily.COURIER, 14, Font.BOLD, BaseColor.BLACK);
                tituloDocumentacion.add(new Phrase("SECCIÓN DOCUMENTOS", fontDescripcion));
                tituloDocumentacion.setAlignment(Element.ALIGN_CENTER);
                tituloDocumentacion.add(new Phrase(Chunk.NEWLINE));
                tituloDocumentacion.add(new Phrase(Chunk.NEWLINE));
                documento.add(tituloDocumentacion);

                Paragraph Pcontratos = new Paragraph();
                Font fontContratos = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                Pcontratos.add(new Phrase("Contratos: " + contratos, fontContratos));
                Pcontratos.setAlignment(Element.ALIGN_JUSTIFIED);
                Pcontratos.add(new Phrase(Chunk.NEWLINE));
                documento.add(Pcontratos);

                Paragraph Pdocumentos = new Paragraph();
                Font fontDocumentos = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                Pdocumentos.add(new Phrase("Documentación: " + documnetos, fontDocumentos));
                Pdocumentos.setAlignment(Element.ALIGN_JUSTIFIED);
                Pdocumentos.add(new Phrase(Chunk.NEWLINE));
                documento.add(Pdocumentos);

                Paragraph Pfiniquitos = new Paragraph();
                Font fontFiniquitos = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                Pfiniquitos.add(new Phrase("Finiquitos: " + finiquitos, fontFiniquitos));
                Pfiniquitos.setAlignment(Element.ALIGN_JUSTIFIED);
                Pfiniquitos.add(new Phrase(Chunk.NEWLINE));
                Pfiniquitos.add(new Phrase(Chunk.NEWLINE));
                documento.add(Pfiniquitos);

                Paragraph tituloComentariosDoc = new Paragraph();
                Font fontTituloDoc = new Font(Font.FontFamily.COURIER, 10, Font.UNDERLINE, BaseColor.BLACK);
                tituloComentariosDoc.add(new Phrase("Comentarios Documentación:", fontTituloDoc));
                tituloComentariosDoc.setAlignment(Element.ALIGN_JUSTIFIED);
                tituloComentariosDoc.add(new Phrase(Chunk.NEWLINE));
                documento.add(tituloComentariosDoc);

                Paragraph comDoc = new Paragraph();
                Font fontComDoc = new Font(Font.FontFamily.COURIER, 10, Font.NORMAL, BaseColor.BLACK);
                comDoc.add(new Phrase(comentariosDocumentos, fontComDoc));
                comDoc.setAlignment(Element.ALIGN_JUSTIFIED);
                comDoc.add(new Phrase(Chunk.NEWLINE));
                comDoc.add(new Phrase(Chunk.NEWLINE));
                documento.add(comDoc);

                //SECCION FAENA
                Paragraph tituloFaena = new Paragraph();
                Font fontFaena = new Font(Font.FontFamily.COURIER, 14, Font.BOLD, BaseColor.BLACK);
                tituloFaena.add(new Phrase("SECCIÓN FAENA", fontFaena));
                tituloFaena.setAlignment(Element.ALIGN_CENTER);
                tituloFaena.add(new Phrase(Chunk.NEWLINE));
                tituloFaena.add(new Phrase(Chunk.NEWLINE));
                documento.add(tituloFaena);

                Paragraph Pinstalacion = new Paragraph();
                Font fontInstalacion = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                Pinstalacion.add(new Phrase("Instalación: " + instalacion, fontInstalacion));
                Pinstalacion.setAlignment(Element.ALIGN_JUSTIFIED);
                Pinstalacion.add(new Phrase(Chunk.NEWLINE));
                documento.add(Pinstalacion);

                Paragraph Pbanio = new Paragraph();
                Font fontBanio = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                Pbanio.add(new Phrase("Baños: " + banios, fontBanio));
                Pbanio.setAlignment(Element.ALIGN_JUSTIFIED);
                Pbanio.add(new Phrase(Chunk.NEWLINE));
                documento.add(Pbanio);

                Paragraph Pcomedores = new Paragraph();
                Font fontComedores = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                Pcomedores.add(new Phrase("Comedores: " + comedores, fontComedores));
                Pcomedores.setAlignment(Element.ALIGN_JUSTIFIED);
                Pcomedores.add(new Phrase(Chunk.NEWLINE));
                Pcomedores.add(new Phrase(Chunk.NEWLINE));
                documento.add(Pcomedores);

                Paragraph tituloComentariosFaena = new Paragraph();
                Font fontTituloFaena = new Font(Font.FontFamily.COURIER, 10, Font.UNDERLINE, BaseColor.BLACK);
                tituloComentariosFaena.add(new Phrase("Comentarios Faena:", fontTituloFaena));
                tituloComentariosFaena.setAlignment(Element.ALIGN_JUSTIFIED);
                tituloComentariosFaena.add(new Phrase(Chunk.NEWLINE));
                documento.add(tituloComentariosFaena);

                Paragraph comFaena = new Paragraph();
                Font fontComentariosFaena = new Font(Font.FontFamily.COURIER, 10, Font.NORMAL, BaseColor.BLACK);
                comFaena.add(new Phrase(comentariosFaena, fontComentariosFaena));
                comFaena.setAlignment(Element.ALIGN_JUSTIFIED);
                comFaena.add(new Phrase(Chunk.NEWLINE));
                comFaena.add(new Phrase(Chunk.NEWLINE));
                documento.add(comFaena);

                //SECCION SEGURIDAD
                Paragraph tituloSeguridad = new Paragraph();
                Font fontSeguridad = new Font(Font.FontFamily.COURIER, 14, Font.BOLD, BaseColor.BLACK);
                tituloSeguridad.add(new Phrase("SECCIÓN SEGURIDAD", fontSeguridad));
                tituloSeguridad.setAlignment(Element.ALIGN_CENTER);
                tituloSeguridad.add(new Phrase(Chunk.NEWLINE));
                tituloSeguridad.add(new Phrase(Chunk.NEWLINE));
                documento.add(tituloSeguridad);

                Paragraph Pseguridad = new Paragraph();
                Font fontSeg = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                Pseguridad.add(new Phrase("Seguridad: " + seguridad, fontSeg));
                Pseguridad.setAlignment(Element.ALIGN_JUSTIFIED);
                Pseguridad.add(new Phrase(Chunk.NEWLINE));
                documento.add(Pseguridad);

                Paragraph Ppeligros = new Paragraph();
                Font fontPeligro = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                Ppeligros.add(new Phrase("Peligros: " + peligros, fontPeligro));
                Ppeligros.setAlignment(Element.ALIGN_JUSTIFIED);
                Ppeligros.add(new Phrase(Chunk.NEWLINE));
                Ppeligros.add(new Phrase(Chunk.NEWLINE));
                documento.add(Ppeligros);

                Paragraph PcomentariosSeguridad = new Paragraph();
                Font fontComeSeg = new Font(Font.FontFamily.HELVETICA, 10, Font.UNDERLINE, BaseColor.BLACK);
                PcomentariosSeguridad.add(new Phrase("Comentarios Seguridad: ", fontComeSeg));
                PcomentariosSeguridad.setAlignment(Element.ALIGN_JUSTIFIED);
                PcomentariosSeguridad.add(new Phrase(Chunk.NEWLINE));
                documento.add(PcomentariosSeguridad);

                Paragraph comSeguridad = new Paragraph();
                Font fontComSeg = new Font(Font.FontFamily.COURIER, 10, Font.NORMAL, BaseColor.BLACK);
                comSeguridad.add(new Phrase(comentarios_seguridad, fontComSeg));
                comSeguridad.setAlignment(Element.ALIGN_JUSTIFIED);
                comSeguridad.add(new Phrase(Chunk.NEWLINE));
                comSeguridad.add(new Phrase(Chunk.NEWLINE));
                documento.add(comSeguridad);
                
                //PROPUESTA DE MEJORA
                
                Paragraph tituloPropuesta = new Paragraph();
                Font fontPropuesta = new Font(Font.FontFamily.COURIER, 14, Font.BOLD, BaseColor.BLACK);
                tituloPropuesta.add(new Phrase("PROPUESTA DE MEJORA", fontPropuesta));
                tituloPropuesta.setAlignment(Element.ALIGN_CENTER);
                tituloPropuesta.add(new Phrase(Chunk.NEWLINE));
                tituloPropuesta.add(new Phrase(Chunk.NEWLINE));
                documento.add(tituloPropuesta);

                Paragraph Ppropuesta = new Paragraph();
                Font fontPropuestaMejora = new Font(Font.FontFamily.COURIER, 10, Font.NORMAL, BaseColor.BLACK);
                Ppropuesta.add(new Phrase(comentarios_Propuesta, fontPropuestaMejora));
                Ppropuesta.setAlignment(Element.ALIGN_JUSTIFIED);
                Ppropuesta.add(new Phrase(Chunk.NEWLINE));
                documento.add(Ppropuesta);

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
