/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.dao;

import cl.nma.dominio.Contrato;
import java.util.List;

/**
 *
 * @author Richard Foncea
 */
public interface ContratoDAO {
    
    int actualizar(Contrato con);
    
    int agregar(Contrato con);

    int eliminar(Integer con);

    List<Contrato> listarContrato();
    
    Contrato obtenerContratoPorId(Integer id);
    
    
}
