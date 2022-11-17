package listavinculada;

public class Nodo<T> {
    private Nodo<T> nodoSiguente;
    private T valor;

    public Nodo(T valor){
        this.valor = valor;
        this.nodoSiguente = null;
    }

    public Nodo getNodoSiguente() {
        return this.nodoSiguente;
    }
    public T getValor() {
        return this.valor;
    }
    public void setNodoSiguente(Nodo nodoSiguente){
        this.nodoSiguente = nodoSiguente;
    }
    public void  setValor(T valor){
        this.valor = valor;
    }


    @Override
    public String toString(){
        return this.getValor().toString();
    }
}
