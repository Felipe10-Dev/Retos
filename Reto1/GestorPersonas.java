package Reto1;

import java.util.Scanner;

public class GestorPersonas {

    // Definimos Los Respectivos Atributos De La Clase Con Un Modificador De Acceso "Private"
    private String nombres[];
    private int edades[];
    private char sexos[];

    // Definimos Sus Respectivos Metodos Constructores

    public GestorPersonas(String[] nombres, int[] edades, char[] sexos) {
        this.nombres = nombres;
        this.edades = edades;
        this.sexos = sexos;
    
    }
    
    // Constructor Vacio
    public GestorPersonas() {    
    }

    // Metodos Getters And Setters
    public String[] getNombres() {
        return this.nombres;
    }

    public void setNombres(String[] nombres) {
        this.nombres = nombres;
    }

    public int[] getEdades() {
        return this.edades;
    }

    public void setEdades(int[] edades) {
        this.edades = edades;
    }

    public char[] getSexos() {
        return this.sexos;
    }

    public void setSexos(char[] sexos) {
        this.sexos = sexos;
    }

    int cantidad; // Variable Que Almacena La Cantidad De Estudiantes A Registrar Proporcionada Por El Usuario

    // Metodos De Nuestra Clase Persona
    // Metodo Para Solicitar Y Almacenar Informacion Proporcionada Por El Usuario
    public void solicitarInformacion(Scanner scanner) {

        System.out.print("Cuantos Estudiantes Deseas Registrar?: ");
        cantidad = Integer.parseInt(scanner.nextLine());

        // Inicializar Los Arreglos Despues De Haberlos Declarado
        nombres = new String[cantidad];
        edades = new int[cantidad];
        sexos = new char[cantidad];

        System.out.println(); // Salto De Linea

        for (int i = 0; i < cantidad; i++) {

            // Guia Para El Usuario
            System.out.println("---------- Estudiante " + (i + 1) + " ----------");

            // Solicitamos El Nombre
            System.out.print("Digita El Nombre: ");
            nombres[i] = scanner.nextLine();

            // Solicitamos La Edad
            System.out.print("Digita La Edad: ");
            edades[i] = Integer.parseInt(scanner.nextLine());

            // Solicitamos El Sexo
            System.out.print("Digita El Sexo(M/F): ");
            sexos[i] = scanner.nextLine().toUpperCase().charAt(0);

            System.out.println(); // Salto De Linea

        }
        

    }  // Llave Final Del Metodo

    // Metodo Para Imprimir La Informacion Almacenada En Cada Uno De Los Arrays
    public void imprimirInformacion() {

        String mensajeMenor = " - Menor De Edad"; // Variable Que Almacenara El Mensaje De Menor De Edad ¿ 

        // Separa La Solicitud Con La Impresion De La Informacion
        System.out.println("------------------------------------------------------------------------------------------------------------\n");

        // Ciclo For Para Recorrer Cada Arreglo E Imprimir Su Respectiva Informacion
        for (int i = 0; i < cantidad; i++) {

            // Guia Para El Usuario
            System.out.println("---------- Estudiante " + (i + 1) + " ----------");

            // Si > Condicional Para Validar La Edad Del Usuario
            if (edades[i] < 18) {

                System.out.printf("""                          
                          Nombre: %s
                          Edad: %d%s
                          Sexo: %c
                          """, nombres[i], 
                          edades[i], 
                          mensajeMenor, 
                          sexos[i]);

            } else { // Sino 

                System.out.printf("""                          
                          Nombre: %s
                          Edad: %d
                          Sexo: %c
                          """, nombres[i], edades[i], sexos[i]);

            }
            
            System.out.println(); // Salto De Linea

        }

    } // Llave Final De Imprimir Informacion
    
    
}
