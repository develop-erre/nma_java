package cl.nma.dominio;

public class RegionComuna {
    
    private int id_comuna;
    private String nombre_comuna;

    public RegionComuna() {
    }

    public RegionComuna(int id_comuna, String nombre_comuna) {
        this.id_comuna = id_comuna;
        this.nombre_comuna = nombre_comuna;
    }

    public int getId_comuna() {
        return id_comuna;
    }

    public void setId_comuna(int id_comuna) {
        this.id_comuna = id_comuna;
    }

    public String getNombre_comuna() {
        return nombre_comuna;
    }

    public void setNombre_comuna(String nombre_comuna) {
        this.nombre_comuna = nombre_comuna;
    }
    
    
}
