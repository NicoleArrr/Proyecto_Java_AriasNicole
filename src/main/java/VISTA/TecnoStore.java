
package VISTA;

import CONTROLADOR.Conexion;
import CONTROLADOR.Validaciones;

public class TecnoStore {

    public static void main(String[] args) {
        Conexion c = new Conexion();
        c.conectar();
        Validaciones ve = new Validaciones();
        
        System.out.println("""
                            *********************
                            *   ¡BIENVENIDO AL  *
                            *     PROGRAMA!     *
                            *********************
                            * Escribe la opción *
                            *      numérica     *
                            *  correspondiente  *
                            *                   *
                            *                   *
                           """);
    }   
}
