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
        String sql = "INSERT INTO asesoria(ID_TIPO_ASESORIA_FK,ID_ACTIVIDAD_FK_AS,ID_TIPO_ESTADO_FK)"
                + "VALUES(?,?,1)";

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, as.getId_tipo_asesoria_fk());
            pst.setInt(2, as.getId_actividades_fk_as());
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
            Logger.getLogger(AsesoriaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        String sql = "update asesoria set comentarios_detectados = ? ,comentarios_propuesta = ? , id_tipo_estado_fk = 3  where id_asesoria = ?";
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement(sql);
            pst.setString(1, as.getComentarios_detectados());
            pst.setString(2, as.getComentarios_propuesta());
            pst.setInt(3, as.getId_asesoria());
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AsesoriaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public int EstadoAsesoriaAsignado(int idAsesoria) {

        int result = 0;
        String sql = "UPDATE asesoria set id_tipo_estado_fk  = 2   where id_asesoria =" + idAsesoria;
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement(sql);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AsesoriaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
