package cl.nma.dao;

import cl.nma.dominio.Capacitacion;
import java.util.List;

public interface CapacitacionDAO {
    
     int actualizar(Capacitacion cap);
    
    int agregar(Capacitacion cap);

    int eliminar(Integer cap);

    List<Capacitacion> listarCapacitacion();
    
    Capacitacion obtenerCapacitacionPorId(Integer id);
}
