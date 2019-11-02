/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.dao;

import cl.nma.dominio.Profesional;
import java.util.List;

/**
 *
 * @author Richard Foncea
 */
public interface ProfesionalDAO {
    
    int actualizar(Profesional prof);
    
    int agregar(Profesional prof);

    int eliminar(Integer idprof);
    
    int habilitar(Integer idprof);

    List<Profesional> listarProfesional();
    
    List<Profesional> listarProfesionalHabilitados();
    List<Profesional> listarProfesionalDesabilitados();
    
    Profesional obtenerProfesionalPorId(Integer id);
    
}
