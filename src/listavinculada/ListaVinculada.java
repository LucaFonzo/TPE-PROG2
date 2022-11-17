package listavinculada;

import java.util.Comparator;
import java.util.Iterator;

public class ListaVinculada<T> implements Iterable<T> {
    private Nodo<T> primerNodo;
    private Comparator<T> ordenador;
    public ListaVinculada(Comparator<T> ordenador){
        this.primerNodo = null;
        this.ordenador = ordenador;
    }
    public void setOrdenador(Comparator<T> ordenador){
        this.ordenador = ordenador;
        this.sort();
    }
    private void setPrimerNodo(Nodo nuevoNodo){
        this.primerNodo = nuevoNodo;
    }

    public Object get(int index){
        int contador = 0;
        Nodo aux = this.primerNodo;
        while (contador < index){
            aux = aux.getNodoSiguente();
            contador++;
        }
        return aux.getValor();
    }

    public int getIndex(T valor){
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

    public void add(T valor){
        Nodo nuevoNodo = new Nodo(valor);
        if (this.primerNodo == null){
            this.setPrimerNodo(nuevoNodo);
        }else if (this.ordenador.compare(this.primerNodo.getValor(),(T)nuevoNodo.getValor()) >= 1){
            nuevoNodo.setNodoSiguente(this.primerNodo);
            this.setPrimerNodo(nuevoNodo);
        }
        else {
            Nodo actual = this.primerNodo;
            Nodo tmp = null;
            while (actual != null && this.ordenador.compare((T) actual.getValor(), (T) nuevoNodo.getValor()) < 0){
                tmp = actual;
                actual = actual.getNodoSiguente();
            }
            if (actual == null){
                tmp.setNodoSiguente(nuevoNodo);
            }else {
                Nodo nodoSiguente = tmp.getNodoSiguente();
                nuevoNodo.setNodoSiguente(nodoSiguente);
                tmp.setNodoSiguente(nuevoNodo);
            }

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

    public void removeAllElements(Object valor){
        if (this.primerNodo.getValor().equals(valor)){
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
        int size = this.size();
        for (int i = 0; i < size;i++) {
            Nodo nodoActual = this.primerNodo;
            Nodo aux = this.primerNodo.getNodoSiguente();
            for (int j = 0; j < size - 1; j++) {
                int result = this.ordenador.compare((T) nodoActual.getValor(),(T) aux.getValor());
                if (result >= 1) {
                    Object temp = nodoActual.getValor();
                    nodoActual.setValor(aux.getValor());
                    aux.setValor(temp);
                }
                nodoActual = aux;
                aux = aux.getNodoSiguente();
            }
        }
    }

    public void mostrarLista(){
        Iterator iteradorListaVinculada = new IteradorListaVinculada(this.primerNodo);
        while (iteradorListaVinculada.hasNext()){
            Object i = iteradorListaVinculada.next();
            System.out.println(i);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorListaVinculada(this.primerNodo);
    }
}
