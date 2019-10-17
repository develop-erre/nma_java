/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.dao;

import cl.nma.database.DBUtil;
import cl.nma.dominio.ReporteAccidente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Richard Foncea
 */
public class ReporteAccidenteDAOImpl implements ReporteAccidenteDAO {

    Connection conexion;

    public ReporteAccidenteDAOImpl() throws SQLException {
        DBUtil db = new DBUtil();
        conexion = db.obtenerConexion();

    }

    @Override
    public int actualizar(ReporteAccidente ra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int agregar(ReporteAccidente ra) {

        int id = 0;
        String sql = "INSERT INTO REPORTE_ACCIDENTE(FECHA,COMENTARIO,ID_EMPRESA_FK,ID_TIPO_ACCIDENTE_FK)"
                + "VALUES(?,?,?,?)";

        PreparedStatement pst;
        try {
            pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setDate(1, castDateDAOImpl(ra.getFecha()));
            //pst.setString(2, ra.getHora());
            pst.setString(2, ra.getComentario());
            pst.setInt(3, ra.getId_empresa_fk());
            pst.setInt(4, ra.getId_tipo_accidente_fk());
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
            Logger.getLogger(ReporteAccidenteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;

    }

    @Override
    public int eliminar(Integer ra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ReporteAccidente> listarReporteAccidentes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReporteAccidente obtenerReporteAccidentePorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public java.sql.Date castDateDAOImpl(java.util.Date date) throws ParseException {

        java.util.Date fech = date;
        java.sql.Date sDate = new java.sql.Date(fech.getTime());
        return sDate;
    }

}
