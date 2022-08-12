package co.edu.utp.misiontic2022.c2.controller;

import co.edu.utp.misiontic2022.c2.model.ConexionDB;
import co.edu.utp.misiontic2022.c2.view.testView;

public class MainController {
    public MainController(){
        ConexionDB conexionDB = new ConexionDB();
        LiderController controller = new LiderController(conexionDB);
        testView view = new testView(controller);
        view.mostrarConsulta();
    }
}
