/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.dao;

import cl.nma.database.DBUtil;
import cl.nma.dominio.Profesional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Richard Foncea
 */
public class ProfesionalDAOImpl implements ProfesionalDAO {

    Connection conexion;

    public ProfesionalDAOImpl() throws SQLException {
        DBUtil db = new DBUtil();
        conexion = db.obtenerConexion();

    }

    @Override
    public int actualizar(Profesional prof) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int agregar(Profesional prof) {

        int id = 0;
        String sql = "INSERT INTO USUARIO(NOMBRE, APELLIDOS,"
                + "RUT,PASSWORD, DIRECCION,FECHA_NACIMIENTO,EMAIL,TELEFONO,ESTADO,"
                + "ID_COMUNA_US_FK, ID_ROL_FK) VALUES("
                + "?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pst;
        try {
            pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, prof.getNombre());
            pst.setString(2, prof.getApellidos());
            pst.setString(3, prof.getRut());
            pst.setString(4, prof.getPassword());
            pst.setString(5, prof.getDireccion());
            pst.setDate(6, prof.getFecha_nac());
            pst.setString(7, prof.getEmail());
            pst.setString(8, prof.getTelefono());
            pst.setInt(9, prof.getEstado());
            pst.setInt(10, prof.getId_comuna_us_fk());
            pst.setInt(11, prof.getId_rol_fk());
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
    public int eliminar(Integer idprof) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Profesional> listarProfesional() {
        List<Profesional> lista = new ArrayList<>();

        String sql = "SELECT * FROM USUARIO WHERE ID_ROL_FK = 2";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            Profesional profesional = null;

            while (rs.next()) {
                profesional = new Profesional();
                profesional.setId_usuario(rs.getInt(1));
                profesional.setNombre(rs.getString(2));
                profesional.setApellidos(rs.getString(3));
                profesional.setRut(rs.getString(4));
                profesional.setEmail(rs.getString(8));
                profesional.setTelefono(rs.getString(9));
                lista.add(profesional);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfesionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public Profesional obtenerProfesionalPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
