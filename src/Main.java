import alumno.Alumno;
import alumno.GrupoAlumno;
import comparadores.ComparadorCantAlumnos;
import comparadores.ComparadorIntegers;
import comparadores.ComparadorNot;
import comparadores.ComparadorStrings;
import listavinculada.ListaVinculada;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ListaVinculada listaIntegers = new ListaVinculada();
        ComparadorIntegers comparadorIntegers = new ComparadorIntegers();
        listaIntegers.setOrdenador(comparadorIntegers);
        listaIntegers.add(10);
        listaIntegers.add(21);
        listaIntegers.add(1);
        listaIntegers.add(5);
        listaIntegers.add(11);
        for (Object i:listaIntegers){
            System.out.println(i);
        }
        System.out.println("-------------");
        listaIntegers.remove(0);
        listaIntegers.removeAllElements(5);
        listaIntegers.removeAllElements(11);
        for (Object i:listaIntegers){
            System.out.println(i);
        }
        System.out.println("-------------");
        Comparator ordenadorString = new ComparadorStrings();
        ListaVinculada listaString = new ListaVinculada();
        listaString.setOrdenador(ordenadorString);
        listaString.add("Facil");
        listaString.add("Es");
        listaString.add("Parcial");
        listaString.add("Prog 2");
        for (Object i:listaString){
            System.out.println(i);
        }
        System.out.println("-------------");
        System.out.println("Pos parcial:" + listaString.getIndex("Parcial"));
        System.out.println("Pos recuperatorio: " + listaString.getIndex("Recuperatorio"));
        Comparator comparadorDescendienteString = new ComparadorNot(ordenadorString);
        listaString.setOrdenador(comparadorDescendienteString);
        System.out.println("-------------");
        for (Object i:listaString){
            System.out.println(i);
        }
        System.out.println("-------------");
        GrupoAlumno unicen = new GrupoAlumno();

        Alumno johnDoe = new Alumno("John","Doe",1200000);
        johnDoe.addPalabra("intercambio");
        unicen.add(johnDoe);

        GrupoAlumno humanas = new GrupoAlumno();
        Alumno moraDiaz = new Alumno("Mora","Diaz",37124425);
        moraDiaz.addPalabra("psicologia");
        moraDiaz.addPalabra("Freud");
        humanas.add(moraDiaz);

        GrupoAlumno historia = new GrupoAlumno();
        Alumno floraRivas = new Alumno("Flora","Rivas",34555111);
        floraRivas.addPalabra("historia");
        floraRivas.addPalabra("antigua");
        Alumno martinGomez = new Alumno("Martin","Gomez",34111222);
        martinGomez.addPalabra("romanos");
        martinGomez.addPalabra("egipcios");
        martinGomez.addPalabra("griegos");
        Alumno romanBazan = new Alumno("Roman","Bazan",32555111);
        romanBazan.addPalabra("argentina");
        historia.add(floraRivas);
        historia.add(martinGomez);
        historia.add(romanBazan);
        humanas.add(historia);

        GrupoAlumno exactas = new GrupoAlumno();
        Alumno juanaGarcia = new Alumno("Juana","Garcia",27123455);
        juanaGarcia.addPalabra("progamacion");
        juanaGarcia.addPalabra("php");
        juanaGarcia.addPalabra("java");
        exactas.add(juanaGarcia);
        Alumno federicoLopez = new Alumno("Federico","Lopez",35999888);
        federicoLopez.addPalabra("redes");
        federicoLopez.addPalabra("php");
        federicoLopez.addPalabra("java");
        federicoLopez.addPalabra("python");
        exactas.add(federicoLopez);

        unicen.add(exactas);
        unicen.add(humanas);

        GrupoAlumno olimpiadasMatematicas = new GrupoAlumno();

        GrupoAlumno matea2 = new GrupoAlumno();
        Alumno juanJuarez = new Alumno("Juan","Juarez",33222444);
        juanJuarez.addPalabra("sucesiones");
        juanJuarez.addPalabra("algebra");
        Alumno julioCesar = new Alumno("Julio","Cesar",33222111);
        julioCesar.addPalabra("sucesiones");
        julioCesar.addPalabra("algebra");

        matea2.add(juanJuarez);
        matea2.add(julioCesar);

        olimpiadasMatematicas.add(matea2);

        GrupoAlumno losFibo = new GrupoAlumno();
        Alumno bernardinoRivas = new Alumno("Bernardino","Rivas",30987654);
        bernardinoRivas.addPalabra("matematicas");
        Alumno josePaso = new Alumno("Jose","Paso",33322112);
        josePaso.addPalabra("problemas");
        Alumno issacNewton = new Alumno("Isacc","Newton",12343565);
        issacNewton.addPalabra("sucesiones");
        losFibo.add(bernardinoRivas);
        losFibo.add(josePaso);
        losFibo.add(issacNewton);

        olimpiadasMatematicas.add(losFibo);

        ListaVinculada listaGrupos = new ListaVinculada();
        Comparator comparatorAlumnos = new ComparadorCantAlumnos();
        listaGrupos.setOrdenador(comparatorAlumnos);
        listaGrupos.add(unicen);
        listaGrupos.add(olimpiadasMatematicas);
        for (Object i:listaGrupos){
            System.out.println(i);
        }
    }
}
