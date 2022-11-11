package comparadores;

import java.util.Comparator;

public class CompadorCompuesto implements Comparator {
    private Comparator comparator1;
    private Comparator comparator2;

    public CompadorCompuesto(Comparator comparator1,Comparator comparator2){
        this.comparator1 = comparator1;
        this.comparator2 = comparator2;
    }

    @Override
    public int compare(Object o1, Object o2) {
        int aux = this.comparator1.compare(o1,o2);
        if (aux == 0){
            return this.comparator2.compare(o1,o2);
        }
        return aux;
    }
}
