/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.dao;

import cl.nma.dominio.ListaReporteAccidente;
import cl.nma.dominio.ReporteAccidente;
import java.util.List;

/**
 *
 * @author Richard Foncea
 */
public interface ReporteAccidenteDAO {
    
    int actualizar(ReporteAccidente ra);
    
    int agregar(ReporteAccidente ra);

    int eliminar(Integer ra);

    List<ReporteAccidente> listarReporteAccidentes();
    
    List<ListaReporteAccidente> listarReporteAccidentesVerAdmin(int idEmpresa);
    
    ReporteAccidente obtenerReporteAccidentePorId(Integer id);
    
}
