package co.edu.utp.misiontic2022.c2.controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.edu.utp.misiontic2022.c2.model.ConexionDB;
import co.edu.utp.misiontic2022.c2.model.ModeloDatos;
import co.edu.utp.misiontic2022.c2.model.DAO.LiderDAO;
import co.edu.utp.misiontic2022.c2.view.TablaJPanel;

public class Controller {
    private ConexionDB conexionDB;
    private ArrayList<LiderDAO> lideres;

    public Controller(ConexionDB conexionDB){
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
                String id = result.getString(1);
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

    public String[][] getData() {
        ResultSet result = LiderDAO.ejecutarConsulta(conexionDB);
        llenarArray(result);
        String[][] out = new String[lideres.size()][4];
        for(int i = 0; i<lideres.size(); i++){
            out[i] = lideres.get(i).getData();
        }
        return out;
    }
    public String[][] obtenerDatosModelo(ModeloDatos modelo){
        return modelo.getDatos();
    }
    public String[] obtenerTitulosModelo(ModeloDatos modelo){
        return modelo.getHeaders();
    }

    public TablaJPanel construirPanel(String actionCommand){
        ModeloDatos datos = null;
        switch(actionCommand){
            case "Informe 1":
                datos = new ModeloDatos(lideres);
        }
        TablaJPanel tabla = new TablaJPanel(datos, this);
        return tabla;
    }
}
