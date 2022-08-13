package co.edu.utp.misiontic2022.c2.controller;

import co.edu.utp.misiontic2022.c2.model.ConexionDB;
import co.edu.utp.misiontic2022.c2.view.MenuJFrame;

public class MainController {
    public MainController(){
        ConexionDB conexionDB = new ConexionDB();
        Controller controller = new Controller(conexionDB);
        
        // Algunas pruebas 
        new MenuJFrame(controller);
    }
}