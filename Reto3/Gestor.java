package Reto3;

import java.util.ArrayList;
import java.util.Scanner;

public class Gestor {

    // Definimos Los Atributos Con Su Respectivo Modificador De Acceso
    private ArrayList<Persona> personas = new ArrayList<>();

    // Metodos Propios De La Clase
    // Metodo Para Solicitar Informacion Al Usuario
    public void registrarPersonas(Scanner scanner) {

        // Solicitamos La Cantidad De Personas Que Va A Registrar En La Nomina
        System.out.print("Digita La Cantidad De Personas A Registrar: ");
        int cantidadPersonas = Integer.parseInt(scanner.nextLine());

        System.out.println(); // Salto De Linea

        // Ciclo Que Recorre La Cantidad De Veces La Cantidad De Personas Proporcionada Por El Usuario
        for (int i = 0; i < cantidadPersonas; i++) {

            // Guia Para El Usuario
            System.out.println("\t---------- Persona ".toUpperCase() + (i + 1) + " ----------");

            // Solicitamos Nombre 
            System.out.print("Digita Tu Nombre: ");
            String nombre = scanner.nextLine().toLowerCase().trim();

            // Solicitamos Edad
            System.out.print("Digita Tu Edad: ");
            int edad = Integer.parseInt(scanner.nextLine());

            // Solicitamos Profesion
            System.out.print("Digita Tu Profesion: ");
            String profesion = scanner.nextLine();

            // Solicitamos Sueldo
            System.out.print("Digita Tu Sueldo: ");
            double sueldo = Double.parseDouble(scanner.nextLine());

            // Validacion De La Edad
            if (edad > 0) {

                // Almacenamos La Informacion En Un Objeto De La Clase Persona
                Persona personaNueva = new Persona(nombre, edad, profesion, sueldo);

                // Añadimos La Persona A Nuestra ArrayList De Tipo Persona
                personas.add(personaNueva);

            } else { // Si No

                // Mensaje
                System.out.println("\tLa Edad No Es Valida".toUpperCase());

            }

            System.out.println(); // Salto De Linea

        }

    }

    // Metodo Para Imprimir Informacion De Cada Persona
    public void listarPersonas() {

        if (personas.isEmpty()) {

            System.out.println("\tNo Existen Personas En La Lista".toUpperCase());

        } else {

            int contador = 1;  // Contador De Personas

            // Ciclo Que Recorre Nuestra Lista
            for (Persona person : personas) {

                // Mostrar Mensaje De Guia Al Usuario
                System.out.println("\t---------- Persona ".toUpperCase() + contador + " ----------");

                // Impresion Formateada De Los Datos Completos Del Usuario En Un Text Block
                System.out.println("""
                             Nombres: %s
                             Edad: %d
                             Profesion: %s 
                             Sueldo: $%.2f
                             """.formatted(person.getNombre(), person.getEdad(), person.getProfesion(), person.getSueldo()));

                contador++; // Postincremento 

            }
        }

    }

    // Metodo Para Eliminar Una Persona De La Lista
    public void eliminarPersonaPorNombre(Scanner scanner) {

        // Banderas
        boolean eliminar = false;
        Persona personaAEliminar = null;

        // Validacion
        if (personas.isEmpty()) {

            // Mensaje
            System.out.println("\tNo Existen Personas En La Lista".toUpperCase());

        } else {

            // Solicitar Informacion Al Usuario
            System.out.print("Digita El Nombre De La Persona Que Deseas Eliminar: ");
            String nombrePersonaEliminar = scanner.nextLine().toLowerCase().trim();

            // Ciclo Para Recorrer La Lista
            for (Persona person : personas) {

                // Validacion Si Recorriendo La Lista El Nombre Proporcionado De La Persona Es Similar A Uno Que Se Encuentre En La Lista
                if (person.getNombre().equalsIgnoreCase(nombrePersonaEliminar)) {

                    eliminar = true; // Si Se Cumple La Condicion Cambia A True Su Valor
                    personaAEliminar = person;  // Variablle Que Almacenara El Elemento De Nuestra Lista(Que Cumple La Condicion)

                }

            }

            // Validacion Para Verificar Si Encontro Un Elemento Similar
            if (eliminar == true) {

                System.out.println(); // Salto De Linea

                personas.remove(personaAEliminar);  // Si Lo Encontro Entonces Eliminar
                System.out.println("\tPersona Eliminada Exitosamente".toUpperCase()); // Mensaje Exitoso

                System.out.println(); // Salto De Linea
                
                // Imprimimos La Informacion De Personas Actualizadas Una Vez Se Haya Hecho La Eliminacion 
                listarPersonas();

            } else { // Si No

                System.out.println(); // Salto De Linea 

                // Imprimir Mensaje 
                System.out.println("\tLa Persona No Existe".toUpperCase());

                System.out.println(); // Salto De Linea
            }

        }

    }

    // Metodo Para Modificar La Informacion De La Persona
    public void modificarInformacionPersona(Scanner scanner) {

        // Banderas
        boolean encontrado = false;
        int contador = 1; // Contador

        // Validacion
        if (personas.isEmpty()) {

            // Mensaje
            System.out.println("\tNo Existen Personas En La Lista".toUpperCase());

        } else {

            // Solicitamos Informacion A El Usuario
            System.out.print("Digita El Nombre De La Persona Que Deseas Modificar Su Informacion: ");
            String modificarInformacion = scanner.nextLine().toLowerCase().trim();

            // Ciclo Que Recorre La ArrayList De Persona
            for (Persona person : personas) {

                // Valida Si Existe El Nombre De La Persona Proporcionada Por El Usuario En La Lista
                if (person.getNombre().equalsIgnoreCase(modificarInformacion)) {
                    encontrado = true; // Si Lo Encuentra Cambia Su Valor A True

                    System.out.println(); // Salto De Linea

                    // Guia Para El Usuario
                    System.out.println("\t---------- Persona ".toUpperCase() + contador + " ----------");

                    // Solicitamos Nombre 
                    System.out.print("Digita Tu Nombre: ");
                    String nombre = scanner.nextLine().toLowerCase().trim();

                    // Solicitamos Edad
                    System.out.print("Digita Tu Edad: ");
                    int edad = Integer.parseInt(scanner.nextLine());

                    // Solicitamos Profesion
                    System.out.print("Digita Tu Profesion: ");
                    String profesion = scanner.nextLine();

                    // Solicitamos Sueldo
                    System.out.print("Digita Tu Sueldo: ");
                    double sueldo = Double.parseDouble(scanner.nextLine());

                    // Añadimos La Persona A Nuestra ArrayList De Tipo Persona
                    person.setNombre(nombre);
                    person.setEdad(edad);
                    person.setProfesion(profesion);
                    person.setSueldo(sueldo);

                    System.out.println(); // Salto De Linea

                    listarPersonas(); // Listamos Las Personas Despues Del Cambio

                    System.out.println(); // Salto De Linea

                    break; // Salimos Porque Ya Lo Encontramos

                }

                contador++; // Postincremento

            }

            // Valida Que Si El Sistema No Encontro La Persona Muestre Un Mensaja 
            if (!encontrado) {

                System.out.println(); // Salto De Linea

                // Mostrar Mensaje 
                System.out.println("\tNo Se Encontro Una Persona Con Ese Nombre".toUpperCase());

                System.out.println(); // Salto De Linea
            }
            
        }

    }

    // Metodo Para Buscar Persona Por Nombre
    public void buscarPersonaPorNombre(Scanner scanner) {

        // Validacion
        if (personas.isEmpty()) {

            // Mensaje
            System.out.println("\tNo Existen Personas En La Lista".toUpperCase());

        } else {

            // Banderas
            boolean encontrado = false;

            // Solicitamos Informacion A El Usuario
            System.out.print("Digita El Nombre De La Persona Que Deseas Buscar: ");
            String nombrePersona = scanner.nextLine().toLowerCase().trim();

            // Ciclo for-each Para Recorrer Nuestra Lista
            for (Persona person : personas) {

                // Validamos Que La El Nombre De La Persona Proporcionado Por El Usuario Se Encuentre En La Lista
                if (person.getNombre().equalsIgnoreCase(nombrePersona)) {

                    encontrado = true; // Cambiamos El Valor Si Se Cumple La Condicion

                    System.out.println(); // Salto De Linea

                    // Guia Para El Usuario
                    System.out.println("\t---------- Persona Encontrada".toUpperCase() + " ----------");

                    // Imprimimos La Informacion Formateada
                    System.out.println("""
                                   Nombre: %s 
                                   Edad: %d
                                   Profesion: %s 
                                   Sueldo: $%.2f
                                   """.formatted(person.getNombre(), person.getEdad(), person.getProfesion(), person.getSueldo()));

                    break; // Salimos Del Ciclo

                }

            }

            // Validacion Si No Se Encuentra La Persona
            if (!encontrado) {

                System.out.println(); // Salto De Linea

                // Mensaje
                System.out.println("\tLa Persona No Existe".toUpperCase());

                System.out.println(); // Salto De Linea

            }

        }

    }

    // Metodo Para Filtrar Personas Con El Salario Mayor A Un Cierto Rango
    public void filtrarPersonasConSalarioMinimo(Scanner scanner) {

        // Validacion
        if (personas.isEmpty()) {

            // Mensaje
            System.out.println("\tNo Existen Personas En La Lista".toUpperCase());

        } else {

            // Bandera
            boolean rangoEncontrado = false;

            // Solicitamos Informacion Al Usuario
            System.out.print("Digita El Rango Minimo Para Realizar La Busqueda: ");
            double rangoSalarial = Double.parseDouble(scanner.nextLine());

            // Ciclo Para Recorrer La Lista
            for (Persona person : personas) {

                // Validacion Para Encontrar Las Personas Con El Sueldo Minimo O Mas
                if (person.getSueldo() >= rangoSalarial && rangoSalarial > 0) {

                    System.out.println(); // Salto De Linea

                    // Guia Para El Usuario
                    System.out.println("\t---------- Persona Encontrada".toUpperCase() + " ----------");

                    // Imprimimos La Informacion Formateada
                    System.out.println("""
                                   Nombre: %s 
                                   Edad: %d
                                   Profesion: %s 
                                   Sueldo: $%.2f
                                   """.formatted(person.getNombre(), person.getEdad(), person.getProfesion(), person.getSueldo()));

                }

            }

            // Validacion Si No Existe Una Persona En Ese Rango De Precios
            if (rangoEncontrado) {

                System.out.println(); // Salto De Linea

                // Imprimimos Un Mensaje
                System.out.println("\tNo Existen Personas Con Dentro De Ese Rango Salarial".toUpperCase());

                System.out.println(); // Salto De Linea

            }

        }

    }

    // Metodo Para Manejar El Menu Interactivo
    public void menuInteractivo(Scanner scanner) {

        // Bandera Que Controla El Flujo Del Programa
        boolean salir = false;

        while (!salir) {

            System.out.print("""
                           \t---------- Gestion De Empleados ----------
                           1. Registrar Personas
                           2. Buscar Personas
                           3. Modificar Personas
                           4. Eliminar Personas 
                           5. Listar Personas
                           6. Filtrar Personas
                           7. Salir
                           """);
            System.out.print("Digita La Opcion Que Deseas Realizar: "); // Solicitamos Info Al Usuario
            int opcion = Integer.parseInt(scanner.nextLine());

            System.out.println(); // Salto De Linea

            switch (opcion) {

                case 1:
                    registrarPersonas(scanner); // Llamamos Metodo
                    break;

                case 2:
                    buscarPersonaPorNombre(scanner); // Llamamos Metodo
                    break;

                case 3:
                    modificarInformacionPersona(scanner); // Llamamos Metodo
                    break;

                case 4:
                    eliminarPersonaPorNombre(scanner); // Llamamos Metodo
                    break;

                case 5:
                    listarPersonas(); // Llamamos Metodo
                    break;

                case 6:
                    filtrarPersonasConSalarioMinimo(scanner); // Llamamos Metodo
                    break;

                case 7:
                    salir = true; // Cambiamos
                    System.out.println("Saliendo Del Programa......"); // Mensaje
                    break;

                default:
                    System.out.println("\tNo Existe La Opcion Digitada".toUpperCase());
                    break;

            }

        }

    }

}
