package cl.nma.dao;

import cl.nma.database.DBUtil;
import cl.nma.dominio.Actividad;
import cl.nma.dominio.ActividadAsesoria;
import cl.nma.dominio.ActividadAsesoriaGetAll;
import cl.nma.dominio.ActividadCapacitacionGettAll;
import cl.nma.dominio.ActividadVisita;
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

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, act.getEstado_act());
            pst.setInt(2, act.getId_sucursal_empresa_fk());
            pst.setInt(3, act.getId_tipo_actividad_fk());
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
            Logger.getLogger(ActividadDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public int agregar(Actividad act) {

        int id = 0;
        String sql = "INSERT INTO ACTIVIDAD(FECHA_ACT,HORA_ACT,ESTADO_ACT,ID_USUARIO_FK,ID_SUCURSAL_EMPRESA_FK,ID_TIPO_ACTIVIDAD_FK)"
                + "VALUES(?,?,?,?,?,?)";

        PreparedStatement pst = null;
        ResultSet rs = null;
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

            rs = pst.getGeneratedKeys();
            while (rs.next()) {
                id = rs.getInt(1); //devuelve la clave autogenerada por la BD
                System.out.println("ID GENERADO:" + id);
            }

        } catch (SQLException | ParseException ex) {
            Logger.getLogger(ActividadDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement(sql);
            pst.setDate(1, castDateDAOImpl(act.getFecha_act()));
            pst.setString(2, act.getHora_act());
            pst.setInt(3, act.getId_usuario_fk());
            pst.setInt(4, act.getId_actividad());
            result = pst.executeUpdate();
        } catch (SQLException | ParseException ex) {
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
                actAs.setTipo_asesoria(rs.getString(9));
                actAs.setNombre_sucursal(rs.getString(10));
                actAs.setNombre_calle(rs.getString(11));
                actAs.setNumero(rs.getString(12));
                actAs.setNombre_comuna(rs.getString(13));
                actAs.setNombre_region(rs.getString(14));

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
    public int finalizarActividad(int idActividad) {
        int result = 0;
        String sql = "UPDATE ACTIVIDAD SET ESTADO_ACT = 1 WHERE ID_ACTIVIDAD = " + idActividad;
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement(sql);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
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
    public List<ActividadAsesoriaGetAll> listarAsesoriasFinalizadasGetAll(int idEmpresa) {

        List<ActividadAsesoriaGetAll> solicitudList = new ArrayList<>();
        String sql = "CALL GetAllAsesoriasFinalizadas(" + idEmpresa + ");";
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
                actAs.setTipo_asesoria(rs.getString(9));
                actAs.setNombre_sucursal(rs.getString(10));
                actAs.setNombre_calle(rs.getString(11));
                actAs.setNumero(rs.getString(12));
                actAs.setNombre_comuna(rs.getString(13));
                actAs.setNombre_region(rs.getString(14));
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
    public List<ActividadCapacitacionGettAll> listarCapacitacionGetAll(int idUsuario) {

        List<ActividadCapacitacionGettAll> capList = new ArrayList<>();
        String sql = "CALL GetAllCapacitacion(" + idUsuario + ");";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            ActividadCapacitacionGettAll actCap;
            while (rs.next()) {
                actCap = new ActividadCapacitacionGettAll();
                actCap.setId_actividad(rs.getInt(1));
                actCap.setId_capacitacion(rs.getInt(2));
                actCap.setId_usuario(rs.getInt(3));
                actCap.setNombre_apellido(rs.getString(4));
                actCap.setFecha_act(rs.getDate(5));
                actCap.setHora_act(rs.getString(6));
                actCap.setNumero_asistente(rs.getInt(7));
                actCap.setNombre_sucursal(rs.getString(8));
                actCap.setDescripcion(rs.getString(9));
                capList.add(actCap);
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
        return capList;

    }

    @Override
    public List<ActividadVisita> listarActividadVisitaGetAllProfesional(int idUsuario) {

        List<ActividadVisita> visList = new ArrayList<>();
        String sql = "CALL GetAllVisitasAsignadas(" + idUsuario + ");";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            ActividadVisita actVis;
            while (rs.next()) {
                actVis = new ActividadVisita();
                actVis.setId_usuario(rs.getInt(1));
                actVis.setNombre_apellido(rs.getString(2));
                actVis.setId_actividad(rs.getInt(3));
                actVis.setFecha_act(rs.getDate(4));
                actVis.setHora_act(rs.getString(5));
                actVis.setId_visita(rs.getInt(6));
                actVis.setTipo_visita(rs.getString(7));
                actVis.setContratos(rs.getInt(8));
                actVis.setDocumentacion(rs.getInt(9));
                actVis.setFiniquitos(rs.getInt(10));
                actVis.setComentarios_documentacion(rs.getString(11));
                actVis.setInstalacion(rs.getInt(12));
                actVis.setBanios(rs.getInt(13));
                actVis.setComedores(rs.getInt(14));
                actVis.setComentarios_faena(rs.getString(15));
                actVis.setSeguridad(rs.getInt(16));
                actVis.setPeligros(rs.getInt(17));
                actVis.setComentarios_seguridad(rs.getString(18));
                actVis.setComentarios_propuesta(rs.getString(19));
                actVis.setNombre_sucursal(rs.getString(20));
                actVis.setNombre_calle(rs.getString(21));
                actVis.setNumero(rs.getString(22));
                actVis.setNombre_comuna(rs.getString(23));
                actVis.setNombre_region(rs.getString(24));
                visList.add(actVis);
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
        return visList;

    }
}
