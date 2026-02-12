
package VISTA;

// import CONTROLADOR.Conexion;
import CONTROLADOR.GestionarMarca;
import java.util.Scanner;
//import CONTROLADOR.Validaciones;

public class TecnoStore {

    public static void main(String[] args) {
        // Declarar las clases en variables e importar los paquetes
        GestionarMarca gm = new GestionarMarca;
        
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
                                * 1)Gestionar Marca  *
                                * 2)Gestionar Celular*
                                * 3)Gestionar Cliente*
                                * 4)Gestionar Venta  *
                                **********************
                               """);
            op = new Scanner(System.in).nextInt();
            while (op < 0 || op > 5) {
                System.out.println("Error, opcion no válida");
                op = new Scanner(System.in).nextInt();
            }
            switch (op) {
                case 1:
                    System.out.println("""
                                       ******************
                                           MENU MARCA
                                       ******************
                                       Escribe la opción
                                        numérica deseada
                                       
                                            1)  Registar
                                            2)  Actualizar
                                            3)  Buscar
                                            4)  Eliminar
                                            5)  Mostrar
                                       """);
                    
                    break;
                case 2:
                    MenuCelular mc =new MenuCelular();
                    e.menu();
                    break;
                case 3:
                    
                    break;
                case 4:
                    System.out.println("Gracias por usar nuestro sistema!");
                    break;
            }
        } while (op != 0);
        System.out.println("Gracias por visitar nuestra tienda y usar el programa \n ¡Vuelve pronto!");
    }   
}
