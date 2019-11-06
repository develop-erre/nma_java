
package cl.nma.dominio;

import java.util.Date;

public class ActividadCapacitacionGettAll {
    
    private int id_actividad;
    private int id_capacitacion;
    private int id_usuario;
    private String nombre_apellido;
    private Date fecha_act;
    private String hora_act;
    private int numero_asistente;
    private String nombre_sucursal;
    private String descripcion;

    public ActividadCapacitacionGettAll() {
    }

    public ActividadCapacitacionGettAll(int id_actividad, int id_capacitacion, int id_usuario, String nombre_apellido, Date fecha_act, String hora_act, int numero_asistente, String nombre_sucursal, String descripcion) {
        this.id_actividad = id_actividad;
        this.id_capacitacion = id_capacitacion;
        this.id_usuario = id_usuario;
        this.nombre_apellido = nombre_apellido;
        this.fecha_act = fecha_act;
        this.hora_act = hora_act;
        this.numero_asistente = numero_asistente;
        this.nombre_sucursal = nombre_sucursal;
        this.descripcion = descripcion;
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public int getId_capacitacion() {
        return id_capacitacion;
    }

    public void setId_capacitacion(int id_capacitacion) {
        this.id_capacitacion = id_capacitacion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
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

    public int getNumero_asistente() {
        return numero_asistente;
    }

    public void setNumero_asistente(int numero_asistente) {
        this.numero_asistente = numero_asistente;
    }

    public String getNombre_sucursal() {
        return nombre_sucursal;
    }

    public void setNombre_sucursal(String nombre_sucursal) {
        this.nombre_sucursal = nombre_sucursal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
        
}
