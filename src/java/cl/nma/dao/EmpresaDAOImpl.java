/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.dao;

import cl.nma.database.DBUtil;
import cl.nma.dominio.Empresa;
import cl.nma.dominio.EmpresaLista;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Richard Foncea
 */
public class EmpresaDAOImpl implements EmpresaDAO {

    Connection conexion;

    public EmpresaDAOImpl() throws SQLException {
        DBUtil db = new DBUtil();
        conexion = db.obtenerConexion();

    }

    @Override
    public int actualizar(Empresa em) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int agregar(Empresa em) {

        int id = 0;
        String sql = "insert into empresa(nombre, rut,"
                + "sitio_web,telefono, estado,id_rubro_fk)"
                + "values("
                + "?,?,?,?,?,?)";

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, em.getNombre());
            pst.setString(2, em.getRut());
            pst.setString(3, em.getSitio_web());
            pst.setString(4, em.getTelefono());
            pst.setInt(5, em.getEstado());
            pst.setInt(6, em.getId_rubro_fk());
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
            Logger.getLogger(EmpresaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public int eliminar(Integer idem) {

        int result = 0;
        String sql = "update empresa set estado = 1 where id_empresa = ?";
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement(sql);
            pst.setInt(1, idem);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public List<Empresa> listarEmpresa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empresa obtenerEmpresaPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EmpresaLista> listarEmpresaLista() {

        List<EmpresaLista> emList = new ArrayList<>();
        String sql = "select * from vista_lista_empresas";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            EmpresaLista el;
            while (rs.next()) {
                el = new EmpresaLista();
                el.setId_empresa(Integer.parseInt(rs.getString(1)));
                el.setNombre_empresa(rs.getString(2));
                el.setRut(rs.getString(3));
                el.setNombre_sucursal(rs.getString(4));
                el.setNombre_calle(rs.getString(5));
                el.setNumero(rs.getString(6));
                el.setComuna(rs.getString(7));
                el.setRegion(rs.getString(8));
                emList.add(el);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return emList;
    }

    @Override
    public List<EmpresaLista> listarEmpresaListaDes() {

        List<EmpresaLista> emList = new ArrayList<>();
        String sql = "select * from vista_lista_empresas_des";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            EmpresaLista el;
            while (rs.next()) {
                el = new EmpresaLista();
                el.setId_empresa(Integer.parseInt(rs.getString(1)));
                el.setNombre_empresa(rs.getString(2));
                el.setRut(rs.getString(3));
                el.setNombre_sucursal(rs.getString(4));
                el.setNombre_calle(rs.getString(5));
                el.setNumero(rs.getString(6));
                el.setComuna(rs.getString(7));
                el.setRegion(rs.getString(8));
                emList.add(el);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return emList;

    }

    @Override
    public int habilitarEmpresa(Integer idem) {

        int result = 0;
        String sql = "update empresa set estado = 0 where id_empresa = ?";
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement(sql);
            pst.setInt(1, idem);
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

}
