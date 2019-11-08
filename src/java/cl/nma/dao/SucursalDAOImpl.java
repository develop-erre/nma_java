/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.dao;

import cl.nma.database.DBUtil;
import cl.nma.dominio.Sucursal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Richard Foncea
 */
public class SucursalDAOImpl implements SucursalDAO {

    Connection conexion;

    public SucursalDAOImpl() throws SQLException {
        DBUtil db = new DBUtil();
        conexion = db.obtenerConexion();
    }

    @Override
    public int actualizar(Sucursal suc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int agregar(Sucursal suc) {

        int id = 0;
        String sql = "INSERT INTO SUCURSAL(NOMBRE, DIRECCION,"
                + "ID_EMPRESA_FK,ID_COMUNA_SUC_FK)"
                + "VALUES("
                + "?,?,?,?)";

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, suc.getNombre());
            pst.setString(2, suc.getDireccion());
            pst.setInt(3, suc.getId_empresa_fk());
            pst.setInt(4, suc.getId_comuna_suc_fk());
            int result = pst.executeUpdate();

            if (result == 0) {
                throw new SQLException("No fue posible insertar el registro");
            }

            rs = pst.getGeneratedKeys();
            while (rs.next()) {
                id = rs.getInt(1); //devuelve la clave autogenerada por la BD
                System.out.println("ID GENERADO:" + id);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public int eliminar(Integer idsuc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sucursal> listarEmpresa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sucursal> obtenerSucursalPorId(Integer id) {

        List<Sucursal> sucList = new ArrayList<>();
        String sql = "SELECT sucursal.id_sucursal\n"
                + ",sucursal.nombre\n"
                + ",CONCAT( sucursal.direccion,\" - \",comuna.nombre_comuna ) AS direccion\n"
                + "FROM SUCURSAL \n"
                + "JOIN comuna ON sucursal.id_comuna_suc_fk = comuna.id_comuna\n"
                + "WHERE ID_EMPRESA_FK =" + id;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            Sucursal suc;
            while (rs.next()) {
                suc = new Sucursal();
                suc.setId_sucursal(Integer.parseInt(rs.getString(1)));
                suc.setNombre(rs.getString(2));
                suc.setDireccion(rs.getString(3));
                sucList.add(suc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return sucList;

    }
}
