package util;

import java.util.Scanner;

public class Validador {

    // Validar entero
    public static int leerEntero(Scanner sc, String mensaje){
        while (true){
            System.out.print(mensaje);
            if (sc.hasNextInt()){
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            } else{
                System.out.println("Ese no es un dato valido, por favor intenta de nuevo");
                sc.nextLine();
            }
        }
    }

    // Validar double
    public static double leerDouble(Scanner sc, String mensaje){
        while (true){
            System.out.print(mensaje);
            if (sc.hasNextDouble()){
                double valor = sc.nextDouble();
                sc.nextLine();
                return valor;
            } else{
                System.out.println("Ese no es un dato valido, por favor intenta de nuevo");
                sc.nextLine();
            }
        }
    }

    // Validar String

    public static String leerTexto(Scanner sc, String mensaje){
        while (true){
            System.out.print(mensaje);
            String texto = sc.nextLine();
            if(!texto.trim().isEmpty()){
                return texto;
            } else {
                System.out.println("Eso no es un textro valido, por favor intenta de nuevo");
            }
        }
    }
}
