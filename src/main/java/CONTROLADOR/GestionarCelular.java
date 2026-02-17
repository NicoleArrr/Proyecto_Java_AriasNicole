
package CONTROLADOR;

import MODELO.celular;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

//En esta clase se definen los métodos creados desde la clase abstracta GestionarCelularAbs

public class GestionarCelular implements GestionarCelularAbs{
    Conexion c = new Conexion();

    @Override
    public void guardar(celular cel) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO celular(modelo, sistema_operativo, gama, precio, stock) VALUES (?,?,?,?,?)");
            // Asignación de valores a los atributos
            ps.setString(1, cel.getModelo());
            ps.setString(2, cel.getSistema_operativo());
            ps.setString(3, cel.getGama());
            ps.setDouble(4, cel.getPrecio());
            ps.setInt(5, cel.getStock());
            
            ps.executeUpdate();
            System.out.println("El registro del celular se ha completado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizar(celular cel, int id) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("UPDATE celular SET (modelo, sistema_operativo, gama, precio, stock) VALUES (?,?,?,?,?)");
            // Asignación de valores a los atributos
            ps.setString(1, cel.getModelo());
            ps.setString(2, cel.getSistema_operativo());
            ps.setString(3, cel.getGama());
            ps.setDouble(4, cel.getPrecio());
            ps.setInt(5, cel.getStock());
            
            ps.executeUpdate();
            System.out.println("La actualización del celular se ha completado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        
    }

    @Override
    public ArrayList<celular> listar() {
        ArrayList<celular> cels = new ArrayList<>();   
    } return cels;

    @Override
    public celular buscar(int id) {
        celular cel = new celular();
    }return cel;
    
}