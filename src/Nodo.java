import java.util.Objects;

public class Nodo {
    private Nodo nodoSiguente;
    private Comparable valor;

    public Nodo(Comparable valor){
        this.valor = valor;
        this.nodoSiguente = null;
    }

    public Nodo getNodoSiguente() {
        return this.nodoSiguente;
    }
    public Comparable getValor() {
        return this.valor;
    }
    public void setNodoSiguente(Nodo nodoSiguente){
        this.nodoSiguente = nodoSiguente;
    }
    public void  setValor(Comparable valor){
        this.valor = valor;
    }


    @Override
    public String toString(){
        return this.getValor().toString();
    }
}
