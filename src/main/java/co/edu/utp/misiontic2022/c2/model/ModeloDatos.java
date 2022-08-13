package co.edu.utp.misiontic2022.c2.model;

import javax.swing.table.AbstractTableModel;

public class ModeloDatos extends AbstractTableModel{
    String datos[][];
    String headers[];

    public ModeloDatos(String[][] datos,String[] headers){
        this.headers = headers;
        this.datos = datos;
    }

    public String[][] getDatos() {
        return datos;
    }
    public String[] getHeaders() {
        return headers;
    }
    @Override
    public int getRowCount() {
        return datos.length;
    }

    @Override
    public int getColumnCount() {
        return datos[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return datos[rowIndex][columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
