package cl.nma.dao;

import cl.nma.dominio.Direccion;
import java.util.List;

public interface DireccionDAO {

    int actualizar(Direccion dir);

    int agregar(Direccion dir);

    int eliminar(Integer id);

    List<Direccion> listarDireccion();

}
