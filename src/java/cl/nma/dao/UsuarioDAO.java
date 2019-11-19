/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.dao;

import cl.nma.dominio.Usuario;
import cl.nma.dominio.UsuarioLista;
import java.util.List;

/**
 *
 * @author Richard Foncea
 */
public interface UsuarioDAO {
    
    int actualizar(Usuario usuario);
    
    Usuario buscarUsuarioPorId(int id);
    
    int agregarUsuarioEmpresa(Usuario usuario);
    
    int agregarProfesional(Usuario usuario);
    
    int deshabilitarProfesional(int id);

    int habilitar(Integer idusuario);
    
    List<UsuarioLista> listarProfesionalHabilitado();
    
    List<UsuarioLista> listarProfesionalDeshabilitado();
    
    UsuarioLista traeUsuarioPorId(int idUsuario);

    List<Usuario> listarUsuario();
    
    Boolean verificarUser(String us, String pass);
    
    UsuarioLista  obtenerUsuario(String us, String pass);
    
}
