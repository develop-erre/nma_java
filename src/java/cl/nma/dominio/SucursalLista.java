

package cl.nma.dominio;

public class SucursalLista {

    private String id_sucursal; 
    private String nombre_sucursal;
    private String direccion_sucural;

    public SucursalLista() {
    }

    public SucursalLista(String id_sucursal, String nombre_sucursal, String direccion_sucural) {
        this.id_sucursal = id_sucursal;
        this.nombre_sucursal = nombre_sucursal;
        this.direccion_sucural = direccion_sucural;
    }

    public String getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(String id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getNombre_sucursal() {
        return nombre_sucursal;
    }

    public void setNombre_sucursal(String nombre_sucursal) {
        this.nombre_sucursal = nombre_sucursal;
    }

    public String getDireccion_sucural() {
        return direccion_sucural;
    }

    public void setDireccion_sucural(String direccion_sucural) {
        this.direccion_sucural = direccion_sucural;
    }
    
    
}
