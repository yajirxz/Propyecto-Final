package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class CuerpoHumano {
    private int Id;
    private String Nombre;
    private String Ubicacion;
    private String Sistema;
    private String Enfermedades;
    private String Url;

    public CuerpoHumano() {
    }

    public CuerpoHumano(int id, String nombre, String ubicacion, String sistema,
                        String enfermedades, String url) {
        Id = id;
        Nombre = nombre;
        Ubicacion = ubicacion;
        Sistema = sistema;
        Enfermedades = enfermedades;
        this.Url = url;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public String getSistema() {
        return Sistema;
    }

    public void setSistema(String sistema) {
        Sistema = sistema;
    }

    public String getEnfermedades() {
        return Enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        Enfermedades = enfermedades;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        this.Url = url;
    }

    @Override
    public String toString() {
        return "CuerpoHumano{" +
                "Id=" + Id +
                ", Nombre='" + Nombre + '\'' +
                ", Ubicación='" + Ubicacion + '\'' +
                ", Sistema='" + Sistema + '\'' +
                ", Enfermedades='" + Enfermedades + '\'' +
                ", Url='" + Url + '\'' +
                '}';
    }
    public ImageIcon createIcon(){
        ImageIcon resultado = null;
        try{
            URL UrlCuerpo = new URL(this.Url);
            resultado = new ImageIcon(UrlCuerpo);
        }catch (MalformedURLException malformedURLException){
            System.out.println(malformedURLException.toString());
        }
        return resultado;
    }
}
