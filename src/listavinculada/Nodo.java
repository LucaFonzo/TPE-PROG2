package listavinculada;

public class Nodo {
    private Nodo nodoSiguente;
    private Object valor;

    public Nodo(Object valor){
        this.valor = valor;
        this.nodoSiguente = null;
    }

    public Nodo getNodoSiguente() {
        return this.nodoSiguente;
    }
    public Object getValor() {
        return this.valor;
    }
    public void setNodoSiguente(Nodo nodoSiguente){
        this.nodoSiguente = nodoSiguente;
    }
    public void  setValor(Object valor){
        this.valor = valor;
    }


    @Override
    public String toString(){
        return this.getValor().toString();
    }
}
