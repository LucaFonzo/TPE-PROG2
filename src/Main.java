import comparadores.ComparadorIntegers;
import comparadores.ComparadorNot;

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
        for (Comparable i:listaIntegers){
            System.out.println(i);
        }
    }
}
