package cl.nma.dominio;

public class ActividadAsesoria {
    
    private int id_actividad;
    private int id_asesoria;
    private int id_sucursal;
    private String nombre;
    private String descripcion;

    public ActividadAsesoria() {
    }

    public ActividadAsesoria(int id_actividad, int id_asesoria, int id_sucursal, String nombre, String descripcion) {
        this.id_actividad = id_actividad;
        this.id_asesoria = id_asesoria;
        this.id_sucursal = id_sucursal;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public int getId_asesoria() {
        return id_asesoria;
    }

    public void setId_asesoria(int id_asesoria) {
        this.id_asesoria = id_asesoria;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
