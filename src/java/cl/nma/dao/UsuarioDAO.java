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
    
    int agregar(Usuario usuario);
    
    int agregarUsuarioEmpresa(Usuario usuario);

    int eliminar(Integer idusuario);

    List<Usuario> listarUsuario();

    List<Usuario> buscarAlumnoPorApellido(String apellido);
    
    Usuario obtenerAlumnoPorId(Integer id);
    
    Boolean verificarUser(String us, String pass);
    
    Usuario  obtenerUsuario(String us, String pass);
    
}
