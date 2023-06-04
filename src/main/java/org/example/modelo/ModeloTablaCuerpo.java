package org.example.modelo;

import org.example.persistencia.CuerpoDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaCuerpo implements TableModel {
    private static  final  int COLUMNS = 6;
    private ArrayList<CuerpoHumano> datos;
    private CuerpoDAO cuerpoDAO;


    public ModeloTablaCuerpo() {
        cuerpoDAO = new CuerpoDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaCuerpo(ArrayList<CuerpoHumano> datos) {
        this.datos = datos;
        cuerpoDAO = new CuerpoDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public String getColumnName(int rowIndex) {
        switch (rowIndex){
            case 0:
                return "ID";
            case 1:
                return "Nombre";
            case 2:
                return "Ubicacion";
            case 3:
                return "Sistema";
            case 4:
                return "Enfermedades";
            case 5:
                return "Url";

        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int rowIndex) {
        switch (rowIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;

        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CuerpoHumano tmp = datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getNombre();
            case 2:
                return tmp.getUbicacion();
            case 3:
                return tmp.getSistema();
            case 4:
                return tmp.getEnfermedades();
            case 5:
                return tmp.getUrl();
        }
        return null;
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int coLIndex) {
        switch (coLIndex){
            case 0:
                //datos.get(rowIndex).setId();
                break;
            case 1:
                datos.get(rowIndex).setNombre((String) o);
                break;
            case 2:
                datos.get(rowIndex).setUbicacion((String) o);
                break;
            case 3:
                datos.get(rowIndex).setSistema((String) o);
                break;
            case 4:
                datos.get(rowIndex).setEnfermedades((String) o);
                break;
            case 5:
                datos.get(rowIndex).setUrl((String) o);
                break;
            default:
                System.out.println("No se modifica nada");

        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public void cargarDatos(){
        try{
            ArrayList<CuerpoHumano> tirar = cuerpoDAO.obtenerTodo();
            System.out.println(tirar);
            datos = cuerpoDAO.obtenerTodo();
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }

    }
    public boolean agregarParteCuerpo(CuerpoHumano cuerpoHumano){
        Boolean resultado = false;

        try{
            if (cuerpoDAO.insertar(cuerpoHumano)){
                datos.add(cuerpoHumano);
                resultado = true;
            } else {
                resultado = false;
            }
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return resultado;
    }
    public boolean delete(CuerpoHumano cuerpoHumano){
        boolean resultado = false;
        try {
            if (cuerpoDAO.delete(String.valueOf(cuerpoHumano))){
                datos.add(cuerpoHumano);
                resultado = true;
            }else {
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
    public boolean actualizarPartesDeCuerpo(CuerpoHumano cuerpoHumano){
        boolean resultado = false;
        try {
            if (cuerpoDAO.update(cuerpoHumano)){
                datos.add(cuerpoHumano);
                resultado = true;
            }else {
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
    public CuerpoHumano obtenerCuerpo(int rowIndex){
        return datos.get(rowIndex);
    }

}

