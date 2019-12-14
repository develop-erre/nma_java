/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.dao;

import cl.nma.database.DBUtil;
import cl.nma.dominio.Usuario;
import cl.nma.dominio.UsuarioLista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Richard Foncea
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    Connection conexion;

    public UsuarioDAOImpl() throws SQLException {
        DBUtil db = new DBUtil();
        conexion = db.obtenerConexion();
    }

    @Override
    public int actualizar(Usuario us) {

        int result = 0;
        String sql = "update usuario \n"
                + "set nombre = ? \n"
                + ",apellidos = ? \n"
                + ",rut= ? \n"
                + ",fecha_nacimiento= ? \n"
                + ",email= ?\n"
                + ",telefono= ?\n"
                + " where id_usuario= ?";
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement(sql);
            pst.setString(1, us.getNombre());
            pst.setString(2, us.getApellidos());
            pst.setString(3, us.getRut());
            pst.setDate(4, castDateDAOImpl(us.getFecha_nac()));
            pst.setString(5, us.getEmail());
            pst.setString(6, us.getTelefono());
            pst.setInt(7, us.getId_usuario());
            result = pst.executeUpdate();
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //siempre cerrar la conexion y el pst
            try {
                if (pst != null) {
                    pst.close();
                    System.out.println("PreparedStatement cerrada");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (conexion != null) {
                    conexion.close();
                    System.out.println("Conexion cerrada");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;

    }

    @Override
    public List<Usuario> listarUsuario() {

        List<Usuario> usuarios = new ArrayList<>();
        String sql = "select * from usuario";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            Usuario usurio;
            while (rs.next()) {
                usurio = new Usuario();
                usurio.setId_usuario(rs.getInt(1));
                usurio.setNombre(rs.getString(2));
                usurio.setApellidos(rs.getString(3));
                usurio.setRut(rs.getString(4));
                usurio.setPassword(rs.getString(5));
                usurio.setId_direccion_fk(rs.getInt(6));
                usurio.setFecha_nac(rs.getDate(7));
                usurio.setEmail(rs.getString(8));
                usurio.setTelefono(rs.getString(9));
                usurio.setEstado(rs.getInt(10));
                usurio.setId_rol_fk(rs.getInt(11));
                usurio.setId_sucursal_fk(rs.getInt(12));

                usuarios.add(usurio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //siempre cerrar la conexion, rs y el pst
            try {
                if (pst != null) {
                    pst.close();
                    System.out.println("PreparedStatement cerrada");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (rs != null) {
                    rs.close();
                    System.out.println("ResultSet cerrada");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (conexion != null) {
                    conexion.close();
                    System.out.println("Conexion cerrada");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return usuarios;
    }

    public boolean verificarUserSession(String us, String pass) {

        boolean bandera = false;
        Usuario usuario;
//        List<Usuario> usuarios = new ArrayList<>();
        String sql = "select * from usuario  where rut='" + us + "' and password = '" + pass + "' ;";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setRut(rs.getString(4));
                usuario.setPassword(rs.getString(5));
                if (usuario.getRut().equals(us) && usuario.getPassword().equals(pass)) {
                    bandera = true;
                }
//                usuarios.add(usuario);
            }

//            for (Usuario var : usuarios) {
//
//                if (var.getRut().equals(us) && var.getPassword().equals(pass)) {
//                    bandera = true;
//                }
//            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //siempre cerrar la conexion, rs y el pst
            try {
                if (pst != null) {
                    pst.close();
                    System.out.println("PreparedStatement cerrada");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (rs != null) {
                    rs.close();
                    System.out.println("Rseultset cerrada");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (conexion != null) {
                    conexion.close();
                    System.out.println("Conexion cerrada");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bandera;
    }

    @Override
    public Boolean verificarUser(String us, String pass) {

        boolean bandera = false;
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "select * from usuario";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            Usuario usuario;
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setId_usuario(rs.getInt(1));
                usuario.setRut(rs.getString(4));
                usuario.setPassword(rs.getString(5));
                usuario.setEstado(rs.getByte(10));
                usuario.setId_rol_fk(rs.getInt(12));
                usuario.setId_sucursal_fk(rs.getInt(13));
                usuarios.add(usuario);
            }

            for (Usuario var : usuarios) {

                if (var.getRut().equals(us) && var.getPassword().equals(pass) && var.getEstado() == 0) {
                    bandera = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //siempre cerrar la conexion, rs y el pst
            try {
                if (pst != null) {
                    pst.close();
                    System.out.println("PreparedStatement cerrada");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (rs != null) {
                    rs.close();
                    System.out.println("Resultset cerrada");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (conexion != null) {
                    conexion.close();
                    System.out.println("Conexion cerrada");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bandera;
    }

    @Override
    public int agregarUsuarioEmpresa(Usuario usuario) {

        int id = 0;
        String sql = "insert into usuario(nombre,apellidos,rut,password,id_direccion_fk,fecha_nacimiento,email,telefono,estado,"
                + "id_rol_fk,id_sucursal_fk) values(?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getApellidos());
            pst.setString(3, usuario.getRut());
            pst.setString(4, usuario.getPassword());
            pst.setInt(5, usuario.getId_direccion_fk());
            pst.setDate(6, castDateDAOImpl(usuario.getFecha_nac()));
            pst.setString(7, usuario.getEmail());
            pst.setString(8, usuario.getTelefono());
            pst.setInt(9, usuario.getEstado());
            pst.setInt(10, usuario.getId_rol_fk());
            pst.setInt(11, usuario.getId_sucursal_fk());
            int result = pst.executeUpdate();

            if (result == 0) {
                throw new SQLException("No fue posible insertar el registro");
            }

            rs = pst.getGeneratedKeys();
            while (rs.next()) {
                id = rs.getInt(1); //devuelve la clave autogenerada por la BD
                System.out.println("ID GENERADO:" + id);
            }

        } catch (SQLException | ParseException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //siempre cerrar la conexion, rs y el pst
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return id;

    }

    @Override
    public UsuarioLista obtenerUsuario(String us, String pass) {

        UsuarioLista usuario = new UsuarioLista();
        String sql = "select \n"
                + "    usuario.id_usuario,\n"
                + "    usuario.nombre,\n"
                + "    usuario.apellidos,\n"
                + "    usuario.rut,\n"
                + "    usuario.estado,\n"
                + "    usuario.id_rol_fk,\n"
                + "    usuario.id_sucursal_fk,\n"
                + "    sucursal.nombre as nombre_sucursal\n"
                + "from usuario \n"
                + "left join sucursal on sucursal.id_sucursal = usuario.id_sucursal_fk\n"
                + "where usuario.rut='" + us + "' and usuario.password = '" + pass + "' ;";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                usuario.setId_usuario(rs.getString(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApellidos(rs.getString(3));
                usuario.setRut(rs.getString(4));
                usuario.setEstado(rs.getString(5));
                usuario.setEstado(rs.getString(5));
                usuario.setId_rol_fk(rs.getString(6));
                usuario.setId_sucursal_fk(rs.getString(7));
                usuario.setNombre_sucursal(rs.getString(8));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //siempre cerrar la conexion, rs y el pst
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return usuario;

    }

    public java.sql.Date castDateDAOImpl(java.util.Date date) throws ParseException {

        java.util.Date fech = date;
        java.sql.Date sDate = new java.sql.Date(fech.getTime());
        return sDate;
    }

    @Override
    public Usuario buscarUsuarioPorId(int id) {

        Usuario usuario = new Usuario();
        String sql = "select * from usuario where id_usuario =" + id;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                usuario.setId_usuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApellidos(rs.getString(3));
                usuario.setRut(rs.getString(4));
                usuario.setId_direccion_fk(rs.getInt(6));
                usuario.setFecha_nac(rs.getDate(7));
                usuario.setEmail(rs.getString(8));
                usuario.setTelefono(rs.getString(9));
                usuario.setEstado(rs.getInt(10));
                usuario.setId_rol_fk(rs.getInt(11));
                usuario.setId_sucursal_fk(rs.getInt(12));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //siempre cerrar la conexion, rs y el pst
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (conexion != null) {
                    conexion.close();
                    System.out.println("Conexion cerrada");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }

    @Override
    public int agregarProfesional(Usuario usuario) {

        int id = 0;
        String sql = "insert into usuario(nombre, apellidos,rut,password,id_direccion_fk,fecha_nacimiento,email,telefono,estado,"
                + "id_rol_fk) values(?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getApellidos());
            pst.setString(3, usuario.getRut());
            pst.setString(4, usuario.getPassword());
            pst.setInt(5, usuario.getId_direccion_fk());
            pst.setDate(6, castDateDAOImpl(usuario.getFecha_nac()));
            pst.setString(7, usuario.getEmail());
            pst.setString(8, usuario.getTelefono());
            pst.setInt(9, usuario.getEstado());
            pst.setInt(10, usuario.getId_rol_fk());
            int result = pst.executeUpdate();

            if (result == 0) {
                throw new SQLException("No fue posible insertar el registro");
            }

            rs = pst.getGeneratedKeys();
            while (rs.next()) {
                id = rs.getInt(1); //devuelve la clave autogenerada por la BD
                System.out.println("ID GENERADO:" + id);
            }

        } catch (SQLException | ParseException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //siempre cerrar la conexion, rs y el pst
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (conexion != null) {
                    conexion.close();
                    System.out.println("Conexion cerrada");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return id;

    }

    @Override
    public int deshabilitarProfesional(int id) {

        int result = 0;
        String sql = "update usuario set estado = 1 where id_usuario = ?";
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement(sql);
            pst.setInt(1, id);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //siempre cerrar la conexion y el pst
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (conexion != null) {
                    conexion.close();
                    System.out.println("Conexion cerrada");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;

    }

    @Override
    public List<UsuarioLista> listarProfesionalHabilitado() {

        List<UsuarioLista> lista = new ArrayList<>();

        String sql = "select * from vista_lista_usuarios";

        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();

            UsuarioLista pf = null;

            while (rs.next()) {
                pf = new UsuarioLista();
                pf.setId_usuario(rs.getString(1));
                pf.setNombre(rs.getString(2));
                pf.setApellidos(rs.getString(3));
                pf.setRut(rs.getString(4));
                pf.setFecha_nacimiento(rs.getString(5));
                pf.setEmail(rs.getString(6));
                pf.setTelefono(rs.getString(7));
                pf.setNombre_calle(rs.getString(8));
                pf.setNumero(rs.getString(9));
                pf.setDepto(rs.getString(10));
                pf.setComuna(rs.getString(11));
                pf.setRegion(rs.getString(12));
                pf.setId_rol_fk(rs.getString(13));
                pf.setId_sucursal_fk(rs.getString(14));
                pf.setId_direccion_fk(rs.getString(15));
                lista.add(pf);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //siempre cerrar la conexion, rs y el pst
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (conexion != null) {
                    conexion.close();
                    System.out.println("Conexion cerrada");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lista;
    }

    @Override
    public List<UsuarioLista> listarProfesionalDeshabilitado() {

        List<UsuarioLista> lista = new ArrayList<>();

        String sql = "select * from vista_lista_usuarios_deshabilitado";
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();

            UsuarioLista pf = null;

            while (rs.next()) {
                pf = new UsuarioLista();
                pf.setId_usuario(rs.getString(1));
                pf.setNombre(rs.getString(2));
                pf.setApellidos(rs.getString(3));
                pf.setRut(rs.getString(4));
                pf.setFecha_nacimiento(rs.getString(5));
                pf.setEmail(rs.getString(6));
                pf.setTelefono(rs.getString(7));
                pf.setNombre_calle(rs.getString(8));
                pf.setNumero(rs.getString(9));
                pf.setDepto(rs.getString(10));
                pf.setComuna(rs.getString(11));
                pf.setRegion(rs.getString(12));
                pf.setId_rol_fk(rs.getString(13));
                pf.setId_sucursal_fk(rs.getString(14));
                pf.setId_direccion_fk(rs.getString(15));
                lista.add(pf);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //siempre cerrar la conexion, rs y el pst
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (conexion != null) {
                    conexion.close();
                    System.out.println("Conexion cerrada");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lista;

    }

    @Override
    public int habilitar(Integer idusuario) {

        int result = 0;
        String sql = "update usuario set estado = 0 where id_usuario = ?";
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement(sql);
            pst.setInt(1, idusuario);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //siempre cerrar la conexion y el pst
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (conexion != null) {
                    conexion.close();
                    System.out.println("Conexion cerrada");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;

    }

    @Override
    public UsuarioLista traeUsuarioPorId(int idUsuario) {

        String sql = " CALL GetUsuarioListaActualizar(" + idUsuario + ")";

        PreparedStatement pst = null;
        ResultSet rs = null;
        UsuarioLista usuario = null;
        try {
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                usuario = new UsuarioLista();
                usuario.setId_usuario(rs.getString(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApellidos(rs.getString(3));
                usuario.setRut(rs.getString(4));
                usuario.setFecha_nacimiento(rs.getString(5));
                usuario.setEmail(rs.getString(6));
                usuario.setTelefono(rs.getString(7));
                usuario.setNombre_calle(rs.getString(8));
                usuario.setNumero(rs.getString(9));
                usuario.setDepto(rs.getString(10));
                usuario.setComuna(rs.getString(11));
                usuario.setRegion(rs.getString(12));
                usuario.setId_rol_fk(rs.getString(13));
                usuario.setId_sucursal_fk(rs.getString(14));
                usuario.setId_direccion_fk(rs.getString(15));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //siempre cerrar la conexion, rs y el pst
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (conexion != null) {
                    conexion.close();
                    System.out.println("Conexion cerrada");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return usuario;

    }
}
