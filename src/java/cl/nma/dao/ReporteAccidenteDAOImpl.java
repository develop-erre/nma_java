package cl.nma.dao;

import cl.nma.database.DBUtil;
import cl.nma.dominio.ListaReporteAccidente;
import cl.nma.dominio.ReporteAccidente;
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
        String sql = "INSERT INTO REPORTE_ACCIDENTE(FECHA,HORA,COMENTARIO,ID_TIPO_ACCIDENTE_FK,ID_SUCURSAL_FK)"
                + "VALUES(?,?,?,?,?)";

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setDate(1, castDateDAOImpl(ra.getFecha()));
            pst.setString(2, ra.getHora());
            pst.setString(3, ra.getComentario());
            pst.setInt(4, ra.getId_tipo_accidente_fk());
            pst.setInt(5, ra.getId_sucursal_fk());
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
            Logger.getLogger(ReporteAccidenteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    @Override
    public List<ListaReporteAccidente> listarReporteAccidentesVerAdmin(int idEmpresa) {

        List<ListaReporteAccidente> repList = new ArrayList<>();
        String sql = "CALL GetAllReporteAccidente(" + idEmpresa + ");";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            ListaReporteAccidente lra;
            while (rs.next()) {
                lra = new ListaReporteAccidente();
                lra.setId_reporte_accidente(rs.getInt(1));
                lra.setId_sucursal(rs.getInt(2));
                lra.setId_empresa(rs.getInt(3));
                lra.setFecha_accidente(rs.getDate(4));
                lra.setHora_accidente(rs.getString(5));
                lra.setComentario(rs.getString(6));
                lra.setDescripcion(rs.getString(7));
                lra.setNombre_sucursal(rs.getString(8));
                repList.add(lra);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReporteAccidenteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return repList;

    }

}
