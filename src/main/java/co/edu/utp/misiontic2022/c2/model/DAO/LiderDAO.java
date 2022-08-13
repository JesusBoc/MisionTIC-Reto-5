package co.edu.utp.misiontic2022.c2.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import co.edu.utp.misiontic2022.c2.model.ConexionDB;
import co.edu.utp.misiontic2022.c2.model.Lider;

public class LiderDAO extends Lider{
    public static final String[] headers = {"ID_Lider","Nombre","Primer_Apellido","Ciudad_residencia"};

    public LiderDAO(String id, String nombre, String apellido, String ciudad) {
        super(id, nombre, apellido, ciudad);
    }
    
    public static ResultSet ejecutarConsulta(ConexionDB conexionDB){
        ResultSet result = null;
        try {
            String sql = "SELECT l.ID_Lider, l.Nombre, l.Primer_Apellido, l.Ciudad_Residencia FROM Lider l ORDER BY Ciudad_Residencia;";
            Statement stmt = conexionDB.getConexion().createStatement();
            result = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String[] getData() {
        String[] result = new String[headers.length];
        result[0] = getId();
        result[1] = getNombre();
        result[2] = getApellido();
        result[3] = getCiudad();
        return result;
    }
}
