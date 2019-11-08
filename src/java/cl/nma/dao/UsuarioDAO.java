/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.dao;

import cl.nma.dominio.Usuario;
import java.util.List;

/**
 *
 * @author Richard Foncea
 */
public interface UsuarioDAO {
    
    int actualizar(Usuario usuario);
    
    Usuario buscarUsuarioPorId(int id);
    
    int agregar(Usuario usuario);
    
    int agregarUsuarioEmpresa(Usuario usuario);
    
    int agregarProfesional(Usuario usuario);
    
    int deshabilitarProfesional(int id);

    int eliminar(Integer idusuario);
    
    int habilitar(Integer idusuario);
    
    List<Usuario> listarProfesionalHabilitado();
    
    List<Usuario> listarProfesionalDeshabilitado();

    List<Usuario> listarUsuario();
    
    Boolean verificarUser(String us, String pass);
    
    Usuario  obtenerUsuario(String us, String pass);
    
}
