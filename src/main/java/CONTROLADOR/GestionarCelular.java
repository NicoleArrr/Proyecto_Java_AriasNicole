
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
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM marca WHERE id=?");
            
            ps.setInt(1, id);
            System.out.println("""
                               -------------------
                               | ¿Deseas eliminar |  
                               |    el celular?   |
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
                System.out.println("El celular ha sido eliminado");
            } else {
                System.out.println("La eliminación del celular ha sido interrumpida");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<celular> listar() {
        ArrayList<celular> celulares = new ArrayList<>();
        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM celular");
            System.out.println("Consulta en ejecución ...");
            while (rs.next()) {
                //Instanciar las clases
                marca mrc = new marca();
                mrc.setId(rs.getInt(1));
                mrc.setNombre(rs.getString(2));
                
                celular cel = new celular();
                cel.setId(rs.getInt(3));
                cel.setModelo(rs.getString(4));
                cel.setSistema_operativo(rs.getString(5));
                cel.setGama(rs.getString(6));
                cel.setPrecio(rs.getDouble(7));
                
                cel.setId_marca(mrc);
                celulares.add(cel);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return celulares;
    } 
        

    @Override
    public celular buscar(int id) {
        celular cel = null;
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("SELECT c.*, m.nombre AS nombre_marca FROM celular c INNER JOIN marca m ON c.id_marca = m.id WHERE c.id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cel = new celular();

                cel.setId(rs.getInt("id"));
                cel.setModelo(rs.getString("modelo"));
                cel.setSistema_operativo(rs.getString("sistema_operativo"));
                cel.setGama(rs.getString("gama"));
                cel.setStock(rs.getInt("stock"));
                cel.setPrecio(rs.getDouble("precio"));

                marca mrc = new marca();
                mrc.setId(rs.getInt("id_marca"));
                mrc.setNombre(rs.getString("nombre_marca"));

                cel.setId_marca(mrc);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }return cel;
    
}