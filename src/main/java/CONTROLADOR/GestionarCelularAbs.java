
package CONTROLADOR;

import MODELO.celular;
import java.util.ArrayList;

// Esta interface o contrato denota simplemente los métodos s redefinir en la clase GestionarCelular

public interface GestionarCelularAbs {

    void guardar(celular cel);

    void actualizar(celular cel, int id);

    void eliminar(int id);

    ArrayList<celular> listar();

    celular buscar(int id);
}
