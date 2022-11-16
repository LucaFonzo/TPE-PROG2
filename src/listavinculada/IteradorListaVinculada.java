package listavinculada;

import java.util.Iterator;

public class IteradorListaVinculada<T> implements Iterator<T> {
    private Nodo cursor;

    public IteradorListaVinculada(Nodo cursor){
        this.cursor = cursor;
    }

    @Override
    public boolean hasNext() {
        return this.cursor != null;
    }

    @Override
    public T next() {
        T valor = (T) this.cursor.getValor();
        this.cursor = this.cursor.getNodoSiguente();
        return valor;
    }
}
