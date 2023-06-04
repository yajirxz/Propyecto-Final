package org.example;

import org.example.controlador.ControladorCuerpo;
import org.example.modelo.CuerpoHumano;
import org.example.persistencia.CuerpoDAO;
import org.example.vista.Ventana;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Ventana view = new Ventana("Proyecto Final: Aplicacion SWING");
        ControladorCuerpo controller = new ControladorCuerpo(view);
    }
}