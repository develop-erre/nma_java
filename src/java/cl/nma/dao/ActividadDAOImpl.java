package cl.nma.dao;

import cl.nma.database.DBUtil;
import cl.nma.dominio.Actividad;
import cl.nma.dominio.ActividadAsesoria;
import cl.nma.dominio.ActividadAsesoriaGetAll;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
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
    public int agregarAsesoria(Actividad act) {

        int id = 0;
        String sql = "INSERT INTO ACTIVIDAD(ESTADO_ACT,ID_SUCURSAL_EMPRESA_FK,ID_TIPO_ACTIVIDAD_FK)"
                + "VALUES(?,?,?)";

        PreparedStatement pst;
        try {
            pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, act.getEstado_act());
            pst.setInt(2, act.getId_sucursal_empresa_fk());
            pst.setInt(3, act.getId_tipo_actividad_fk());
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

    @Override
    public List<ActividadAsesoria> listarSolicitudAsesoria() {

        List<ActividadAsesoria> solicitudList = new ArrayList<>();
        String sql = "SELECT * FROM VISTA_SOLICITUD_ASESORIAS";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            ActividadAsesoria actAs;
            while (rs.next()) {
                actAs = new ActividadAsesoria();
                actAs.setId_actividad(rs.getInt(1));
                actAs.setId_asesoria(rs.getInt(2));
                actAs.setId_sucursal(rs.getInt(3));
                actAs.setNombre(rs.getString(4));
                actAs.setDescripcion(rs.getString(5));
                solicitudList.add(actAs);
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
        return solicitudList;

    }

    @Override
    public int asignarAsesoria(Actividad act) {

        int result = 0;
        String sql = "UPDATE ACTIVIDAD SET FECHA_ACT =?, HORA_ACT =? , ID_USUARIO_FK =? WHERE ID_ACTIVIDAD =?";
        //"UPDATE ACTIVIDAD SET FECHA_ACT =?, HORA_ACT =? , ID_USUARIO_FK =? WHERE ID_ACTIVIDAD =?"
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement(sql);
            pst.setDate(1, castDateDAOImpl(act.getFecha_act()));
            pst.setString(2, act.getHora_act());
            pst.setInt(3, act.getId_usuario_fk());
            pst.setInt(4, act.getId_actividad());
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ActividadDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public List<ActividadAsesoriaGetAll> listarSolicitudAsesoriaGetAll(int idProfesional) {

        List<ActividadAsesoriaGetAll> solicitudList = new ArrayList<>();
        String sql = "CALL GetAllAsesoriasAsignadas(" + idProfesional + ");";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            ActividadAsesoriaGetAll actAs;
            while (rs.next()) {
                actAs = new ActividadAsesoriaGetAll();
                actAs.setId_usuario(rs.getInt(1));
                actAs.setNombre_apellido(rs.getString(2));
                actAs.setId_actividad(rs.getInt(3));
                actAs.setFecha_act(rs.getDate(4));
                actAs.setHora_act(rs.getString(5));
                actAs.setId_asesoria(rs.getInt(6));
                actAs.setComentarios_detectados(rs.getString(7));
                actAs.setComentarios_propuesta(rs.getString(8));
                actAs.setNombre_sucursal(rs.getString(9));
                actAs.setTipo_asesoria(rs.getString(10));
                solicitudList.add(actAs);
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
        return solicitudList;

    }

    public java.sql.Date castDateDAOImpl(java.util.Date date) throws ParseException {

        java.util.Date fech = date;
        java.sql.Date sDate = new java.sql.Date(fech.getTime());
        return sDate;
    }

    public Time castTime(String hora) {

        Time result = Time.valueOf(hora);

        return result;
    }

    @Override
    public int finalizarActividad(Actividad act) {
        int result = 0;
        String sql = "UPDATE ACTIVIDAD SET ESTADO_ACT = 1 WHERE ID_ACTIVIDAD = ?";
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement(sql);
            pst.setInt(1, act.getId_actividad());
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
