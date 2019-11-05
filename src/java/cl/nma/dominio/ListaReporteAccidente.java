package cl.nma.dominio;

import java.util.Date;

public class ListaReporteAccidente {
    
    private int id_reporte_accidente;
    private int id_sucursal;
    private int id_empresa;
    private Date fecha_accidente;
    private String hora_accidente;
    private String comentario;
    private String descripcion;
    private String nombre_sucursal;

    public ListaReporteAccidente() {
    }

    public ListaReporteAccidente(int id_reporte_accidente, int id_sucursal, int id_empresa, Date fecha_accidente, String hora_accidente, String comentario, String descripccion, String nombre_sucursal) {
        this.id_reporte_accidente = id_reporte_accidente;
        this.id_sucursal = id_sucursal;
        this.id_empresa = id_empresa;
        this.fecha_accidente = fecha_accidente;
        this.hora_accidente = hora_accidente;
        this.comentario = comentario;
        this.descripcion = descripccion;
        this.nombre_sucursal = nombre_sucursal;
    }

    public int getId_reporte_accidente() {
        return id_reporte_accidente;
    }

    public void setId_reporte_accidente(int id_reporte_accidente) {
        this.id_reporte_accidente = id_reporte_accidente;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public Date getFecha_accidente() {
        return fecha_accidente;
    }

    public void setFecha_accidente(Date fecha_accidente) {
        this.fecha_accidente = fecha_accidente;
    }

    public String getHora_accidente() {
        return hora_accidente;
    }

    public void setHora_accidente(String hora_accidente) {
        this.hora_accidente = hora_accidente;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripccion) {
        this.descripcion = descripccion;
    }

    public String getNombre_sucursal() {
        return nombre_sucursal;
    }

    public void setNombre_sucursal(String nombre_sucursal) {
        this.nombre_sucursal = nombre_sucursal;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }
    
    
    
}
