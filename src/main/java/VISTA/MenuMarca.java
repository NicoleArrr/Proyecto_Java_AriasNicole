
package VISTA;

import CONTROLADOR.GestionarMarca;
import CONTROLADOR.GestionarMarcaAbs;
import MODELO.marca;
import CONTROLADOR.Validaciones;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuMarca {
    Validaciones v = new Validaciones();
    GestionarMarcaAbs gm = new GestionarMarca() {
        
        private void registrar() {
            marca m = new marca();
            System.out.println("Ingrese el nombre de la marca:");
            m.setNombre(new Scanner(System.in).nextLine());
            gm.registrar(m);
        }

        private void actualizar() {
            System.out.println("Ingrese el id de la marca correspondiente a la búsqueda");
            int id = new Scanner(System.in).nextInt();
            marca m = gm.buscar(id);
            if (m != null) {
                System.out.println("Marca" +m+ "encontrada");
                System.out.println("Ingresa la nueva marca");
                m.setNombre(new Scanner(System.in).nextLine());
                gm.actualizar(m, id);
            } else {
                    System.out.println("Error en la búsqueda, intenta de nuevo");
                }  
        }

        private void eliminar() {
            
        }

        public ArrayList<marca> listar() {
            
        }

        public marca buscar() {
        
        }
    };
}
