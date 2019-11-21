package cl.nma.dao;

import cl.nma.dominio.Actividad;
import cl.nma.dominio.ActividadAsesoria;
import cl.nma.dominio.ActividadAsesoriaGetAll;
import cl.nma.dominio.ActividadCapacitacionGettAll;
import cl.nma.dominio.ActividadVisita;
import java.util.List;


public interface ActividadDAO {
    
    int actualizar(Actividad act);
    
    int finalizarActividad(int idActividad);
    
    int agregar(Actividad act);
    
    int agregarAsesoria(Actividad act);

    int eliminar(Integer act);

    List<Actividad> listarActividad();
    
    Actividad obtenerActividadPorId(Integer id);
    
    List<ActividadAsesoria> listarSolicitudAsesoria();
    
    int asignarAsesoria(Actividad act);
    
    List<ActividadAsesoriaGetAll> listarSolicitudAsesoriaGetAll(int idProfesional);
    
    List<ActividadAsesoriaGetAll> listarAsesoriasFinalizadasGetAll(int idEmpresa);
    
    List<ActividadVisita> listarVisitasFinalizadasGetAll(int idSucursal);
    
    List<ActividadCapacitacionGettAll> listarCapacitacionGetAll(int idUsuario);
    
    List<ActividadVisita> listarActividadVisitaGetAllProfesional(int idUsuario);
    
}