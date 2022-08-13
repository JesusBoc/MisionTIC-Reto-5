package co.edu.utp.misiontic2022.c2.controller;

import java.sql.ResultSet;
import java.util.ArrayList;

import co.edu.utp.misiontic2022.c2.model.ConexionDB;
import co.edu.utp.misiontic2022.c2.model.ModeloDatos;
import co.edu.utp.misiontic2022.c2.model.DAO.LiderDAO;
import co.edu.utp.misiontic2022.c2.model.DAO.ProyectoDAO;
import co.edu.utp.misiontic2022.c2.view.TablaJPanel;

public class Controller {
    private ConexionDB conexionDB;
    private ArrayList<LiderDAO> lideres;
    private ArrayList<ProyectoDAO> proyectos;

    public Controller(ConexionDB conexionDB){
        this.conexionDB = conexionDB;
        lideres = new ArrayList<LiderDAO>();
        proyectos = new ArrayList<ProyectoDAO>();
    }

    private void llenarLideres(){
        ResultSet result = LiderDAO.ejecutarConsulta(conexionDB);
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
    private void llenarProyectos(){
        ResultSet result = ProyectoDAO.ejecutarConsulta(conexionDB);
        if(!proyectos.isEmpty()){
            proyectos.clear();
        }
        try {
            while(result.next()){
                Integer id = result.getInt(1);
                String constructora = result.getString(2);
                Integer numeroHabitaciones = result.getInt(3);
                String ciudad = result.getString(4);
                proyectos.add(new ProyectoDAO(id, constructora, numeroHabitaciones, ciudad));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String[][] lideresToString() {
        llenarLideres();
        String[][] out = new String[lideres.size()][4];
        for(int i = 0; i<lideres.size(); i++){
            out[i] = lideres.get(i).getData();
        }
        return out;
    }
    public String[][] proyectosToString(){
        llenarProyectos();
        String[][] out = new String[proyectos.size()][4];
        for (int i = 0; i < out.length; i++) {
            out[i] = proyectos.get(i).getData();
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
                datos = new ModeloDatos(lideresToString(),LiderDAO.headers);
                break;
            case "Informe 2":
                datos = new ModeloDatos(proyectosToString(),ProyectoDAO.headers);
        }
        TablaJPanel tabla = new TablaJPanel(datos, this);
        return tabla;
    }
}
