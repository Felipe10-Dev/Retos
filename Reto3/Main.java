package Reto3;

import java.util.Scanner; // Importamos La Clase Scanner

public class Main {

    // Metodo Principal
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Instanciamos La Clase Scanner

        Gestor dondePacho = new Gestor(); // Instanciamos La Clase Gestor

        dondePacho.menuInteractivo(scanner);
        
        scanner.close(); // Cerramos El Scanner Para Liberar Recursos 
       

    }

}
