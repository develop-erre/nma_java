package cl.nma.dominio;

public class Capacitacion {

    private int id_capacitacion;
    private int numero_asistente;
    private int id_tipo_capacitacion_fk;
    private int id_actividad_fk_tc;

    public Capacitacion() {
    }

    public Capacitacion(int id_capacitacion, int numero_asistente, int id_tipo_capacitacion_fk, int id_actividad_fk_tc) {
        this.id_capacitacion = id_capacitacion;
        this.numero_asistente = numero_asistente;
        this.id_tipo_capacitacion_fk = id_tipo_capacitacion_fk;
        this.id_actividad_fk_tc = id_actividad_fk_tc;
    }

    public int getId_capacitacion() {
        return id_capacitacion;
    }

    public void setId_capacitacion(int id_capacitacion) {
        this.id_capacitacion = id_capacitacion;
    }

    public int getNumero_asistente() {
        return numero_asistente;
    }

    public void setNumero_asistente(int numero_asistente) {
        this.numero_asistente = numero_asistente;
    }

    public int getId_tipo_capacitacion_fk() {
        return id_tipo_capacitacion_fk;
    }

    public void setId_tipo_capacitacion_fk(int id_tipo_capacitacion_fk) {
        this.id_tipo_capacitacion_fk = id_tipo_capacitacion_fk;
    }

    public int getId_actividad_fk_tc() {
        return id_actividad_fk_tc;
    }

    public void setId_actividad_fk_tc(int id_actividad_fk_tc) {
        this.id_actividad_fk_tc = id_actividad_fk_tc;
    }

    @Override
    public String toString() {
        return "Capacitacion{" + "id_capacitacion=" + id_capacitacion + ", numero_asistente=" + numero_asistente + ", id_tipo_capacitacion_fk=" + id_tipo_capacitacion_fk + ", id_actividad_fk_tc=" + id_actividad_fk_tc + '}';
    }
    
}
