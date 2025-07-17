package Reto1;

import java.util.Scanner;

public class Main  {

    // Metodo Principal
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // instanciamos La Clase Scanner
        GestorPersonas Segundo = new GestorPersonas(); // Instanciamos La Clase Persona

       
        boolean salir = false; // Bandera para controlar si salimos del programa
        
        Persona hermana = new Persona("Sara Isabella", 12, 'F'); 
        System.out.println(hermana.toString());
        
        

        while (!salir) {
            
            Segundo.solicitarInformacion(scanner);
            Segundo.imprimirInformacion();

            System.out.print("¿Deseas salir? Escribe 'fin' para salir o cualquier otra cosa para continuar: ");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("fin")) {
                salir = true;
            }

            System.out.println(); // Salto de línea
        }

        scanner.close(); // Cerramos Scanner al final del todo

        System.out.println("Programa finalizado correctamente.");

    }

}
