
package CONTROLADOR;

import MODELO.marca;
import java.util.ArrayList;

public interface GestionarMarcaAbs {

    void guardar(marca mrc);

    void actualizar(marca mrc, int id);

    void eliminar(int id);

    ArrayList<marca> listar();

    marca buscar(int id);
}
