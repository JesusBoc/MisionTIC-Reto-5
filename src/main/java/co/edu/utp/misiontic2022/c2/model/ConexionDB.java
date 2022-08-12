package co.edu.utp.misiontic2022.c2.model;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.utp.misiontic2022.c2.util.JDBCUtilities;

public class ConexionDB {
    private Connection conexion;

    public ConexionDB(){
        conexion = null;
        try {
            conexion = JDBCUtilities.getConnection();
        } catch (SQLException e) {
            showSQLExceptions(e);
        }
    }
    
    public Connection getConexion(){
        return conexion;
    }

    public void cerrarConexion(){
        try {
            conexion.close();
        } catch (SQLException e) {
            showSQLExceptions(e);
        }   
    }
    private void showSQLExceptions(SQLException e){
        System.out.println("Status: " + e.getSQLState());
        System.out.println("Codigo de error: " + e.getErrorCode());
        System.out.println(e.getMessage());
        e.printStackTrace();
    }
}
