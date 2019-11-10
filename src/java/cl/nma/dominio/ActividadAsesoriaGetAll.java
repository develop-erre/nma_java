package cl.nma.dominio;

import java.util.Date;

public class ActividadAsesoriaGetAll {

    private int id_usuario;
    private String nombre_apellido;
    private int id_actividad;
    private Date fecha_act;
    private String hora_act;
    private int id_asesoria;
    private String comentarios_detectados;
    private String comentarios_propuesta;
    private String tipo_asesoria;
    private String nombre_sucursal;
    private String nombre_calle;
    private String numero;
    private String nombre_comuna;
    private String nombre_region;

    public ActividadAsesoriaGetAll() {
        
    }

    public ActividadAsesoriaGetAll(int id_usuario, String nombre_apellido, int id_actividad, Date fecha_act, String hora_act, int id_asesoria, String comentarios_detectados, String comentarios_propuesta, String tipo_asesoria, String nombre_sucursal, String nombre_calle, String numero, String nombre_comuna, String nombre_region) {
        this.id_usuario = id_usuario;
        this.nombre_apellido = nombre_apellido;
        this.id_actividad = id_actividad;
        this.fecha_act = fecha_act;
        this.hora_act = hora_act;
        this.id_asesoria = id_asesoria;
        this.comentarios_detectados = comentarios_detectados;
        this.comentarios_propuesta = comentarios_propuesta;
        this.tipo_asesoria = tipo_asesoria;
        this.nombre_sucursal = nombre_sucursal;
        this.nombre_calle = nombre_calle;
        this.numero = numero;
        this.nombre_comuna = nombre_comuna;
        this.nombre_region = nombre_region;
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

    public int getId_asesoria() {
        return id_asesoria;
    }

    public void setId_asesoria(int id_asesoria) {
        this.id_asesoria = id_asesoria;
    }

    public String getComentarios_detectados() {
        return comentarios_detectados;
    }

    public void setComentarios_detectados(String comentarios_detectados) {
        this.comentarios_detectados = comentarios_detectados;
    }

    public String getComentarios_propuesta() {
        return comentarios_propuesta;
    }

    public void setComentarios_propuesta(String comentarios_propuesta) {
        this.comentarios_propuesta = comentarios_propuesta;
    }

    public String getTipo_asesoria() {
        return tipo_asesoria;
    }

    public void setTipo_asesoria(String tipo_asesoria) {
        this.tipo_asesoria = tipo_asesoria;
    }

    public String getNombre_sucursal() {
        return nombre_sucursal;
    }

    public void setNombre_sucursal(String nombre_sucursal) {
        this.nombre_sucursal = nombre_sucursal;
    }

    public String getNombre_calle() {
        return nombre_calle;
    }

    public void setNombre_calle(String nombre_calle) {
        this.nombre_calle = nombre_calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre_comuna() {
        return nombre_comuna;
    }

    public void setNombre_comuna(String nombre_comuna) {
        this.nombre_comuna = nombre_comuna;
    }

    public String getNombre_region() {
        return nombre_region;
    }

    public void setNombre_region(String nombre_region) {
        this.nombre_region = nombre_region;
    }

}
