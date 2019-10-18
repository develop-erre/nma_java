/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.dao;

import cl.nma.dominio.Sucursal;
import java.util.List;

/**
 *
 * @author Richard Foncea
 */
public interface SucursalDAO {
    
    int actualizar(Sucursal suc);
    
    int agregar(Sucursal suc);

    int eliminar(Integer idsuc);

    List<Sucursal> listarEmpresa();
    
    List<Sucursal> obtenerSucursalPorId(Integer id);
    
}
