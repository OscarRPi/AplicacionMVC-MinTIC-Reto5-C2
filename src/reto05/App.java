package reto05;

import controller.Controlador;
import model.Modelo;
import view.Vista;

public class App {
    public static void main(String[] args) {
        
        Modelo model = new Modelo();
        Vista vista = new Vista();
        
        Controlador controller = new Controlador(vista,model);
        controller.iniciar();
        vista.setVisible(true);
    }
}
