package comparadores;
import java.util.Comparator;
import alumno.ElementoGrupo;
public class ComparadorCantAlumnos implements Comparator<ElementoGrupo> {
    @Override
    public int compare(ElementoGrupo o1, ElementoGrupo o2) {
        return  o2.getCantidadAlumnos() - o1.getCantidadAlumnos();
    }
}
