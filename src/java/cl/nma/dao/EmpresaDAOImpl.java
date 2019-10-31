/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.dao;

import cl.nma.database.DBUtil;
import cl.nma.dominio.Empresa;
import cl.nma.dominio.EmpresaLista;
import cl.nma.dominio.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Richard Foncea
 */
public class EmpresaDAOImpl implements EmpresaDAO{
    
    Connection conexion;

    public EmpresaDAOImpl() throws SQLException {
        DBUtil db = new DBUtil();
        conexion = db.obtenerConexion();

    }

    @Override
    public int actualizar(Empresa em) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int agregar(Empresa em) {
        
        int id = 0;
        String sql = "INSERT INTO EMPRESA(NOMBRE, RUT,"
                + "SITIO_WEB,TELEFONO, ESTADO,ID_RUBRO_FK)"
                + "VALUES("
                + "?,?,?,?,?,?)";
        
        PreparedStatement pst;
        try {
            pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, em.getNombre());
            pst.setString(2, em.getRut());
            pst.setString(3, em.getSitio_web());
            pst.setString(4, em.getTelefono());
            pst.setInt(5, em.getEstado());
            pst.setInt(6, em.getId_rubro_fk());
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
        }
        return id;
        
    }

    @Override
    public int eliminar(Integer idem) {
        
        int result = 0;
        String sql = "UPDATE EMPRESA SET ESTADO = 1 WHERE ID_EMPRESA = ?";
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement(sql);
            pst.setInt(1, idem);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public List<Empresa> listarEmpresa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empresa obtenerEmpresaPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EmpresaLista> listarEmpresaLista() {
        
        List<EmpresaLista> emList = new ArrayList<>();
        String sql = "SELECT * FROM VISTA_LISTA_EMPRESAS";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            EmpresaLista el;
            while (rs.next()) {
                el = new EmpresaLista();
                el.setId_empresa(Integer.parseInt(rs.getString(1)));
                el.setNombre(rs.getString(2));
                el.setRut(rs.getString(3));
                el.setNombre_suc(rs.getString(4));
                el.setDireccion(rs.getString(5));
                emList.add(el);
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
        return emList;
    }
    
}
