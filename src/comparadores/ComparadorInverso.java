package comparadores;

import java.util.Comparator;

public class ComparadorInverso implements Comparator {
    private Comparator comparator;
    public ComparadorInverso(Comparator comparator){
        this.comparator = comparator;
    }
    @Override
    public int compare(Object o1, Object o2) {
        return -1*this.comparator.compare(o1,o2);
    }
}
