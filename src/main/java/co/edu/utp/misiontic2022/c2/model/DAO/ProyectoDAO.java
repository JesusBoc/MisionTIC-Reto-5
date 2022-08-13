package co.edu.utp.misiontic2022.c2.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import co.edu.utp.misiontic2022.c2.model.ConexionDB;
import co.edu.utp.misiontic2022.c2.model.Proyecto;

public class ProyectoDAO extends Proyecto{
    public static final String[] headers = {"ID_Proyecto", "Constructora", "Numero_Habitaciones","Ciudad"};

    public ProyectoDAO(Integer id, String constructora, Integer numeroHabitaciones, String ciudad) {
        super(id, constructora, numeroHabitaciones, ciudad);
    }
    
    public static ResultSet ejecutarConsulta(ConexionDB conexionDB){
        ResultSet result = null;
        try {
            String sql = "SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad FROM Proyecto WHERE Clasificacion = 'Casa Campestre' AND Ciudad IN ('Santa Marta','Cartagena','Barranquilla');";
            Statement stmt = conexionDB.getConexion().createStatement();
            result = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public String[] getData(){
        String[] result = new String[4];
        result[0] = getId().toString();
        result[1] = getConstructora();
        result[2] = getNumeroHabitaciones().toString();
        result[3] = getCiudad();
        return result;
    }
}