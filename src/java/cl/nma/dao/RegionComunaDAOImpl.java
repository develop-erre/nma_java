
package cl.nma.dao;

import cl.nma.database.DBUtil;
import cl.nma.dominio.ActividadAsesoria;
import cl.nma.dominio.RegionComuna;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegionComunaDAOImpl implements RegionComunaDAO{
    
    Connection conexion;

    public RegionComunaDAOImpl() throws SQLException {
        DBUtil db = new DBUtil();
        conexion = db.obtenerConexion();

    }

    @Override
    public List<RegionComuna> listar() {
        
        List<RegionComuna> listaComunas = new ArrayList<>();
        String sql = "SELECT * FROM VISTA_REGION_COMUNA";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            RegionComuna reg_com;
            while (rs.next()) {
                reg_com = new RegionComuna();
                reg_com.setId_comuna(rs.getInt(1));
                reg_com.setNombre_comuna(rs.getString(2));
                listaComunas.add(reg_com);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return listaComunas;
        
    }
    
}
