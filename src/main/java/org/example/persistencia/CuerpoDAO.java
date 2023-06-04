package org.example.persistencia;

import org.example.modelo.CuerpoHumano;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CuerpoDAO implements InterfazDAO {
    public CuerpoDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqLInsert = "INSERT INTO cuerpo (Nombre, Ubicacion, Sistema, Enfermedades, URL) VALUES(?, ?, ?, ?, ?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("CuerpoHumanoDB.db").getConnection().prepareStatement(sqLInsert);
        pstm.setString(1, ((CuerpoHumano) obj).getNombre());
        pstm.setString(2, ((CuerpoHumano) obj).getUbicacion());
        pstm.setString(3, ((CuerpoHumano) obj).getSistema());
        pstm.setString(4, ((CuerpoHumano) obj).getEnfermedades());
        pstm.setString(5, ((CuerpoHumano) obj).getUrl());

        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE cuerpo SET Nombre = ?, Ubicacion = ?, Sistema = ?, Enfermedades = ?, URL = ? WHERE ID = ? ; ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("CuerpoHumanoDB.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((CuerpoHumano) obj).getNombre());
        pstm.setString(2, ((CuerpoHumano) obj).getUbicacion());
        pstm.setString(3, ((CuerpoHumano) obj).getSistema());
        pstm.setString(4, ((CuerpoHumano) obj).getEnfermedades());
        pstm.setString(5, ((CuerpoHumano) obj).getUrl());
        pstm.setInt(6, ((CuerpoHumano) obj).getId());

        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM cuerpo WHERE id = ? ; ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("CuerpoHumanoDB.db").
                getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM cuerpo";
        ArrayList<CuerpoHumano> resultado = new ArrayList<>();
             Statement stm = ConexionSingleton.getInstance("CuerpoHumanoDB.db").getConnection().createStatement();
             ResultSet rst = stm.executeQuery(sql);
             while (rst.next()){
                  resultado.add(new CuerpoHumano (rst.getInt(1), rst.getString(2),
                    rst.getString(3), rst.getString(4),
                    rst.getString(5), rst.getString(6)));
        }
        return resultado;

}

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM cuerpo WHERE id = ? ;";
        CuerpoHumano cuerpoHumano = null;
        PreparedStatement pstm = ConexionSingleton.getInstance("CuerpoHumanoDB.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            cuerpoHumano = new CuerpoHumano(rst.getInt(1), rst.getString(2),
                    rst.getString(3), rst.getString(4),
                    rst.getString(5), rst.getString(6));
            return cuerpoHumano;
        }
        return null;
    }
}
