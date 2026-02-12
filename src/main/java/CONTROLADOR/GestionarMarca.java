
package CONTROLADOR;

import MODELO.marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Statement;

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
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("La actualización de la marca se ha completado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public marca buscar(int id) {
        marca m = null;
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("SELECT m.id,m.nombre from marca m where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                m = new marca();
                m.setId(rs.getInt("id"));
                m.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return m;
    }
    
    @Override
    public void eliminar(int id) {
        try (Connection con = c.conectar()) {
            //La usamos cuando queremos hacer una inserción o modificacion a la base de datos.
            PreparedStatement ps = con.prepareStatement("delete from area where id=?");
            ps.setInt(1, id);
            int op = new Scanner(System.in).nextInt();
            if (op == 0) {
                ps.executeUpdate();
                System.out.println("La marca se ha eliminado");
            } else {
                System.out.println("La eliminación de la marca ha sido interrumpida");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<marca> listar() {
        ArrayList<marca> marcas = new ArrayList<>();
        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM marca");
            while (rs.next()) {
                marcas.add(new marca(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return marcas;
    } 
}
