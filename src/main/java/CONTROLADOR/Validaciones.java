
package CONTROLADOR;

import MODELO.celular;
import java.util.Scanner;

public class Validaciones {
   
   public int validarEntero (String mensaje, int minvalor, int maxvalor){
       
       int op = 0;
       boolean boleanito = false;
       do {           
           try {
               System.out.println(mensaje);
               op = new Scanner(System.in).nextInt();
               while (op < minvalor || op > maxvalor){
                   System.out.println("Opción no válida \n Por favor, escribe una opción numérica 0,1,2,3,4 o 5");
                   op = new Scanner(System.in).nextInt();
                   boleanito = true;
               }
           } catch (Exception e){
               System.out.println("Opción no válida. Solo se aceptan números enteros");
           }
           
       } while (boleanito == true);
       return op;
   }
   
   public double validarPrecio(double precio) {
    Scanner sc = new Scanner(System.in);

    do {
        try {
            System.out.println("Ingresa el precio:");
            precio = sc.nextDouble();

            if (precio < 0) {
                System.out.println("Precio no válido. Por favor, escribe un valor mayor o igual a 0");
            }

        } catch (Exception e) {
            System.out.println("Precio no válido. Solo se aceptan números mayores o iguales a 0");
            sc.nextLine();
        }

    } while (precio < 0);

    return precio;
    }
   
   public int validarStock(int stock) {
    Scanner sc = new Scanner(System.in);

    do {
        try {
            System.out.println("Ingresa el stock:");
            stock = sc.nextInt();

            if (stock < 0) {
                System.out.println("Stock no válido. Por favor, escribe un valor mayor o igual a 0");
            }

        } catch (Exception e) {
            System.out.println("Stock no válido. Solo se aceptan números enteros mayores o iguales a 0");
            sc.nextLine();
        }

    } while (stock < 0);

    return stock;
    }
   
   public String validarCorreo(String correo) {
    Scanner sc = new Scanner(System.in);

    do {
        try {
            if (!correo.contains("@")) {
            System.out.println("Correo no válido. El correo debe contener @");
            }

        } catch (Exception e) {
            System.out.println("Error al leer el correo. Intenta de nuevo.");
            sc.nextLine();
        }
        
    } while (!correo.contains("@"));

    return correo;
}
       
}