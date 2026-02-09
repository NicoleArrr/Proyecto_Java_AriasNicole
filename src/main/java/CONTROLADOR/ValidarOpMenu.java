
package CONTROLADOR;

import java.util.Scanner;

public class ValidarOpMenu {
   
   public int validarop_mp (String mensaje, int minvalor, int maxvalor){
       
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
}
