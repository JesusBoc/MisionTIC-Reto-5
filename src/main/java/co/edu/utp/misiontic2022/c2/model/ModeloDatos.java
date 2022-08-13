package co.edu.utp.misiontic2022.c2.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import co.edu.utp.misiontic2022.c2.model.DAO.LiderDAO;

public class ModeloDatos extends AbstractTableModel{
    String datos[][];
    String headers[];

    public ModeloDatos(List<LiderDAO> datos){
        headers = LiderDAO.headers;
        this.datos = dataToStrings(datos);
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

    private String[][] dataToStrings(List<LiderDAO> lideres){
        String[][] out = new String[lideres.size()][4];
        for(int i = 0; i<lideres.size(); i++){
            out[i] = lideres.get(i).getData();
        }
        return out;
    }
}
