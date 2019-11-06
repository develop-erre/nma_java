package cl.nma.dao;

import cl.nma.dominio.Asesoria;
import java.util.List;

public interface AsesoriaDAO {

    int actualizar(Asesoria as);
    
    int EstadoAsesoriaAsignado(int idAsesoria);
    
    int finalizarAsesoria(Asesoria as);

    int agregar(Asesoria as);

    int eliminar(Integer as);

    List<Asesoria> listarActividad();

    Asesoria obtenerAsesoriaPorId(Integer id);

}
