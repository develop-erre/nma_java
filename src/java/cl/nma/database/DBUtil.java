/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.database;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Richard Foncea
 */
public class DBUtil {
    
    private DataSource pool; 

    public DBUtil() {
        try {
            Context ctx = new InitialContext();
            pool = (DataSource) ctx.lookup("java:/comp/env/jdbc/no_mas_accidentes");
            System.out.println("Pool DataSource --> conexion reconocida");
            if (pool == null) {
                throw new RuntimeException("Base de datos desconocida'jdbc/no_mas_accidentes'");
            }
        } catch (NamingException ex) {
           ex.printStackTrace();
        } 
    }
    
    public Connection obtenerConexion() throws SQLException{
        return pool.getConnection();
    }
}
