
package VISTA;

// import CONTROLADOR.Conexion;
import java.util.Scanner;
//import CONTROLADOR.Validaciones;

public class TecnoStore {

    public static void main(String[] args) {
        
        int op;
        do {
            System.out.println("""
                                **********************
                                *  ¡BIENVENIDO A LA  *
                                * TIENDA TECNOSTORE! *
                                **********************
                                *  Escribe la opción *
                                *  numérica deseada  *
                                *                    *
                                * 0)    Salir        *
                                * 1)Gestion de Marca  *
                                * 2)Gestion de Celular*
                                * 3)Gestion de Cliente*
                                * 4)Gestion de Venta  *
                                ***********************
                               """);
            op = new Scanner(System.in).nextInt();
            while (op < 0 || op > 5) {
                System.out.println("Error, opcion no válida");
                op = new Scanner(System.in).nextInt();
            }
            switch (op) {
                case 1:
                    MenuMarca mm = new MenuMarca();
                    mm.menu();
                    break;
                case 2:
                    MenuCelular mc = new MenuCelular();
                    mc.menu();
                    break;
                case 3:
                    MenuCliente mcl = new MenuCliente();
                    mc.menu();
                    break;
                case 4:
                    MenuVenta mv = new MenuVenta();
                    mv.menu();
                case 5:
                    System.out.println("Gracias por usar nuestro sistema!");
                    break;
            }
        } while (op != 0);
        System.out.println("Gracias por visitar nuestra tienda y usar el programa \n ¡Te esperamos pronto!");
    }   
}
