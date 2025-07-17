package Reto2;

import java.util.Scanner;

public class Main {

    // Metodo Main
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Instanciamos La Clase Scanner 
        
        Inventario donSalomon = new Inventario(); // Instanciamos La Clase Scanner
        
        donSalomon.menuIterativo(scanner); // Llamamos El Metodo Menu Iterativo Que Es La Que Lleva El Flujo De Todo El Programa
        
        
        scanner.close(); // Cerramos El Scanner Para Liberar Recursos
         
        
        
    }

}
