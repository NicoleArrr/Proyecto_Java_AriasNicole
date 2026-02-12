
package CONTROLADOR;

import MODELO.marca;
import java.util.ArrayList;

// Esta interface o contrato denota simplemente los métodos s redefinir en la clase GestionarMarca

public interface GestionarMarcaAbs {

    void registrar(marca mrc);

    void actualizar(marca mrc, int id);

    void eliminar(int id);

    ArrayList<marca> listar();

    marca buscar(int id);
}
