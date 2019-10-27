package cl.nma.dao;

import cl.nma.dominio.Visita;
import java.util.List;

public interface VisitaDAO {

    int actualizar(Visita vis);

    int agregar(Visita vis);

    int eliminar(Integer vis);

    List<Visita> listarVisita();

    Visita obtenerVisitaPorId(Integer id);

}
