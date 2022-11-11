import java.util.Comparator;
import java.util.Iterator;

public class ListaVinculada implements Iterable<Comparable>{
    private Nodo primerNodo;
    private Comparator ordenador;
    public ListaVinculada(){
        this.primerNodo = null;
        this.ordenador = null;
    }
    public void setOrdenador(Comparator ordenador){
        this.ordenador = ordenador;
        this.sort();
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

    public void add(Comparable valor){
        if (this.primerNodo == null){
            this.primerNodo = new Nodo(valor);
        }else if (this.ordenador.compare(this.primerNodo.getValor(),valor) >= 1){
            Nodo nuevoNodo = new Nodo(valor);
            nuevoNodo.setNodoSiguente(this.primerNodo);
            this.primerNodo = nuevoNodo;
        }
        else {
            Nodo aux = this.primerNodo;
            while (aux.getNodoSiguente() != null){
                if (this.ordenador.compare(valor,aux.getValor()) >= 1 || this.ordenador.compare(valor,aux.getValor()) == 0 ){
                    Nodo nuevoNodo = new Nodo(valor);
                    Nodo tmp = aux.getNodoSiguente();
                    aux.setNodoSiguente(nuevoNodo);
                    nuevoNodo.setNodoSiguente(tmp);
                    return;
                }
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
        while (this.primerNodo.getValor().equals(valor)){
            this.primerNodo = this.primerNodo.getNodoSiguente();
        }
        Nodo aux = this.primerNodo;
        while (aux.getNodoSiguente() != null){
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
    public boolean estaVacia(){
        if (this.primerNodo == null){
            return true;
        }
        return false;
    }
    public void sort(){
        for (int i = 0; i < this.size();i++) {
            Nodo nodoActual = this.primerNodo;
            Nodo aux = this.primerNodo.getNodoSiguente();
            for (int j = 0; j < this.size() - 1; j++) {
                int result = this.ordenador.compare(nodoActual.getValor(),aux.getValor());
                if (result >= 1) {
                    Comparable temp = nodoActual.getValor();
                    nodoActual.setValor(aux.getValor());
                    aux.setValor(temp);
                }
                nodoActual = aux;
                aux = aux.getNodoSiguente();
            }
        }
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
