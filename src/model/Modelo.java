package model;

import utils.JDBCUtilities;
import model.vo.Consulta1;
import model.vo.Consulta2;
import model.vo.Consulta3;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Modelo {
    public String resu;
    
    public List<Consulta1> consulta1() throws SQLException {
        
        Connection conn = JDBCUtilities.getConnection();
        Statement consulta = conn.createStatement();
        ResultSet res = consulta.executeQuery("SELECT ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia FROM Lider ORDER BY Ciudad_Residencia ASC");
        
        ArrayList<Consulta1> respuesta = new ArrayList<>();
        
        while(res.next()){
            Consulta1 C1 = new Consulta1();
            C1.setId_lider(res.getInt("ID_Lider"));
            C1.setNombre(res.getString("Nombre"));
            C1.setPrimer_apellido(res.getString("Primer_Apellido"));
            C1.setCiudad_residencia(res.getString("Ciudad_Residencia"));
            respuesta.add(C1);
        }
        return respuesta;
    }
    
    public List<Consulta2> consulta2() throws SQLException {
        
        Connection conn = JDBCUtilities.getConnection();
        Statement consulta = conn.createStatement();
        ResultSet res = consulta.executeQuery("SELECT ID_Proyecto,Constructora,Numero_Habitaciones,Ciudad FROM Proyecto WHERE Clasificacion = 'Casa Campestre' AND Ciudad IN ('Barranquilla', 'Santa Marta', 'Cartagena')");
        
        ArrayList<Consulta2> respuesta = new ArrayList<>();
        
        while(res.next()){
            Consulta2 C2 = new Consulta2();
            C2.setId_proyecto(res.getInt("ID_Proyecto"));
            C2.setConstructora(res.getString("Constructora"));
            C2.setNumero_habitaciones(res.getInt("Numero_Habitaciones"));
            C2.setCiudad(res.getString("Ciudad"));
            respuesta.add(C2);
        }
        return respuesta;
    }
    
    public List<Consulta3> consulta3() throws SQLException {
        
        Connection conn = JDBCUtilities.getConnection();
        Statement consulta = conn.createStatement();
        ResultSet res = consulta.executeQuery("SELECT Y.ID_Compra,X.Constructora,X.Banco_Vinculado FROM PRoyecto X JOIN Compra Y ON X.ID_Proyecto = Y.ID_Proyecto WHERE Y.Proveedor = 'Homecenter' AND X.Ciudad = 'Salento'");
        
        ArrayList<Consulta3> respuesta = new ArrayList<>();
        
        while(res.next()){
            Consulta3 C3 = new Consulta3();
            C3.setId_compra(res.getInt("ID_Compra"));
            C3.setConstructora(res.getString("Constructora"));
            C3.setBanco_vinculado(res.getString("Banco_Vinculado"));
            respuesta.add(C3);
        }
        return respuesta;
    }
    
}
