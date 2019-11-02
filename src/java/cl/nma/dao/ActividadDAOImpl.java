
package cl.nma.dao;

import cl.nma.database.DBUtil;
import cl.nma.dominio.Actividad;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ActividadDAOImpl implements ActividadDAO {
    
    Connection conexion;

    public ActividadDAOImpl() throws SQLException {
        DBUtil db = new DBUtil();    
        conexion = db.obtenerConexion();

    }

    @Override
    public int actualizar(Actividad act) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int agregar(Actividad act) {
    
        int id = 0;
        String sql = "INSERT INTO ACTIVIDAD(FECHA_ACT,HORA_ACT,ESTADO_ACT,ID_USUARIO_FK,ID_SUCURSAL_EMPRESA_FK,ID_TIPO_ACTIVIDAD_FK)"
                + "VALUES(?,?,?,?,?,?)";
        
        PreparedStatement pst;
        try {
            pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setDate(1, castDateDAOImpl(act.getFecha_act()));
            pst.setString(2, act.getHora_act());
            pst.setInt(3, act.getEstado_act());
            pst.setInt(4, act.getId_usuario_fk());
            pst.setInt(5, act.getId_sucursal_empresa_fk());
            pst.setInt(6, act.getId_tipo_actividad_fk());
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
            Logger.getLogger(ActividadDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public int eliminar(Integer act) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Actividad> listarActividad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Actividad obtenerActividadPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public java.sql.Date castDateDAOImpl(java.util.Date date) throws ParseException {

        java.util.Date fech = date;
        java.sql.Date sDate = new java.sql.Date(fech.getTime());
        return sDate;
    }
    
}
