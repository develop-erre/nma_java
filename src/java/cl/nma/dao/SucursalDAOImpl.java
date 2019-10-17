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
        
        PreparedStatement pst;
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
    public int eliminar(Integer idsuc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sucursal> listarEmpresa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sucursal obtenerSucursalPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
