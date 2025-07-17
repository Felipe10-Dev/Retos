package Reto1;

public class Persona {

    // Definimos Los Atributos
    private String nombre; 
    private int edad;
    private char sexo; 
    
    // Definimos Los Metodos Constructores
    
    // Constructor Con Todos Los Parametros
    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }
    
    // Constructor Sin Parametros
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

    public char getSexo() {
        return this.sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    // Metodos De La Clase Persona
    @Override
    public String toString() {
     
        StringBuilder build = new StringBuilder(); 
        
        build.append("Nombre: ").append(getNombre()).append("\n");
        build.append("Edad: ").append(getEdad()).append(" Años").append("\n"); 
        build.append("Sexo: ").append(getSexo()).append("\n"); 
        
        
        return build.toString(); 
        
    }
        
    

    
    

    
}
