package co.edu.utp.misiontic2022.c2.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import co.edu.utp.misiontic2022.c2.model.Compras;
import co.edu.utp.misiontic2022.c2.model.ConexionDB;

public class ComprasDAO extends Compras{
    public static final String[] headers = {"ID_Compra","Constructora","Banco_Vinculado"};

    public ComprasDAO(Integer id, String constructora, String bancoVinculado) {
        super(id, constructora, bancoVinculado);
    }
    
    public static ResultSet ejecutarConsulta(ConexionDB conexionDB){
        ResultSet result = null;
        try {
            String sql = "SELECT c.ID_Compra, p.Constructora, p.Banco_Vinculado FROM Compra c JOIN Proyecto p ON c.ID_Proyecto  = p.ID_Proyecto WHERE Proveedor = 'Homecenter' AND p.Ciudad = 'Salento';";
            Statement stmt = conexionDB.getConexion().createStatement();
            result = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String[] getData() {
        String[] out = new String[3];
        out[0] = getId().toString();
        out[1] = getConstructora();
        out[2] = getBancoVinculado();
        return out;
    }
}
