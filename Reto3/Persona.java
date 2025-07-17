package Reto3;

public class Persona {

    // Definimos Los Atributos De Persona Con Su Respectivo Modificador De Acceso
    private String nombre;
    private int edad;
    private String profesion;
    private double sueldo;

    // Definimos Los Metodos Constructores
    // Constructor Con Todos Los Parametros
    public Persona(String nombre, int edad, String profesion, double sueldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
        this.sueldo = sueldo;
    }

    // Constructor Vacio
    public Persona() {
    }

    // Metodos Getters And Setters
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getProfesion() {
        return this.profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public double getSueldo() {
        return this.sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    // Metodos Propios De La Clase
    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder(); // Instanciamos La Clase StringBuilder

        builder.append("Nombre: ").append(getNombre()).append("\n");
        builder.append("Edad: ").append(getEdad()).append("\n");
        builder.append("Profesion: ").append(getProfesion()).append("\n");
        builder.append("Sueldo: ").append(getSueldo()).append("\n");
       
        return builder.toString();

    }

}
