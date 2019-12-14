package cl.nma.dao;

import cl.nma.database.DBUtil;
import cl.nma.dominio.Direccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DireccionDAOImpl implements DireccionDAO {

    Connection conexion;

    public DireccionDAOImpl() throws SQLException {
        DBUtil db = new DBUtil();
        conexion = db.obtenerConexion();

    }

    /*
    INSERT INTO DIRECCION (NOMBRE_CALLE, NUMERO, DEPTO, OFICINA, ID_COMUNA_FK) VALUES (?, ?, ?, ?,?);
     */
    @Override
    public int actualizar(Direccion dir) {
        
        
        int result = 0;
        String sql = "update direccion set nombre_calle = ? ,numero = ? ,depto= ? ,id_comuna_fk= ?  where id_direccion= ?";
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement(sql);
            pst.setString(1,dir.getNombre_calle());
            pst.setString(2,dir.getNumero());
            pst.setString(3,dir.getDepto());
            pst.setInt(4,dir.getId_comuna_fk());
            pst.setInt(5,dir.getId_direccion());
            result = pst.executeUpdate();
        } catch (SQLException ex) {
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
    public int agregar(Direccion dir) {

        int id = 0;
        String sql = "insert into direccion (nombre_calle, numero, depto, id_comuna_fk) values (?, ?, ?,?);";

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, dir.getNombre_calle());
            pst.setString(2, dir.getNumero());
            pst.setString(3, dir.getDepto());
            pst.setInt(4, dir.getId_comuna_fk());
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
    public int eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Direccion> listarDireccion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
