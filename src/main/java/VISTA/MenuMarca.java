
package VISTA;

import CONTROLADOR.GestionarMarca;
import CONTROLADOR.GestionarMarcaAbs;
import MODELO.marca;
import CONTROLADOR.Validaciones;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuMarca {
    Validaciones v = new Validaciones();
    GestionarMarcaAbs gm = new GestionarMarca();
        
        private void registrar() {
            marca m = new marca();
            System.out.println("Ingrese el nombre de la marca:");
            m.setNombre(new Scanner(System.in).nextLine());
            gm.registrar(m);
        }

        private void actualizar() {
            System.out.println("Ingrese el id de la marca correspondiente a buscar");
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

        private void buscar() {
            System.out.println("Ingrese el id de la marca correspondiente a buscar");
            int id = new Scanner(System.in).nextInt();
            marca m = gm.buscar(id);
            if (m != null) {
                System.out.println("Marca" +m+ "encontrada");
            } else {
                    System.out.println("Error, La marca no existe");
                }
        }
        
        private void eliminar() {
            System.out.println("Ingrese el id de la marca a eliminar");
            int id = new Scanner(System.in).nextInt();
            gm.eliminar(id);
        }

        private void listar() {
            ArrayList<marca> marcas = gm.listar();
            for (marca m : marcas) {
            System.out.println(m);
            }
        }
        
    public void menu() {
        int op = 0;
        do {
            System.out.println("""
                                       ******************
                                           MENU MARCA
                                       ******************
                                       Escribe la opción
                                        numérica deseada
                                       
                                            1)  Registrar
                                            2)  Actualizar
                                            3)  Buscar
                                            4)  Eliminar
                                            5)  Mostrar
                                            6)  Regresar
                                       """);
            op = new Scanner(System.in).nextInt();
            switch(op){
                case 1:
                    registrar();
                case 2:
                    actualizar();
                case 3:
                    buscar();
                case 4:
                    eliminar();
                case 5:
                    listar();
            }            
        } while (op != 6);
    }
}
