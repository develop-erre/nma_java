package cl.nma.dominio;

public class Visita {

    private int id_visita;
    private int id_tipo_visita_fk;
    private int id_actividad_fk_v;
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

    public Visita() {
    }

    public Visita(int id_visita, int id_tipo_visita_fk, int id_actividad_fk_v, int contratos, int documentacion, int finiquitos, String comentarios_documentacion, int instalacion, int banios, int comedores, String comentarios_faena, int seguridad, int peligros, String comentarios_seguridad, String comentarios_propuesta) {
        this.id_visita = id_visita;
        this.id_tipo_visita_fk = id_tipo_visita_fk;
        this.id_actividad_fk_v = id_actividad_fk_v;
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
    }

    public int getId_visita() {
        return id_visita;
    }

    public void setId_visita(int id_visita) {
        this.id_visita = id_visita;
    }

    public int getId_tipo_visita_fk() {
        return id_tipo_visita_fk;
    }

    public void setId_tipo_visita_fk(int id_tipo_visita_fk) {
        this.id_tipo_visita_fk = id_tipo_visita_fk;
    }

    public int getId_actividad_fk_v() {
        return id_actividad_fk_v;
    }

    public void setId_actividad_fk_v(int id_actividad_fk_v) {
        this.id_actividad_fk_v = id_actividad_fk_v;
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
    
    
}
