package comparadores;

import alumno.Alumno;

import java.util.Comparator;

public class ComparadorApellido implements Comparator<Alumno> {
    @Override
    public int compare(Alumno o1, Alumno o2) {
        return o1.getApellido().compareTo(o2.getApellido());
    }
}
