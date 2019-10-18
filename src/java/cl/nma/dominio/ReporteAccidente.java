package cl.nma.dominio;

import cl.nma.controllers.reportarAccidenteServlets;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReporteAccidente {
    
    private int id_reporte_accidente;
    private Date fecha;
    private String hora;
    private String comentario;
    private int id_sucursal_fk;
    private int id_tipo_accidente_fk;

    public ReporteAccidente() {
    }

    public ReporteAccidente(int id_reporte_accidente, Date fecha, String hora, String comentario, int id_sucursal_fk, int id_tipo_accidente_fk) {
        this.id_reporte_accidente = id_reporte_accidente;
        this.fecha = fecha;
        this.hora = hora;
        this.comentario = comentario;
        this.id_sucursal_fk = id_sucursal_fk;
        this.id_tipo_accidente_fk = id_tipo_accidente_fk;
    }

    public int getId_reporte_accidente() {
        return id_reporte_accidente;
    }

    public void setId_reporte_accidente(int id_reporte_accidente) {
        this.id_reporte_accidente = id_reporte_accidente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId_sucursal_fk() {
        return id_sucursal_fk;
    }

    public void setId_sucursal_fk(int id_sucursal_fk) {
        this.id_sucursal_fk = id_sucursal_fk;
    }

    public int getId_tipo_accidente_fk() {
        return id_tipo_accidente_fk;
    }

    public void setId_tipo_accidente_fk(int id_tipo_accidente_fk) {
        this.id_tipo_accidente_fk = id_tipo_accidente_fk;
    }

    @Override
    public String toString() {
        return "ReporteAccidente{" + "id_reporte_accidente=" + id_reporte_accidente + ", fecha=" + fecha + ", hora=" + hora + ", comentario=" + comentario + ", id_sucursal_fk=" + id_sucursal_fk + ", id_tipo_accidente_fk=" + id_tipo_accidente_fk + '}';
    }

    
}
