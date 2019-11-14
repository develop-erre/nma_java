package cl.nma.dominio;

import java.util.Date;

public class ActividadVisita {
    
    private int id_usuario;
    private String nombre_apellido;
    private int id_actividad;
    private Date fecha_act;
    private String hora_act;
    private int id_visita;
    private String tipo_visita;
    private int contratos;
    private int documentacion;
    private int finiquitos;
    private String comentarios_documentacion;
    private int instalacion;
    private int banios;
    private int comedores;
    private String comentarios_faena;
    private int seguridad;
    private int peligros;
    private String comentarios_seguridad;
    private String comentarios_propuesta;
   
    private String nombre_sucursal;
    private String nombre_calle;
    private String numero;
    private String nombre_comuna;
    private String nombre_region;

    public ActividadVisita() {
    }

    public ActividadVisita(int id_usuario, String nombre_apellido, int id_actividad, Date fecha_act, String hora_act, int id_visita, String tipo_visita, int contratos, int documentacion, int finiquitos, String comentarios_documentacion, int instalacion, int banios, int comedores, String comentarios_faena, int seguridad, int peligros, String comentarios_seguridad, String comentarios_propuesta, String nombre_sucursal, String nombre_calle, String numero, String nombre_comuna, String nombre_region) {
        this.id_usuario = id_usuario;
        this.nombre_apellido = nombre_apellido;
        this.id_actividad = id_actividad;
        this.fecha_act = fecha_act;
        this.hora_act = hora_act;
        this.id_visita = id_visita;
        this.tipo_visita = tipo_visita;
        this.contratos = contratos;
        this.documentacion = documentacion;
        this.finiquitos = finiquitos;
        this.comentarios_documentacion = comentarios_documentacion;
        this.instalacion = instalacion;
        this.banios = banios;
        this.comedores = comedores;
        this.comentarios_faena = comentarios_faena;
        this.seguridad = seguridad;
        this.peligros = peligros;
        this.comentarios_seguridad = comentarios_seguridad;
        this.comentarios_propuesta = comentarios_propuesta;
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

    public int getId_visita() {
        return id_visita;
    }

    public void setId_visita(int id_visita) {
        this.id_visita = id_visita;
    }

    public String getTipo_visita() {
        return tipo_visita;
    }

    public void setTipo_visita(String tipo_visita) {
        this.tipo_visita = tipo_visita;
    }

    public int getContratos() {
        return contratos;
    }

    public void setContratos(int contratos) {
        this.contratos = contratos;
    }

    public int getDocumentacion() {
        return documentacion;
    }

    public void setDocumentacion(int documentacion) {
        this.documentacion = documentacion;
    }

    public int getFiniquitos() {
        return finiquitos;
    }

    public void setFiniquitos(int finiquitos) {
        this.finiquitos = finiquitos;
    }

    public String getComentarios_documentacion() {
        return comentarios_documentacion;
    }

    public void setComentarios_documentacion(String comentarios_documentacion) {
        this.comentarios_documentacion = comentarios_documentacion;
    }

    public int getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(int instalacion) {
        this.instalacion = instalacion;
    }

    public int getBanios() {
        return banios;
    }

    public void setBanios(int banios) {
        this.banios = banios;
    }

    public int getComedores() {
        return comedores;
    }

    public void setComedores(int comedores) {
        this.comedores = comedores;
    }

    public String getComentarios_faena() {
        return comentarios_faena;
    }

    public void setComentarios_faena(String comentarios_faena) {
        this.comentarios_faena = comentarios_faena;
    }

    public int getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(int seguridad) {
        this.seguridad = seguridad;
    }

    public int getPeligros() {
        return peligros;
    }

    public void setPeligros(int peligros) {
        this.peligros = peligros;
    }

    public String getComentarios_seguridad() {
        return comentarios_seguridad;
    }

    public void setComentarios_seguridad(String comentarios_seguridad) {
        this.comentarios_seguridad = comentarios_seguridad;
    }

    public String getComentarios_propuesta() {
        return comentarios_propuesta;
    }

    public void setComentarios_propuesta(String comentarios_propuesta) {
        this.comentarios_propuesta = comentarios_propuesta;
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
