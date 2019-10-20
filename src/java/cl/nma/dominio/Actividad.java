package cl.nma.dominio;

import java.util.Date;

public class Actividad {
    
    private int id_actividad;
    private Date fecha_act;
    private String hora_act;
    private int estado_act;
    private int id_usuario_fk;
    private int id_sucursal_empresa_fk;

    public Actividad() {
    }

    public Actividad(int id_actividad, Date fecha_act, String hora_act, int estado_act, int id_usuario_fk, int id_sucursal_empresa_fk) {
        this.id_actividad = id_actividad;
        this.fecha_act = fecha_act;
        this.hora_act = hora_act;
        this.estado_act = estado_act;
        this.id_usuario_fk = id_usuario_fk;
        this.id_sucursal_empresa_fk = id_sucursal_empresa_fk;
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public Date getFecha_act() {
        return fecha_act;
    }

    public void setFecha_act(Date fecha_act) {
        this.fecha_act = fecha_act;
    }

    public String getHora_act() {
        return hora_act;
    }

    public void setHora_act(String hora_act) {
        this.hora_act = hora_act;
    }

    public int getEstado_act() {
        return estado_act;
    }

    public void setEstado_act(int estado_act) {
        this.estado_act = estado_act;
    }

    public int getId_usuario_fk() {
        return id_usuario_fk;
    }

    public void setId_usuario_fk(int id_usuario_fk) {
        this.id_usuario_fk = id_usuario_fk;
    }

    public int getId_sucursal_empresa_fk() {
        return id_sucursal_empresa_fk;
    }

    public void setId_sucursal_empresa_fk(int id_sucursal_empresa_fk) {
        this.id_sucursal_empresa_fk = id_sucursal_empresa_fk;
    }

    @Override
    public String toString() {
        return "Actividad{" + "id_actividad=" + id_actividad + ", fecha_act=" + fecha_act + ", hora_act=" + hora_act + ", estado_act=" + estado_act + ", id_usuario_fk=" + id_usuario_fk + ", id_sucursal_empresa_fk=" + id_sucursal_empresa_fk + '}';
    }
    
    
    
}
