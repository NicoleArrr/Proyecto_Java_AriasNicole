
package CONTROLADOR;

import MODELO.celular;
import MODELO.marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

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
            ps.setString(2, cel.getModelo());
            ps.setString(3, cel.getSistema_operativo());
            ps.setString(4, cel.getGama());
            ps.setDouble(5, cel.getPrecio());
            ps.setInt(6, cel.getStock());
            
            ps.executeUpdate();
            System.out.println("La actualización del celular se ha completado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM celular WHERE id=?");
            
            ps.setInt(1, id);
            System.out.println("""
                               -------------------
                               | ¿Deseas eliminar |  
                               |    la marca?     |
                               -------------------
                               |(Escribe la opción|
                               | numérica deseada)|
                               |                  |
                               |     1) SI        |
                               |     2) NO        |
                               -------------------
                               """);
            int op = new Scanner(System.in).nextInt();
            if (op == 1) {
                ps.executeUpdate();
                System.out.println("El celular se ha eliminado");
            } else {
                System.out.println("La eliminación del celular ha sido interrumpida");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public ArrayList<celular> listar() {
        ArrayList<celular> cels = new ArrayList<>();
        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM celular");
            
            while (rs.next()) {
                cels.add(new celular(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getDouble(6)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cels;
    }

    @Override
    public celular buscar(int id) {
        ArrayList<celular> cels = new ArrayList<celular>();
    }return cels;
    
}