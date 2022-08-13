package co.edu.utp.misiontic2022.c2.view;

import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Frame;

public class ResultJDialog extends JDialog{

    public ResultJDialog(Frame owner,TablaJPanel panel,String title){
        super(owner,true);
        setTitle(title);
        getContentPane().add(panel, BorderLayout.CENTER);
        setSize(800,500);
        setVisible(true);
    }
}
