/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.dao;

import cl.nma.database.DBUtil;
import cl.nma.dominio.Contrato;
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
public class ContratoDAOImpl implements ContratoDAO {

    Connection conexion;

    public ContratoDAOImpl() throws SQLException {
        DBUtil db = new DBUtil();
        conexion = db.obtenerConexion();

    }

    @Override
    public int actualizar(Contrato con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int agregar(Contrato con) {
        
        
        int id = 0;
        String sql = "INSERT INTO CONTRATO(FECHA_DE_CONTRATO,VALOR,DESCRIPCION,ID_EMPRESA_FK)"
                + "VALUES(CURRENT_DATE(),?,?,?)";
        
        PreparedStatement pst;
        try {
            pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, con.getValor());
            pst.setString(2, con.getDescripcion());
            pst.setInt(3, con.getId_empresa_fk());
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
    public int eliminar(Integer con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contrato> listarContrato() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contrato obtenerContratoPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
