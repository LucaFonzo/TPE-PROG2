package alumno;

import comparadores.ComparadorStrings;
import listavinculada.ListaVinculada;

import java.util.ArrayList;
import java.util.Comparator;

public class Alumno extends ElementoGrupo {
    private String nombre;
    private String apellido;
    private Integer dni;
    private ListaVinculada<String> palabras;

    public Alumno(String nombre, String apellido, Integer dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.palabras = new ListaVinculada<>(new ComparadorStrings());
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

    public void addPalabra(String palabra){
        this.palabras.add(palabra);
    }

    @Override
    public int getCantidadAlumnos() {
        return 1;
    }

}
