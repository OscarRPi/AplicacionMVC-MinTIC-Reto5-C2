package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import view.Vista;
import model.Modelo;
import model.vo.Consulta1;
import model.vo.Consulta2;
import model.vo.Consulta3;

public class Controlador implements ActionListener {
    private final Vista view;
    private final Modelo model;
    
    public Controlador(Vista view, Modelo model){
        this.view = view;
        this.model = model;
        this.view.BTN1.addActionListener(this);
        this.view.BTN2.addActionListener(this);
        this.view.BTN3.addActionListener(this);
    }
    
    public void iniciar(){
        view.setTitle("Reto 5 MVC Mision TIC UTP Grupo 16");
        view.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.BTN1){
            
            String[] titulo =new String[] {"ID_Lider","Nombre","Primer_Apellido","Ciudad_Residencia"};
            view.dtm.setColumnIdentifiers(titulo);
            view.dtm.setNumRows(0);
            
            List<Consulta1> Listado;
            try {
                Listado = model.consulta1();
                Listado.forEach(consulta -> {
                    view.dtm.addRow(new Object[] {
                        consulta.getId_lider(),
                        consulta.getNombre(),
                        consulta.getPrimer_apellido(),
                        consulta.getCiudad_residencia()  
                    });
                });
            } 
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en la consulta");
            }

        }
        else if(e.getSource() == view.BTN2){

            String[] titulo =new String[] {"ID_Proyecto","Constructora","Numero_Habitaciones","Ciudad"};
            view.dtm.setColumnIdentifiers(titulo);
            view.dtm.setNumRows(0);
            
            List<Consulta2> Listado;
            
            try {
                Listado = model.consulta2();
                Listado.forEach(consulta -> {
                    view.dtm.addRow(new Object[] {
                        consulta.getId_proyecto(),
                        consulta.getConstructora(),
                        consulta.getNumero_habitaciones(),
                        consulta.getCiudad()  
                    });
                });
            } 
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en la consulta");
            }
            
                
        }
        else if(e.getSource() == view.BTN3){
            
            String[] titulo =new String[] {"ID_Compra","Constructora","Banco_Vinculado"};
            view.dtm.setColumnIdentifiers(titulo);
            view.dtm.setNumRows(0);
            List<Consulta3> Listado;
            try {
                Listado = model.consulta3();
                Listado.forEach(consulta -> {
                    view.dtm.addRow(new Object[] {
                        consulta.getId_compra(),
                        consulta.getConstructora(),
                        consulta.getBanco_vinculado()
                    });
                });
            } 
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en la consulta");
            }
        }
    }
}
