package co.edu.utp.misiontic2022.c2.controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.edu.utp.misiontic2022.c2.model.ConexionDB;
import co.edu.utp.misiontic2022.c2.model.DAO.LiderDAO;

public class LiderController {
    private ConexionDB conexionDB;
    private ArrayList<LiderDAO> lideres;

    public LiderController(ConexionDB conexionDB){
        this.conexionDB = conexionDB;
        lideres = new ArrayList<LiderDAO>();
    }
    
    public ResultSet ejecutarConsulta(){
        ResultSet result = LiderDAO.ejecutarConsulta(conexionDB);
        return result;
    }

    public List<LiderDAO> getLideres(){
        ResultSet result = LiderDAO.ejecutarConsulta(conexionDB);
        llenarArray(result);
        return lideres;
    }
    
    private void llenarArray(ResultSet result){
        if(!lideres.isEmpty()){
            lideres.clear();
        }
        try {
            while(result.next()){
                Integer id = result.getInt(1);
                String nombre = result.getString(2);
                String apellido = result.getString(3);
                String ciudad = result.getString(4);
                lideres.add(new LiderDAO(id, nombre, apellido, ciudad));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

    public String[] headers(){
        return LiderDAO.headers;
    }
}
