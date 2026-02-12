
package CONTROLADOR;

import MODELO.marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

//En esta clase se definen los métodos creados desde la clase abstracta GestionarMarcaAbs

public class GestionarMarca implements GestionarMarcaAbs{
        Conexion c = new Conexion();

    @Override
    public void registrar(marca mrc) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO marca(nombre) values (?)");
            ps.setString(1, mrc.getNombre());
            ps.executeUpdate();
            System.out.println("El registro de la marca se ha completado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public void actualizar(marca mrc, int id) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("UPDATE marca SET nombre=? where id=?");
            ps.setString(1, mrc.getNombre());
            ps.setInt(2, mrc.getId());
            ps.executeUpdate();
            System.out.println("La actualización de la marca se ha completado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public marca buscar(int id) {
        marca m = new marca();
    }
    
    @Override
    public void eliminar(int id) {
        
    }

    @Override
    public ArrayList<marca> listar() {
        
    }

    
}
