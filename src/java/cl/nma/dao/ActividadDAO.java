package cl.nma.dao;

import cl.nma.dominio.Actividad;
import java.util.List;


public interface ActividadDAO {
    
    int actualizar(Actividad act);
    
    int agregar(Actividad act);

    int eliminar(Integer act);

    List<Actividad> listarActividad();
    
    Actividad obtenerActividadPorId(Integer id);
}