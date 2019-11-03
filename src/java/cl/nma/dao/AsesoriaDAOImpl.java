package cl.nma.dao;

import cl.nma.database.DBUtil;
import cl.nma.dominio.Asesoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AsesoriaDAOImpl implements AsesoriaDAO {

    Connection conexion;

    public AsesoriaDAOImpl() throws SQLException {
        DBUtil db = new DBUtil();
        conexion = db.obtenerConexion();

    }

    @Override
    public int actualizar(Asesoria as) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int agregar(Asesoria as) {
        
        int id = 0;
        String sql = "INSERT INTO ASESORIA(ID_TIPO_ASESORIA_FK,ID_ACTIVIDAD_FK_AS)"
                + "VALUES(?,?)";
        
        PreparedStatement pst;
        try {
            pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, as.getId_tipo_asesoria_fk());
            pst.setInt(2, as.getId_actividades_fk_as());
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
    public int eliminar(Integer as) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Asesoria> listarActividad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Asesoria obtenerAsesoriaPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int finalizarAsesoria(Asesoria as) {
        
        int result = 0;
        String sql = "UPDATE ASESORIA SET COMENTARIOS_DETECTADOS = ? ,COMENTARIOS_PROPUESTA = ?  WHERE ID_ASESORIA = ?";
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement(sql);
            pst.setString(1, as.getComentarios_detectados());
            pst.setString(2, as.getComentarios_propuesta());
            pst.setInt(3, as.getId_asesoria());
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

}
