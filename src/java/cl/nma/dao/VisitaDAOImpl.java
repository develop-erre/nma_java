package cl.nma.dao;

import cl.nma.database.DBUtil;
import cl.nma.dominio.Visita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VisitaDAOImpl implements VisitaDAO {

    Connection conexion;

    public VisitaDAOImpl() throws SQLException {
        DBUtil db = new DBUtil();
        conexion = db.obtenerConexion();

    }

    @Override
    public int actualizar(Visita vis) {
        
        int result = 0;
        String sql = "update visita \n"
                + "set contratos = ? \n"
                + ",documentacion = ? \n"
                + ",finiquitos= ? \n"
                + ",comentario_documentacion= ? \n"
                + ",instalacion= ? \n"
                + ",banios= ? \n"
                + ",comedores= ? \n"
                + ",comentarios_faena= ? \n"
                + ",seguridad= ? \n"
                + ",peligros= ? \n"
                + ",comentarios_seguridad= ? \n"
                + ",comentarios_propuesta= ? \n"
                + " where id_visita= ?";
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement(sql);
            pst.setInt(1, vis.getContratos());
            pst.setInt(2, vis.getDocumentacion());
            pst.setInt(3, vis.getFiniquitos());
            pst.setString(4, vis.getComentarios_documentacion());
            pst.setInt(5, vis.getInstalacion());
            pst.setInt(6, vis.getBanios());
            pst.setInt(7, vis.getComedores());
            pst.setString(8, vis.getComentarios_faena());
            pst.setInt(9, vis.getSeguridad());
            pst.setInt(10, vis.getPeligros());
            pst.setString(11, vis.getComentarios_seguridad());
            pst.setString(12, vis.getComentarios_propuesta());
            pst.setInt(13, vis.getId_visita());
            result = pst.executeUpdate();
        } catch (SQLException ex) {
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
    public int agregar(Visita vis) {

        int id = 0;
        String sql = "insert into visita(id_tipo_visita_fk,id_actividad_fk_v)"
                + "values(?,?)";

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, vis.getId_tipo_visita_fk());
            pst.setInt(2, vis.getId_actividad_fk_v());
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
            Logger.getLogger(VisitaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public int eliminar(Integer vis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Visita> listarVisita() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Visita obtenerVisitaPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
