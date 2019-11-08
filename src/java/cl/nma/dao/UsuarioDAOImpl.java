/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.dao;

import cl.nma.database.DBUtil;
import cl.nma.dominio.Usuario;
import java.sql.Connection;
import java.sql.Date;
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
        String sql = "UPDATE USUARIO \n"
                + "SET NOMBRE = ? \n"
                + ",APELLIDOS = ? \n"
                + ",RUT= ? \n"
                + ",DIRECCION= ? \n"
                + ",FECHA_NACIMIENTO= ? \n"
                + ",EMAIL= ?\n"
                + ",TELEFONO= ?\n"
                + ",ID_COMUNA_US_FK= ? WHERE ID_USUARIO= ?";
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement(sql);
            pst.setString(1, us.getNombre());
            pst.setString(2, us.getApellidos());
            pst.setString(3, us.getRut());
            pst.setString(4, us.getDireccion());
            pst.setDate(5, castDateDAOImpl(us.getFecha_nac()));
            pst.setString(6, us.getEmail());
            pst.setString(7, us.getTelefono());
            pst.setInt(8, us.getId_comuna_us_fk());
            pst.setInt(9, us.getId_usuario());
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
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
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;

    }

    @Override
    public int agregar(Usuario us) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Integer idus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listarUsuario() {

        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO";
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
                usurio.setDireccion(rs.getString(6));
                usurio.setFecha_nac(rs.getDate(7));
                usurio.setEmail(rs.getString(8));
                usurio.setTelefono(rs.getString(9));
                usurio.setEstado(rs.getInt(10));
                usurio.setId_comuna_us_fk(rs.getInt(11));
                usurio.setId_rol_fk(rs.getInt(12));
                usurio.setId_empresa_fk(rs.getInt(13));

                usuarios.add(usurio);
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
        return usuarios;
    }

    public boolean verificarUserSession(String us, String pass) {

        boolean bandera = false;
        Usuario usuario;
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO  WHERE rut='" + us + "' and password = '" + pass + "' ;";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setRut(rs.getString(4));
                usuario.setPassword(rs.getString(5));
                usuarios.add(usuario);
            }

            for (Usuario var : usuarios) {

                if (var.getRut().toString().equals(us) && var.getPassword().toString().equals(pass)) {
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
        return bandera;
    }

    @Override
    public Boolean verificarUser(String us, String pass) {

        boolean bandera = false;
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO";
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
                usuario.setId_empresa_fk(rs.getInt(13));
                usuarios.add(usuario);
            }

            for (Usuario var : usuarios) {

                if (var.getRut().toString().equals(us) && var.getPassword().toString().equals(pass) && var.getEstado() == 0) {
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
        return bandera;
    }

    @Override
    public int agregarUsuarioEmpresa(Usuario usuario) {

        int id = 0;
        String sql = "INSERT INTO USUARIO(NOMBRE, APELLIDOS,"
                + "RUT,PASSWORD, DIRECCION,FECHA_NACIMIENTO,EMAIL,TELEFONO,ESTADO,"
                + "ID_COMUNA_US_FK, ID_ROL_FK,ID_EMPRESA_FK) VALUES("
                + "?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pst;
        try {
            pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getApellidos());
            pst.setString(3, usuario.getRut());
            pst.setString(4, usuario.getPassword());
            pst.setString(5, usuario.getDireccion());
            pst.setDate(6, castDateDAOImpl(usuario.getFecha_nac()));
            pst.setString(7, usuario.getEmail());
            pst.setString(8, usuario.getTelefono());
            pst.setInt(9, usuario.getEstado());
            pst.setInt(10, usuario.getId_comuna_us_fk());
            pst.setInt(11, usuario.getId_rol_fk());
            pst.setInt(12, usuario.getId_empresa_fk());
            int result = pst.executeUpdate();

            if (result == 0) {
                throw new SQLException("No fue posible insertar el registro");
            }

            ResultSet rs = pst.getGeneratedKeys();
            while (rs.next()) {
                id = rs.getInt(1); //devuelve la clave autogenerada por la BD
                System.out.println("ID GENERADO:" + id);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfesionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;

    }

    @Override
    public Usuario obtenerUsuario(String us, String pass) {

        Usuario usuario = new Usuario();
        String sql = "SELECT * FROM USUARIO  WHERE rut='" + us + "' and password = '" + pass + "' ;";
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
                usuario.setPassword(rs.getString(5));
                usuario.setEstado(rs.getInt(10));
                usuario.setId_rol_fk(rs.getInt(12));
                usuario.setId_empresa_fk(rs.getInt(13));
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
        String sql = "SELECT * FROM USUARIO WHERE ID_USUARIO =" + id;
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
                usuario.setDireccion(rs.getString(6));
                usuario.setFecha_nac(rs.getDate(7));
                usuario.setEmail(rs.getString(8));
                usuario.setTelefono(rs.getString(9));
                usuario.setId_comuna_us_fk(rs.getInt(11));
                usuario.setId_rol_fk(rs.getInt(12));
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
}
