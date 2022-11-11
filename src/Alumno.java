import java.util.ArrayList;

public class Alumno {
    private String nombre;
    private String apellido;
    private Integer dni;
    private ArrayList<String> palabras;

    public Alumno(String nombre, String apellido, Integer dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.palabras = new ArrayList<>();
    }

    public boolean tienePalabra(String palabraBuscada){
        return this.palabras.contains(palabraBuscada);
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getDni() {
        return dni;
    }
}
