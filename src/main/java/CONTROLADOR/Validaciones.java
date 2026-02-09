
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
        do {           
           try {
               System.out.println("validando precio");
               precio = new Scanner (System.in).nextDouble();
               while (precio < 0){
                   System.out.println("Precio no válido \n Por favor, escribe un valor mayor a igual a 0");
                   precio = new Scanner(System.in).nextDouble();
               }
           } catch (Exception e){
               System.out.println("Precio no válido. Solo se aceptan números mayores a iguales a 0");
           }
           
       } while (precio >= 0);
       return precio;
    }
   
}
