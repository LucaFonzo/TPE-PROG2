import java.util.Comparator;
import java.util.Iterator;

public class ListaVinculada implements Iterable<Comparable>{
    private Nodo primerNodo;
    private Comparator ordenador;
    public ListaVinculada(){
        this.primerNodo = null;
        this.ordenador = null;
    }

    public Comparable get(int index){
        int contador = 0;
        Nodo aux = this.primerNodo;
        while (contador < index){
            aux = aux.getNodoSiguente();
            contador++;
        }
        return aux.getValor();
    }

    public int getIndex(Comparable valor){
        int index = 0;
        Nodo aux = this.primerNodo;
        while (aux != null){
            if (aux.getValor().equals(valor)){
                return index;
            }
            index++;
            aux = aux.getNodoSiguente();
        }
        return -1;
    }

    public void setOrdenador(Comparator ordenador){
        this.ordenador = ordenador;
    }

    public void add(Comparable valor){
        if (this.estaVacia()){
            this.primerNodo = new Nodo(valor);
        }else {
            Nodo aux = this.primerNodo;
            while (aux.getNodoSiguente() != null){
                aux = aux.getNodoSiguente();
            }
            Nodo nuevoNodo = new Nodo(valor);
            aux.setNodoSiguente(nuevoNodo);
        }
    }

    public void remove(int index){
        int contador = 0;
        Nodo aux = this.primerNodo;
        if (index == 0){
            this.primerNodo = this.primerNodo.getNodoSiguente();
        }else {
            while (contador < index - 1){
                aux = aux.getNodoSiguente();
                contador++;
            }
            Nodo nodoAEliminar = aux.getNodoSiguente();
            aux.setNodoSiguente(nodoAEliminar.getNodoSiguente());
            nodoAEliminar.setNodoSiguente(null);
        }
    }

    public void removeAllElements(Comparable valor){
        Nodo aux = this.primerNodo;
        while (aux != null){
            if (aux.getNodoSiguente().getValor().equals(valor)){
                Nodo nodoAEliminar = aux.getNodoSiguente();
                aux.setNodoSiguente(nodoAEliminar.getNodoSiguente());
                nodoAEliminar.setNodoSiguente(null);
            }
            aux = aux.getNodoSiguente();
        }
    }

    public int size(){
        int size = 0;
        Nodo aux = this.primerNodo;
        while (aux != null){
            size++;
            aux = aux.getNodoSiguente();
        }
        return size;
    }
    public void sort(){
        for (Nodo i = this.primerNodo;i != null;i.getNodoSiguente()){
            for (Nodo j = i.getNodoSiguente();j != null;j.getNodoSiguente()){
                int aux = this.ordenador.compare(i,j);
                if (aux > 1){
                    //I ES MAYOR A J
                }else if (aux < 1){
                    //I ES MENOR A J
                }else {
                    //SON IGUALES
                }
            }
        }

    }

    public boolean estaVacia(){
        if (this.primerNodo == null){
            return true;
        }
        return false;
    }

    @Override
    public Iterator<Comparable> iterator() {
        return new IteradorListaVinculada();
    }
    private class IteradorListaVinculada implements Iterator<Comparable>{
        private int pos;
        public IteradorListaVinculada(){
            this.pos = 0;
        }

        @Override
        public boolean hasNext() {
            return this.pos < size();
        }

        @Override
        public Comparable next() {
            pos++;
            return get(pos - 1);
        }
    }
}
