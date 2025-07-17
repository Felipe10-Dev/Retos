package Reto2;

public class Producto {

    // Definimos Los Atributos
    private String nombre;
    private int cantidad;
    private double precio;

    // Definimos Los Metodos Constructores 
    // Constructor Con Todos Los Parametros
    public Producto(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Constructor Vacio
    public Producto() {
    }

    //  Metodos Getters And Setters
    public String getNombre() {
        return this.nombre;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Otros Metodos De La Clase
    @Override
    public String toString() {

        String mensaje = ("""
                           Nombre: %s
                           Cantidad: %d
                           Precio: $%.2f
                           """.formatted(nombre, cantidad, precio));

        return mensaje;
    }

}
