
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
                   System.out.println("Opción no válida \n Por favor, escribe una opción numérica 1,2 o 3");
                   op = new Scanner(System.in).nextInt();
                   boleanito = true;
               }
           } catch (Exception e){
               System.out.println("Opción no válida. Solo se aceptan números enteros");
           }
           
       } while (boleanito == true);
       return op;
   }
   
   private double validarPrecio(double precio) {
    Scanner scanner = new Scanner(System.in);

    do {
        try {
            System.out.println("Ingresa el precio:");
            precio = scanner.nextDouble();

            if (precio < 0) {
                System.out.println("Precio no válido. Por favor, escribe un valor mayor o igual a 0");
            }

        } catch (Exception e) {
            System.out.println("Precio no válido. Solo se aceptan números mayores o iguales a 0");
            scanner.nextLine();
        }

    } while (precio < 0);

    return precio;
    }
   
   private int validarStock(int stock) {
    Scanner scanner = new Scanner(System.in);

    do {
        try {
            System.out.println("Ingresa el stock:");
            stock = scanner.nextInt();

            if (stock < 0) {
                System.out.println("Stock no válido. Por favor, escribe un valor mayor o igual a 0");
            }

        } catch (Exception e) {
            System.out.println("Stock no válido. Solo se aceptan números enteros mayores o iguales a 0");
            scanner.nextLine();
        }

    } while (stock < 0);

    return stock;
    }
       
}
