
package CONTROLADOR;

import MODELO.cliente;
import java.util.ArrayList;

// Esta interface o contrato denota simplemente los métodos s redefinir en la clase GestionarCliente

public interface GestionarClienteAbs {

    void guardar(cliente clt);

    void actualizar(cliente clt, int id);

    void eliminar(int id);

    ArrayList<cliente> listar();

    cliente buscar(int id);
}
