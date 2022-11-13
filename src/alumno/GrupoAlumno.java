package alumno;

import java.util.ArrayList;

public class GrupoAlumno extends ElementoGrupo{
    private ArrayList<ElementoGrupo> grupos;

    public GrupoAlumno(){
        this.grupos = new ArrayList<>();
    }

    @Override
    public int getCantidadAlumnos() {
        int total = 0;
        for (ElementoGrupo grupo:grupos){
            total += grupo.getCantidadAlumnos();
        }
        return total;
    }

    public void add(ElementoGrupo elementoGrupo){
        if (!this.grupos.contains(elementoGrupo))
            this.grupos.add(elementoGrupo);
    }

    @Override
    public String toString(){
        return "Alumnos: " + this.getCantidadAlumnos();
    }
}
