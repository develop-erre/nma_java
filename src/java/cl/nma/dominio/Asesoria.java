package cl.nma.dominio;

public class Asesoria {
    
    private int id_asesoria;
    private String comentarios_detectados; 
    private String comentarios_propuesta; 
    private int id_tipo_asesoria_fk;
    private int id_actividades_fk_as;

    public Asesoria() {
    }

    public Asesoria(int id_asesoria, String comentarios_detectados, String comentarios_propuesta, int id_tipo_asesoria_fk, int id_actividades_fk_as) {
        this.id_asesoria = id_asesoria;
        this.comentarios_detectados = comentarios_detectados;
        this.comentarios_propuesta = comentarios_propuesta;
        this.id_tipo_asesoria_fk = id_tipo_asesoria_fk;
        this.id_actividades_fk_as = id_actividades_fk_as;
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

    public int getId_tipo_asesoria_fk() {
        return id_tipo_asesoria_fk;
    }

    public void setId_tipo_asesoria_fk(int id_tipo_asesoria_fk) {
        this.id_tipo_asesoria_fk = id_tipo_asesoria_fk;
    }

    public int getId_actividades_fk_as() {
        return id_actividades_fk_as;
    }

    public void setId_actividades_fk_as(int id_actividades_fk_as) {
        this.id_actividades_fk_as = id_actividades_fk_as;
    }

    @Override
    public String toString() {
        return "Asesoria{" + "id_asesoria=" + id_asesoria + ", comentarios_detectados=" + comentarios_detectados + ", comentarios_propuesta=" + comentarios_propuesta + ", id_tipo_asesoria_fk=" + id_tipo_asesoria_fk + ", id_actividades_fk_as=" + id_actividades_fk_as + '}';
    }
    
    
}
