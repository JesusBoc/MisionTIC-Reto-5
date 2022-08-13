package co.edu.utp.misiontic2022.c2.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;

import co.edu.utp.misiontic2022.c2.controller.Controller;
import co.edu.utp.misiontic2022.c2.model.ModeloDatos;

public class TablaJPanel extends JPanel{
    private String data[][];
    private String titles[];
    public TablaJPanel(ModeloDatos datos, Controller controller){
        data = controller.obtenerDatosModelo(datos);
        titles = controller.obtenerTitulosModelo(datos);
        setLayout(new BorderLayout());
        JTable tabla = new JTable(data,titles);
        JScrollPane panel = new JScrollPane(tabla);
        add(panel, BorderLayout.CENTER);
    }
}
