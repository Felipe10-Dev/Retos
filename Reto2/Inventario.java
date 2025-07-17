package Reto2;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {

    // Definimos Los Atributos 
    private ArrayList<String> nombre = new ArrayList<>();
    private ArrayList<Integer> cantidad = new ArrayList<>();
    private ArrayList<Double> precio = new ArrayList<>();

    // Constructor Vacio
    public Inventario() {
    }

    // Metodos Getters And Setters
    public ArrayList<String> getNombre() {
        return this.nombre;
    }

    public void setNombre(ArrayList<String> nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integer> getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(ArrayList<Integer> cantidad) {
        this.cantidad = cantidad;
    }

    public ArrayList<Double> getPrecio() {
        return this.precio;
    }

    public void setPrecio(ArrayList<Double> precio) {
        this.precio = precio;
    }

    // Otros Metodos De La Clase

    // Metodo Para Agregar Productos
    public void agregarProductos(Scanner scanner) {

        // Solicitamos La Cantidad De Productos Que Se Desea Agregar
        System.out.print("Cuantos Productos Deseas Agregar: ");
        int cantidadProductosAgregar = Integer.parseInt(scanner.nextLine());

        // Agregamos Un Condicional Para Validar Que La Entrada De Usuario Sea Positiva
        if (cantidadProductosAgregar > 0) {

            // Ciclo Que Recorre Y Solicita Informacion Sobre Un Producto
            for (int i = 0; i < cantidadProductosAgregar; i++) {

                System.out.println(); // Salto De Linea

                System.out.println("\t---------- Producto ".toUpperCase() + (i + 1) + " ----------");

                // Solicitamos El Nombre
                System.out.print("Digita El Nombre Del Producto: ");
                nombre.add(scanner.nextLine().toLowerCase().trim());

                // Solicitamos La Cantidad
                System.out.print("Digita La Cantidad(Unidad) Del Producto: ");
                cantidad.add(Integer.parseInt(scanner.nextLine()));

                // Solicitamos El Precio
                System.out.print("Digita El Precio Del Producto: ");
                precio.add(Double.parseDouble(scanner.nextLine()));

                System.out.println("\tProducto Añadido Correctamente.".toUpperCase()); // Mensaje Para El Cliente

            }

        } else {
            
            System.out.println("\tLa Cantidad Debe Ser Positiva".toUpperCase());
            
        }

    } // Llave Final Metodo

    // Metodo Para Listar Productos
    public void listarProductos() {

        // Validacion Donde Validamos Valga La Rebundancia Que Verifica Que Todos Los ArrayList Esten Vacios
        if (nombre.isEmpty() && cantidad.isEmpty() && precio.isEmpty()) {

            // Si Es Asi Se Ejecuta Esta Linea
            System.out.println("\tNo Existe Ningun Producto".toUpperCase());

            
        } else {

            // Ciclo Que Recorre Nuestra Lista 
            for (int i = 0; i < cantidad.size(); i++) {

                System.out.println("\t---------- Producto ".toUpperCase() + (i + 1) + " ----------");
                
                // Imprime La Lista De Los Productos Con La Informacion Formateada Y En Un Text Block
                System.out.println("""
                               Nombre: %s
                               Cantidad: %d
                               Precio: $%.2f
                               """.formatted(nombre.get(i), cantidad.get(i), precio.get(i)));

            }

        }

    } // Llave Final Metodo 

    // Metodo Para Eliminar Productos Por Nombre 
    public void eliminarProductosPorNombre(Scanner scanner) {

        // Variable Que Controla El Flujo De El Ciclo For 
        boolean encontrado = false;

        // Solicitamos El Nombre Del Producto A Eliminar
        System.out.print("Digita El Nombre Del Producto Que Deseas Eliminar: ");
        String nombreProductoAEliminar = scanner.nextLine().toLowerCase().trim();

        // Ciclo Que Lo Utilizamos Para Recorrer Nuestro Array
        for (int i = 0; i < nombre.size(); i++) {

            // Validacion Que Utilizamos Para Encontrar Si Los Nombres Del Producto Coinciden Para Ser Eliminado
            if (nombre.get(i).equals(nombreProductoAEliminar)) {

                // Si Lo Encuentra Lo Remueve Lo Elimina Del ArrayList
                nombre.remove(nombreProductoAEliminar);
                cantidad.remove(i);
                precio.remove(i);

                System.out.println(); // Añadimos Un Salto De Linea
                
                // Mensaje De Confirmacion
                System.out.print("\tProducto Eliminado Correctamente".toUpperCase());

                // Asignamos Verdadero A La Variable Para Dar A Conocer Que Si Existe En El ArrayList
                encontrado = true;

            }

        }

        System.out.println(); // Agregamos Un Salto De Linea
        
        // Validacion En Caso De Que El Producto No Se Encuentre
        if (encontrado == false) {

            // Mensaje
            System.out.println("\tEl Producto No Ha Sido Encontrado".toUpperCase());
            
        }

    } // Llave Final Metodo

    // Metodo Para Buscar Productos Por Nombre
    public void buscarProductoPorNombre(Scanner scanner) {

        // Bandera Para Manejar El Flujo Del Metodo
        boolean encontrado = false;

        // Solicitamos Informacion Al Usuario
        System.out.print("Digita El Nombre Del Producto A Buscar: ");
        String nombreProductoABuscar = scanner.nextLine().toLowerCase().trim();

        // Ciclo Para Recorrer Nuestra ArrayList
        for (int i = 0; i < nombre.size(); i++) {

            //  Validamos Que El Producto Exista En Nuestra ArrayList
            if (nombre.get(i).equals(nombreProductoABuscar)) {
                
                System.out.println(); // Salto De Linea
  
                System.out.print("\t---------- Producto Encontrado ----------".toUpperCase());
                
                // Imprimimos El Producto Con Su Informacion Formateada
                System.out.printf("""
                                  \nNombre: %s
                                  Cantidad: %d
                                  Precio: $%.2f
                                  """, nombre.get(i), cantidad.get(i), precio.get(i));

                encontrado = true; // Si Lo Encuentra

            }
        }

        System.out.println(); // Salto De Linea
        
        // Validacion Por Si El Producto No Existe
        if (encontrado == false) {

            // Mensaje
            System.out.println("\tEl Producto No Ha Sido Encontrado".toUpperCase());

        }

    } // Llave Final Del Metodo

    // Metodo Que Permite Actualizar Un Producto
    public void actualizarProducto(Scanner scanner) {

        // Bandera Para Controlar Las Validaciones Del For
        boolean encontrado = false;

        // Solicitamos Informacion Al Usuario
        System.out.print("Digita El Nombre Del Producto Que Deseas Actualizar La Cantidad: ");
        String nombreProductoActualizar = scanner.nextLine().toLowerCase().trim();

        // Ciclo Para Recorrer Nuestra ArrayList
        for (int i = 0; i < nombre.size(); i++) {

            // Validacion Si El Nombre Del Producto Proporcionado Por El Usuario Existe Dentro Del ArrayList
            if (nombre.get(i).equals(nombreProductoActualizar)) {

                // Solicitamos Informacion Al Usuario
                System.out.print("Digita La Cantidad Nueva Del Producto: ");
                cantidad.set(i, Integer.parseInt(scanner.nextLine()));

                System.out.println(); // Agregamos Un Salto De Linea
                
                // Mensaje Exitoso
                System.out.println("\tLa Actualizacion Se Ha Hecho Correctamente".toUpperCase());
                
                System.out.println(); // Salto De Linea
                
                System.out.print("\t---------- Producto Actualizado ----------".toUpperCase());
                
                // Imprimimos La Informacion De Producto Con La Cantidad Actualizada Con La Informacion Formateada
                System.out.printf("""
                                  \nNombres: %s
                                  Cantidad: %d
                                  Precio: $%.2f
                                  """, nombre.get(i), cantidad.get(i), precio.get(i));

                // Se Le Asigna True A La Variable Si La Encuentra
                encontrado = true;

            }

        }

        // Vaidacion En Caso De Que No La Encuentre
        if (encontrado == false) {

            System.out.println(); // Salto De Linea
            
            // Mensaje
            System.out.println("\tEl Producto No Ha Sido Encontrado".toUpperCase());

        }

    } // Llave Final Del Metodo

    // Metodo Que Calcula El Valor Total De Inventario
    public void calcularValorTotalInventario() {

        // Variable Que Almacenara El Valor Total 
        double valorTotal = 0;

        // Variable Que Almacena La Suma De El Precio Por Unidad * La Cantidad De Productos
        double precioPorProducto = 0;
        ;

        // Ciclo For Para Recorrer El ArrayList De Precios 
        for (int i = 0; i < precio.size(); i++) {

            // Formula Para Obtener El Precio Total Del Producto Segun Su Cantidad
            precioPorProducto = cantidad.get(i) * precio.get(i);

            // Suma Y Asignacion De Los Totales De Cada Producto Para Obtener El Total De Inventario De Todos Los Productos Disponibles
            valorTotal += precioPorProducto;

        }

        // Encabezado
        System.out.print("\t---------- Inventario Valor Total ----------".toUpperCase());
        
        System.out.println("""
                           \nTotal: $%.3f
                           """.formatted(valorTotal));

    } // Llave Final Del Metodo

    // Metodo Para Mostrar Producto Con La Cantidad Menor A Un Respectivo Umbral Proporcionado Por El Usuario
    public void mostrarProductoSegunUmbral(Scanner scanner) {

        // Bandera Para Manejar El Else De Nuestro Condicional Pero Fuera Del For
        boolean encontrado = false;

        // Solicitamos Informacion Al Usuario
        System.out.print("Digita La Cantidad Para Filtrar Los Productos: ");
        int cantidadProductosFiltrar = Integer.parseInt(scanner.nextLine());

        // Utilizamos Un Ciclo Para Recorrer La Lista De Cantidad De Productos         
        for (int i = 0; i < cantidad.size(); i++) {

            // Utilizamos Un Condicional Para Realizar Una Validacion
            if (cantidad.get(i) <= cantidadProductosFiltrar) {

                System.out.println(); // Salto De Linea 
                
                // Encabezado
                System.out.print("\t---------- Producto ".toUpperCase() + (i + 1)  + " ----------");
                
                // Imprimimos Los Productos Con La Informacion Formateada
                System.out.printf("""
                                  \nNombre: %s 
                                  Cantidad: %d
                                  Precio: $%.2f
                                   """, nombre.get(i), cantidad.get(i), precio.get(i));

                // La Variable De Control Se Le Asigna El Valor De True Indicando Que Si Hay Productos En Ese Umbral
                encontrado = true;

            }

        }

        // Validacion Por Si La Variable Es False
        if (encontrado == false) {

            System.out.println(); // Salto De Linea
            
            // Mensaje
            System.out.println("\tNo Se Encontro Un Producto Con La Cantidad Indicada O Menor".toUpperCase());

        }

    } // Llave Final Del Metodo

    // Metodo De Menu Iterativo
    public void menuIterativo(Scanner scanner) {

        // Variable Que Controla El Flujo De Nuestro Programa O Menu Iterativo
        boolean salir = false;

        while (!salir) {

            System.out.println(); // Imprimimos Un Salto De Linea

            // Mostrar Menu Interativo Con Las Opciones Disponibles 
            System.out.println("""
                           \t***** Sistema De Gestión De Inventario *****
                           1. Agregar Producto
                           2. Listar Productos
                           3. Buscar Producto(Nombre)
                           4. Eliminar Producto(Nombre)
                           5. Actualizar Cantidad De Un Producto
                           6. Calcular Valor Total Del Inventario
                           7. Mostrar Productos Con Cantidad
                           8. Salir
                           """);
            System.out.print("Digita Una Opcion: "); // Solicitar Informacion Al Usuario
            int opcion = Integer.parseInt(scanner.nextLine());

            System.out.println(); // Imprimimos Salto De Linea

            switch (opcion) {

                case 1:
                    agregarProductos(scanner); // Llamamos El Metodo De Agregar Productos
                    break; // Rompe La Sentencia 

                case 2:
                    listarProductos(); // Llamamos El Metodo De Listar Productos
                    break; // Rompe La Sentencia

                case 3:
                    buscarProductoPorNombre(scanner); // Llamamos El Metodo Buscar Producto Por Nombre
                    break; // Rompe La Sentencia

                case 4:
                    eliminarProductosPorNombre(scanner); // Llamamos El Metodo Eliminar Productos
                    break; // Rompe La Sentencia

                case 5:
                    actualizarProducto(scanner); // Llamamos El Metodo De Actualizar Productos
                    break; // Rompe La Sentencia

                case 6:
                    calcularValorTotalInventario(); // Llamamos El Metodo Para Calcular Valor Total Del Inventario
                    break; // Rompe La Sentencia

                case 7:
                    mostrarProductoSegunUmbral(scanner); // Llamamos El Metodo De Mostrar Productos Con Cantidad Bajo Una Condicion
                    break; // Rompe La Sentencia

                case 8:
                    salir = true;
                    System.out.println("Saliendo Del Programa...........");
                    break; // Rompe El Ciclo Y Sale

                default:
                    System.out.println("\tLa Opcion No Existe".toUpperCase());

            }

        }

    } // Llave De Cierre Del Metodo

}
