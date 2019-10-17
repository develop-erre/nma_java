package cl.nma.dao;

import cl.nma.dominio.Empresa;
import cl.nma.dominio.EmpresaLista;
import java.util.List;

public interface EmpresaDAO {
    
    int actualizar(Empresa em);
    
    int agregar(Empresa em);

    int eliminar(Integer idem);

    List<Empresa> listarEmpresa();
    
    List<EmpresaLista> listarEmpresaLista();
    
    Empresa obtenerEmpresaPorId(Integer id);
}
